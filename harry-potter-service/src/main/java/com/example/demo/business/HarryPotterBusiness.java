package com.example.demo.business;

import java.io.IOException;
import java.util.List;

import com.example.demo.models.Character;

public interface HarryPotterBusiness {
	
	List<Character> characters(String mouthOfBirth) throws IOException;

	List<Character> character(Character character) throws IOException;

}
