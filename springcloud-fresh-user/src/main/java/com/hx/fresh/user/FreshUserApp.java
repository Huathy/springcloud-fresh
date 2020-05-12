package com.hx.fresh.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@MapperScan("com.hx.fresh.user.mapper")
@SpringBootApplication
@EnableEurekaClient		//将应用注册到eureka服务器
@EnableRedisHttpSession		//将session存到redis中
public class FreshUserApp {
	public static void main(String[] args) {
		SpringApplication.run(FreshUserApp.class, args);
	}
}
