package com.hanzek.zavrsni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com")
@SpringBootApplication
public class ZavrsniApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZavrsniApplication.class, args);
	}
}
