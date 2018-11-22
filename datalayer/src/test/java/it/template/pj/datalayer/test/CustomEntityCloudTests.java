package it.template.pj.datalayer.test;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import it.template.pj.datalayer.CustomEntityManagerAbsTst;

@ActiveProfiles("cloud")
public class CustomEntityCloudTests extends CustomEntityManagerAbsTst{
	
	@Test
	public void crudTest() {	
		super.crudTest();	
	}
}
