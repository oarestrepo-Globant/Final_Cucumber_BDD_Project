package org.globant.pageObjects.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.globant.utils.basePageObject.BaseMobileScreen;

import java.util.Arrays;
import java.util.List;

import static org.globant.utils.configuration.mobile.MobileDriverConfig.getMobileDriver;


/**
 * Class for Menu screen.
 *
 */
public class MenuScreen extends BaseMobileScreen {

    @AndroidFindBy(uiAutomator="new UiSelector().resourceIdMatches(\".*FeatureItem\")")
    private List<AndroidElement> menuOptions;

    @AndroidFindBy (uiAutomator = "new UiSelector().resourceIdMatches(\".*content\").text(\"Privacy & Legal\")")
    private AndroidElement privacyLegalLinkText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*content\").className(\"android.widget.TextView\")")
    private List<AndroidElement> categoriesList;

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver<AndroidElement>
     *
     * */
    public MenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Allows to obtain the number of visible options.
     * @return amount of options displayed
     */
    public int getOptionsAmount(){
        return menuOptions.size();
    }

    /**
     * it scrolls down until screen bottom.
     */
    public void swipeScreenBottom(){
        int swipes = 0;
        int maxSwipesAmount = 5;
        while(!isElementAvailable(privacyLegalLinkText) && swipes < maxSwipesAmount){
            verticalSwipeEvent();
            swipes++;
        }
    }

    /**
     * Evaluates the displayed categories versus the desired ones and returns the number of matches.
     * @return amount of categories displayed
     */
    public int getAmountOfCategoriesListed(){
        String category_1 = "My Profile";
        String category_2 = "Property Rules";
        String category_3= "Cast Compliment";
        String category_4= "Link to Account";
        String category_5 = "Car Locator";
        String category_6 = "Help";
        String category_7 = "Privacy & Legal";

        List<String> list = Arrays.asList(category_1, category_2, category_3, category_4, category_5, category_6, category_7);
        return getOptionsAmount(list, this.categoriesList);
    }

    /**
     * click on Privacy & Legal button and return new PrivacyLegalScreen.
     * @return PrivacyLegalScreen
     */
    public PrivacyLegalScreen goToPrivacyLegalScreen(){
        click(privacyLegalLinkText);
        return new PrivacyLegalScreen(getMobileDriver());
    }
}
