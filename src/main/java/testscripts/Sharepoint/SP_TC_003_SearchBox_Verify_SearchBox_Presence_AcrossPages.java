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
public class SP_TC_003_SearchBox_Verify_SearchBox_Presence_AcrossPages extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_003_SearchBox_Verify_SearchBox_Presence_AcrossPages",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_003_SearchBox_Verify_SearchBox_Presence_AcrossPages() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To verify Search Box
            _ref.sharePointHomePage.verifySearchBoxPresence(driver);
            // To click News Menu
            _ref.sharePointHomePage.clickNewsMenuOption(driver,BrowserName);
            // To verify Search Box
            _ref.sharePointHomePage.verifySearchBoxPresence(driver);
            // To click Groups Menu
            _ref.groupsPage.clickGroupsMenu(driver,BrowserName);
            // To verify Search Box
            _ref.sharePointHomePage.verifySearchBoxPresence(driver);
            // To click Tools Menu
            _ref.sharePointHomePage.clickToolsMenuOption(driver,BrowserName);
            // To verify Search Box
            _ref.sharePointHomePage.verifySearchBoxPresence(driver);
            // To click Project Menu
            _ref.projectPage.clickProjectMenu(driver,BrowserName);
            // To verify Search Box
            _ref.sharePointHomePage.verifySearchBoxPresence(driver);
            // To click NewsFeed Menu
            _ref.sharePointHomePage.clickNewsFeedMenu(driver,BrowserName);
            // To verify Search Box
            _ref.sharePointHomePage.verifySearchBoxPresence(driver);
            // To click OneDrive Menu
            _ref.sharePointHomePage.clickOneDriveMenu(driver,BrowserName);
            // To verify Search Box
            _ref.sharePointHomePage.verifySearchBoxPresence(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
              //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify search box menu across pages", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
