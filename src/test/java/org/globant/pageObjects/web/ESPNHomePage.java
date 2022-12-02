package org.globant.pageObjects.web;

import org.globant.utils.basePageObject.BaseWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Class for ESPN Home Page.
 * This class has methods that recreate actions of a user inside ESPN Home page.
 * */
public class ESPNHomePage extends BaseWebPage{
    @FindBy(id="global-viewport")
    private WebElement homePageView;
    @FindBy(id ="global-user-trigger")
    private WebElement userIcon;
    @FindBy(id ="oneid-iframe")
    private WebElement loginUserIFrame;
    @FindBy(id="logo")
    private WebElement espnLogo;
    @FindBy(css="button#BtnSubmit")
    private WebElement loginButton;
    @FindBy(css = "button#BtnCreateAccount")
    private WebElement signUpButton;
    @FindBy(css="li.user div.global-user-container ul.account-management li:last-child > a")
    private WebElement loginUserButton;
    @FindBy(css="input#InputLoginValue")
    private WebElement placeHolderUserName;
    @FindBy(css="input#InputPassword")
    private WebElement placeHolderPassword;
    @FindBy(css="li.user > div > div > ul.account-management > li.display-user > span")
    private WebElement userNameInNavText;

    @FindBy(css="li.user > div > div > ul.account-management > li.display-user > span")
    private List<WebElement> userNameInNavTextList;

    @FindBy(css="li.pillar.watch > a")
    private WebElement watchButton;

    @FindBy(css="ul > li.user > div > div > ul.account-management > li:nth-child(9) > a")
    private WebElement logoutButton;

    @FindBy(css="ul .account-management >li > a[tref='/members/v3_1/modifyAccount']")
    private WebElement espnProfileButton;

    @FindBy(css="a[id='AccountDeleteLink']")
    private WebElement deleteAccountTextButton;

    @FindBy(css="button#BtnSubmit")
    private WebElement yesDeleteAccountButton;

    @FindBy(id="#BtnSubmit")
    private WebElement okButtonFromDeleteAccount;

    @FindBy(css=".form-section > #BtnSubmit")
    private WebElement submitButtonFromLoginAndLogutIframe;

    @FindBy(css="#Title > span")
    private WebElement areYouSureText;

    /**
     * Constructor method for ESPNHomePage class.
     * @param driver:WebDriver
     * */
    public ESPNHomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Allows you to place the mouse over an element of the page.
     * */
    public void placeMouseOnUserIcon(){
        super.placeMouseToElement(userIcon);
    }

    /**
     * Validates if the modal login is visible.
     * @return true if visible, otherwise return false.
     * */
    public boolean isModalLoginDisplayed(){
        waitForVisibility(loginUserIFrame);
        return loginUserIFrame.isDisplayed();
    }

    /**
     * Validates if the ESPN logo is visible.
     * @return true if visible, otherwise return false.
     * */
    public boolean isEspnLogoDisplayed(){
        return espnLogo.isDisplayed();
    }

    /**
     * Validates if the Signup button is visible.
     * @return true if visible, otherwise return false.
     * */
    public boolean isSignUpButtonDisplayed(){
        return signUpButton.isDisplayed();
    }

    /**
     * Validates if the login button is visible.
     * @return true if visible, otherwise return false.
     * */
    public boolean isLoginIsDisplayed(){
        return loginButton.isDisplayed();
    }

   /* public boolean isModalEelementsDisplayed(){
        return isEspnLogoDisplayed() && isSignUpButtonDisplayed() && isLoginIsDisplayed();
    }*/

    /**
     * Allows you to switch to the login iframe.
     * */
    public void changeToLoginIframe(){
        super.changeToIframe(loginUserIFrame.getAttribute("id"));
    }

    /**
     *Allows you to click on the login button
     * */
    public void clickLoginUserButton(){
        super.clickElement(loginUserButton);
    }

    /**
     * Allows to write email and password for login.
     * @param email:String
     * @param password:String
     * */
    public void enterLoginCredentials(String email, String password){
        super.typeOnPlaceholder(placeHolderUserName, email);
        super.typeOnPlaceholder(placeHolderPassword, password);
        super.clickElement(loginButton);
    }

    /**
     * Allows you to obtain the user name displayed in the user panel.
     * */
    public String getUsernameLogged() {
        super.placeMouseToElement(userIcon);
        return userNameInNavText.getText();
    }

    /**
     * Allows to click on the "Watch" button.
     * */
    public ESPNWatchPage clickWatchButton(){
        super.clickElement(watchButton);
        return new ESPNWatchPage(super.getDriver());
    }

    /**
     * Allows to click on the "Logout" button.
     * */
    public void clickLogoutButton() {
        super.clickElement(logoutButton);
    }

    /**
     * Check if a user is logged in.
     * @return true if there is a user logged in, otherwise return false.
     * */
    public boolean checkUserIsLoggedOut() {
        super.refreshBrowser();
        super.placeMouseToElement(userIcon);
        return userNameInNavTextList.size() == 0;
    }

    /**
     * It makes the login process and validate that it was successfully.
     * @param email:String
     * @param password:String
     * @return true if the login was successfully, otherwise return false.
     * */
    public boolean loginProcess(String email, String password) {
        placeMouseOnUserIcon();
        clickLoginUserButton();
        changeToLoginIframe();
        enterLoginCredentials(email, password);
        return true;
    }

    /**
     * It makes the logout process and validate that it was successfully.
     * @return true if the logout was successfully, otherwise return false.
     * */
    public void logoutProcess(){
        placeMouseOnUserIcon();
        clickLogoutButton();
        checkUserIsLoggedOut();
    }
/*
    public void waitForAreYouSureText(){
        super.waitForVisibility(areYouSureText);
    }

    //FACTORIZAR
    public void deactivate()  {
        placeMouseOnUserIcon();
        super.clickElement(espnProfileButton);
        changeToLoginIframe();
        super.waitForVisibility(deleteAccountTextButton);
        super.scrollDownPage();
        super.placeMouseToElement(deleteAccountTextButton);
        super.clickElement(deleteAccountTextButton);

        waitForAreYouSureText();
        super.waitForText(submitButtonFromLoginAndLogutIframe, "Yes, delete this account");

        super.clickElement(submitButtonFromLoginAndLogutIframe);
        super.waitForText(submitButtonFromLoginAndLogutIframe,"OK" );
        super.clickElement(submitButtonFromLoginAndLogutIframe);
    }

    public boolean isAccountDeactivated()  {
        String text = "";
        String a = "Account Deactivated";
        String b = "Find Your Account";

        super.placeMouseToElement(areYouSureText);
        waitForVisibility(areYouSureText);
        text = areYouSureText.getText();

        return text.contains(a) || text.contains(b);
    }*/
}