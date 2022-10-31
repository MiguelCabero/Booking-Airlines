import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PricesApiTest {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "http://localhost:8081";
	}

	@Test
	public void apiCalledWhenRightBodyReturns201() {

		final String resource = "/api/prices";

		final String responseString = given().queryParam("airline", 1)
				.queryParam("origin", 1).queryParam("destination", 2)
				.queryParam("luggage", true)
				.queryParam("roundtrip", true)
				.queryParam("datetime", "12/01/2023 12:00")
				.header("Accept", "application/json").get(resource)
				.then().log().all().assertThat().statusCode(200)
				.body("company", equalTo("Ryanair")).extract()
				.asString();

	}

}