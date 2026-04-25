package com.alvin.stepdef;

import com.alvin.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import page.LoginPage;

public class LoginStepDef {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        driver = DriverFactory.getDriver(); // ✅ ambil di sini
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String username) {
        loginPage.inputUsername(username);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        loginPage.inputPassword(password);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("show error message")
    public void showErrorMessage() {
    }

    @Then("user is on homepage")
    public void userIsOnHomepage() {
    }
}