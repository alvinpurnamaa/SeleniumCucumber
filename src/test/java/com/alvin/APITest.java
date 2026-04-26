package com.alvin;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class APITest {

    @Test
    public void getUsersTest() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";

        given()
                .when()
                .get("/users")
                .then()
                .log().all();

        assertTrue(true);
    }
}