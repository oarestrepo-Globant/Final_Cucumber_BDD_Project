package org.globant.utils.baseTest;

import org.apache.log4j.Logger;
import org.globant.configuraton.Driver;
import org.globant.pageObjects.web.ESPNHomePage;
import org.globant.pageObjects.web.ESPNWatchPage;

import static java.lang.String.format;


/**
 * Class for ESPN Base Test.
 * This class has the setup to start the test.
 * It defines  driver, home Page and Watchpage as a static attribute.
 * */

public class BaseTest  {
    protected static Driver driver;
    protected static ESPNHomePage home;
    protected static ESPNWatchPage watchPage;
    public static Logger log = Logger.getLogger(BaseTest.class);

    /*protected static final String email = "test.espn@test.com";
    protected static final String password = "oscar123";*/

    /**
     * Allows you to open a dirver, open the browser, delete cookies and open the ESPN site in full screen mode.
     * */
    protected static void testSetup(String url) {
        driver = new Driver();
        log.info("Deleting all cookies");
        driver.deleteCookies();
        log.info(format("Navigating to %s", url));
        driver.getUrl(url);
        driver.maximizeWindow();
        home = new ESPNHomePage(driver.getDriver());
        watchPage = new ESPNWatchPage(driver.getDriver());
    }

    /**
     * Allows to close the browser
     * */
    protected static void tearDown(){
        driver.closeBrowser();
    }

}