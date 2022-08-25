package com.espark.adarsh;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.DisabledIf;
import org.springframework.test.context.junit.jupiter.EnabledIf;

@DisabledIfEnvironmentVariable(named = "SPRING_PROFILES_ACTIVE", matches = "(dev|default|local)")
@SpringBootTest
class SpringbootLiquibaseApplicationTests {

	@Test
	void contextLoads() {
	}

}
