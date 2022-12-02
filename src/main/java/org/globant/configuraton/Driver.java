package org.globant.configuraton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private WebDriver  webDriver;

    public Driver(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }
    //@Parameters({"url"})
    public WebDriver getDriver() {
        return webDriver;
    }

    public void closeBrowser(){
        getDriver().quit();
    }

    public void deleteCookies(){
        getDriver().manage().deleteAllCookies();
    }

    public void getUrl(String url){
        webDriver.get(url);
    }

    public void maximizeWindow(){
        getDriver().manage().window().maximize();
    }
}