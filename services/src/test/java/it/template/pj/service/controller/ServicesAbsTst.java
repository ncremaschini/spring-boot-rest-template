package it.template.pj.service.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.template.pj.service.ServiceMain;

public abstract class ServicesAbsTst extends ServiceMain {

	private static final Logger logger = LoggerFactory.getLogger(ServicesAbsTst.class);

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objMapper;
	
	private static boolean dbInitialized = false;



	protected void setup() throws Exception {
		logger.info("setup()");

		if (isLocalProfile()) {
			if (!dbInitialized) {
				

				
				dbInitialized = true;
			}
		}
		
		
	}

	protected void getEnvInfoTest() throws Exception {

		this.mockMvc.perform(get("/api/v1/env")).andExpect(status().isOk());

	}

	protected void tearDown() throws InterruptedException {
		logger.info("tearDown()");

	}
}
