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
 * Created by vijay.nagarajan on 10/06/2016.
 */



public class SP_TC_019_Group_Verify_New_Workflow_Menu extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_019_Group_Verify_New_Workflow_Menu",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_019_Group_Verify_New_Workflow_Menu() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Settings Menu
            _ref.sharePointHomePage.clickSettingsMenu(driver,BrowserName);
            // To click SiteContents option
            _ref.sharePointHomePage.clickSiteContentsOption(driver,BrowserName);
            // To click Site WorkFlows Menu
            _ref.sharePointHomePage.clickSiteWorkflowsMenu(driver,BrowserName);
            // To verify Start New WorkFlows Menu
            _ref.sharePointHomePage.verifyStartNewWorkflowMenuPresence(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify New Workflow menu presence", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

