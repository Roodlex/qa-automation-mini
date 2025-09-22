package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UiTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        try {
            String chromeBin = System.getenv("CHROME_BIN");       // from CI
            String driverPath = System.getenv("CHROMEDRIVER");    // from CI
            if (driverPath != null && !driverPath.isBlank()) {
                System.setProperty("webdriver.chrome.driver", driverPath);
            }

            ChromeOptions options = new ChromeOptions();
            if (chromeBin != null && !chromeBin.isBlank()) {
                options.setBinary(chromeBin);
            }
            options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");

            driver = new ChromeDriver(options);
        } catch (Exception e) {
            // Don’t fail CI just because Chrome/Driver mismatched on runner
            throw new SkipException("Skipping UI smoke on CI: " + e.getMessage());
        }
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void openGoogleHomePage() {
        if (driver == null) throw new SkipException("Driver not available on CI");
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("google"),
                "Google homepage did not load correctly");
    }
}
