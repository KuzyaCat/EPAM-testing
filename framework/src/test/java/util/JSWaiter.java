package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class JSWaiter {
    public static ExpectedCondition<Boolean> waitUntilJSReady() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean)((JavascriptExecutor)driver)
                        .executeScript("return (document.readyState == \"complete\") && (jQuery !== null) && (jQuery.active == 0)");
            }
        };
    }
}
