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
 * Created by vijay.nagarajan on 11/03/2016.
 */

public class SPU_270_TC_001_002_Creation_Of_New_Project extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_270_TC_001_002_Creation_Of_New_Project",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_270_TC_001_002_Creation_Of_New_Project() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click project Menu
            _ref.projectPage.clickProjectMenu(driver,BrowserName);
            // To click create new project
            _ref.projectPage.clickCreateNewProjectMenu(driver, BrowserName);
            // To enter values and create project
            _ref.projectPage.enterValuesAndCreateTheProject(driver, BrowserName, Prerequsite.configMap.get("TC_004_005_Project_Creation_Name"),Prerequsite.configMap.get("TC_004_005_Project_Expiry_Date"));
            // To verify menus under new project page
            _ref.projectPage.verifyMenuUnderNewProjectPage(driver, BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);


            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to create new project", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

