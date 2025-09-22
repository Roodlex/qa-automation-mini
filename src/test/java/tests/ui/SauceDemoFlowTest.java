package tests.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.InventoryPage;
import pages.LoginPage;

public class SauceDemoFlowTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() { if (driver != null) driver.quit(); }

    @Test
    public void login_fail_showsError() {
        var login = new LoginPage(driver);
        login.open();
        login.login("bad_user", "bad_pass");
        Assert.assertTrue(login.getError().toLowerCase().contains("epic sadface"));
    }

    @Test
    public void login_success_addItemToCart_showsBadge1() {
        var login = new LoginPage(driver);
        login.open();
        login.login("standard_user", "secret_sauce");

        var inv = new InventoryPage(driver);
        inv.addFirstItemToCart();
        Assert.assertEquals(inv.getCartCount(), 1);
    }
}
