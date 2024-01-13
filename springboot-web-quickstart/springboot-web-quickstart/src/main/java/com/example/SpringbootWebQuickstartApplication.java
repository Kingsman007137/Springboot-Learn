package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//启动类，启动springboot工程
@SpringBootApplication
public class SpringbootWebQuickstartApplication {

	//端口号改为7000
	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebQuickstartApplication.class, args);
	}

}
