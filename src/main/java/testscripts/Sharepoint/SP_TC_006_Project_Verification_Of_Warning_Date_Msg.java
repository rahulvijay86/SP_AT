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
public class SP_TC_006_Project_Verification_Of_Warning_Date_Msg extends ExtendedLibrary {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_006_Project_Verification_Of_Warning_Date_Msg",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_006_Project_Verification_Of_Warning_Date_Msg() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Project menu
            _ref.projectPage.clickProjectMenu(driver, BrowserName);
            // To Click Create New Project menu
            _ref.projectPage.clickCreateNewProjectMenu(driver, BrowserName);
            // To enter values and create project
            _ref.projectPage.enterValuesToCreateTheProject(Prerequsite.configMap.get("TC_004_005_Project_Creation_Name")+getRandomCode(),Prerequsite.configMap.get("TC_004_005_Project_Creation_Description"),driver, BrowserName);
            // To verify Date Warning  Message
            _ref.projectPage.verifyDateWarningMsg(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to click Home menu under Groups Page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}



