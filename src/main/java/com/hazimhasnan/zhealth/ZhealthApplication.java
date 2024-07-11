package com.hazimhasnan.zhealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ZhealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhealthApplication.class, args);
	}

}
