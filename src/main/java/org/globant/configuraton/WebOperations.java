package org.globant.configuraton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;
/**
 * Class for WebOperations.
 * This class has methods that recreate the general actions of a user on a web page.
 *
 * */
public class WebOperations {
    private final WebDriver driver;
    private final WebDriverWait wait;
    protected final Actions action;

    /**
     * Constructor method for WebOperations class.
     * @param driver:WebDriver
     * */
    public WebOperations(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15L));
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
        //clickElement(element);
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

    /**
     * Allows you to scroll down the web page.
     * */
    public void scrollDownPage(){
        action
                .scrollByAmount(0, 10000)
                .perform();
    }

    /**
     * Allows you to wait for the visibility of the text of an element on the web page.
     * @param element: WebElement
     * @param text:String
     * @return true if the text is visible on the element, otherwise returns false
     * */
    public boolean waitForText(WebElement element, String text){
        return  wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}
