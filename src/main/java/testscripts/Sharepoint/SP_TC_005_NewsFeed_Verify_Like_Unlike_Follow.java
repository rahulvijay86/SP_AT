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
 * Created by manjari.muralidharan on 10/19/2016.
 */

public class SP_TC_005_NewsFeed_Verify_Like_Unlike_Follow extends ExtendedLibrary {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_005_NewsFeed_Verify_Like_Unlike_Follow",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_005_NewsFeed_Verify_Like_Unlike_Follow() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.sharePointHomePage.clickNewsFeedMenu(driver,BrowserName);
            // To click like
            _ref.newsFeedPage.clickLike(driver, BrowserName);
            // To click Unlike
            _ref.newsFeedPage.clickUnlike(driver, BrowserName);
            // To click OverFlow Menu
            _ref.newsFeedPage.clickOnOverFlowMenu(driver, BrowserName);
            // To click Activities Menu
            _ref.newsFeedPage.verifyActivitiesMenu(driver);
            // To click On following Menu
            _ref.newsFeedPage.clickOnFollowingMenu(driver, BrowserName);
            // To click more options and verify menu
            _ref.newsFeedPage.clickMoreOptionsAndVerifyMenus(driver, BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify like, unlike and follow menus", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


