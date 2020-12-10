package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ManSneakersPage extends Page {
    private final String PAGE_URL = "https://deal.by/Krossovki-muzhskie.html";

    private final String PRODUCER_FILTER_PARENT_ELEMENT = "//div[(@data-qaid='a18') and (@class=\"FilterSection__root--2ST64\")]";
    private final String PRODUCER_FILTER_INPUT_XPATH = PRODUCER_FILTER_PARENT_ELEMENT
            + "//div[@class=\"input__root--2vSJx\"]//input[@type=\"text\"]";
    private final String PRODUCER_LIST_XPATH = PRODUCER_FILTER_PARENT_ELEMENT + "//ul[@class=\"ek-list\"]";
    private final By PRODUCER_LIST_ITEM_SPAN_LOCATOR = By.className("SingleCheckbox__label--1ObCD");

    Wait<WebDriver> wait;
    private final long SECONDS_TO_WAIT = 10;
    private final long POLLING_SECONDS = 1;

    @FindBy(xpath = PRODUCER_FILTER_INPUT_XPATH)
    private WebElement filterByProducerFilterInput;
    private WebElement producerList;

    public ManSneakersPage(WebDriver driver) {
        super(driver);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(SECONDS_TO_WAIT))
                .pollingEvery(Duration.ofSeconds(POLLING_SECONDS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Timeout was exceeded!");
    }

    public ManSneakersPage fillFilterInput(String filterValue) {
        filterByProducerFilterInput.sendKeys(filterValue);
        return this;
    }

    public List<String> getProducerListItemValues() {
        return wait
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(PRODUCER_LIST_ITEM_SPAN_LOCATOR)).get(0)
                .findElements(PRODUCER_LIST_ITEM_SPAN_LOCATOR)
                .stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public ManSneakersPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }
}
