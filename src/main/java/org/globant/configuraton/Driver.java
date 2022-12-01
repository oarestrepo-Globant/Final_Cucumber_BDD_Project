package org.globant.configuraton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

public class Driver {
    private WebDriver  webDriver;

    public Driver(String browser){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }
    @Parameters({"url"})
    public WebDriver getDriver() {
        return webDriver;
    }

    public void closeBrowser(){
        getDriver().quit();
    }

    public void deleteCookies(){
        getDriver().manage().deleteAllCookies();
    }

    public void getUrl(){
        webDriver.get("https://www.espnqa.com/?src=com&_adblock=true&espn=cloud");
    }

    public void maximizeWindow(){
        getDriver().manage().window().maximize();
    }
}