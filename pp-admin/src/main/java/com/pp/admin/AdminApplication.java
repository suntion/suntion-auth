package com.pp.admin;

import com.pp.admin.exception.GlobalExceptionResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.pp"})
@MapperScan(basePackages = {"com.pp.**.dao"})
public class AdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	@Bean
	public GlobalExceptionResolver globalExceptionResolver() {
		return new GlobalExceptionResolver();
	}

}
