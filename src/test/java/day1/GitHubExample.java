package day1;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class GitHubExample {
  @Test(enabled=false, description="Getting all repositories")
  
  public void getAllRepo() {
	  given()
	  .auth()
	  .oauth2("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")
	  .when()
	  .get("https://api.github.com/user/repos")
	  .then()
	  .log()
	  .body()
	  .statusCode(200)
	  .time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS);
  }
 @Test(enabled=true, description="Adding repositories")
  
  public void addRepository() {
	 JSONObject js=new JSONObject();
	 js.put("name", "tsl968-restAssured");
	 js.put("description", "I am created by RestAssured");
	 js.put("homepage", "https://github.com/shaikhRabiya");
	  given()
	  .auth() // Specifying Authentication needed
	  .oauth2("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")
	  .header("Content-Type","application/json")
	  .body(js.toJSONString())
	  .when()
	  .post("https://api.github.com/user/repos")
	  .then()
	  .log()
	  .body()
	  .statusCode(201)
	  .time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS);
  }
}
