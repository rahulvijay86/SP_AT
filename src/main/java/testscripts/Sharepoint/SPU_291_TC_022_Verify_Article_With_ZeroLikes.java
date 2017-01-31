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
 * Created by vijay.nagarajan on 08/19/2016.
 */

public class SPU_291_TC_022_Verify_Article_With_ZeroLikes extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","likeurl"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String likeurl) throws Exception {

        ResultUtil.createReport("SPU_291_TC_022_Verify_Article_With_ZeroLikes",browserName,platform,likeurl);
        driver=launchURL(platform, browserName, remoteurl, likeurl);
    }

    @Test
    public void SPU_291_TC_022_Verify_Article_With_ZeroLikes() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To verify the like button Presence
            _ref.newsPage.verifyLikeButtonPresence(driver);
            // To verify the like button
            _ref.newsPage.verifyLikeButton(driver,BrowserName);
            // To get likes count
            int unlike =_ref.newsPage.getLikes(driver,BrowserName);
            // To verify Zero likes
            _ref.newsPage.verifyZeroLikes(driver,unlike);
            // To click Like Button
            _ref.newsPage.clickLikeButton(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver,BrowserName);

            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to login and logoutUser not able to verify article with zero likes", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


