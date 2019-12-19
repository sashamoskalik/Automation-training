package by.bsu.framework.page;

import by.bsu.framework.model.PageError;
import by.bsu.framework.model.SearchCar;
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

public class ChooseCarPage extends AbstractPage {

    private final String CHOOSE_CAR_PAGE_URL = "https://www.avtoprokat.ru/cars/results";
    private final WebDriverWait wait;
    private static final Logger LOGGER = (Logger) LogManager.getRootLogger();


    public AbstractPage openPage() {
        driver.navigate().to(CHOOSE_CAR_PAGE_URL);
        LOGGER.info("Open choose car page");
        return this;
    }

    public ChooseCarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @FindBy(xpath = "//*[@id=\"B_4255952_1500417_1500417___170019_1\"]/div[2]/div[3]/div/div/div[3]/span/a")
    WebElement carButton;

    @FindBy(xpath = "//*[@id=\"search-results\"]/div[4]/div/div[2]/a")
    private WebElement priceFilter;

    @FindBy(xpath = "//*[@id=\"bcrm_currency_cont\"]/div/div[1]/div")
    private WebElement chooseCurrency;

    @FindBy(xpath = "//*[@id=\"bcrm_currency_cont\"]/div/div[2]/ul/a[2]")
    private WebElement usdCurrency;

    @FindBy(xpath = "//*[@id=\"bcrm_search_results_filter\"]/div/div[2]/div[2]/div/input")
    private WebElement searchCar;

    public void setSearchCar(String car){
        searchCar.clear();
        searchCar.sendKeys(car);
        LOGGER.info("Filled search car field" + car);
    }

    public ChooseCarPage params(SearchCar params){
        params.getMark().ifPresent(this::setSearchCar);
        LOGGER.info("Choose car params");
        return this;
    }

    public void chooseUsdCurrency(){
        usdCurrency.click();
    }

    public void pushChooseCurrency(){
        chooseCurrency.click();
    }

    public void pushPriceFilter(){
        priceFilter.click();
    }

    public void pushChoosenCarButton(){
        carButton.click();
    }

    public boolean errorPriceFilter(PageError error){
        WebElement priceFilterError =
                new WebDriverWait(driver, WAIT)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"B_4255956_1500417_1500417___170019_1\"]/div[2]/div[1]/dl/dt/span[1]/text()")));
        LOGGER.info("Check error price filter");
        return priceFilterError.getText().contains(error.getErrorDescription());
    }

    public boolean errorChangeCurrency(PageError error){
        WebElement changeCurrencyError =
                new WebDriverWait(driver, WAIT)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"bcrm_currency_cont\"]/div/div[1]/div/span/text()")));
        LOGGER.info("Check error change currency");
        return changeCurrencyError.getText().contains(error.getErrorDescription());
    }

    public boolean errorChooseCar(PageError error){
        WebElement dropOffError =
                new WebDriverWait(driver, WAIT)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"bcrm_search_result\"]/div[4]/div[2]/div[2]/div[1]/div/div[1]/h1")));
        LOGGER.info("Check error choose car");
        return dropOffError.getText().contains(error.getErrorDescription());
    }

    public boolean errorSearchCar(PageError error){
        WebElement searchCarError =
                new WebDriverWait(driver, WAIT)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"search-results\"]/div[6]/div/div/span")));
        LOGGER.info("Check error search car");
        return searchCarError.getText().contains(error.getErrorDescription());
    }

}
