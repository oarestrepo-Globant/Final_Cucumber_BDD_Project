package org.globant.testing.stepDefinitions;

import io.cucumber.java.en.Given;
import org.globant.utils.configuration.mobile.MobileDriverConfig;

public class MobileSteps extends MobileDriverConfig {


    @Given("I am in the main screen")
    public void iAmInTheMainScreen() {
        environmentSetUp();
        loadDashBoardScreen();

        System.out.println("GIVEN");
        System.out.println("GIVEN");
    }
}
