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

public class SPU_255_TC_001_002_Verify_PostCross_And_Delete_Post extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_255_TC_001_002_Verify_PostCross_And_Delete_Post",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_255_TC_001_002_Verify_PostCross_And_Delete_Post() {
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
            // To click on Delete it
            _ref.sharePointHomePage.ClickOnDeleteIt(driver,BrowserName);
            // To verify post deletion
//            _ref.sharePointHomePage.verifyPostDeletion(driver,Prerequsite.configMap.get("SPU_TC_001_255"));
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify the Delete Post Cross and delet the post", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

