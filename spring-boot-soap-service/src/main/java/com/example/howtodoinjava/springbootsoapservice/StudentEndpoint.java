package com.example.howtodoinjava.springbootsoapservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.howtodoinjava.xml.school.Character;
import com.howtodoinjava.xml.school.Student;
import com.howtodoinjava.xml.school.StudentDetailsRequest;
import com.howtodoinjava.xml.school.StudentDetailsResponse;

import retrofit2.Call;
import retrofit2.Response;

@Endpoint
public class StudentEndpoint {
	private static final String NAMESPACE_URI = "http://www.howtodoinjava.com/xml/school";

	private StudentRepository StudentRepository;
	private static final Map<String, Student> students = new HashMap<>();
	
	@Autowired
	ApiServiceImpl apiServiceImpl;

	@Autowired
	public StudentEndpoint(StudentRepository StudentRepository) {
		this.StudentRepository = StudentRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
	@ResponsePayload
	public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) throws IOException {
		StudentDetailsResponse response = new StudentDetailsResponse();
		List<Student> studentList = new ArrayList<>();
		
		List<Character> responseList = getCharacters(request.getMonth()).body();
		
		responseList.stream().forEach(e -> {
			Student student = new Student();
			student.setName(e.getName());
			student.setStandard(Integer.parseInt(e.getYearOfBirth()));
			student.setAddress(e.getHouse());
//			studentList.add(student);
			response.getStudent().add(student);
		});
		

		return response;
	}
	
	private Response<List<Character>> getCharacters(String month) throws IOException {
		Call<List<Character>> retrofitCall = apiServiceImpl.getCharacters(month);
		return retrofitCall.execute();
	}
}