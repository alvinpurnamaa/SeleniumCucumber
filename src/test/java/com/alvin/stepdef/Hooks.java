package com.alvin.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.alvin.DriverFactory;

public class Hooks {

    @Before
    public void setup() {
        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}