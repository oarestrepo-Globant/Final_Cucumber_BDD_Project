package org.globant.testing.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.globant.utils.baseTest.BaseTest;
import org.testng.Assert;

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
     * Verify that the entire process to create an account on the espn website is successful.
     * */
   
    @Given("I am a valid espn user")
    public void iAmAValidEspnUser() {
        log.info("Place mouse over icon user avatar");
        home.placeMouseOnUserIcon();

        log.info("Click on login button");
        home.clickLoginUserButton();

        log.info("Login modal is present");
        Assert.assertTrue(home.isModalLoginDisplayed(), "Modal is NOT present");
        home.changeToLoginIframe();

        log.info("ESPN logo is displayed in login modal");
        Assert.assertTrue(home.isEspnLogoDisplayed(), "The modal NOT contains ESPN logo");

        log.info("Login button is displayed on login modal");
        Assert.assertTrue(home.isLoginIsDisplayed(), "The modal NOT contains login button");

        log.info("SignUp button is displayed on login modal");
        Assert.assertTrue(home.isSignUpButtonDisplayed(), "The modal NOT contains SignUp button");

        /// Sign Up

        log.info("Click first signup button");
        home.clickSubmitButton();

        log.info("Specified elements from SignUp modal are displayed");
        Assert.assertTrue(home.checkIfAllElementsFromSingUpModalAreDisplayed(), "Not all elements are displayed");

        log.info("Fill signup form and create account");
        home.fillSignUpFormAndCreateAccount();
    }

    /**
     * Direct the test to espn's watch page.
     * */
    @When("I go to ESPN watch page")
    public void iGoToESPNWatchPage() {
        log.info("Go to Watch page");
        home.clickWatchButton();
    }

    /**
     * Check if the login modal is present. Then check that the ESPN logo, the login button and the signup button are present.
     * Finally it close the modal.
     * */
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

    /**
     * Verify that the user can return to the home page from the watch page.
     * */
    @And("I can go back to the ESPN landing page")
    public void iCanGoBackToTheESPNLandingPage() {
        log.info("Back to home page");
        watchPage.backToHomePage();

        log.info("Verify home page is displayed");
        Assert.assertEquals(home.getUsernameLogged(), "Oscar!");
    }

    /**
     * Allows the user to be logged out. Then check if it was a successfully logout.
     * */
    @And("I can logout from my ESPN account")
    public void iCanLogoutFromMyESPNAccount() {
        log.info("Doing Log out");
        home.clickLogoutButton();

        log.info("Logout successfully");
        Assert.assertTrue(home.checkUserIsLoggedOut(),"Unsuccessfully logout");
    }

    @Given("I want to be new user and fill signup form with {string} {string} {string} {string}")
    public void iWantToBeNewUserAndFillSignupFormWith(String firstname, String lastname, String email, String password) {
        throw new io.cucumber.java.PendingException();
    }

    

   /* @AfterAll
    public static void afterAll(){
        tearDown();
    }*/

}
