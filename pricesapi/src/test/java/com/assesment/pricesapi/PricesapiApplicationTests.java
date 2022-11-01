package com.assesment.pricesapi;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import io.restassured.path.json.JsonPath;

@SpringBootTest
public class PricesapiApplicationTests {

	@Test
	public void apiCalledWhenRightBodyReturnsRightPrice() {
		final String resource = "http://localhost:8083/api/prices";

		final String payload = "{\r\n" + "  \"airline\": 1,\r\n"
				+ "  \"luggage\": 0,\r\n"
				+ "  \"distance\": 2300,\r\n"
				+ "  \"layover\": 0,\r\n" + "  \"days_left\": 15,\r\n"
				+ "  \"age_of_passenger\": 2\r\n" + "}";

		final String responseString = given()
				.header("Content-type", "application/json")
				.header("Accept", "application/json").body(payload)
				.post(resource).then().log().all().assertThat()
				.statusCode(200).extract().asString();

		final JsonPath js = new JsonPath(responseString);
		final String price = js.getString("price");

		Assert.assertEquals(Double.parseDouble(price), 119.0);
	}
}
