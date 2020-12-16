package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Collectors;

public class CatalogPage extends Page {
    private final String BASE_PAGE_URL = "https://deal.by";
    private String pageUrl;

    private final String PRODUCER_FILTER_PARENT_ELEMENT = "//div[(@data-qaid='a18') and (@class=\"FilterSection__root--2ST64\")]";
    private final String PRODUCER_FILTER_INPUT_XPATH = PRODUCER_FILTER_PARENT_ELEMENT
            + "//div[@class=\"input__root--2vSJx\"]//input[@type=\"text\"]";
    private final String CATALOG_CHEAP_BUTTON_XPATH = "//div[(@class='tagsSlider__sortPill--NmfKH') and (@data-qaid='price')]";
    private final String CATALOG_EXPENSIVE_BUTTON_XPATH = "//div[(@class='tagsSlider__sortPill--NmfKH') and (@data-qaid='-price')]";

    private final By PRODUCER_LIST_LOCATOR = By.xpath(PRODUCER_FILTER_PARENT_ELEMENT + "//ul[@class=\"ek-list\"]");
    private final By PRODUCER_LIST_ITEM_SPAN_LOCATOR = By.className("SingleCheckbox__label--1ObCD");
    private final By CATALOG_ITEM_PRICE_LOCATOR = By.xpath("//span[(@class='x-gallery-tile__price') and (@data-qaid='product_price')]");

    @FindBy(xpath = PRODUCER_FILTER_INPUT_XPATH)
    private WebElement producerFilterInput;

    @FindBy(xpath = CATALOG_EXPENSIVE_BUTTON_XPATH)
    private WebElement catalogExpensiveButton;

    @FindBy(xpath = CATALOG_CHEAP_BUTTON_XPATH)
    private WebElement catalogCheapButton;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public CatalogPage(WebDriver driver, String url) {
        super(driver);
        pageUrl = BASE_PAGE_URL + url;
    }

    public CatalogPage enterValueToFilterInput(String filterValue) {
        logger.info("Enter value to input: " + filterValue);
        producerFilterInput.sendKeys(Keys.chord(filterValue));
        producerFilterInput.sendKeys(Keys.SPACE);
//        jsExecutor.executeScript("arguments[0].setAttribute('value', arguments[1])", producerFilterInput, filterValue);
        return this;
    }

    public List<String> getProducerListItemValues() {
        logger.info("Get producer items list names");
        List<String> producerListItemValues = getWebElement(PRODUCER_LIST_LOCATOR)
                .findElements(PRODUCER_LIST_ITEM_SPAN_LOCATOR)
                .stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        logger.info(producerListItemValues.size() + " producer list items found: " + producerListItemValues.toString());
        return producerListItemValues;
    }

    public CatalogPage clickExpensiveButton() {
        logger.info("Click expensive button");
        catalogExpensiveButton.click();
        return this;
    }

    public CatalogPage clickCheapButton() {
        logger.info("Click cheap button");
        catalogCheapButton.click();
        return this;
    }

    public List<Double> getCatalogItemsPrices() {
        logger.info("Get catalog items prices");
        return getWebElementsList(CATALOG_ITEM_PRICE_LOCATOR)
                .stream()
                .map(item -> Double.parseDouble(item.getAttribute("data-qaprice")))
                .collect(Collectors.toList());
    }

    public CatalogPage openPage() {
        logger.info("Open page: " + BASE_PAGE_URL);
        driver.get(BASE_PAGE_URL);
        return this;
    }

    @Override
    public CatalogPage waitUntilJSReady() {
        return (CatalogPage)super.waitUntilJSReady();
    }
}
