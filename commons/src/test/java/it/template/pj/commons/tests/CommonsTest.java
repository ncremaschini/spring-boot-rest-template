package it.template.pj.commons.tests;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import it.template.pj.commons.CommonsMain;

/**
 * @author nicola.cremaschini 15 nov 2017
 */

@ActiveProfiles({ "local" })
public class CommonsTest extends CommonsMain {
	
	@Test
	public void customTest() {
		
	}
}
