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
 * Created by manjari.muralidharan on 10/26/2016.
 */

public class SPU_286_TC_026_027_028_Verify_User_Able_To_Post extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","portalsiteurl"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String portalsiteurl) throws Exception {

        ResultUtil.createReport("SPU_286_TC_026_027_028_Verify_User_Able_To_Post",browserName,platform,portalsiteurl);
        driver=launchURL(platform, browserName, remoteurl, portalsiteurl);
    }

    @Test
    public void SPU_286_TC_026_027_028_Verify_User_Able_To_Post() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            //To click start a conversation
            _ref.newsFeedPage.ClickStartConversation(driver, BrowserName);
            //To enter the comment
            _ref.newsFeedPage.postComment(driver, BrowserName,Prerequsite.configMap.get("SPU_TC_286_026"));
            //To post the comment
            _ref.newsFeedPage.clickOnPostButton(driver, BrowserName);
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to post the comment", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


