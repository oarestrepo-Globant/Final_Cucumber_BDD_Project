package org.globant.utils.configuration.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.globant.pageObjects.mobile.DashBoardScreen;
import org.globant.pageObjects.mobile.WorkFlowsScreen;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class for Mobile Driver Configuration.
 * */
public class MobileDriverConfig {
    protected static WorkFlowsScreen workFlows;
    protected static DashBoardScreen dashBoard ;
    public static AndroidDriver<AndroidElement> mobileDriver;
    public static Logger log = Logger.getLogger(MobileDriverConfig.class);

    /**
     * Start Navigation and Close alerts before DashBoard Screen.
     *
     */
   public static void setUpStartApp() {
        workFlows = new WorkFlowsScreen(getMobileDriver());
        dashBoard = new DashBoardScreen(getMobileDriver());

        log.info("Start Navigation");
        loadDashBoardScreen();

        log.info("Close alerts before DashBoard Screen");
        dashBoard.dismissActions();
    }


    /**
     * SetUp before to run suite of test.
     *
     */
    public static void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetUp(capabilities);
        ConfigCapabilities.applicationSetUp(capabilities);
        try {
            mobileDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }

    }


    /**
     * Close the application after completing the test.
     *
     */
    public void mobileApplicationEnd() {
        mobileDriver.quit();
    }

    /**
     * return the driver.
     *
     * @return driver
     */
    public static AndroidDriver<AndroidElement> getMobileDriver() {
        return mobileDriver;
    }

    /**
     * return SignUpOrLogInScreen after close the alerts.
     *
     * @return SignUpOrLogInScreen
     */
    protected static DashBoardScreen loadDashBoardScreen() {
        workFlows.startPermissionsProcess();
        return workFlows.shareLocationPermissions();
    }
}
