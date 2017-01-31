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
public class SP_TC_003_NewsFeed_Follow_Of_Tag extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_003_NewsFeed_Follow_Of_Tag",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_003_NewsFeed_Follow_Of_Tag() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click NewsFeed menu
            _ref.sharePointHomePage.clickNewsFeedMenu(driver,BrowserName);
            // To start conversation
            _ref.newsFeedPage.startConversation(driver,BrowserName,Prerequsite.configMap.get("TC_003_Enter_Tag"));
            // To click post button
            _ref.newsFeedPage.clickOnPostButton(driver,BrowserName);
            // To click Follow tag
            _ref.newsFeedPage.clickFollowTag(driver,BrowserName);
            // To click UnFollow tag
            _ref.newsFeedPage.clickUnFollowTag(driver,BrowserName);
            // To click tag
            _ref.newsFeedPage.clickTag(driver,BrowserName);
            // To click on Add related tag
            _ref.newsFeedPage.clickOnAddRelatedTag(driver,BrowserName,Prerequsite.configMap.get("TC_003_Enter_Related_Tag"));
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to follow tag in newsfeed", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

