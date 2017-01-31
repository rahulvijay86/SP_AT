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
public class SP_TC_007_NewsFeed_Post_To_Individual extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_007_NewsFeed_Post_To_Individual",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_007_NewsFeed_Post_To_Individual() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click NewsFeed menu
            _ref.sharePointHomePage.clickNewsFeedMenu(driver,BrowserName);
            // To post comment by selecting user name
            _ref.newsFeedPage.postComment(Prerequsite.configMap.get("TC_007_Enter_Post"),driver, BrowserName);
            // To click post button
            _ref.newsFeedPage.clickOnPostButton(driver, BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to post comments by tagging individual", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

