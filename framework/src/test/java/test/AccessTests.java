package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ItemPage;

public class AccessTests extends CommonConditions {
    private final String WRIST_WATCH_PAGE_URL = "/p106387137-muzhskie-chasy-amst.html";

    @Test(description = "Being unauthorized try to add ite to favorites")
    public void addToFavoritesBeingUnauthorized() {
        ItemPage dealByItemPage = new ItemPage(driver, WRIST_WATCH_PAGE_URL)
                .openPage();

        boolean isSuggestingToRegister = dealByItemPage
                .clickFavoriteButton()
                .getRegisterModalElements()
                .size() > 0;

        Assert.assertTrue(isSuggestingToRegister);
    }
}
