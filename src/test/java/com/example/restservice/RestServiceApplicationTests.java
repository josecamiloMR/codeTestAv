package com.example.restservice;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestServiceApplicationTests {

	@Autowired
	servController controller;


	//test to check if any of the services are not empty
	@Test
	public void checkNotEmpty() {
		String  testA= controller.firstPoint();
		assertNotEquals("", testA);
		
		String  testB= controller.secondPoint();
		assertNotEquals("", testA);
	}


	//test to check if the change made from the request was succesfull
	@Test
	public void check1800Change(){
		assertTrue(controller.secondPoint().contains("1800Flowers"));
	}

}
