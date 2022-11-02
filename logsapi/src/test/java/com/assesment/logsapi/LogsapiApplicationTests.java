package com.assesment.logsapi;

import static io.restassured.RestAssured.given;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class LogsapiApplicationTests {

	String timeStamp;
	String clientIpString = "";

	@BeforeAll
	public void setup() {
		timeStamp = Timestamp.valueOf(LocalDateTime.now()).toString().replaceAll(" ", "");
		clientIpString = "127.0.0.1";
	}

	@Test
	@Order(1)
	public void apiCalledWhenRightBodyReturns201() {

		final String resource = "http://localhost:8082/api/logs";

		final String payloadString = "{\r\n" + "    \"clientIp\": \"" + clientIpString + "\",\r\n"
				+ "    \"timestampStart\": \"" + timeStamp + "\"\r\n" + "}";

		final String responseString = given().header("Content-type", "application/json").when().body(payloadString)
				.post(resource).then().log().all().assertThat().statusCode(201).extract().asString();
	}

	@Test
	@Order(2)
	public void findByIpAndTimeStampReturnsOk() {

		final String resource = "http://localhost:8082/api/logs/" + clientIpString + "/" + timeStamp;

		System.out.println(resource);
		final String responseString = given().header("Accept", "application/json").when().get(resource).then().log()
				.all().assertThat().statusCode(200).extract().asString();
	}

	@Test
	@Order(3)
	public void findByIpAndTimeStampReturnsNotFound() {

		final String resource = "http://localhost:8082/api/logs/" + "128.5.5.19" + "/" + timeStamp;

		System.out.println(resource);
		final String responseString = given().header("Accept", "application/json").when().get(resource).then().log()
				.all().assertThat().statusCode(404).extract().asString();
	}

	@Test
	@Order(4)
	public void updateByIdAndTimeStampReturnsOk() throws InterruptedException {

		final String timeStampEnd = Timestamp.valueOf(LocalDateTime.now()).toString().replaceAll(" ", "");

		final String resource = "http://localhost:8082/api/logs/" + clientIpString + "/" + timeStamp;

		final String timeStampUpdate = "{\r\n" + "\"timestampEnd\" : \"" + timeStampEnd + "\"\r\n" + "}";

		System.out.println(timeStampUpdate);

		System.out.println(resource);
		final String responseString = given().header("Content-type", "application/json").when().body(timeStampUpdate)
				.put(resource).then().log().all().assertThat().statusCode(200).extract().asString();
	}
}
