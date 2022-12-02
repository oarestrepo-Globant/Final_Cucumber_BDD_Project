package org.globant.testing.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.globant.utils.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Class for ESPN Web Steps.
 * This class has methods that represent the step-by-step for the test automation of the espn page.
 * */
public class EspnWebSteps extends BaseTest {
    private static String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
    private String username = "Oscar!";

    /*@BeforeAll
    public static void beforeAll(){
        testSetup(url);
    }*/

    /**
     * This method lifts the driver, performs the initial configurations
     * and allows you to open the browser and access the ESPN website.
     * */
    @Given("Open browser and enter ESPN url")
    public void openBrowserAndEnterESPNUrl() {
        testSetup(url);
    }

    /**
     * Allows you to place the mouse over the user's avatar icon.
     * */
    @Given("I place mouse over the icon user avatar")
    public void iPlaceMouseOverTheIconUserAvatar() {
        //home.logout();
        log.info("Place mouse over icon user avatar");
        home.placeMouseOnUserIcon();
    }

    /**
     * Allows to click on the login button.
     * */
    @When("I click  login button")
    public void iClickLoginButton(){
        log.info("Click on login button");
        home.clickLoginUserButton();
    }

    /**
     * Check if the login modal is present. Then check that the ESPN logo, the login button and the signup button are present.
     * */
    @Then("Modal is present and contains specified elements")
    public void modalIsPresentAndContainsSpecifiedElements() {
        log.info("Login modal is present");
        Assert.assertTrue(home.isModalLoginDisplayed(), "Modal is NOT present");
        home.changeToLoginIframe();

        log.info("ESPN logo is displayed in login modal");
        Assert.assertTrue(home.isEspnLogoDisplayed(), "The modal NOT contains ESPN logo");

        log.info("Login button is displayed on login modal");
        Assert.assertTrue(home.isLoginIsDisplayed(), "The modal NOT contains login button");

        log.info("SignUp button is displayed on login modal");
        Assert.assertTrue(home.isSignUpButtonDisplayed(), "The modal NOT contains SignUp button");
    }


    @Given("As a logged user go the Watch page")
    public void asALoggedUserGoTheWatchPage() {
        //ESTOS VALORES DEBEN SER PASADOS POR PARAMETROS
        home.loginProcess(email, password);
        home.clickWatchButton();
    }

    @Then("I can see specified elements")
    public void iCanSeeSpecifiedElements() {
        log.info("Verify at least one carousel is displayed");
        Assert.assertTrue(watchPage.verifyAtLeastOneCarouselIsDisplayed(), "No carousel is displayed");

        log.info("Each card in the carousel has description");
        Assert.assertTrue(watchPage.checkEachCardInCarouselHasDescription(), "At least one card has NOT description");

        log.info("Verify x button is present in second card from the first carousel");
        watchPage.isXButtonFromSupplierModalPresent();

        log.info("Close modal");
        watchPage.clickXButtonFromSupplierModal();
    }

    @And("I can go back to the landing page")
    public void iCanGoBackToTheLandingPage() {
        log.info("Back to home page");
        watchPage.backToHomePage();

        log.info("Verify home page is displayed");
        Assert.assertEquals(home.getUsernameLogged(), "Oscar!");
    }

    @And("I can log out")
    public void iCanLogOut() {
        log.info("Doing Log out");
        home.clickLogoutButton();

        log.info("Logout successfully");
        Assert.assertTrue(home.checkUserIsLoggedOut(),"Unsuccessfully logout");
    }

   /* @AfterAll
    public static void afterAll(){
        tearDown();
    }*/
}
