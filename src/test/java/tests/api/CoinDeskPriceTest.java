package tests.api;

import org.testng.SkipException;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CoinDeskPriceTest {

    @Test
    public void btcPrice_feedRespondsWithUsdRate() {
        if (util.TestEnv.isCi()) throw new SkipException("Skipping network test on CI");

        given()
        .when()
            .get("https://api.coincap.io/v2/assets/bitcoin")
        .then()
            .statusCode(200)
            .body("data.id", equalTo("bitcoin"))
            .body("data.priceUsd", not(isEmptyOrNullString()));
    }
}
