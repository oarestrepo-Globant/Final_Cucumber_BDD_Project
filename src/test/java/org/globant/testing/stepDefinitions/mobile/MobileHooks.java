package org.globant.testing.stepDefinitions.mobile;

import io.cucumber.java.*;
import org.globant.utils.configuration.mobile.MobileDriverConfig;

public class MobileHooks extends MobileDriverConfig {

    /**
     * It lifts the server and the initial mobile configuration.
     * */
    @Before("@mobile")
    public void beforeMobile(){
        environmentSetUp();
    }

    /**
     * Closes the app after every scenario.
     * */
    @After("@mobile")
    public void closeAndroidApplication(){
        mobileApplicationEnd();
    }
}
