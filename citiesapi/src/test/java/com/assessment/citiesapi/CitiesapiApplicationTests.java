package com.assessment.citiesapi;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CitiesapiApplicationTests {

	@Test
	void retrieveAllCitiesWhenCalledReturnsOk() {
		final String resource = "http://localhost:8084/api/cities";

		final String responseString = given().header("Accept", "application/json").when().get(resource).then().log()
				.all().assertThat().statusCode(200).extract().asString();
	}

}