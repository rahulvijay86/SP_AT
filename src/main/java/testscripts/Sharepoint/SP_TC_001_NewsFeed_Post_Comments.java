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
public class SP_TC_001_NewsFeed_Post_Comments extends Prerequsite {

//    private static final String PROJECT_PATH = System.getProperty("user.dir");
//    private static final String packageName ="Koala.jpg";
//    private static final String packagePath = PROJECT_PATH + "\\testdata\\" + packageName;

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_001_NewsFeed_Post_Comments",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_001_NewsFeed_Post_Comments() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click NewsFeed menu
            _ref.sharePointHomePage.clickNewsFeedMenu(driver,BrowserName);
            // To post comment
            _ref.newsFeedPage.postComment(Prerequsite.configMap.get("TC_001_Start_Conversation"),driver,BrowserName);
            // To add Image
            _ref.newsFeedPage.addImage(driver,BrowserName);
            // To click post button
            _ref.newsFeedPage.clickOnPostButton(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to post comments under newsfeed", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}