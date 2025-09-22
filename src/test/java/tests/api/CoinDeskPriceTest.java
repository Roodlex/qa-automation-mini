package tests.api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CoinDeskPriceTest {

    @Test
    public void btcPrice_feedRespondsWithUsdRate() {
        given()
        .when()
            .get("https://api.coindesk.com/v1/bpi/currentprice.json")
        .then()
            .statusCode(200)
            .body("chartName", equalTo("Bitcoin"))
            .body("bpi.USD.rate_float", greaterThan(0.0f))
            .body("time.updatedISO", not(isEmptyOrNullString()));
    }
}
