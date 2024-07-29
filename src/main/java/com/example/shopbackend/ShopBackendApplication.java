package com.example.shopbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ShopBackendApplication {

	public static void main(String[] args) { SpringApplication.run(ShopBackendApplication.class, args); }

}
