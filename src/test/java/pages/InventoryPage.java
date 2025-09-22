package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private final WebDriver driver;
    private final By firstAddToCart = By.cssSelector(".inventory_item button.btn_primary");
    private final By cartBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) { this.driver = driver; }

    public void addFirstItemToCart() { driver.findElement(firstAddToCart).click(); }

    public int getCartCount() {
        return Integer.parseInt(driver.findElement(cartBadge).getText());
    }
}
