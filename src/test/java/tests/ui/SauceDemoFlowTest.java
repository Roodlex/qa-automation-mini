package tests.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import pages.InventoryPage;
import pages.LoginPage;

public class SauceDemoFlowTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        try {
            String chromeBin = System.getenv("CHROME_BIN");
            String driverPath = System.getenv("CHROMEDRIVER");
            if (driverPath != null && !driverPath.isBlank()) {
                System.setProperty("webdriver.chrome.driver", driverPath);
            }
            ChromeOptions options = new ChromeOptions();
            if (chromeBin != null && !chromeBin.isBlank()) options.setBinary(chromeBin);
            options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
        } catch (Exception e) {
            throw new SkipException("Skipping SauceDemo UI on CI: " + e.getMessage());
        }
    }

    @AfterClass(alwaysRun = true)
    public void teardown() { if (driver != null) driver.quit(); }

    @Test
    public void login_fail_showsError() {
        if (driver == null) throw new SkipException("Driver not available on CI");
        var login = new LoginPage(driver);
        login.open();
        login.login("bad_user", "bad_pass");
        Assert.assertTrue(login.getError().toLowerCase().contains("epic sadface"));
    }

    @Test
    public void login_success_addItemToCart_showsBadge1() {
        if (driver == null) throw new SkipException("Driver not available on CI");
        var login = new LoginPage(driver);
        login.open();
        login.login("standard_user", "secret_sauce");

        var inv = new InventoryPage(driver);
        inv.addFirstItemToCart();
        Assert.assertEquals(inv.getCartCount(), 1);
    }
}
