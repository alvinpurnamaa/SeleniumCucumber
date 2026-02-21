package com.alvin.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
    @Then("user is on homepage")
    public void userIsOnHomepage() {

    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {
    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String username) {
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
    }

    @When("user click login button")
    public void userClickLoginButton() {
    }

    @Then("show error message")
    public void showErrorMessage() {
    }
}

