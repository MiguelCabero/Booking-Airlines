import static io.restassured.RestAssured.given;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class LogsApiTest {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "http://localhost:8081";
	}

	@Test
	public void apiCalledWhenRightBodyReturns201() {

		final String resource = "/api/logs";

		final String payloadString = "{\r\n"
				+ "    \"client_ip\": \"127.0.0.1\",\r\n"
				+ "    \"timestamp_start\": \""
				+ Timestamp.valueOf(LocalDateTime.now()) + "\"\r\n"
				+ "}";
		final String responseString = given()
				.header("Accept", "application/json").when()
				.body(payloadString).post(resource).then().log().all()
				.assertThat().statusCode(201).extract().asString();

	}

}
