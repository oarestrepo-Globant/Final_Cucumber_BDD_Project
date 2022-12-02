package org.globant.utils.basePageObject;

import org.globant.configuraton.WebOperations;
import org.openqa.selenium.WebDriver;

/**
 * Class for Base Web Page.
 * */
public class BaseWebPage extends WebOperations {
    /**
     * Constructor method for BaseWebPage
     * */
    public BaseWebPage(WebDriver driver) {
        super(driver);
    }
}
