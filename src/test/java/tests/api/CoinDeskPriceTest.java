package tests.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CoinDeskPriceTest {

    @Test
    public void btcPrice_feedRespondsWithUsdRate() {
        // CoinCap public endpoint - very stable
        given()
        .when()
            .get("https://api.coincap.io/v2/assets/bitcoin")
        .then()
            .statusCode(200)
            .body("data.id", equalTo("bitcoin"))
            .body("data.priceUsd", not(isEmptyOrNullString()))
            .body("data.changePercent24Hr", not(isEmptyOrNullString()));
    }
}
