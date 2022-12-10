package org.globant.utils.basePageObject;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Base class for all screens Objects.
 *
 */
public abstract class BaseMobileScreen {

    protected final AndroidDriver<AndroidElement> mobileDriver;

    public Logger log = Logger.getLogger(BaseMobileScreen.class);

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     */
    public BaseMobileScreen(AndroidDriver<AndroidElement> driver) {
        this.mobileDriver = driver;
     initElements(new AppiumFieldDecorator(
                driver, Duration.ofSeconds(10)), this);
    }

    /**
     * Wrapper for click event.
     *
     * @param element : AndroidElement
     */
    public void click(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(mobileDriver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * Wrapper for Visibility event.
     *
     * @param element : AndroidElement
     * @return true if element is displayed,  otherwise return false.
     */
    public boolean isElementAvailable(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(mobileDriver, 3);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Wrapper for Visibility event.
     *
     * @param element : AndroidElement
     * @param timeout : int
     *
     * @return  true if element is displayed,  otherwise return false.
     */
    public boolean isElementAvailable(AndroidElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(mobileDriver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Wrapper for Visibility event.
     *
     * @param listOfElements : List
     *
     * @return true if element is displayed,  otherwise return false.
     */
    public boolean isElementAvailable(List listOfElements) {
        WebDriverWait wait = new WebDriverWait(mobileDriver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(listOfElements));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Wrapper for vertical swipe event.
     * */
    public void verticalSwipeEvent() {
        Dimension dim = mobileDriver.manage().window().getSize();
        int x = dim.getHeight() / 2;
        int y = dim.getWidth() / 2;
        int edgeBorder = 10;
        try {
           new TouchAction(mobileDriver)
                   .press(PointOption.point(x, y))
                   .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                   .moveTo(PointOption.point(x, edgeBorder))
                   .release()
                   .perform();
        } catch (Exception e) {
            System.err.println("verticalSwipeEvent(): TouchAction FAILED\n" + e.getMessage());
        }
    }

    /**
     * Evaluates the displayed options versus the desired ones and returns the number of matches.
     *
     * @param stringsList : List<String>
     * @param elementList : List<AndroidElement>
     *
     * @return amount of options displayed.
     */
    public int getOptionsAmount(List<String> stringsList, List<AndroidElement> elementList) {
        int optionsValidatedAmount = 0;

        isElementAvailable(elementList);
        for (String optionString: stringsList) {
            for (AndroidElement element:elementList) {
                element.getText();
                if(optionString.equals(element.getText()))
                    optionsValidatedAmount++;
            }
        }
        return optionsValidatedAmount;
    }
}

