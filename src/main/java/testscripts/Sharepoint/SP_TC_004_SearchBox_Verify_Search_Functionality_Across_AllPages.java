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
 * Created by manjari.muralidharan on 10/07/2016.
 */


public class SP_TC_004_SearchBox_Verify_Search_Functionality_Across_AllPages extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_004_SearchBox_Verify_Search_Functionality_Across_AllPages",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_004_SearchBox_Verify_Search_Functionality_Across_AllPages() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To verify Document search functionality
            _ref.sharePointHomePage.verifyDocSearchFunctionality(driver,BrowserName,Prerequsite.configMap.get("TC_002_Enter_Document"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To verify Conversation search functionality
            _ref.sharePointHomePage.verifyConvSearchFunctionality(driver, BrowserName, Prerequsite.configMap.get("TC_002_Enter_Conversation"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To verify Name search functionality
            _ref.sharePointHomePage.verifyNameSearchFunctionality(driver, BrowserName, Prerequsite.configMap.get("TC_002_Enter_Name"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To verify Email search functionality
            _ref.sharePointHomePage.verifyEmailSearchFunctionality(driver, BrowserName, Prerequsite.configMap.get("TC_002_Enter_email"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To click news menu
            _ref.sharePointHomePage.clickNewsMenuOption(driver,BrowserName);
            // To verify Document search functionality
            _ref.sharePointHomePage.verifyDocSearchFunctionality(driver,BrowserName,Prerequsite.configMap.get("TC_002_Enter_Document"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To verify Conversation search functionality
            _ref.sharePointHomePage.verifyConvSearchFunctionality(driver, BrowserName, Prerequsite.configMap.get("TC_002_Enter_Conversation"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To verify Name search functionality
            _ref.sharePointHomePage.verifyNameSearchFunctionality(driver, BrowserName, Prerequsite.configMap.get("TC_002_Enter_Name"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To verify Email search functionality
            _ref.sharePointHomePage.verifyEmailSearchFunctionality(driver, BrowserName, Prerequsite.configMap.get("TC_002_Enter_email"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To click groups menu
            _ref.groupsPage.clickGroupsMenu(driver,BrowserName);
            // To verify Document search functionality
            _ref.sharePointHomePage.verifyDocSearchFunctionality(driver,BrowserName,Prerequsite.configMap.get("TC_002_Enter_Document"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To verify Conversation search functionality
            _ref.sharePointHomePage.verifyConvSearchFunctionality(driver, BrowserName, Prerequsite.configMap.get("TC_002_Enter_Conversation"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To verify Name search functionality
            _ref.sharePointHomePage.verifyNameSearchFunctionality(driver, BrowserName, Prerequsite.configMap.get("TC_002_Enter_Name"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To verify Email search functionality
            _ref.sharePointHomePage.verifyEmailSearchFunctionality(driver, BrowserName, Prerequsite.configMap.get("TC_002_Enter_email"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To click Tools menu
            _ref.sharePointHomePage.clickToolsMenuOption(driver, BrowserName);
            // To verify Document search functionality
            _ref.sharePointHomePage.verifyDocSearchFunctionality(driver,BrowserName,Prerequsite.configMap.get("TC_002_Enter_Document"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To verify Conversation search functionality
            _ref.sharePointHomePage.verifyConvSearchFunctionality(driver, BrowserName, Prerequsite.configMap.get("TC_002_Enter_Conversation"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To verify Name search functionality
            _ref.sharePointHomePage.verifyNameSearchFunctionality(driver, BrowserName, Prerequsite.configMap.get("TC_002_Enter_Name"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To verify Email search functionality
            _ref.sharePointHomePage.verifyEmailSearchFunctionality(driver, BrowserName, Prerequsite.configMap.get("TC_002_Enter_email"));
            // To click portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User unable to verify search functionality across pages.", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

