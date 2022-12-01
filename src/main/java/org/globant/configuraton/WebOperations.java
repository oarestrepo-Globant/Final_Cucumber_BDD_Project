package org.globant.configuraton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOperations {
    private final WebDriver driver;
    private final WebDriverWait wait;
    protected final Actions action;

    public WebOperations(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15L));
        this.action = new Actions(driver);
        initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(List<WebElement> elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void clickElement(WebElement element){
        waitForVisibility(element);
        waitForClickable(element);
        element.click();
    }

    public void typeOnPlaceholder(WebElement element, String text){
        waitForVisibility(element);
        placeMouseToElement(element);
        element.sendKeys(text);
    }

    public void placeMouseToElement(WebElement element){
        waitForVisibility(element);
        action.moveToElement(element).perform();
    }

    public void changeToIframe(String frameToChange){
        driver.switchTo().frame(frameToChange);
    }

    public void backToPreviousPage(){
        driver.navigate().back();
    }

    public void refreshBrowser(){
        driver.navigate().refresh();
    }

    public void scrollDownPage(){
        action
                .scrollByAmount(0, 1000)
                .perform();
    }

    public boolean waitForText(WebElement element, String text){
        return  wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}
