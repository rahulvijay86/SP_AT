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

public class SPU_291_TC_021_Verify_Like_Button_And_Count extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","pageurl"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String pageurl) throws Exception {

        ResultUtil.createReport("SPU_291_TC_021_Verify_Like_Button_And_Count",browserName,platform,pageurl);
        driver=launchURL(platform, browserName, remoteurl, pageurl);
    }

    @Test
    public void SPU_291_TC_021_Verify_Like_Button_And_Count() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_FIVE")));
            // To verify the like button
            _ref.newsPage.verifyLikeButton(driver, BrowserName);
            // To get likes count
            int like =_ref.newsPage.getLikes(driver, BrowserName);
            //To click Like button
            _ref.newsPage.clickLikeButton(driver, BrowserName);
            // To get likes count
            int unlike =_ref.newsPage.getLikes(driver, BrowserName);
            // To verify like increment
            _ref.newsPage.likesIncrement(driver,like,unlike);
            // Click Unlike button
//            _ref.newsPage.clickUnLikeButton(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify like and count", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

