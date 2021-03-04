package com.integra.broker.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.integra.broker.entities.Employee;
import com.integra.broker.repositories.EmployeeRepository;

@Configuration
public class LoadDatabase {

	private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

	CommandLineRunner initDatabase(EmployeeRepository repository) {
		return args -> {
//			logger.info("Preloading " + repository.save(new Employee(null, "Bilbo Baggins", "burglar", null)));
//			logger.info("Preloading " + repository.save(new Employee(null, "Frodo Baggins", "thief", null)));
		};
	}
}
