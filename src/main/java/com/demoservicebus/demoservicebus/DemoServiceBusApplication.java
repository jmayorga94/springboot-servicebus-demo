package com.demoservicebus.demoservicebus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class DemoServiceBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceBusApplication.class, args);
	}

}
