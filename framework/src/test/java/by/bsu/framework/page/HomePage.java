package by.bsu.framework.page;

import by.bsu.framework.model.CarBook;
import by.bsu.framework.model.PageError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.sun.webkit.CursorManager.WAIT;


public class HomePage extends AbstractPage {
    private final String HOMEPAGE_URL = "https://www.avtoprokat.ru/";
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    public HomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        return this;
    }

    @FindBy(xpath = "//*[@id=\"bcrm_search\"]/form/div/div[4]/div[6]/span[1]")
    private WebElement ageCheck;

    @FindBy(xpath = "//*[@id=\"driver_age\"]")
    private WebElement driverAge;

    @FindBy(xpath = "//*[@id=\"pickup_location_input\"]")
    private WebElement location;

    @FindBy(xpath = "//*[@id=\"bcrm_search_btn\"]")
    private WebElement searchButton;

    private void setLocation(String loc){
        location.clear();
        location.sendKeys(loc);
        focus();
    }

    private void pushAgeCheck() {
        ageCheck.click();
    }

    public void pushSearch(){
        searchButton.click();
    }

    private void setDriverAge(String age) {
        driverAge.clear();
        driverAge.sendKeys(age);
        focus();
    }

    public HomePage params(CarBook params) {
        params.getPlaceFrom().ifPresent(this::pickUpLocation);
        params.getUserAge().ifPresent(this::inputAge);
        return this;
    }

    private void pickUpLocation(String pickUpLocation){
        setLocation(pickUpLocation);
        pushSearch();
    }

    private void inputAge(String age){
        pushAgeCheck();
        setDriverAge(age);
        pushSearch();
    }

    public boolean checkPlaceErrorMessage(PageError error) {
        WebElement locationError =
                new WebDriverWait(driver, WAIT)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"bcrm_all_errors_cont\"]/div/span/div[1]")));
        return locationError.getText().
                contains(error.getErrorDescription());
    }

    public boolean checkAgeErrorMessage(PageError error){
        WebElement ageError =
                new WebDriverWait(driver, WAIT)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"bcrm_all_errors_cont\"]/div/span/div[1]")));
        return ageError.getText().contains(error.getErrorDescription());
    }
}