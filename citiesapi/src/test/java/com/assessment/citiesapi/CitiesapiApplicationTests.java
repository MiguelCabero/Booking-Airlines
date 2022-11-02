package com.assessment.citiesapi;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import io.restassured.path.json.JsonPath;

@SpringBootTest
class CitiesapiApplicationTests {

	@Test
	void retrieveAllCitiesWhenCalledReturnsOk() {
		final String resource = "http://localhost:8084/api/cities";

		final String responseString = given()
				.header("Accept", "application/json").when()
				.get(resource).then().log().all().assertThat()
				.statusCode(200).extract().asString();

		final JsonPath js = new JsonPath(responseString);
		final int responseLength = js.getInt("$.size()");

		Assert.assertEquals(responseLength, 8);
	}

	@Test
	void retrieveAllCitiesWhenCalledReturnsSize() {
		final String resource = "http://localhost:8084/api/cities";

		final String responseString = given()
				.header("Accept", "application/json").when()
				.get(resource).then().log().all().extract()
				.asString();

		final JsonPath js = new JsonPath(responseString);
		final int responseLength = js.getInt("$.size()");

		Assert.assertEquals(responseLength, 8);
	}

}