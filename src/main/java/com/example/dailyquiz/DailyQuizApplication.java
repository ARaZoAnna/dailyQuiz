package com.example.dailyquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class DailyQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyQuizApplication.class, args);
	}

}
