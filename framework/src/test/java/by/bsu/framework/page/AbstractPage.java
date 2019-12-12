package by.bsu.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    final int WAIT_TIMEOUT_SECONDS = 10;

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
    }
}