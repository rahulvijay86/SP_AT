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
public class SP_TC_003_Project_Menu_Verification_Under_Create_New_Project_Page extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_003_Project_Menu_Verification_Under_Create_New_Project_Page",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_003_Project_Menu_Verification_Under_Create_New_Project_Page() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Project menu
            _ref.projectPage.clickProjectMenu(driver,BrowserName);
            // To Click Create New Project menu
            _ref.projectPage.clickCreateNewProjectMenu(driver,BrowserName);
            // To verify create Project page menu
            _ref.projectPage.verifyCreateProjectPageMenu(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify menu under create project page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

