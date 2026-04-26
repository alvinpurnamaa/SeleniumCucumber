package com.alvin.stepdef;

import io.cucumber.java.en.Given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiStepDef {

    @Given("user get API user detail")
    public void getApiUser() {
        given()
                .baseUri("https://reqres.in/api")
                .when()
                .get("/users/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }
}