import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    private final String HOME_URL = "https://www.avtoprokat.ru/";
    private final int WAIT = 30;

    private WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        driver.get(HOME_URL);
        PageFactory.initElements(this.driver, this);
        new WebDriverWait(driver, WAIT);
    }

    @FindBy(xpath = "//*[@id=\"bcrm_search\"]/form/div/div[4]/div[6]/span[1]")
    private WebElement ageCheck;

    @FindBy(xpath = "//*[@id=\"driver_age\"]")
    private WebElement driverAge;

    @FindBy(xpath = "//*[@id=\"pickup_location_input\"]")
    private WebElement location;

    @FindBy(xpath = "//*[@id=\"bcrm_search_btn\"]")
    private WebElement searchButton;

    public void setLocation(String loc){
        location.clear();
        location.sendKeys(loc);
    }

    public void pushAgeCheck() {
        ageCheck.click();
    }

    public void pushSearch(){
        searchButton.click();
    }

    public void setDriverAge(String age) {
        driverAge.clear();
        driverAge.sendKeys(age);
    }

    public boolean isErrorAge() {
        WebElement error =
                new WebDriverWait(driver, WAIT)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"driver_age-error\"]")));
        return error.isDisplayed();
    }

    public boolean isError(){
        WebElement error =
                new WebDriverWait(driver, WAIT)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"bcrm_all_errors_cont\"]/div/span/div[1]")));
        return error.isDisplayed();
    }
}