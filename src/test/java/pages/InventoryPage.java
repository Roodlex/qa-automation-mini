package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {
    private final WebDriver driver;
    private final By firstAddToCart = By.cssSelector(
            ".inventory_item button.btn_primary, button[data-test='add-to-cart-sauce-labs-backpack']"
    );
    private final By cartBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) { this.driver = driver; }

    public void addFirstItemToCart() {
        driver.findElement(firstAddToCart).click();
    }

    public int getCartCount() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        return Integer.parseInt(driver.findElement(cartBadge).getText());
    }
}
