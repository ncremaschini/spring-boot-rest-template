/**
 * 
 */
package it.template.pj.datalayer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nicola.cremaschini
 *
 */
public  abstract class CustomEntityManagerAbsTst extends DatalayerMain{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomEntityManagerAbsTst.class);
		
	private static boolean dbInitialized = false;
	
	@Before
    public void setup() throws Exception {
        
		if(isLocalProfile()) {			
			if(!dbInitialized) {
	
			}
		}
    }
	
	protected void crudTest() {
		
		
		
	}
	
	
	@After
	public void tearDown() throws Exception{
		logger.info("tearDown()");
		
	
	}

}
