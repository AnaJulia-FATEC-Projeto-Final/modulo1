package com.anajulia.modulo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Modulo1Application implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Modulo1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Modulo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("projeto da ana julia iniciado!");
	}
}