package org.globant.utils.baseTest;

import org.apache.log4j.Logger;
import org.globant.configuraton.Driver;
import org.globant.pageObjects.web.HomePage;

import static java.lang.String.format;

public class BaseTest  {
    protected static Driver driver;
    protected static HomePage home;
    public static Logger log = Logger.getLogger(BaseTest.class);

    protected static void testSetup(String url) {
        driver = new Driver();
        log.info("Deleting all cookies");
        driver.deleteCookies();
        log.info(format("Navigating to %s", url));
        driver.getUrl(url);
        driver.maximizeWindow();
        home = new HomePage(driver.getDriver());
    }

    protected static void tearDown(){
        driver.closeBrowser();
    }
}