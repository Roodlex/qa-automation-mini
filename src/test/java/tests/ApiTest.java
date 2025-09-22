package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class ApiTest {
    @Test
    public void testGetUsers() {
        RestAssured.given()
            .when().get("https://jsonplaceholder.typicode.com/users/1")
            .then().statusCode(200)
            .and().body("id", equalTo(1))
            .and().body("username", not(isEmptyOrNullString()));
    }
}
