package com.example.howtodoinjava.springbootsoapservice;

import java.util.List;

import com.howtodoinjava.xml.school.Character;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServiceImpl {

	@GET("harrypotter/characters")
	 Call<List<Character>> getCharacters(@Query("mouthOfBirth") String month);
}
