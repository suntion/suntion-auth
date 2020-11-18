package com.pp.auth;

import com.pp.auth.exception.GlobalExceptionResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.pp"})
@MapperScan(basePackages = {"com.pp.**.dao"})
public class ApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public GlobalExceptionResolver globalExceptionResolver() {
		return new GlobalExceptionResolver();
	}

}
