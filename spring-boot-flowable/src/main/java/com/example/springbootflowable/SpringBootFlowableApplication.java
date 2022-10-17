package com.example.springbootflowable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFlowableApplication implements CommandLineRunner {

	@Autowired
	private TestFlowable testFlowable;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFlowableApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		testFlowable.createDeploymentZip();
	}
}
