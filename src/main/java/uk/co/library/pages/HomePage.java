package uk.co.library.pages;
/* 
 Created by Kalpesh Patel
 */

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='keywords']")
    WebElement keyWords;

    @FindBy(xpath = "//input[@id='location']")
    WebElement locations;

    @FindBy(xpath = "//select[@id='distance']")
    WebElement distances;

    @FindBy(xpath = "//button[@id='toggle-hp-search']")
    WebElement toggleMoreOptions;

    @FindBy(xpath = "//input[@id='salarymin']")
    WebElement salaryMin;

    @FindBy(xpath = "//input[@id='salarymax']")
    WebElement salaryMax;

    @FindBy(xpath = "//select[@id='salarytype']")
    WebElement salaryType;

    @FindBy(xpath = "//select[@id='tempperm']")
    WebElement typeOfJob;

    @FindBy(xpath = "//input[@id='hp-search-btn']")
    WebElement findJobs;

    @FindBy(xpath = "//*[contains(text(),'Accept')]")
    WebElement acceptCookies;

    public void clickOnAcceptCookie() {
        Reporter.log("Clicking on Accept Cookies : " + acceptCookies.toString());
        switchToiFrame("gdpr-consent-notice");
        clickOnElement(acceptCookies);
    }

    public void enterJobTitle(String jobTitle) {
        Reporter.log("Sending keywords : " + jobTitle + " to " + keyWords.toString());
        sendTextToElement(keyWords, jobTitle);
    }

    public void enterLocation(String location) {
        Reporter.log("Sending Location : " + location + " to " + locations.toString());
        sendTextToElement(locations, location);
    }

    public void selectDistance(String distance) {
        Reporter.log("Selecting distance : " + distance + " from " + distances.toString());
        selectByValueFromDropDown(distances, distance);
    }

    public void clickOnMoreSearchOptionLink() {
        Reporter.log("Clicking on More options : " + toggleMoreOptions.toString());
        clickOnElement(toggleMoreOptions);
    }

    public void enterMinSalary(String minSalary) {
        Reporter.log("Sending Min Salary : " + minSalary + " to " + salaryMin.toString());
        sendTextToElement(salaryMin, minSalary);
    }

    public void enterMaxSalary(String maxSalary) {
        Reporter.log("Sending Max Salary : " + maxSalary + " to " + salaryMax.toString());
        sendTextToElement(salaryMax, maxSalary);
    }

    public void selectSalaryType(String sType) {
        Reporter.log("Selecting Salary Types : " + sType + " from " + salaryType.toString());
        selectByValueFromDropDown(salaryType, sType);
    }

    public void selectJobType(String jobType) {
        Reporter.log("Selecting Job Types : " + jobType + " to " + typeOfJob.toString());
        selectByValueFromDropDown(typeOfJob, jobType);
    }

    public void clickOnFindJobsButton() {
        Reporter.log("Sending ENTER key : " + findJobs.toString());
        clickOnElement(findJobs, Keys.ENTER);
    }

}
