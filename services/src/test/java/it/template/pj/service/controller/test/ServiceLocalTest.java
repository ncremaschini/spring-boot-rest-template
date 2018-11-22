package it.template.pj.service.controller.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import it.template.pj.service.controller.ServicesAbsTst;

@ActiveProfiles("local")
public class ServiceLocalTest extends ServicesAbsTst {

	@Before
	public void setup() throws Exception {
		super.setup();
	}

	@Test
	public void getEnvInfoTest() throws Exception {
		super.getEnvInfoTest();
	}
	
	@After
	public void tearDown() throws InterruptedException {
		super.tearDown();
	}
}
