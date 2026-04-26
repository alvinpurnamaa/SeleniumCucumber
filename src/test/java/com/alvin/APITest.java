package com.alvin;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class APITest {

    @Test
    public void getUsersTest() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";

        int statusCode =
                given()
                        .when()
                        .get("/users")
                        .then()
                        .log().all()
                        .extract()
                        .statusCode();

        // Accept 200 or 204 (kadang API kosong)
        assertTrue(statusCode == 200 || statusCode == 204);
    }
}