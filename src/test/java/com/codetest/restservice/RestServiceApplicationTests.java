package com.codetest.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.List;

import com.codetest.restservice.controllers.ServiceController;
import com.codetest.restservice.entities.Posts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import net.minidev.json.JSONObject;

@SpringBootTest
class RestServiceApplicationTests {

	@Autowired
	ServiceController controller;


	//test to check if the change made from the request was succesfull
	@Test
	public void CountNumberOfUsersUniqueID(){
		final JSONObject expected = new JSONObject();
		expected.appendField("usersId", 10);

		ResponseEntity<JSONObject> actual = controller.getCountUsersId();
		
		assertTrue(actual.getStatusCode() == HttpStatus.OK);

		assertEquals(expected, actual.getBody());
	}
	//test to check if the change made from the request was succesfull
	@Test
	public void checkIfFourItemChangeTitleFlowers(){
		final Posts expected = new Posts();
		expected.setTitle("1800Flowers");
		expected.setBody("1800Flowers");

		ResponseEntity<List<Posts>> actual = controller.getModifyFourPost();
		
		Posts actualPostChanged = actual.getBody().get(4);

		assertTrue(actual.getStatusCode() == HttpStatus.OK);

		assertEquals(expected.getTitle(), actualPostChanged.getTitle());

		assertEquals(expected.getBody(), actualPostChanged.getBody());

	}

}
