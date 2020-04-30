package com.wph.demo.sh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wph.demo.sh.mapper")
public class DemoShApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoShApplication.class, args);
	}

}
