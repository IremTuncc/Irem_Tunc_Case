package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By logoLocator = By.cssSelector("div[class*='header-logo']");
    private final By navigationMenuLocator = By.cssSelector("div.header-menu");
    private final By heroSectionLocator = By.cssSelector("section[class*='homepage-hero']");
    private final By cookieAcceptButton = By.cssSelector("button[class*='accept'], a[class*='accept']");

    public void navigateToHomePage() {
        driver.get("https://insiderone.com/");
        acceptCookiesIfPresent();
    }

    private void acceptCookiesIfPresent() {
        try {
            Thread.sleep(2000);
            if (isElementDisplayed(cookieAcceptButton)) {
                click(cookieAcceptButton);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            // Cookie yok, devam et
        }
    }

    public boolean isHomePageOpened() {
        return isElementDisplayed(logoLocator) &&
                getCurrentUrl().contains("insiderone.com");
    }

    public boolean areMainBlocksLoaded() {
        return isElementDisplayed(logoLocator) &&
                isElementDisplayed(navigationMenuLocator) &&
                isElementDisplayed(heroSectionLocator);
    }
}

