package com.alvin.stepdef;

import io.cucumber.java.de.Wenn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.LoginPage;

public class LoginStepDef {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user is on login page")
    public void userIsOnLoginPage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

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
        driver.quit();
    }

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        driver.quit();
    }
}

