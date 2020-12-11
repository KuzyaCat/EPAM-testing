package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.ManSneakersPage;
import page.WristWatchPage;

public class DealByTest {
    private final String CHROME_DRIVER_PATH = "/src/test/resources/drivers/chromedriver";
    private final String WRIST_WATCH_PAGE_URL = "/p106387137-muzhskie-chasy-amst.html";
    private final String SNEAKERS_PAGE_URL = "/Krossovki-muzhskie.html";

    private final String EXPECTED_ITEM_TITLE_VALUE = "Мужские часы AMST AM 3003 (Коричневый)";
    private final String FILTER_VALUE = "re";

    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void initBrowserDriver() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + CHROME_DRIVER_PATH);

        driver = new ChromeDriver();
    }

    @Test (description = "Test add to basket")
    public void addProductToBasketTest() {
        WristWatchPage dealByWristWatchPage = new WristWatchPage(driver, WRIST_WATCH_PAGE_URL)
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

    @Test (description = "Test filter sneakers by producer")
    public void filterSneakersByProducerTest() {
        boolean areProducerListItemValuesMatchInputValue =  new ManSneakersPage(driver, SNEAKERS_PAGE_URL)
                .openPage()
                .fillFilterInput(FILTER_VALUE)
                .getProducerListItemValues()
                .stream()
                .allMatch(itemValue -> itemValue.contains(FILTER_VALUE));

        Assert.assertTrue(areProducerListItemValuesMatchInputValue);
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
        driver = null;
    }
}

