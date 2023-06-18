package com.mryow.demo.onetomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mryow.demo.onetomany"})
@EntityScan(basePackages = {"com.mryow.demo.onetomany.models"})
@EnableJpaRepositories(basePackages = {"com.mryow.demo.onetomany.repositories"})
public class OnetomanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnetomanyApplication.class, args);
	}

}
