package org.globant.testing.stepDefinitions.mobile;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.globant.utils.configuration.mobile.MobileDriverConfig;

public class DisneyMobileHooks extends MobileDriverConfig {

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
