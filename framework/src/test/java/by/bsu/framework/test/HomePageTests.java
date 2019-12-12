package by.bsu.framework.test;

import by.bsu.framework.model.PageError;
import by.bsu.framework.page.HomePage;
import by.bsu.framework.service.CarReservationCreator;
import by.bsu.framework.service.PageErrorCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends CommonConditions {

    @Test
    public void pickUpLocation() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage().params(CarReservationCreator.withoutChoosingPlaceFromTheList()).pushSearch();
        PageError pageError = PageErrorCreator.errorWithoutChoosingplaceFromTheList();
        Assert.assertTrue(homePage.checkPlaceErrorMessage(pageError));
    }

    @Test
    public void driverAge() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage().params(CarReservationCreator.youngUser()).pushSearch();
        PageError pageError = PageErrorCreator.errorYoungUser();
        Assert.assertTrue(homePage.checkAgeErrorMessage(pageError));
    }
}
