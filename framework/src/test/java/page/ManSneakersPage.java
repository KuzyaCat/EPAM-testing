package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Collectors;

public class ManSneakersPage extends Page {
    private final String BASE_PAGE_URL = "https://deal.by";
    private String pageUrl;
    private JavascriptExecutor jsExecutor;

    private final String PRODUCER_FILTER_PARENT_ELEMENT = "//div[(@data-qaid='a18') and (@class=\"FilterSection__root--2ST64\")]";
    private final String PRODUCER_FILTER_INPUT_XPATH = PRODUCER_FILTER_PARENT_ELEMENT
            + "//div[@class=\"input__root--2vSJx\"]//input[@type=\"text\"]";

    private final By PRODUCER_LIST_LOCATOR = By.xpath(PRODUCER_FILTER_PARENT_ELEMENT + "//ul[@class=\"ek-list\"]");
    private final By PRODUCER_LIST_ITEM_SPAN_LOCATOR = By.className("SingleCheckbox__label--1ObCD");

    @FindBy(xpath = PRODUCER_FILTER_INPUT_XPATH)
    private WebElement producerFilterInput;

    public ManSneakersPage(WebDriver driver, String url) {
        super(driver);
        pageUrl = BASE_PAGE_URL + url;
        jsExecutor = (JavascriptExecutor) driver;
    }

    public ManSneakersPage(WebDriver driver) {
        super(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }

    public ManSneakersPage fillFilterInput(String filterValue) {
        producerFilterInput.sendKeys(Keys.chord(filterValue));
        producerFilterInput.sendKeys(Keys.SPACE);
//        jsExecutor.executeScript("arguments[0].setAttribute('value', arguments[1])", producerFilterInput, filterValue);
        return this;
    }

    public List<String> getProducerListItemValues() {
        return getWebElement(PRODUCER_LIST_LOCATOR)
                .findElements(PRODUCER_LIST_ITEM_SPAN_LOCATOR)
                .stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public ManSneakersPage openPage() {
        driver.get(pageUrl);
        return this;
    }

    @Override
    public ManSneakersPage waitUntilJSReady() {
        return (ManSneakersPage)super.waitUntilJSReady();
    }
}
