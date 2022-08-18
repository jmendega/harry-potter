package com.example.demo.bussines.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.business.impl.ApiServiceImpl;
import com.example.demo.business.impl.HarryPotterBusinessImpl;
import com.example.demo.models.Character;

import retrofit2.Call;
import retrofit2.mock.Calls;

public class HarryPotterBusinessImplTest {

	@Mock
	ApiServiceImpl apiServiceImpl;

	@InjectMocks
	HarryPotterBusinessImpl harryPotterBusinessImpl;

	List<Character> charactersList = new ArrayList<>();

	@BeforeEach
	public void setUp() {

		charactersList.add(Character.builder().name("name").species("species").gender("gender").house("house")
				.dateOfBirth("29-12-1982").build());
		charactersList.add(Character.builder().name("name2").species("species2").gender("gender2").house("house2")
				.dateOfBirth("29-11-1982").build());
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getCharactersMonthOfBirthNull() throws IOException {

		// Arrange
		Call<List<Character>> callCharacters = Calls.response(charactersList);
		when(apiServiceImpl.getCharacters()).thenReturn(callCharacters);

		// Act
		List<Character> response = harryPotterBusinessImpl.characters(null);

		// Assert
		assertNotNull(response);

	}

	@Test
	void getCharacters() throws IOException {

		// Arrange
		Call<List<Character>> callCharacters = Calls.response(charactersList);
		when(apiServiceImpl.getCharacters()).thenReturn(callCharacters);

		// Act
		List<Character> response = harryPotterBusinessImpl.characters("11");

		// Assert
		assertNotNull(response);
		assertEquals(1, response.size());

	}

	@Test
	void character() throws IOException {

		// Arrange
		Character character = Character.builder().name("name3").species("species3").gender("gender3").house("house3")
				.dateOfBirth("29-10-1982").build();
		Call<List<Character>> callCharacters = Calls.response(charactersList);
		when(apiServiceImpl.getCharacters()).thenReturn(callCharacters);

		// Act
		List<Character> response = harryPotterBusinessImpl.character(character);

		// Assert
		assertNotNull(response);
		assertEquals(3, response.size());
	}
	
	@Test
	void getCharactersErrorGetMonth() throws IOException {

		// Arrange
		Character character = Character.builder().name("name3").species("species3").gender("gender3").house("house3")
				.dateOfBirth("29/10/1982").build();
		charactersList.add(character);
		Call<List<Character>> callCharacters = Calls.response(charactersList);
		when(apiServiceImpl.getCharacters()).thenReturn(callCharacters);

		// Act
		// Assert
		assertThrows(ResponseStatusException.class, ()->harryPotterBusinessImpl.characters("11"));

	}

}
