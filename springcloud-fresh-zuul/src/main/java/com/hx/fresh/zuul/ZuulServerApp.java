package com.hx.fresh.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.hx.fresh.zuul.filter.TokenFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulServerApp {
	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApp.class, args);
	}
	
	@Bean
	public TokenFilter tokenFilter() {
		return new TokenFilter();
	}
}
