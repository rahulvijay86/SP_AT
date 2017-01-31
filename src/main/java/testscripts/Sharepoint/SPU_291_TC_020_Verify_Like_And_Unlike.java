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
 * Created by manjari.muralidharan on 10/31/2016.
 */

public class SPU_291_TC_020_Verify_Like_And_Unlike extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","newsurl"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String newsurl) throws Exception {

        ResultUtil.createReport("SPU_291_TC_020_Verify_Like_And_Unlike",browserName,platform,newsurl);
        driver=launchURL(platform, browserName, remoteurl, newsurl);
    }

    @Test
    public void SPU_291_TC_020_Verify_Like_And_Unlike() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_FIVE")));
            // To click on full story
            _ref.newsPage.clickOnFullStory(driver,BrowserName);
            // To verify the like button
            _ref.newsPage.verifyLikeButton(driver,BrowserName);
            // To get likes count
            int unlike =_ref.newsPage.getLikes(driver,BrowserName);
            //To click Like button
            _ref.newsPage.clickLikeButton(driver,BrowserName);
            // To get likes count
            int like =_ref.newsPage.getLikes(driver,BrowserName);
            // To verify like increment
            _ref.newsPage.likesIncrement(driver,unlike,like);
            // To get likes count
            int liked = _ref.newsPage.getLikes(driver,BrowserName);
            //To click Like button
            _ref.newsPage.clickUnLikeButton(driver,BrowserName);
            // To get likes count
            int unliked =_ref.newsPage.getLikes(driver,BrowserName);
            // To verify like decrement
            _ref.newsPage.likesDecrement(driver,liked,unliked);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify like and unlike", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
