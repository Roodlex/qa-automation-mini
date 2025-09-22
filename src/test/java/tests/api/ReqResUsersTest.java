package tests.api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ReqResUsersTest {

    private static final String BASE = "https://reqres.in/api";

    @Test
    public void getUser_byId_returnsValidSchema() {
        given()
        .when()
            .get(BASE + "/users/2")
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body(matchesJsonSchema(SCHEMA_USER));
    }

    @Test
    public void createUser_returns201_andEchoesFields() {
        String payload = """
            { "name": "QA Bot", "job": "automation" }
        """;

        given()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post(BASE + "/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("QA Bot"))
            .body("job", equalTo("automation"))
            .body("id", not(isEmptyOrNullString()))
            .body("createdAt", not(isEmptyOrNullString()));
    }

    // Minimal JSON schema (inline to avoid extra files)
    private static final String SCHEMA_USER = """
    {
      "$schema": "http://json-schema.org/draft-07/schema#",
      "type": "object",
      "properties": {
        "data": {
          "type": "object",
          "properties": {
            "id": { "type": "integer" },
            "email": { "type": "string" },
            "first_name": { "type": "string" },
            "last_name": { "type": "string" },
            "avatar": { "type": "string" }
          },
          "required": ["id","email","first_name","last_name","avatar"]
        }
      },
      "required": ["data"]
    }
    """;
}
