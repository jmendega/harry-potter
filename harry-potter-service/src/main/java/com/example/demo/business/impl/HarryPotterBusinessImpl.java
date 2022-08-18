package com.example.demo.business.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.business.HarryPotterBusiness;
import com.example.demo.models.Character;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class HarryPotterBusinessImpl implements HarryPotterBusiness {

	@Autowired
	ApiServiceImpl apiServiceImpl;

	@Override
	public List<Character> characters(String mouthOfBirth) throws IOException {
		List<Character> responseList = getCharacters().body();

		if (mouthOfBirth != null) {
			return getListCharacters(mouthOfBirth, responseList);
		}

		return responseList;
	}

	@Override
	public List<Character> character(Character character) throws IOException {
		Response<List<Character>> response = getCharacters();
		response.body().add(character);
		return response.body();
	}

	private List<Character> getListCharacters(String mouthOfBirth, List<Character> responseList) {
		List<Character> listCharacters = new ArrayList<>();
		responseList.stream().filter(character -> !character.getDateOfBirth().equals("")).forEach(e -> {
			if (getMonthDate(e.getDateOfBirth()).equals(Integer.valueOf(mouthOfBirth))) {
				listCharacters.add(e);
			}
		});
		return listCharacters;
	}

	private Response<List<Character>> getCharacters() throws IOException {
		Call<List<Character>> retrofitCall = apiServiceImpl.getCharacters();
		return retrofitCall.execute();
	}

	private Integer getMonthDate(String demo) {
		try {
			Date date = new SimpleDateFormat("dd-MM-yyyy").parse(demo);
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			return localDate.getMonthValue();

		} catch (ParseException e1) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "date of birth format error", e1);
		}
	}

}
