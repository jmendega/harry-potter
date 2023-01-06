package com.howtodoinjava.xml.school;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wand {
	
	private String wood;
	private String core;
	private String length;

}
