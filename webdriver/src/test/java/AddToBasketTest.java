import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToBasketTest {
    private final String CHROME_DRIVER_PATH = "/drivers/chromedriver";
//    private final String PAGE_URL = "https://cutt.ly/IhmH8m3";
    private final String PAGE_URL = "https://deal.by/p115977873-naruchnye-chasy-amst.html?_openstat=by_prosale%3B%D1%87%D0%B0%D1%81%D1%8B+%D0%BD%D0%B0%D1%80%D1%83%D1%87%D0%BD%D1%8B%D0%B5+%D0%B8+%D0%BA%D0%B0%D1%80%D0%BC%D0%B0%D0%BD%D0%BD%D1%8B%D0%B5%3B%D0%9D%D0%90%D0%A0%D0%A3%D0%A7%D0%9D%D0%AB%D0%95++%D0%A7%D0%90%D0%A1%D0%AB+AMST%3Bsearch";
    private final String BUY_BUTTON_CLASSNAME = "js-product-buy-button";

    private final long SECONDS_TO_WAIT = 10;
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;

    @BeforeTest(alwaysRun = true)
    public void initBrowserDriver() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + CHROME_DRIVER_PATH);

        driver = new ChromeDriver();
        jsExecutor = (JavascriptExecutor) driver;
    }

    @Test (description = "Test add to basket")
    public void TestAddProductToBasket() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, SECONDS_TO_WAIT)
                .until(JQueryConditions.jQueryAJAXCompleted());

        WebElement buyButton = driver.findElements(By.className(BUY_BUTTON_CLASSNAME)).get(0);
        System.out.println("buyButton: " + buyButton);
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
        driver = null;
    }
}
