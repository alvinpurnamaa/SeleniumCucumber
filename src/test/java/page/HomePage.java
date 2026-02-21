package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {

    WebDriver driver;

    By backPackItem = By.className("inventory_item_name");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void validateBackPackDisplated() {
        assertTrue(driver.findElement(backPackItem).isDisplayed());
    }
}
