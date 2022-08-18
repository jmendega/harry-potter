package com.example.demo.business.impl;

import java.util.List;

import com.example.demo.models.Character;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServiceImpl {

	@GET("house/gryffindor")
	 Call<List<Character>> getCharacters();
}
