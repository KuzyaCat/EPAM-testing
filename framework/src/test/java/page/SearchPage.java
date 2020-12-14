package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends Page {
    private final String BASE_PAGE_URL = "https://deal.by/search?search_term=";
    private String pageUrl;

    private final By CATALOG_WRAPPER_LOCATOR = By.className("x-catalog-gallery__list");
    private final By ITEM_DESCRIPTION_LOCATOR = By.xpath("//span[@class=\"ek-link ek-link_style_multi-line\"]");

    public SearchPage(WebDriver driver, String searchValue) {
        super(driver);
        pageUrl = BASE_PAGE_URL + searchValue;
    }

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getCatalogItemsDescriptionTextList() {
        WebElement catalogWrapperElement = getWebElement(CATALOG_WRAPPER_LOCATOR);

        logger.info("Get catalog items description list");
        List<WebElement> catalogItemsDescriptionElements = catalogWrapperElement.findElements(ITEM_DESCRIPTION_LOCATOR);

        if (catalogItemsDescriptionElements.size() == 0) {
            logger.info("No catalog items element found");
            return Collections.emptyList();
        }

        List<String> catalogItemsDescriptionTextList = catalogItemsDescriptionElements
                .stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        logger.info("Found " + catalogItemsDescriptionElements.size() + " items: " + catalogItemsDescriptionTextList.toString());

        return catalogItemsDescriptionTextList;
    }

    public SearchPage openPage() {
        logger.info("Open page: " + pageUrl);
        driver.get(pageUrl);
        return this;
    }
}
