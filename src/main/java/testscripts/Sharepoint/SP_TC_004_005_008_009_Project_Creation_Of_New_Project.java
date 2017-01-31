package testscripts.Sharepoint;

import actions.Browser;
import actions.ResultUtil;
import common.ExtendedLibrary;
import intialize.Prerequsite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import util.DataProviderUtil;

import java.util.Map;

/**
 * Created by vijay.nagarajan on 10/03/2016.
 */
public class SP_TC_004_005_008_009_Project_Creation_Of_New_Project extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_004_005_008_009_Project_Creation_Of_New_Project",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_004_005_008_009_Project_Creation_Of_New_Project() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Project menu
            _ref.projectPage.clickProjectMenu(driver, BrowserName);
            // To Click Create New Project menu
            _ref.projectPage.clickCreateNewProjectMenu(driver, BrowserName);
            // To enter values and create project
            _ref.projectPage.enterValuesAndCreateTheProject(driver, BrowserName, Prerequsite.configMap.get("TC_004_005_Project_Creation_Name")+getRandomCode(),Prerequsite.configMap.get("TC_004_005_Project_Expiry_Date"));
            // To verify project creation page ribbon menu
            _ref.projectPage.verifyProjectCreationPageRibbonMenu(driver);
            // To verify menu under New Project Page
            _ref.projectPage.verifyMenuUnderNewProjectPage(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to login and logout", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


