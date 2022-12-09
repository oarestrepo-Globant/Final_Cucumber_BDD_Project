package org.globant.pageObjects.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.globant.utils.basePageObject.BaseScreen;

import java.util.Arrays;
import java.util.List;

/**
 * Class for Add Plans Screen.
 *
 */
public class AddPlansScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*actionSheetItemText\")")
    private List<AndroidElement> plansOptionList;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*actionSheetItemText\").text(\"Check Dining Availability\")")
    private AndroidElement reserveDinningOptionText;

    /**
     * Constructor method for AddPlansScreen class.
     *
     * @param driver : AndroidDriver
     */
    public AddPlansScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     *
     * Evaluates the displayed options versus the desired ones.
     * @return the amount of matches between displayed options versus the desired ones.
     */
    public int getPlanOptionsAmount(){
        String option_1 = "Check Dining Availability";
        String option_2 = "Order Food";
        String option_3 = "Shop in Store ";
        String option_4 = "Link PhotoPass Photos";
        String option_5 = "Buy Tickets and Passes";
        String option_6 = "Make a Park Reservation";
        String option_7 = "View My Genie Day and Tip Board";

        List<String> list = Arrays.asList(option_1, option_2, option_3, option_4, option_5, option_6, option_7);
        return getOptionsAmount(list, this.plansOptionList);
    }

    /**
     * allows you to check if the dinning option is visible
     * @return true it is displayed, otherwise return false.
     */
    public boolean isReserveDiningOptionDisplayed(){
        return isElementAvailable(reserveDinningOptionText);
    }
}
