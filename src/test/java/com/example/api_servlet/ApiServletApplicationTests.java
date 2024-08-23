package com.example.api_servlet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

// Para simplificar foi feito apenas teste de integração
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApiServletApplicationTests {
	// Injetamos o teste restTemplate 
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void test() {
		User user = new User(null, "user", "113", "teste@email.com");

		User postResponse = restTemplate.postForObject("/users", user, User.class);

		assertNotNull(postResponse.id());
		assertEquals(user.username(), postResponse.username());
		assertEquals(user.email(), postResponse.email());
		assertEquals(user.password(), postResponse.password());

		User[] getResponses = restTemplate.getForObject("/users", User[].class);
		User getResponse = getResponses[0];

		assertNotNull(getResponse.id());
		assertEquals(user.username(), getResponse.username());
		assertEquals(user.email(), getResponse.email());
		assertEquals(user.password(), getResponse.password());
	}

}
