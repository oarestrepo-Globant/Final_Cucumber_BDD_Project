package org.globant.pageObjects.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.globant.utils.basePageObject.BaseScreen;

import java.util.Arrays;
import java.util.List;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

// TODO: Auto-generated Javadoc

/**
 * Class for Map screen.
 *
 */
public class MapScreen extends BaseScreen {

    /**
     * Constructor method for MapScreen.
     *
     * @param driver the driver
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle\")")
    private AndroidElement categoryList;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filterTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filter\")")
    private AndroidElement filterButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*toggleTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Show List\")")
    private AndroidElement showListButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categorySelectHeader\")\n")
    private AndroidElement categoryTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitleLayout\").childSelector(new UiSelector().classNameMatches(\"android.widget.ImageView\"))")
    private AndroidElement dropDownCategoryList;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*listSelectorContainer\").resourceIdMatches(\".*facilityTypeTitle\")")
    private List<AndroidElement> listOfCategoryOptions;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.LinearLayout\").childSelector(new UiSelector().descriptionContains(\"Hotels\"))")
    private AndroidElement hotelOptionLabel;

    /**
     * Allows you to evaluate whether the list of categories is displayed.
     * @return true if Category List element is displayed in screen, otherwise false.
     */
    public boolean categoryIsDisplayed() {
        return isElementAvailable(categoryList);
    }

    /**
     * Allows you to evaluate whether the filter button is displayed.
     * @return true if Filter Button element is displayed in screen, otherwise false.
     */
    public boolean filterIsDisplayed() {
        return isElementAvailable(filterButton);
    }

    /**
     * Allows you to evaluate whether the show list button is displayed.
     * return true if Show List Button element is displayed in screen, otherwise false.
     */
    public boolean showListIsDisplayed() {
        return isElementAvailable(showListButton);
    }

    /**
     * Allows you to evaluate whether the show list button is displayed.
     * Then allows to click on dropdown category list.
     *
     * @return true if different categories are listed to select, otherwise false.
     */
    public void tapCategoryList(){
        super.isElementAvailable(categoryTitle);
        super.click(dropDownCategoryList);
    }

    /**
     *
     * Evaluates the displayed options versus the desired ones and returns the number of matches.
     * @return number of matches.
     */
    public int getAmountOfPlansOptions(){
        isElementAvailable(categoryTitle);
        categoryTitle.getText().equalsIgnoreCase("Select Category");

        String option_1 = "Attractions";
        String option_2 = "Characters";
        String option_3 = "Dining";
        String option_4 = "Entertainment";
        String option_5 = "Restrooms";
        String option_6 = "Events and Tours";
        String option_7 = "PhotoPass";
        String option_8 = "Guest Services";
        String option_9 = "Shops";
        String option_10 = "Hotels";
        String option_11 = "Spa and Recreation";

        List<String> list = Arrays.asList(option_1, option_2, option_3, option_4, option_5, option_6, option_7, option_8, option_9, option_10, option_11);
        return getOptionsAmount(list, this.listOfCategoryOptions);
    }

    /**
     * Allows you to evaluate if the hotel option is displayed.
     * @return true if Hotel Option is displayed in screen, otherwise false.
     */
    public boolean isHotelOptionLabelAvailable(){
        return isElementAvailable(hotelOptionLabel);
    }
}
