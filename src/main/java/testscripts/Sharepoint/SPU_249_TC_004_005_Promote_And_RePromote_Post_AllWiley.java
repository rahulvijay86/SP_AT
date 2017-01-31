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
 * Created by manjari.muralidharan on 11/09/2016.
 */

public class SPU_249_TC_004_005_Promote_And_RePromote_Post_AllWiley extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","siteurl"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String siteurl) throws Exception {

        ResultUtil.createReport("SPU_249_TC_004_005_Promote_And_RePromote_Post_AllWiley",browserName,platform,siteurl);
        driver=launchURL(platform, browserName, remoteurl, siteurl);
    }

    @Test
    public void SPU_249_TC_004_Promote_Post_AllWiley() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_FIVE")));
            // To start conversation
            _ref.newsFeedPage.startConversation(driver,BrowserName,Prerequsite.configMap.get("SPU_TC_249_004"));
            // To click on post Tag
            _ref.newsFeedPage.clickOnPostTag(driver, BrowserName);
            // To click Wiley portal menu
            _ref.groupsPage.clickWileyPortalMenu(driver,BrowserName);
            // To verify Promoted NewsFeed
            _ref.newsFeedPage.verifyPromotedNewsFeedPresence(driver,Prerequsite.configMap.get("SPU_TC_249_004"));
            // To click LogOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to Promote All wiley Tag", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
