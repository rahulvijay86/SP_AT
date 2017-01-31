package testscripts.Sharepoint;

import actions.Browser;
import actions.ResultUtil;
import common.ExtendedLibrary;
import intialize.Prerequsite;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import util.DataProviderUtil;

import java.util.Map;

/**
 * Created by vijay.nagarajan on 10/27/2016.
 */

public class SPU_311_TC_007_Unfollow_One_Subsection extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_311_TC_007_Unfollow_One_Subsection",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_311_TC_007_Unfollow_One_Subsection() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // Follow One Section
            _ref.sharePointHomePage.FollowOneSection(driver,BrowserName);
            // Unfollow One Sub Section
            _ref.sharePointHomePage.UnFollowOneSubSection(driver,BrowserName);
            //Click on Sign out dropdown
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            //Click sign out
            _ref.sharePointHomePage.clickSignOutMenu(driver,BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to un follow one sub section", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


