package org.globant.pageObjects.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.globant.utils.basePageObject.BaseScreen;

import static org.globant.utils.configuration.mobile.MobileDriverConfig.getMobileDriver;


/**
 * DashBoard screen.
 *
 * @author Hans.Marquez
 */
public class DashBoardScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*android:id/button2\")")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"dismiss-icon\")")
    private AndroidElement dismissWelcome;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").descriptionContains(\"Map\")")
    private AndroidElement mapButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches( \".*tab_icon\").descriptionContains(\"More Options, Tab, 5of5\")")
    private AndroidElement menuButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_animated_icon\")")
    private AndroidElement addPlanButton;

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     * @author Hans.Marquez
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Navigate to Login Screen from DashBoard Screen.
     */
    public MapScreen goToMapScreen() {
        click(mapButton);
        return new MapScreen(super.mobileDriver);
    }

    /**
     * @author oscar.restrepo
     * dismiss previous alerts before DashBoard Screen is displayed.
     */
    public void dismissActions() {
        if (this.isElementAvailable(dismissWelcome, 25)){
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)){
            click(dismissPreferenceUpdateButton);
        }
    }

    /**
     * @author oscar.restrepo
     * Tap on menu button available in dashboard screen and return PrivacyLegalScreen Object instance.
     */
    public MenuScreen clickMenuButton(){
        click(menuButton);
        return new MenuScreen(getMobileDriver());
    }

    /**
     * @author oscar.restrepo
     * Click on Add Plans Button at bottom of the screen.
     */
    public AddPlansScreen clickAddPlansButton(){
        click(addPlanButton);
        return new AddPlansScreen(getMobileDriver());
    }
}