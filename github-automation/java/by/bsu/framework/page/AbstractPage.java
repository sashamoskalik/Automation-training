package by.bsu.framework.page;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public abstract class AbstractPage {
    final int WAIT_TIMEOUT_SECONDS = 10;

    private static final Logger LOGGER = (Logger) LogManager.getRootLogger();

    @FindBy(xpath = "//body")
    private WebElement body;

    WebDriver driver;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract AbstractPage openPage();

    void focus() {
        body.click();
        LOGGER.info("Focus body");
    }
}