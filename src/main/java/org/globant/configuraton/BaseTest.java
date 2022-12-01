package org.globant.utils.baseTest;

import org.apache.log4j.Logger;
import org.globant.configuraton.Driver;

/*import org.espn.pages.HomePage;
import org.espn.reporting.Logger;*/
import org.globant.pageObjects.mobile.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static java.lang.String.format;

public class BaseTest  {
    protected Driver driver;
    protected HomePage home;
    public Logger log = Logger.getLogger(BaseTest.class);

    @Parameters({"browser", "url"})
    @BeforeClass
    public void testSetup(String browser, String url) {
        driver = new Driver(browser);
        log.info("Deleting all cookies");
        driver.deleteCookies();
        log.info(format("Navigating to %s", url));
        driver.getUrl();
        driver.maximizeWindow();
        home = new HomePage(driver.getDriver());
    }

    @AfterClass
    public void tearDown(){
        driver.closeBrowser();
    }
}