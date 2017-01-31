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
 * Created by manjari.muralidharan on 11/01/2016.
 */


public class SPU_292_TC_023_024_025_Verify_Promote_Button extends Prerequsite {

    @Parameters({"platform", "browserName", "remoteurl", "portalsiteurl"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName, String remoteurl, String portalsiteurl) throws Exception {

        ResultUtil.createReport("SPU_292_TC_023_024_025_Verify_Promote_Button", browserName, platform, portalsiteurl);
        driver = launchURL(platform, browserName, remoteurl, portalsiteurl);
    }

    @Test
    public void SPU_292_TC_023_024_025_Verify_Promote_Button() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_FIVE")));
            // To verify Promote button
            _ref.newsFeedPage.verifyPromoteButtonPresence(driver);
            // To post comment
            _ref.newsFeedPage.postComment(Prerequsite.configMap.get("SPU_TC_024_262"), driver, BrowserName);
            // To click on post button
            _ref.newsFeedPage.clickOnPostButton(driver, BrowserName);
            // To click on promote button
            _ref.newsFeedPage.clickOnPromoteButton(driver,BrowserName,Prerequsite.configMap.get("SPU_TC_024_262"));
            // To click wiley portal menu
            _ref.groupsPage.clickWileyPortalMenu(driver,BrowserName);
            // To verify Promote NewsFeed menu
            _ref.newsFeedPage.verifyPromotedNewsFeedPresence(driver, Prerequsite.configMap.get("SPU_TC_024_262"));
            // To click LogOut Dropdown menu
            _ref.sharePointHomePage.clickLogoutMenuDropdown(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify the Promote Button in SiteFeed", "" + e.getMessage(), driver);
            driver.quit();
        }
    }
}
