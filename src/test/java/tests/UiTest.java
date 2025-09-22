package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UiTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Use Chrome installed by GitHub Actions (set in ci.yml)
        String chromeBin = System.getenv("CHROME_BIN");
        ChromeOptions options = new ChromeOptions();
        if (chromeBin != null && !chromeBin.isBlank()) {
            options.setBinary(chromeBin);
        }
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");

        // Selenium 4 will resolve the matching driver automatically
        driver = new ChromeDriver(options);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void openGoogleHomePage() {
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("google"));
    }
}
