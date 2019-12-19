package by.bsu.framework.test;

import by.bsu.framework.model.PageError;
import by.bsu.framework.page.CarCharacteristicPage;
import by.bsu.framework.page.ChooseCarPage;
import by.bsu.framework.page.HomePage;
import by.bsu.framework.page.PersonalInformationPage;
import by.bsu.framework.service.*;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class HomePageTests extends CommonConditions {

    private static final Logger LOGGER = (Logger) LogManager.getRootLogger();

    @Test
    public void pickUpLocation() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage().params(CarReservationCreator.withoutChoosingPlaceFromTheList()).pushSearch();
        PageError pageError = PageErrorCreator.errorWithoutChoosingplaceFromTheList();
        Assert.assertTrue(homePage.checkPlaceErrorMessage(pageError));
        LOGGER.info("Pick up location test");
    }

    @Test
    public void driverAge() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage().params(CarReservationCreator.youngUser()).pushSearch();
        PageError pageError = PageErrorCreator.errorYoungUser();
        Assert.assertTrue(homePage.checkAgeErrorMessage(pageError));
        LOGGER.info("Driver age test");
    }

    @Test void dateTo(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage().pushSearch();
        PageError pageError = PageErrorCreator.errorDateTo();
        Assert.assertTrue(homePage.errorDateTo(pageError));
        LOGGER.info("Date to test");
    }

    @Test
    public void carBook(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage().params(CarReservationCreator.bookingCar()).pushSearch();
        ChooseCarPage chooseCarPage = new ChooseCarPage(driver);
        chooseCarPage.pushChoosenCarButton();
        CarCharacteristicPage carCharacteristicPage = new CarCharacteristicPage(driver);
        carCharacteristicPage.pushCarCharacteristicContinueButton();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.params(PersonalInformationCreator.personalInformation()).pushContinueButton();
        PageError pageError = PageErrorCreator.accessRegistrationCar();
        Assert.assertTrue(personalInformationPage.bookCarError(pageError));
        LOGGER.info("Car book test");
    }

    @Test
    public void errorEmail(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage().pushLoginButon();
        homePage.accountParams(LoginCreator.errorEmail()).pushEnterAccountButton();
        PageError pageError = PageErrorCreator.errorEmail();
        Assert.assertTrue(homePage.errorEmail(pageError));
        LOGGER.info("Error email test");
    }

    @Test
    public void priceFilter(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage().params(CarReservationCreator.bookingCarForPriceFilter()).pushSearch();
        ChooseCarPage chooseCarPage = new ChooseCarPage(driver);
        chooseCarPage.pushPriceFilter();
        PageError pageError = PageErrorCreator.errorPriceFilter();
        Assert.assertTrue(chooseCarPage.errorPriceFilter(pageError));
        LOGGER.info("Price filter test");
    }

    @Test
    public void changeCurrency(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage().params(CarReservationCreator.bookingCarForChangeCurrency()).pushSearch();
        ChooseCarPage chooseCarPage = new ChooseCarPage(driver);
        chooseCarPage.pushPriceFilter();
        chooseCarPage.chooseUsdCurrency();
        PageError pageError = PageErrorCreator.errorChangeCurrency();
        Assert.assertTrue(chooseCarPage.errorChangeCurrency(pageError));
        LOGGER.info("Change currency test");
    }

    @Test
    public void dropOffCarInAnotherLocation(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage().params(CarReservationCreator.bookingCarForDropOffInAnotherLocation()).pushSearch();
        ChooseCarPage chooseCarPage = new ChooseCarPage(driver);
        PageError pageError = PageErrorCreator.errorDropOffInAnotherLocation();
        Assert.assertTrue(chooseCarPage.errorChooseCar(pageError));
        LOGGER.info("Drop off car in another location test");
    }

    @Test
    public void errorBigDateTo(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage().params(CarReservationCreator.bookingCarForBigDateTo()).pushSearch();
        ChooseCarPage chooseCarPage = new ChooseCarPage(driver);
        PageError pageError = PageErrorCreator.errorBigDateTo();
        Assert.assertTrue(chooseCarPage.errorChooseCar(pageError));
        LOGGER.info("Error big date to test");
    }

    @Test
    public void searhNotExistCar(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage().params(CarReservationCreator.bookingCarForSearchCar()).pushSearch();
        ChooseCarPage chooseCarPage = new ChooseCarPage(driver);
        chooseCarPage.params(SearchCarCreator.markCar());
        PageError pageError = PageErrorCreator.errorSearchCar();
        Assert.assertTrue(chooseCarPage.errorSearchCar(pageError));
        LOGGER.info("Search not exist car test");
    }
}
