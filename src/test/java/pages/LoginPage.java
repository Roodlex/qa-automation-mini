package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By user = By.id("user-name");
    private final By pass = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By error = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) { this.driver = driver; }

    public void open() { driver.get("https://www.saucedemo.com/"); }

    public void login(String username, String password) {
        driver.findElement(user).clear();
        driver.findElement(user).sendKeys(username);
        driver.findElement(pass).clear();
        driver.findElement(pass).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public String getError() { return driver.findElement(error).getText(); }
}
