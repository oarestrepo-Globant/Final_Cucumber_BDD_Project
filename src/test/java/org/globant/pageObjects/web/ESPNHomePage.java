package org.globant.pageObjects.web;

import org.globant.utils.basePageObject.BaseWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(css=".form-section > #BtnSubmit")
    private WebElement submitButtonFromLoginAndLogutIframe;

   /* @FindBy(css="#Title > span")
    private WebElement areYouSureText;

    @FindBy(css="a[id='AccountDeleteLink']")
    private WebElement deleteAccountTextButton;

    @FindBy(css="button#BtnSubmit")
    private WebElement yesDeleteAccountButton;

    @FindBy(id="#BtnSubmit")
    private WebElement okButtonFromDeleteAccount;*/

    public ESPNHomePage(WebDriver driver) {
        super(driver);
    }

    public void placeMouseOnUserIcon(){
        super.placeMouseToElement(userIcon);
    }
    public boolean isModalLoginDisplayed(){
        waitForVisibility(loginUserIFrame);
        return loginUserIFrame.isDisplayed();
    }

    public boolean isEspnLogoDisplayed(){
        return espnLogo.isDisplayed();
    }

    public boolean isSignUpButtonDisplayed(){
        return signUpButton.isDisplayed();
    }

    public boolean isLoginIsDisplayed(){
        return loginButton.isDisplayed();
    }

   /* public boolean isModalEelementsDisplayed(){
        return isEspnLogoDisplayed() && isSignUpButtonDisplayed() && isLoginIsDisplayed();
    }*/

    public void changeToLoginIframe(){
        super.changeToIframe(loginUserIFrame.getAttribute("id"));
    }

    public void clickLoginUserButton(){
        super.clickElement(loginUserButton);
    }

    public void enterLoginCredentials(String email, String password){
        super.typeOnPlaceholder(placeHolderUserName, email);
        super.typeOnPlaceholder(placeHolderPassword, password);
        super.clickElement(loginButton);
    }

    public String getUsernameLogged() {
        super.placeMouseToElement(userIcon);
        return userNameInNavText.getText();
    }

    public ESPNWatchPage clickWatchButton(){
        super.clickElement(watchButton);
        return new ESPNWatchPage(super.getDriver());
    }

    public void clickLogoutButton() {
        super.clickElement(logoutButton);
    }

    public boolean checkUserIsLoggedOut() {
        super.refreshBrowser();
        super.placeMouseToElement(userIcon);
        return userNameInNavTextList.size() == 0;
    }

    public boolean loginProcess(String email, String password) {
        placeMouseOnUserIcon();
        clickLoginUserButton();
        changeToLoginIframe();
        enterLoginCredentials(email, password);
        return true;
    }

    public void logoutProcess(){
        placeMouseOnUserIcon();
        clickLogoutButton();
        checkUserIsLoggedOut();
    }

   /* public void waitForAreYouSureText(){
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