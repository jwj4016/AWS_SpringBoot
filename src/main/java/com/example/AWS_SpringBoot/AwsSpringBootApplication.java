package com.example.AWS_SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplicaiton
//스프링 부트의 자동 설정, 스프링 빈 읽기&생성 자동 설정. 해당 클래스가 있는 위치부터 설정 읽기 시작.
//
@SpringBootApplication
public class AwsSpringBootApplication {

	public static void main(String[] args) {
		//내장 was 실행
		SpringApplication.run(AwsSpringBootApplication.class, args);
	}

}
