package by.bsu.framework.page;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class CarCharacteristicPage extends AbstractPage {

    private final String CHOOSE_CAR_PAGE_URL = "https://www.avtoprokat.ru/cars/results/book";
    private final WebDriverWait wait;
    private static final Logger LOGGER = (Logger) LogManager.getRootLogger();

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(CHOOSE_CAR_PAGE_URL);
        LOGGER.info("Open characteristic page");
        return null;
    }

    public CarCharacteristicPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @FindBy(xpath = "//*[@id=\"bcrm_search_car_info\"]/div[2]/div/div[2]/a")
    WebElement carCharacteristicContinueButton;


    public void pushCarCharacteristicContinueButton(){
        carCharacteristicContinueButton.click();
        LOGGER.info("Click characteristic button");
    }
}
