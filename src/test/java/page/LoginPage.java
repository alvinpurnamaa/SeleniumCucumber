package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By usernameField = By.cssSelector("input#user-name");
    By passwordField = By.xpath("//*[@id=\"password\"]");
    By loginButton = By.id("login-button");
    By errorMessage = By.className("error-message-container");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    //commit
}
