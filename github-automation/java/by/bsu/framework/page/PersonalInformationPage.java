package by.bsu.framework.page;

import by.bsu.framework.model.PageError;
import by.bsu.framework.model.PersonalInformation;
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

public class PersonalInformationPage extends AbstractPage {

    private final String CHOOSE_CAR_PAGE_URL = "https://www.avtoprokat.ru/cars/results/book/#substep=1";
    private final WebDriverWait wait;
    private static final Logger LOGGER = (Logger) LogManager.getRootLogger();

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(CHOOSE_CAR_PAGE_URL);
        LOGGER.info("Open personal information page");
        return this;
    }

    public PersonalInformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @FindBy(xpath = "//*[@id=\"bcrm_step_3b\"]/div/div[2]/div[5]/div[3]/div[2]/input")
    WebElement name;

    @FindBy(xpath = "//*[@id=\"bcrm_step_3b\"]/div/div[2]/div[5]/div[4]/div[2]/input")
    WebElement surname;

    @FindBy(xpath = "//*[@id=\"bcrm_step_3b\"]/div/div[2]/div[5]/div[5]/div[2]/input")
    WebElement email;

    @FindBy(xpath = "//*[@id=\"bcrm_step_3b\"]/div/div[2]/div[5]/div[7]/div[2]/input")
    WebElement phone;

    @FindBy(xpath = "//*[@id=\"bcrm_step_3b\"]/div/div[2]/div[6]/div/div/a[2]")
    WebElement continueButton;

    void inputName(String nameInput){
        name.clear();
        name.sendKeys(nameInput);
        LOGGER.info("Filled name field" + nameInput);
    }

    void inputSurname(String surnameInput){
        surname.clear();
        surname.sendKeys(surnameInput);
        LOGGER.info("Filled surname field" + surnameInput);
    }

    public PersonalInformationPage params(PersonalInformation params){
        params.getName().ifPresent(this::inputName);
        params.getSurname().ifPresent(this::inputSurname);
        params.getEmail().ifPresent(this::inputEmail);
        params.getPhone().ifPresent(this::inputPhone);
        LOGGER.info("Personal information params");
        return this;
    }

    void inputEmail(String emailInput){
        email.clear();
        email.sendKeys(emailInput);
        LOGGER.info("Filled email field" + emailInput);
    }

    void inputPhone(String phoneInput){
        phone.clear();
        phone.sendKeys(phoneInput);
        LOGGER.info("Filled phone field" + phoneInput);
    }

    public void pushContinueButton(){
        continueButton.click();
    }

    public boolean bookCarError(PageError error){
        WebElement carError =
                new WebDriverWait(driver, WAIT)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"bcrm_step_3c\"]/div[2]/div[1]/div[3]/div[1]/span[2]")));
        LOGGER.info("Check bool car error");
        return carError.getText().contains(error.getErrorDescription());
    }
}
