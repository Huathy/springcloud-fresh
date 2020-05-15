package com.hx.fresh.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@MapperScan("com.hx.fresh.goods.mapper")
@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession
public class FreshGoodsApp {
	public static void main(String[] args) {
		SpringApplication.run(FreshGoodsApp.class, args);
	}
}
