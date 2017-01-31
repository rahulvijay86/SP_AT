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

public class SP_TC_004_NewsFeed_Post_To_Everyone extends Prerequsite {
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String packageName ="Koala.jpg";
    private static final String packagePath = PROJECT_PATH + "\\testdata\\" + packageName;

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_004_NewsFeed_Post_To_Everyone",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_004_NewsFeed_Post_To_Everyone() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click NewsFeed menu
            _ref.sharePointHomePage.clickNewsFeedMenu(driver,BrowserName);
            // To post comment
            _ref.newsFeedPage.postComment(driver,BrowserName,Prerequsite.configMap.get("TC_004_Enter_Post"));
            // To click post button
            _ref.newsFeedPage.clickOnPostButton(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to post", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


