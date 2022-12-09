package org.globant.testing.stepDefinitions.web;

import io.cucumber.java.*;
import org.globant.utils.baseTest.BaseTest;

public class WebHooks extends BaseTest {

    /**
     * It lifts the driver and the browser before the test
     * */
    @Before("@web")
    public static void beforeWeb(){
        webTestSetup();
    }

    /**
     * It closes the browser after the test is done.
     * */
    @After("@web")
    public static void after(){
        tearDown();
    }
}
