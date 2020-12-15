package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {
    private final String CHROME_DRIVER_PATH = "/src/test/resources/drivers/chromedriver";

    protected WebDriver driver;

    @BeforeMethod()
    public void browserSetup() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + CHROME_DRIVER_PATH);

        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit()
    {
        driver.quit();
        driver = null;
    }
}
