package org.globant.utils.basePageObject;

import org.globant.configuraton.WebOperations;
import org.openqa.selenium.WebDriver;

public class BaseWebPage extends WebOperations {
    public BaseWebPage(WebDriver driver) {
        super(driver);
    }
}
