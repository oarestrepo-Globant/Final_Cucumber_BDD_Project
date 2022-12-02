package org.globant.testing.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.globant.utils.baseTest.BaseTest;
import org.testng.Assert;

import static java.lang.String.format;

public class EspnWebSteps extends BaseTest {
    private static String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";

    /*@BeforeAll
    public static void beforeAll(){
        testSetup(url);
    }*/


    @Given("Open browser and enter ESPN url")
    public void openBrowserAndEnterESPNUrl() {
        testSetup(url);
    }

    @Given("I place mouse over the icon user avatar")
    public void iPlaceMouseOverTheIconUserAvatar() {
//        home.logout();
        log.info("Place mouse over icon user avatar");
        home.placeMouseOnUserIcon();
    }

    @When("I click  login button")
    public void iClickLoginButton(){
        log.info("Click on login button");
        home.clickLoginUserButton();
    }

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
        home.login(email, password);
        home.clickWatchButton();
    }


    @Then("I can see specified elements")
    public void iCanSeeSpecifiedElements() {
        log.info("Verify at least one carousel is displayed");
        Assert.assertTrue(watchPage.verifyAtLeastOneCarouselIsDisplayed(), "No carousel is displayed");

        log.info("");
        watchPage.isAllCardsFromCarousel();
    }

    @And("I can go back to the landing page")
    public void iCanGoBackToTheLandingPage() {
    }

   /* @AfterAll
    public static void afterAll(){
        tearDown();
    }*/
}
