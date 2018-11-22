package it.template.pj.commons;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonsMain {

	@Autowired
	private Environment environment;

	@SpringBootApplication(scanBasePackages="it.template.pj.commons")
	static class TestConfiguration {
	}
	
	protected boolean isLocalProfile() {
		List<String> profiles = Arrays.asList(environment.getActiveProfiles());
		return profiles.contains("local");
	}
}
