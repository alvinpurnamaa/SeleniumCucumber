package com.alvin.stepdef;

import io.cucumber.java.en.Given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiStepDef {

    @Given("user get gorest users")
    public void getGorestUsers() {
        given()
                .baseUri("https://gorest.co.in/public/v2")
                .when()
                .get("/users")
                .then()
                .log().all()
                .statusCode(200);
    }
}