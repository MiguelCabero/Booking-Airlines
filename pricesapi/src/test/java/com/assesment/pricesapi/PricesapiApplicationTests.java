package com.assesment.pricesapi;

import static io.restassured.RestAssured.given;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import com.assesment.pricesapi.services.DateUtilities;

import io.restassured.path.json.JsonPath;

@SpringBootTest
public class PricesapiApplicationTests {

	@Test
	public void apiCalledWhenRightBodyReturnsRightPrice() {
		final String resource = "http://localhost:8083/api/prices";

		final String payload = "{\r\n" + "  \"cityOne\": 1,\r\n"
				+ "  \"cityTwo\": 2,\r\n" + "  \"airline\": 3,\r\n"
				+ "  \"luggage\": 0,\r\n" + "  \"layover\": 0,\r\n"
				+ "  \"date_selected\": \"2022-11-19\",\r\n"
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

	@Test
	public void diffUTilityWhenCalledReturnDff()
			throws ParseException {
		final String date_target = "2022-11-17";
		final String date_from = "2022-11-02";

		final Long diff = DateUtilities.getDaysDifference(date_target,
				date_from);

		Assert.assertEquals(new Long(diff), new Long(15));
	}

	@Test
	public void generateDatesUTilityWhenCalledReturnSevenDates()
			throws ParseException {
		final String date_target = "2022-11-17";

		final List<LocalDate> dates = DateUtilities
				.generateDates(date_target);

		Assert.assertEquals(dates.size(), 7);
	}

	// Destination origin and date generate 7 flights
	@Test
	public void generateFlightsWhenCalledReturnsOk() {
		final String date_target = "2022-11-17";
		final String resource = "http://localhost:8083/api/prices/1/2/"
				+ date_target;

		final String responseString = given()
				.header("Content-type", "application/json")
				.header("Accept", "application/json").get(resource)
				.then().log().all().assertThat().statusCode(200)
				.extract().asString();
	}

	@Test
	public void generateFlightsWhenCalledReturnSevenFlights() {
		final String date_target = "2022-11-17";
		final String resource = "http://localhost:8083/api/prices/1/2/"
				+ date_target;

		final String responseString = given()
				.header("Content-type", "application/json")
				.header("Accept", "application/json").get(resource)
				.then().log().all().assertThat().statusCode(200)
				.extract().asString();

		final JsonPath js = new JsonPath(responseString);
		final int responseLength = js.getInt("$.size()");

		Assert.assertEquals(responseLength, 7);
	}
}
