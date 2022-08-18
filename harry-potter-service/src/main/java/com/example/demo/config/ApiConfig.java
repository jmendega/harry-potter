package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.business.impl.ApiServiceImpl;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Slf4j
@Configuration
public class ApiConfig {
	
	@Bean
	ApiServiceImpl gestionApi() {
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://hp-api.herokuapp.com/api/characters/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
		log.info("Creating ApiServiceImpl rest client host {}", "http://hp-api.herokuapp.com/api/characters/");
		return retrofit.create(ApiServiceImpl.class);
	}

}
