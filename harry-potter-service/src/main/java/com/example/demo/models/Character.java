package com.example.demo.models;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Character {

	@NotNull(message = "name must not be null")
	private String name;
	private String[] alternate_names;
	@NotNull(message = "species must not be null")
	private String species;
	@NotNull(message = "gender must not be null")
	private String gender;
	@NotNull(message = "house must not be null")
	private String house;
	@NotNull(message = "dateOfBirth must not be null")
	private String dateOfBirth;
	private String yearOfBirth;
	private Boolean wizard;
	private String ancestry;
	private String eyeColour;
	private String hairColour; 
	private Wand wand;
	private String patronus;
	private Boolean hogwartsStudent;
	private Boolean hogwartsStaff;
	private String actor;
	private List<String> alternate_actors;
	private Boolean alive;
	private String image;

}
