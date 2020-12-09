package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.DealByWristWatchPage;

public class DealByTest {
    private final String CHROME_DRIVER_PATH = "/src/main/resources/drivers/chromedriver";
    private final String EXPECTED_ITEM_TITLE_VALUE = "НАРУЧНЫЕ ЧАСЫ AMST";

    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void initBrowserDriver() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + CHROME_DRIVER_PATH);

        driver = new ChromeDriver();
    }

    @Test (description = "Test add to basket")
    public void addProductToBasketTest() {
        DealByWristWatchPage dealByWristWatchPage = new DealByWristWatchPage(driver)
                .openPage();

        int expectedBasketItemsCounterValue = dealByWristWatchPage.getBasketItemsCounterValue() + 1;
        int actualBasketItemsCounterValueAfterClick = dealByWristWatchPage
                .clickBuyButton()
                .selectBasketItemsCounter()
                .getBasketItemsCounterValue();

        String actualItemTitle = dealByWristWatchPage
                .selectItemTitle()
                .getItemTitleText();

        Assert.assertEquals(expectedBasketItemsCounterValue, actualBasketItemsCounterValueAfterClick);
        Assert.assertEquals(actualItemTitle, EXPECTED_ITEM_TITLE_VALUE);
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
        driver = null;
    }
}

