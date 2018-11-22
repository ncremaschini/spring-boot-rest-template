package it.template.pj.services.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import it.template.pj.services.ServicesApp;
import it.template.pj.services.config.ApiVersion;
import it.template.pj.services.data.CustomDataService;
import it.template.pj.services.dto.EnvInfoDTO;

/**
 * @author nicola.cremaschini
 * 
 */
@RestController
@RequestMapping("/")
@ApiVersion(1)
public class ServicesController {

	private static final Logger logger = LoggerFactory.getLogger(ServicesController.class);
	
	@Autowired
	private CustomDataService customerDataService;
	
	@ApiOperation(value = "retrieve software info")
	@RequestMapping(value = "env", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EnvInfoDTO> getEnvInfo() {
		ResponseEntity<EnvInfoDTO> responseEntity;

		String title = ServicesApp.class.getPackage().getImplementationTitle();
		String version = ServicesApp.class.getPackage().getImplementationVersion();

		EnvInfoDTO envInfoDTO = new EnvInfoDTO();
		envInfoDTO.setServicesTitle(title);
		envInfoDTO.setServicesVersion(version);

		responseEntity = new ResponseEntity<EnvInfoDTO>(envInfoDTO, HttpStatus.OK);
		
		logger.debug(responseEntity.toString());
		
		return responseEntity;
	}		
}