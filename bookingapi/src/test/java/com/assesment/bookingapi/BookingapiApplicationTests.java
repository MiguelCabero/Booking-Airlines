package com.assesment.bookingapi;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookingapiApplicationTests {

	@Test
	public void apiCalledWhenRightBodyReturns201() {

		final String resource = "http://localhost:8081/api/bookings";
		final String payloadString = "{\r\n"
				+ "    \"user_id\": 1,\r\n"
				+ "    \"airline_id\": 1,\r\n"
				+ "    \"datetime\": \"" + LocalDateTime.now()
				+ "\",\r\n" + "    \"origin\": 1,\r\n"
				+ "    \"destination\": 3,\r\n"
				+ "    \"luggage\": 1,\r\n" + "    \"price\": 800\r\n"
				+ "}";
		System.out.println(payloadString);
		final String responseString = given()
				.header("Content-type", "application/json").when()
				.body(payloadString).post(resource).then().log().all()
				.assertThat().statusCode(201).extract().asString();
	}
}
