package test;

import com.google.common.collect.Ordering;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CatalogPage;

import java.util.List;

public class SortTests extends CommonConditions {
    private final String SNEAKERS_CATALOG_PAGE_URL = "/Krossovki-muzhskie.html";

    @Test(description = "Test sort ascending catalog items by price")
    public void sortAscendingCatalogItemsByPriceTest() {
        List<Double> catalogItemsPriceList =  new CatalogPage(driver, SNEAKERS_CATALOG_PAGE_URL)
                .openPage()
                .clickExpensiveButton()
                .getCatalogItemsPrices();

        boolean areCatalogItemsSortedByPrice = Ordering.natural().reverse().isOrdered(catalogItemsPriceList);

        Assert.assertTrue(areCatalogItemsSortedByPrice);
    }

    @Test(description = "Test sort descending catalog items by price")
    public void sortDescendingCatalogItemsByPriceTest() {
        List<Double> catalogItemsPriceList =  new CatalogPage(driver, SNEAKERS_CATALOG_PAGE_URL)
                .openPage()
                .clickCheapButton()
                .getCatalogItemsPrices();

        boolean areCatalogItemsSortedByPrice = Ordering.natural().isOrdered(catalogItemsPriceList);

        Assert.assertTrue(areCatalogItemsSortedByPrice);
    }
}
