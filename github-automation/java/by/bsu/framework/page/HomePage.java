package by.bsu.framework.page;

import by.bsu.framework.model.CarBook;
import by.bsu.framework.model.EnterAccount;
import by.bsu.framework.model.PageError;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

import static com.sun.webkit.CursorManager.WAIT;


public class HomePage extends AbstractPage {
    private final String HOMEPAGE_URL = "https://www.avtoprokat.ru/";
    private final WebDriverWait wait;
    private static final Logger LOGGER = (Logger) LogManager.getRootLogger();

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    public HomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        LOGGER.info("Open home page");
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

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[3]/td[6]/span")
    private WebElement dateTo;

    @FindBy(xpath = "//*[@id=\"dp1576702193275\"]")
    private WebElement dateToArea;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div[2]/div[2]/div[2]/a[1]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"loginEmail\"]")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    private WebElement enterAccountButton;

    @FindBy(xpath = "//*[@id=\"bcrm_search\"]/form/div/div[3]/div[2]/span[1]")
    private WebElement returnLocationCheckbox;

    @FindBy(xpath = "//*[@id=\"dropoff_location_input\"]")
    private WebElement dropOffLocation;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[2]/td[5]/a")
    private WebElement bigDateTo;

    public void pushBigDateTo(){
        bigDateTo.click();
    }

    public void setDropOffLocation(String location){
        dropOffLocation.clear();
        dropOffLocation.sendKeys(location);
        focus();
        LOGGER.info("Filled drop off location field" + location);
    }

    public void pushReturnLocationCheckbox(){
        returnLocationCheckbox.click();
    }

    public void pushEnterAccountButton(){
        enterAccountButton.click();
    }

    private void setEmail(String email){
        inputEmail.clear();
        inputEmail.sendKeys(email);
        LOGGER.info("Filled email field" + email);

    }

    public void pushLoginButon(){
        loginButton.click();
    }

    private void pushDateTo(){
        dateToArea.click();
        dateTo.click();
    }

    private void setLocation(String loc){
        location.clear();
        location.sendKeys(loc);
        focus();
        LOGGER.info("Filled location field" + loc);
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
        LOGGER.info("Filled driver age field" + age);
    }

    public HomePage accountParams(EnterAccount params){
        params.getEmail().ifPresent(this::setEmail);
        LOGGER.info("Account params");
        return this;
    }

    public HomePage params(CarBook params) {
        params.getPlaceFrom().ifPresent(this::pickUpLocation);
        params.getUserAge().ifPresent(this::inputAge);
        params.getPlaceTo().ifPresent(this::setDropOffLocation);
        LOGGER.info("Home page params");
        return this;
    }

    private void pickUpLocation(String pickUpLocation){
        setLocation(pickUpLocation);
    }

    private void inputAge(String age){
        pushAgeCheck();
        setDriverAge(age);
        pushSearch();
        LOGGER.info("Filled age field" + age);
    }

    public boolean checkPlaceErrorMessage(PageError error) {
        WebElement locationError =
                new WebDriverWait(driver, WAIT)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"bcrm_all_errors_cont\"]/div/span/div[1]")));
        LOGGER.info("Check error place");
        return locationError.getText().
                contains(error.getErrorDescription());
    }

    public boolean checkAgeErrorMessage(PageError error){
        WebElement ageError =
                new WebDriverWait(driver, WAIT)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"bcrm_all_errors_cont\"]/div/span/div[1]")));
        LOGGER.info("Check error age");
        return ageError.getText().contains(error.getErrorDescription());
    }

    public boolean errorDateTo(PageError error){
        WebElement dateToError =
                new WebDriverWait(driver, WAIT)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"dp1576702193275\"]")));
        LOGGER.info("Check error date to");
        return dateToError.getText().contains(error.getErrorDescription());
    }

    public boolean errorEmail(PageError error){
        WebElement emailError =
                new WebDriverWait(driver, WAIT)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"loginEmail-error\"]")));
        LOGGER.info("Check error email");
        return emailError.getText().contains(error.getErrorDescription());
    }
}