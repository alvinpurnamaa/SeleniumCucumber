package com.alvin.stepdef;

import io.cucumber.java.en.Given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiStepDef {

    @Given("user get gorest users")
    public void getGorestUsers() {

        int statusCode =
                given()
                        .baseUri("https://gorest.co.in/public/v2")
                        .when()
                        .get("/users")
                        .then()
                        .log().all()
                        .extract()
                        .statusCode();

        assertTrue(statusCode == 200 || statusCode == 204);
    }
}