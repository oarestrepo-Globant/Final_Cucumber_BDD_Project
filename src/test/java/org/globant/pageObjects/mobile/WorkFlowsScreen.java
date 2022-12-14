package org.globant.pageObjects.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.globant.utils.basePageObject.BaseMobileScreen;

import static org.globant.utils.configuration.mobile.MobileDriverConfig.getMobileDriver;

/**
 * Class for Work Flow Screen
 *
 */
public class WorkFlowsScreen extends BaseMobileScreen {

    @AndroidFindBy(id = "permission_primary_btn")
    private AndroidElement getStartedButton;

    @AndroidFindBy(id = "permission_primary_btn")
    private AndroidElement shareLocationButton;

    @AndroidFindBy(id = "android:id/button1")
    private AndroidElement allowLocationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_allow_foreground_only_button\")")
    private AndroidElement allowButton;

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver<AndroidElement>
     *
     */
    public WorkFlowsScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }


    /**
     * Start permissions process by clicking get started button.
     */
    public void startPermissionsProcess() {
        click(this.getStartedButton);
    }

    /**
     * Share Location permissions process.
     * @return DashBoardScreen
     */
    public DashBoardScreen shareLocationPermissions() {
       super.click(this.shareLocationButton);
        super.click(this.allowLocationButton);
        super.click(this.allowButton);
        return new DashBoardScreen(getMobileDriver());
    }
}
