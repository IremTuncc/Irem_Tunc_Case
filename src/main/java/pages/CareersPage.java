package pages;

import org.openqa.selenium.By;

public class CareersPage extends BasePage {

    private final By seeAllQAJobsButton = By.cssSelector("a[href*='open-positions'][href*='qualityassurance']");

    public void navigateToCareersQAPage() {
        driver.get("https://insiderone.com/careers/quality-assurance/");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickSeeAllQAJobs() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clickWithJS(seeAllQAJobsButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}