package com.assesment.pricesapi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PricesapiApplicationTests {

	@Test
	public void apiCalledWhenRightBodyReturnsRightPrice() {
		final String resource = "http://localhost:8083/api/prices";

		final String payload = "{\"luggage\": 0,\r\n" + "\"distance\": 2300,\r\n" + "\"stops\": 0,\r\n"
				+ "\"days_left\": 15,\r\n" + "\"age_of_passenger\": 2\r\n" + "}";

		final String responseString = given().header("Content-type", "application/json").body(payload).post(resource)
				.then().log().all().assertThat().statusCode(200).body("price", equalTo(119)).extract().asString();
	}
}
