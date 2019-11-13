import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDriver {
    private WebDriver driver;
    private Page page;
    private final String age = "17";
    private final String location = "Париж Аэропорт Шарль Де Голь";

    @BeforeClass
    public void browserSetUp() {
        driver = new ChromeDriver();
        page = new Page(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void pickUpLocation() {
        page.setLocation(location);
        page.pushSearch();
        page.isError();
    }

    @Test
    public void driverAge() {
        page.pushAgeCheck();
        page.setDriverAge(age);
        Assert.assertTrue(page.isErrorAge());
    }

    @AfterClass
    public void browserTearDown() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
