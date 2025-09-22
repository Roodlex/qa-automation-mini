package tests.api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ReqResUsersTest {

    @Test
    public void createPost_returns201_andEchoesTitle() {
        // Using JSONPlaceholder (public test API): POST returns 201
        String payload = """
            { "title": "qa-sample", "body": "demo", "userId": 1 }
        """;

        given()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("https://jsonplaceholder.typicode.com/posts")
        .then()
            .statusCode(201)
            .body("title", equalTo("qa-sample"))
            .body("id", notNullValue());
    }
}
