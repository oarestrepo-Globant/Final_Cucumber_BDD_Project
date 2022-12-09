package org.globant.utils.baseTest;

import org.apache.log4j.Logger;
import org.globant.utils.configuration.web.WebDriverConfig;
import org.globant.pageObjects.web.ESPNHomePage;
import org.globant.pageObjects.web.ESPNWatchPage;

import static java.lang.String.format;


/**
 * Class for ESPN Base Test.
 * This class has the setup to start the test.
 * It defines  driver, home Page and Watch page as a static attribute.
 * */
public class BaseTest  {
    protected static WebDriverConfig driverWeb;
    protected static ESPNHomePage home;
    protected static ESPNWatchPage watchPage;
    private static String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
    public static Logger log = Logger.getLogger(BaseTest.class);

    /**
     * Allows you to open a driver, open the browser and delete cookies.
     * */
    protected static void webTestSetup() {
        driverWeb = new WebDriverConfig();
        log.info("Deleting all cookies");
        driverWeb.deleteCookies();
        home = new ESPNHomePage(driverWeb.getDriver());
        watchPage = new ESPNWatchPage(driverWeb.getDriver());
    }

    /**
     * It opens the espn home page on the browser.
     * */
    public void goToEspnPage() {
        log.info(format("Navigating to %s", this.url));
        driverWeb.getUrl(this.url);
        driverWeb.maximizeWindow();
    }

    /**
     * Allows to close the browser
     * */
    protected static void tearDown(){
        driverWeb.closeBrowser();
    }
}