package page;

import org.openqa.selenium.WebDriver;

public class DealByWristWatchPage extends Page {
    private final String PAGE_URL = "https://cutt.ly/IhmH8m3"; // short link

    public DealByWristWatchPage(WebDriver driver) {
        super(driver);
    }

    public DealByWristWatchPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }
}
