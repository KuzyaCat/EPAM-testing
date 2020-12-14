package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.reporters.jq.Main;

public class MainPage extends Page {
    private final String BASE_PAGE_URL = "https://deal.by";

    private final By SEARCH_INPUT_LOCATOR = By.className("ps-search__field--3s5Te");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage enterValueToSearchInput(String value) {
        logger.info("Get search input element");
        WebElement searchInput = getWebElement(SEARCH_INPUT_LOCATOR);

        logger.info("Enter value to search value: " + value);
        searchInput.sendKeys(value);

        logger.info("Click ENTER");
        searchInput.sendKeys(Keys.ENTER);

        return this;
    }

    public MainPage openPage() {
        logger.info("Open page: " + BASE_PAGE_URL);
        driver.get(BASE_PAGE_URL);

        return this;
    }
}
