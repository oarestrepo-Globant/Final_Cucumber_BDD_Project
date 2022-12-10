package org.globant.testing.stepDefinitions.web;

import io.cucumber.java.en.*;
import org.globant.utils.baseTest.BaseWebTest;
import org.testng.Assert;

/**
 * Class for ESPN Web Steps.
 * This class has methods that represent the step-by-step for the test automation of the espn page.
 * */
public class EspnWebSteps extends BaseWebTest {
    private String username = "Oscar!";


    /**
     * This method lifts the driver, performs the initial configurations
     * and allows you to open the browser and access the ESPN website.
     * */
    @Given("I go to ESPN page")
    public void iGoToESPNPage() {
        goToEspnPage();
    }

    /**
     * Verify that the entire process to create an account on the espn website is successful.
     * */
    @When("I want to be new user and fill signup form with {string} {string} {string} {string}")
    public void iWantToBeNewUserAndFillSignupFormWith(String firstname, String lastname, String email, String password) {
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

        log.info("Click first signup button");
        home.clickSubmitButton();

        log.info("Specified elements from SignUp modal are displayed");
        Assert.assertTrue(home.checkIfAllElementsFromSingUpModalAreDisplayed(), "Not all elements are displayed");

        log.info("Fill signup form and create account");
        home.fillSignUpFormAndCreateAccount(firstname,  lastname,  email, password);
    }

    /**
     * Navigate to espn's watch page.
     * */
    @And("I navigate to the Watch page")
    public void iNavigateToTheWatchPage() {
        log.info("Go to Watch page");
        home.clickWatchButton();
    }

    /**
     * Verify that specified elements are displayed on watch page.
     * */
    @Then("I should see the carousel")
    public void iShouldSeeTheCarousel() {
        log.info("Verify at least one carousel is displayed");
        Assert.assertTrue(watchPage.verifyAtLeastOneCarouselIsDisplayed(), "No carousel is displayed");

        log.info("Each card in the second carousel has title and description");
        Assert.assertTrue(watchPage.checkEachCardInCarouselHasDescription(), "At least one card has NOT description");
    }

    /**
     * Go to the previous page (home page) and click on the logout button.
     * */
    @But("I logout from my ESPN account")
    public void iLogoutFromMyESPNAccount() {
        log.info("Verify x button is present in second card from the first carousel");
        watchPage.isXButtonFromSupplierModalPresent();

        log.info("Close modal");
        watchPage.clickXButtonFromSupplierModal();

        log.info("Back to home page");
        watchPage.backToHomePage();

        log.info("Verify home page is displayed");
        Assert.assertEquals(home.getUsernameLogged(), username);

        log.info("Doing Log out");
        home.clickLogoutButton();
    }

    /**
     * Check if the user had a successfully logout and is on the espn main page.
     * */
    @Then("I should return to the main page")
    public void iShouldReturnToTheMainPage() {
        log.info("Logout successfully");
        Assert.assertTrue(home.checkUserIsLoggedOut(),"Unsuccessfully logout");
    }
}
