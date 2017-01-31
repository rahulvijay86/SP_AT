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
 * Created by vijay.nagarajan on 08/03/2016.
 */

public class SPU_255_TC_003_DeletePostCross_Verify_Post_Retained_OnClicking_Cancel_Delete extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_255_TC_003_DeletePostCross_Verify_Post_Retained_OnClicking_Cancel_Delete",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_TC_003_255_DeletePostCross_Verify_Post_Retained_OnClicking_Cancel_Delete() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.newsFeedPage.startConversation(driver,BrowserName,Prerequsite.configMap.get("SPU_TC_001_255"));
            _ref.newsFeedPage.clickOnPostButton(driver,BrowserName);
            _ref.sharePointHomePage.verifyDeletePostCrossPresence(driver,Prerequsite.configMap.get("SPU_TC_001_255"));
            _ref.sharePointHomePage.DeletePostCross(driver,BrowserName,Prerequsite.configMap.get("SPU_TC_001_255"));
            _ref.sharePointHomePage.ClickOnCancel(driver,BrowserName);
            _ref.sharePointHomePage.verifyPostIsRetained(driver,Prerequsite.configMap.get("SPU_TC_001_255"));
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver,BrowserName);

            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify the Delete Post Cross in Site Feeds menu", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
