package pages;

import org.openqa.selenium.By;

public class LeverApplicationPage extends BasePage {

    private final By applicationForm = By.cssSelector("div.application-form");

    public boolean isOnLeverPage() {
        return getCurrentUrl().contains("lever.co") ||
                getCurrentUrl().contains("jobs.lever.co");
    }

    public boolean isApplicationFormPresent() {
        return isElementDisplayed(applicationForm);
    }
}