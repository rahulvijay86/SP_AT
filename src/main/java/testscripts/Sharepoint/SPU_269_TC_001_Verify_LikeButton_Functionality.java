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
 * Created by vijay.nagarajan on 11/04/2016.
 */

public class SPU_269_TC_001_Verify_LikeButton_Functionality extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_269_TC_001_Verify_LikeButton_Functionality",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_269_TC_001_Verify_LikeButton_Functionality() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // Click News Menu Option
            _ref.sharePointHomePage.clickNewsMenuOption(driver,BrowserName);
            // Click Full Story
            _ref.newsPage.clickOnFullStory(driver,BrowserName);
            // To verify Like Button presence
            _ref.newsPage.verifyLikeButtonPresence(driver);
            // To verify Like Button presence
            _ref.newsPage.verifyLikeButton(driver, BrowserName);
            // To get likes
            int unlike =_ref.newsPage.getLikes(driver, BrowserName);
            // To click like
            _ref.newsPage.clickLikeButton(driver, BrowserName);
            // To verify Like color
//            _ref.newsPage.verifyLikeColor(driver);
            // To verify the tool tip message after clicking like
            _ref.newsPage.verifyTooltipAfterLike(driver,BrowserName);
            // To get likes
            int like =_ref.newsPage.getLikes(driver, BrowserName);
            // To verify likes increment
            _ref.newsPage.likesIncrement(driver,unlike,like);
            // To click Unlike
//            _ref.newsPage.clickUnLikeButton(driver, BrowserName);
            // To verify the tool tip message before clicking like
//            _ref.newsPage.verifyTooltipBeforeLike(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify the like button functionality", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
