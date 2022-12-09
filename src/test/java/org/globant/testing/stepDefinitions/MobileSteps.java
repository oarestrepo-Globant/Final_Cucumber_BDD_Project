package org.globant.testing.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.globant.pageObjects.mobile.AddPlansScreen;
import org.globant.pageObjects.mobile.MapScreen;
import org.globant.pageObjects.mobile.MenuScreen;
import org.globant.pageObjects.mobile.PrivacyLegalScreen;
import org.globant.utils.configuration.mobile.MobileDriverConfig;
import org.testng.Assert;

public class MobileSteps extends MobileDriverConfig {

    private final int amountOfPlansOptionsExpected = 11;
    private final int optionsAmountExpected = 6;
    private final int categoriesListedAmountExpected = 7;
    private final int legalOptionsAmountExpected = 10;

    private final int amountPlansOptionExpected = 7;
    private MapScreen map;
    private MenuScreen menu;
    private PrivacyLegalScreen privacy;
    private AddPlansScreen addPlan;

   /* @Before("@mobile")
    public static void beforeMobile(){
        environmentSetUp();
    }*/

    /**
     * It lifts the driver and starts de disney app.
     * */
    @Given("I am in the main screen")
    public void iAmInTheMainScreen() {
        log.info("Doing SetUp");
        environmentSetUp();
        //////////////////////////
    }

    /**
     * Allows you to go to the map view and validates that:
     *      There is a list of map options.
     *      There is a category button.
     *      There is a filter button.
     * */
    @Given("I am in the Map view")
    public void iAmInTheMapView() {
        log.info("Start Navigation to Map Screen");
        map = dashBoard.goToMapScreen();

        log.info("Validate Show List Button");
        Assert.assertTrue(map.showListIsDisplayed(), "Show List is not displayed");

        log.info("Validate Category Button");
        Assert.assertTrue(map.categoryIsDisplayed(), "Category is not displayed");

        log.info("Validate Filter Button");
        Assert.assertTrue(map.filterIsDisplayed(), "Filter is not displayed");
    }

    /**
     * Allows you to tap on the list of categories and expand it.
     * */
    @When("I tap category list")
    public void iTapCategoryList() {
        log.info("Tap Category List");
        //MapScreen maps  = new MapScreen(getMobileDriver());
        map.tapCategoryList();
    }

    /**
     * Allows you to check if all categories are displayed and in particular to verify that the Hotels option is displayed.
     * */
    @Then("I should see a list of categories")
    public void iShouldSeeAListOfCategories() {
        log.info("Validate Different categories are listed to select");
        Assert.assertEquals(map.getAmountOfPlansOptions(), amountOfPlansOptionsExpected);

        log.info("Validate Hotel Option is available");
        Assert.assertTrue(map.isHotelOptionLabelAvailable(), "Hotels Option is not displayed");

        mobileApplicationEnd();
    }

    ////////// PRIVACY & LEGAL //////////

    /**
     * Allows you to go to the menu screen and validate it is displayed.
     * */
    @Given("I am in the Menu screen")
    public void iAmInTheMenuScreen() {
        log.info("Tap Dashboard Menu Button");
        menu = dashBoard.clickMenuButton();

        log.info("Validate Menu view ");
        Assert.assertEquals(menu.getOptionsAmount(), optionsAmountExpected);
    }

    /**
     * Allows to go to the privacy and legal screen.
     * Validates that all categories are displayed.
     * */
    @When("I tap on Privacy & legal")
    public void iTapOnPrivacyLegal() {
        log.info("Scroll down menu view");
        menu.swipeScreenBottom();

        log.info("Validate 7 categories are listed");
        Assert.assertEquals(menu.getAmountOfCategoriesListed(), categoriesListedAmountExpected);

        log.info("Go to Privacy & Legal screen");
        privacy = menu.goToPrivacyLegalScreen();
    }

    /**
     * Allows to verify that there are 10 options in the privacy and legal screen.
     * */
    @Then("I should see a list of options")
    public void iShouldSeeAListOfOptions() {
        log.info("Validate list of 10 Legal Options are displayed");
        Assert.assertEquals(privacy.getAmountOfLegalOptionsListed(), legalOptionsAmountExpected);

        mobileApplicationEnd();
    }

////////// ADD PLANS OPTION //////////

    /**
     * Allows go to the Add Plans screen
     * */
    @When("I am in the Add Plans screen")
    public void iAmInTheAddPlansScreen() {
        log.info("Tap Add Plans Button in dashboard screen");
        addPlan = dashBoard.clickAddPlansButton();
    }

    /**
     * Allows you to check if all the options are displayed in the Add Plans screen.
     * */
    @Then("I should see a list of plans to add")
    public void iShouldSeeAListOfPlansToAdd() {
        log.info("Add Plans Option List is shown to the user");
        Assert.assertEquals(addPlan.getPlanOptionsAmount(), amountPlansOptionExpected);

        log.info("Validate Reserve Dining Option is displayed");
        Assert.assertTrue(addPlan.isReserveDiningOptionDisplayed(), "Reserve Dining Option is NOT displayed");


        mobileApplicationEnd();
    }
}
