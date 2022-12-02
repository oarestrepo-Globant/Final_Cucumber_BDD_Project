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
     * Allows to create an account in the ESPN webpage
     * */
    @Given("I am a valid espn user")
    public void iAmAValidEspnUser() {
        log.info("Place mouse over icon user avatar");
        home.placeMouseOnUserIcon();

        log.info("Click on login button");
        home.clickLoginUserButton();
        //home.changeToLoginIframe();


        log.info("Login modal is present");
        Assert.assertTrue(home.isModalLoginDisplayed(), "Modal is NOT present");
        home.changeToLoginIframe();

        log.info("ESPN logo is displayed in login modal");
        Assert.assertTrue(home.isEspnLogoDisplayed(), "The modal NOT contains ESPN logo");

        log.info("Login button is displayed on login modal");
        Assert.assertTrue(home.isLoginIsDisplayed(), "The modal NOT contains login button");

        log.info("SignUp button is displayed on login modal");
        Assert.assertTrue(home.isSignUpButtonDisplayed(), "The modal NOT contains SignUp button");

        //////SIGNUP ABAJO DE ESTA LINEA

        log.info("Click first signup button");
        home.clickSubmitButton();

        log.info("Fill signup form");
        home.fillSignUpForm();

        //////SIGNUP ARRIBA DE ESTA LINEA

    }

    /**
     *Allows to navigate to the Watch page on the ESPN website.
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
     * Allows to go back into previous page.
     * */
    @And("I can go back to the ESPN landing page")
    public void iCanGoBackToTheESPNLandingPage() {
        log.info("Back to home page");
        watchPage.backToHomePage();

        log.info("Verify home page is displayed");
        Assert.assertEquals(home.getUsernameLogged(), "Oscar!");
    }

    /**
     * Allows the user to be logged out and check it has a successfully logout process..
     * */
    @And("I can logout from my ESPN account")
    public void iCanLogoutFromMyESPNAccount() {
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
