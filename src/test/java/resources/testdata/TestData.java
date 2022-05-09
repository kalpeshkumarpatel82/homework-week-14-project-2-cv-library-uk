package resources.testdata;
/* 
 Created by Kalpesh Patel
 */

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name="searchCriteria")
    public Object[][] getData(){
        Object[][] data = new Object[][]{
                {"Tester","Harrow","5","30000","500000","annum","Permanent","Tester"},
                {"Manager","London","7","3500","5000","month","Contract","Manager"},
                {"Qa Tester","Leister","15","1000","2000","week","Temporary","Qa Tester"},
                {"Cook","Reading","35","30000","500000","annum","Apprenticeship","Cook"},
                {"Loader","Brent","10","50","100","day","Temporary","Loader"},
                {"Electrician","newport","750","10","15","hour","Part Time","Electrician"},
                {"Plumber","Manchester","10","25000","30000","annum","Permanent","Plumber"},
        };
        return data;
    }

}
