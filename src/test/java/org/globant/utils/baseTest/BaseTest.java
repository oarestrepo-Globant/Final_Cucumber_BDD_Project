package org.globant.utils.baseTest;

import org.apache.log4j.Logger;
import org.globant.configuraton.Driver;
import org.globant.pageObjects.web.ESPNHomePage;
import org.globant.pageObjects.web.ESPNWatchPage;

import static java.lang.String.format;

public class BaseTest  {
    protected static Driver driver;
    protected static ESPNHomePage home;
    protected static ESPNWatchPage watchPage;
    public static Logger log = Logger.getLogger(BaseTest.class);

    protected static final String email = "test.espn@test.com";
    protected static final String password = "oscar123";

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

    protected static void tearDown(){
        driver.closeBrowser();
    }
}