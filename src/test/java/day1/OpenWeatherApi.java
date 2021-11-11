package day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OpenWeatherApi {
	@Test(enabled = false, description = "Getting weather API information Generally")
	public void getWeatherInfo() {

		RestAssured.given().when()
				.get("https://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=a61e09c87e0404a999e1b41d518c171a")
				.then().log().body().statusCode(200);
	}

	@Test(enabled = false, description = "Getting weather API information Generally")
	public void getWeatherInfo2() {

		Response res = RestAssured.given().when()
				.get("https://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=a61e09c87e0404a999e1b41d518c171a");

		System.out.println(res.prettyPrint());
		System.out.println(res.getTime());
		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());

	}

	@Test(enabled = true, description = "Getting weather API information Generally")
	public void getWeatherInfo3() {
		Map<String, String> param = new HashMap<String, String>();
		param.put("q", "Chennai");
		param.put("appid", "a61e09c87e0404a999e1b41d518c171a");

		RestAssured.given()
//	    .queryParam("q", "Mumbai")
//	    .queryParam("appid", "a61e09c87e0404a999e1b41d518c171a")
				.params(param).when().get("https://api.openweathermap.org/data/2.5/weather").then().log().body()
				.statusCode(200);

	}
}
