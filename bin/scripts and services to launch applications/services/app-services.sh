#!/bin/bash 
# version 0.0.2
# Script to launch services application with external files configuration (log4j2.xml and application.yml).

PROJECT_PATH=/path/to/jar/app-services

LOG_PATH=$PROJECT_PATH/log4j2_services.xml
SPRING_PROPERTIES_PATH=$PROJECT_PATH/application_services.yml
OUTPUT_LOG_FILE_PATH=$PROJECT_PATH/logs/

MIN_HEPASIZE=-Xms512m
MAX_HEAPSIZE=-Xmx2048m

echo "Save log file @ $OUTPUT_LOG_FILE_PATH"

function findLatestJar {
	files=`ls -t $PROJECT_PATH/services*.jar | head -n 1`;
	JAR_PATH=${files[0]};
}

function init {
	filename=$(basename "$1")
	
	if [ -f $1 ]; then
		echo "$filename found!"
		return 0;
	else
		echo "$filename not found @ $1"
		return 1
	fi
	
}

findLatestJar;

init $JAR_PATH
ERROR_JAR_NOT_FOUND=$?

init $LOG_PATH
ERROR_LOGGER_CONFIG_FILE_NOT_FOUND=$?

init $SPRING_PROPERTIES_PATH
ERROR_SPRING_PROPERTIES_FILE_NOT_FOUND=$?

if [[ ( $ERROR_JAR_NOT_FOUND -eq 0 ) && ( $ERROR_LOGGER_CONFIG_FILE_NOT_FOUND -eq 0 ) && ( $ERROR_SPRING_PROPERTIES_FILE_NOT_FOUND -eq 0 ) ]]; then
	echo "Launching application . . ."
	java -DLOG_FILE_PATH=${OUTPUT_LOG_FILE_PATH} $MIN_HEAPSIZE $MAX_HEAPSIZE -Dlogging.config=$LOG_PATH -jar $JAR_PATH --spring.config.location=$SPRING_PROPERTIES_PATH
else
	echo "ERROR! Files not found, see log."
	exit 1
fi
