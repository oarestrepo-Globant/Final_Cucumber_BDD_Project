package org.globant.pageObjects.web;

import org.globant.utils.basePageObject.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for ESPN Web Page.
 * This class has methods that recreate actions of a user inside ESPN Watch page.
 * */
public class ESPNWatchPage extends BaseWebPage {
    @FindBy(css="#fittPageContainer > section")
    private List<WebElement> carouselContainersList;

    @FindBy(css="#fittPageContainer > section > div:nth-child(1) > section > div.Carousel__Wrapper.relative.Carousel__Wrapper--canScrollRight > div > div > ul > li:nth-child(2) > a")
    private WebElement secondCardOfFirstCarousel;

    @FindBy(css = ".lightbox__closebtn")
    private WebElement xButtonFromSupplierModal;

    @FindBy(css= "div.Carousel__Wrapper--canScrollRight li")
    private List<WebElement> listOfCardsFromFirstCarousel;

    /**
     * Constructor method for ESPNWatchPage class.
     * @param driver:WebDriver
     * */
    public ESPNWatchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Check that there is at least one carousel visible on the watch page.
     * @return true if there is at least one carousel, otherwise returns false.
     * */
    public boolean verifyAtLeastOneCarouselIsDisplayed(){
        super.waitForVisibility(carouselContainersList);
        return carouselContainersList.size() > 0;
    }

    /**
     * Allows to click on the second card of the first carousel.
     * */
    public void clickSecondCardFromFirstCarrousel(){
        super.clickElement(secondCardOfFirstCarousel);
    }

    /**
     * Check if the modal has a button with an X to close it.
     * @return true if the X button is visible, otherwise it returns false.
     * */
    public boolean isXButtonFromSupplierModalPresent(){
        clickSecondCardFromFirstCarrousel();
        super.waitForVisibility(xButtonFromSupplierModal);
        return xButtonFromSupplierModal.isDisplayed();
    }

    /**
     * Allows you to click on the button with an x in the modal.
     * */
    public void clickXButtonFromSupplierModal(){
        super.clickElement(xButtonFromSupplierModal);
    }

    /**
     * Allows to go back to the previous web page.
     * */
    public ESPNHomePage backToHomePage(){
        super.backToPreviousPage();
        return new ESPNHomePage(getDriver());
    }

    /**
     * Verify if each card in the carousel has a title and a small description about streaming source.
     * @return true if each card in the carousel has a title and a small description, otherwise return false.
     * */
    public boolean checkEachCardInCarouselHasDescription(){
        List <WebElement> cardsWithTitleList = new ArrayList<>();
        List<WebElement> cardsWithSrcDescriptionList = new ArrayList<>();

        listOfCardsFromFirstCarousel.forEach(element ->{
            cardsWithTitleList.add(element.findElement(By.cssSelector("h2.WatchTile__Title")));
        });

        listOfCardsFromFirstCarousel.forEach(element ->{
            cardsWithSrcDescriptionList.add(element.findElement(By.cssSelector("div.WatchTile__Meta")));
        });

        return cardsWithTitleList.size() == listOfCardsFromFirstCarousel.size() || cardsWithSrcDescriptionList.size() == listOfCardsFromFirstCarousel.size();
    }
}
