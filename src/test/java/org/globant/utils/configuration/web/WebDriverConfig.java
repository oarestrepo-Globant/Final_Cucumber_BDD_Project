package org.globant.utils.configuration.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class for Web WebDriverConfig.
 * This class has the methods related to the chrome driver.
 * */
public class WebDriverConfig {
    private WebDriver  webDriver;

    /**
     * Constructor method for web driver class.
     * */
    public WebDriverConfig(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    /**
     * Allows to obtain the driver
     * @return driver
     * */
    public WebDriver getDriver() {
        return webDriver;
    }

    /**
     * Allows to close the browser.
     * */
    public void closeBrowser(){
        getDriver().quit();
    }

    /**
     * Allows to delete browser cookies.
     * */
    public void deleteCookies(){
        getDriver().manage().deleteAllCookies();
    }

    /**
     * Allows to open a specified web page.
     * @param url:String
     * */
    public void getUrl(String url){
        webDriver.get(url);
    }

    /**
     * Allows to open the browser in full screen
     * */
    public void maximizeWindow(){
        getDriver().manage().window().maximize();
    }
}