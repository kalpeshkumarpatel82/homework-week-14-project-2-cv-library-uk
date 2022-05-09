package uk.co.library.testsuite;
/* 
 Created by Kalpesh Patel
 */

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.TestBase;

public class JobSearchTest extends TestBase {
    HomePage homePage;
    ResultPage resultPage;


    @BeforeMethod(alwaysRun = true)
    public void init() {
        homePage = new HomePage();
        resultPage = new ResultPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"}, dataProvider = "searchCriteria", dataProviderClass = TestData.class)
    public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType, String result) throws InterruptedException {
        //Optional added for lower resolution screen, comment this if you have better resolution
        //Here switch to iFrame, make program run slower
        homePage.clickOnAcceptCookie();
        homePage.enterJobTitle(jobTitle);
        homePage.enterLocation(location);
        homePage.selectDistance(distance);
        homePage.clickOnMoreSearchOptionLink();
        homePage.enterMinSalary(salaryMin);
        homePage.enterMaxSalary(salaryMax);
        homePage.selectSalaryType(salaryType);
        homePage.selectJobType(jobType);
        Thread.sleep(2000);
        homePage.clickOnFindJobsButton();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(resultPage.verifyTheResults(jobTitle) == true, "failed to search");
        softAssert.assertAll();

    }
}
