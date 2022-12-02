package org.globant.pageObjects.web;

import org.globant.utils.basePageObject.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ESPNWatchPage extends BaseWebPage {
    @FindBy(css="#fittPageContainer > section")
    private List<WebElement> carouselContainersList;

    @FindBy(css="#fittPageContainer > section > div:nth-child(1) > section > div.Carousel__Wrapper.relative.Carousel__Wrapper--canScrollRight > div > div > ul > li:nth-child(2) > a")
    private WebElement secondCardOfFirstCarousel;

    @FindBy(css = ".lightbox__closebtn")
    private WebElement xButtonFromSupplierModal;

    @FindBy(css= "div.Carousel__Wrapper--canScrollRight li")
    private List<WebElement> listOfCardsFromFirstCarousel;

    public ESPNWatchPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyAtLeastOneCarouselIsDisplayed(){
        super.waitForVisibility(carouselContainersList);
        return carouselContainersList.size() > 0;
    }

    public void clickSecondCardFromFirstCarrousel(){
        super.clickElement(secondCardOfFirstCarousel);
    }

    public boolean isXButtonFromSupplierModalPresent(){
        clickSecondCardFromFirstCarrousel();
        super.waitForVisibility(xButtonFromSupplierModal);
        return xButtonFromSupplierModal.isDisplayed();
    }

    public void clickXButtonFromSupplierModal(){
        super.clickElement(xButtonFromSupplierModal);
    }

    public ESPNHomePage backToHomePage(){
        super.backToPreviousPage();
        return new ESPNHomePage(getDriver());
    }

    /**
     * Verify if each card in the carousel has a title and a small description about streaming source.
     * @return true
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
