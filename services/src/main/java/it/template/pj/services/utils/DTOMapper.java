package it.template.pj.services.utils;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class DTOMapper {

	private ModelMapper customMapper;


	private static final Logger logger = LoggerFactory.getLogger(DTOMapper.class);

	public DTOMapper() {
		customMapper = new ModelMapper();
	}

}
