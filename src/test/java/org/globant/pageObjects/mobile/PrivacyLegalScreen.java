package org.globant.pageObjects.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.globant.utils.basePageObject.BaseScreen;

import java.util.Arrays;
import java.util.List;

/**
 * Class for Privacy & Legal screen.
 *
 */
public class PrivacyLegalScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*txt_element\")")
    private List<AndroidElement> legaOptionsList;

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     */
    public PrivacyLegalScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     *
     * Evaluates the displayed options versus the desired ones and returns the number of matches.
     * @return list of options displayed.
     */
    public int getAmountOfLegalOptionsListed(){
        String option_1 = "Privacy Policy";
        String option_2 = "Terms of Use";
        String option_3 = "Supplemental Terms and Conditions";
        String option_4 = "Legal Notices";
        String option_5 = "Property Rules";
        String option_6 = "Electronic Communications Disclosure";
        String option_7 = "Your California Privacy Rights";
        String option_8 = "Do Not Sell My Personal Information";
        String option_9 = "In-App Maps Subject to Google Terms and Conditions";
        String option_10 = "In-App Maps Subject to Google Privacy Policy";

        List<String> list = Arrays.asList(option_1, option_2, option_3, option_4, option_5, option_6, option_7, option_8, option_9, option_10);
        return getOptionsAmount(list, this.legaOptionsList);
    }
}
