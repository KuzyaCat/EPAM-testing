package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchPage;

import java.util.List;

public class SearchTests extends CommonConditions {
    private final String SEARCH_VALUE = "лондон";

    @Test(description = "Test search items by query value")
    public void addProductToBasketTest() {
        List<String> catalogItemsDescriptionTextList = new SearchPage(driver, SEARCH_VALUE)
                .openPage()
                .getCatalogItemsDescriptionTextList();

        boolean areAllItemsDescriptionsMatchSearchValue = catalogItemsDescriptionTextList.size() > 0
                && catalogItemsDescriptionTextList
                    .stream()
                    .allMatch(description -> description.contains(SEARCH_VALUE.toLowerCase()));

        Assert.assertTrue(areAllItemsDescriptionsMatchSearchValue);
    }
}
