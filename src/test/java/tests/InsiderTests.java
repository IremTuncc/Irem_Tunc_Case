package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.CareersPage;
import pages.QAJobsPage;
import pages.LeverApplicationPage;
import utils.DriverManager;

public class InsiderTests {

    private HomePage homePage;
    private CareersPage careersPage;
    private QAJobsPage qaJobsPage;
    private LeverApplicationPage leverPage;

    @BeforeClass
    public void setUp() {
        homePage = new HomePage();
        careersPage = new CareersPage();
        qaJobsPage = new QAJobsPage();
        leverPage = new LeverApplicationPage();
        System.out.println("Test basladi");
    }

    @Test(priority = 1)
    public void testHomePageIsOpenedWithMainBlocks() {
        System.out.println("Test 1: Ana sayfa");
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageOpened());
        Assert.assertTrue(homePage.areMainBlocksLoaded());
        System.out.println("Test 1: BASARILI");
    }

    @Test(priority = 2)
    public void testNavigateToQAJobsAndFilter() {
        System.out.println("Test 2: QA Jobs filtreleme");
        careersPage.navigateToCareersQAPage();
        careersPage.clickSeeAllQAJobs();
        qaJobsPage.filterByLocation("Istanbul, Turkiye");
        qaJobsPage.filterByDepartment("Quality Assurance");
        Assert.assertTrue(qaJobsPage.isJobsListPresent());
        System.out.println("Test 2: BASARILI");
    }

    @Test(priority = 3)
    public void testAllJobsMatchFilterCriteria() {
        System.out.println("Test 3: Is kriterleri kontrolu");
        Assert.assertTrue(
                qaJobsPage.allJobsContainText("Quality Assurance", "Istanbul, Turkiye", "Quality Assurance")
        );
        System.out.println("Test 3: BASARILI");
    }

    @Test(priority = 4)
    public void testViewRoleRedirectsToLeverPage() {
        System.out.println("Test 4: Lever redirect");
        qaJobsPage.clickViewRole();
        Assert.assertTrue(leverPage.isOnLeverPage());
        System.out.println("Test 4: BASARILI");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Test bitti");
        DriverManager.quitDriver();
    }
}