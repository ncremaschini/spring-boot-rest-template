package it.template.pj.service;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author pietro.zanella 09 gen 2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ServiceMain {

	@Autowired
	private Environment environment;

	@SpringBootApplication(scanBasePackages = { "it.template.pj" })
	static class TestConfiguration {
	}

	protected boolean isLocalProfile() {
		List<String> profiles = Arrays.asList(environment.getActiveProfiles());
		return profiles.contains("local");
	}

}
