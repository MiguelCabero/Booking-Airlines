import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BookingApiTest {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "http://localhost:8081";
	}

	@Test
	public void apiCalledWhenRightBodyReturns201() {

		final String resource = "/api/bookings";

		final String payloadString = "{\r\n"
				+ "    \"user_id\": 1,\r\n"
				+ "    \"airline_id\": 1,\r\n" + "    \"datetime\": "
				+ LocalDateTime.now() + "\r\n"
				+ "    \"origin\": 1,\r\n"
				+ "    \"destination\": 3,\r\n"
				+ "    \"luggage\": 1,\r\n" + "    \"price\": 800\r\n"
				+ "}";

		final String responseString = given()
				.header("Accept", "application/json").when()
				.body(payloadString).post(resource).then().log().all()
				.assertThat().statusCode(201).extract().asString();

	}

}
