package com.study.information_push;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class InformationPushApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformationPushApplication.class, args);
	}

}
