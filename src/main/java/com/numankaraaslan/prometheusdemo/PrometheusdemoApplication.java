package com.numankaraaslan.prometheusdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class PrometheusdemoApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(PrometheusdemoApplication.class, args);
	}
}
