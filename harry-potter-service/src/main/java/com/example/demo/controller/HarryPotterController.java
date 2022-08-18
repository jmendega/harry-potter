package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.HarryPotterBusiness;
import com.example.demo.models.Character;

@RestController
@RequestMapping("/harrypotter")
public class HarryPotterController {
	
	@Autowired
	private HarryPotterBusiness harryPotterBusiness;
	
	@RequestMapping(value = "/characters", method = RequestMethod.GET)
	public List<Character> characters(@RequestParam(required = false) String mouthOfBirth) throws Exception{
		return harryPotterBusiness.characters(mouthOfBirth);	 
	}
	
	@RequestMapping(value = "/character", method = RequestMethod.POST)
	public List<Character> character(@Valid @RequestBody Character character) throws Exception{
		return harryPotterBusiness.character(character);	 
	}
	
	

}
