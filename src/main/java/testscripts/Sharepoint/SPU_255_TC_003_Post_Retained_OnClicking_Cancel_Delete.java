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
 * Created by manjari.muralidharan on 11/02/2016.
 */

public class SPU_255_TC_003_Post_Retained_OnClicking_Cancel_Delete extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_255_TC_003_Post_Retained_OnClicking_Cancel_Delete",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_255_TC_003_Post_Retained_OnClicking_Cancel_Delete() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To post comment
            _ref.newsFeedPage.postComment(Prerequsite.configMap.get("SPU_TC_001_255"),driver,BrowserName);
            // To click on post button
            _ref.newsFeedPage.clickOnPostButton(driver,BrowserName);
            // To verify delete post cross
            _ref.sharePointHomePage.verifyDeletePostCrossPresence(driver,Prerequsite.configMap.get("SPU_TC_001_255"));
            // To click on delete post cross
            _ref.sharePointHomePage.DeletePostCross(driver, BrowserName,Prerequsite.configMap.get("SPU_TC_001_255"));
            // To click on cancel
            _ref.sharePointHomePage.ClickOnCancel(driver,BrowserName);
            // To verify post is retained
            _ref.sharePointHomePage.verifyPostIsRetained(driver,Prerequsite.configMap.get("SPU_TC_001_255"));
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);


            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify post retained after clicking cancel delete", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
