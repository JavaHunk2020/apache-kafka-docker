package com.consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class MainEater {
	
	public static void main(String[] args) {
		//new SpringApplicationBuilder(MainEater.class).web(WebApplicationType.NONE).run(args);
		new SpringApplicationBuilder(MainEater.class).run(args);
	}

}
