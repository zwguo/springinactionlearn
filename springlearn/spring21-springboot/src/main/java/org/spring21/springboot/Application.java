package org.spring21.springboot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.spring21.springboot")
@EnableAutoConfiguration
public class Application {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
		System.out.println("---------finish-------------");
		System.in.read();
	}
}
