package org.globant.utils.basePageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Class for Base Web Page.
 * */
public class BaseWebPage  {

    /**
     * Constructor method for BaseWebPage
     * */
    private final WebDriver driver;
    private final WebDriverWait wait;
    protected final Actions action;

    /**
     * Constructor method for WebOperations class.
     * @param driver:WebDriver
     * */
    public BaseWebPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15L);
        this.action = new Actions(driver);
        initElements(driver, this);
    }

    /**
     * Allows to obtain the driver
     * @return driver
     * */
    protected WebDriver getDriver() {
        return driver;
    }

    /**
     * Allows you to wait for the visibility of an element on a web page until it is clickable.
     * @param element: WebElement
     * */
    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Allows you to wait for the visibility of an element on a web page.
     * @param element: WebElement
     * */
    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Allows you to wait for the visibility of a list of elements on a web page.
     * @param elements: List<WebElement>
     * */
    public void waitForVisibility(List<WebElement> elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    /**
     * Allows you to click on a visible element on the web page.
     * @param element: WebElement
     * */
    public void clickElement(WebElement element){
        waitForVisibility(element);
        waitForClickable(element);
        element.click();
    }

    /**
     * Allows to wait for the visibility of a form element and then send the necessary data to it.
     * @param element: WebElement
     * @param text: String
     * */
    public void typeOnPlaceholder(WebElement element, String text){
        waitForVisibility(element);
        element.sendKeys(text);
    }

    /**
     * Allows you to wait for the visibility of an element and then hover the mouse over it.
     * @param element: WebElement
     * */
    public void placeMouseToElement(WebElement element){
        waitForVisibility(element);
        action.moveToElement(element).perform();
    }

    /**
     * Allows you to change the iframe of the web page.
     * @param frameToChange:String
     * */
    public void changeToIframe(String frameToChange){
        driver.switchTo().frame(frameToChange);
    }

    /**
     * Allows you to ga back into previous page.
     * */
    public void backToPreviousPage(){
        driver.navigate().back();
    }

    /**
     * Allows you to refresh the browser.
     * */
    public void refreshBrowser(){
        driver.navigate().refresh();
    }
}

