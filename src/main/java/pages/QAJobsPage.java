package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class QAJobsPage extends BasePage {

    private final By locationFilter = By.id("filter-by-location");
    private final By departmentFilter = By.id("filter-by-department");
    private final By jobsList = By.cssSelector("div.position-list-item");
    private final By positionDepartments = By.cssSelector("span.position-department");
    private final By positionLocations = By.cssSelector("div.position-location");
    private final By viewRoleButtons = By.linkText("View Role");

    public void filterByLocation(String location) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        WebElement dropdown = findElement(locationFilter);
        Select select = new Select(dropdown);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        select.selectByVisibleText(location);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
    }

    public void filterByDepartment(String department) {
        WebElement dropdown = findElement(departmentFilter);
        Select select = new Select(dropdown);
        select.selectByVisibleText(department);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
    }

    public boolean isJobsListPresent() {
        try {
            List<WebElement> jobs = findElements(jobsList);
            return jobs.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean allJobsContainText(String position, String location, String department) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        List<WebElement> jobs = findElements(jobsList);

        if (jobs.size() == 0) {
            return false;
        }

        for (WebElement job : jobs) {
            String deptText = job.findElement(positionDepartments).getText().trim();
            String locText = job.findElement(positionLocations).getText().trim();

            if (!deptText.contains(department)) {
                return false;
            }

            if (!locText.contains(location)) {
                return false;
            }
        }

        return true;
    }

    public void clickViewRole() {
        List<WebElement> buttons = findElements(viewRoleButtons);
        if (buttons.size() > 0) {
            buttons.get(0).click();
            switchToNewWindow();
        }
    }
}