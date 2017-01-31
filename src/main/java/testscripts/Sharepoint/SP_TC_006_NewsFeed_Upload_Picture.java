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
 * Created by manjari.muralidharan on 10/20/2016.
 */

public class SP_TC_006_NewsFeed_Upload_Picture extends ExtendedLibrary {

//    private static final String PROJECT_PATH = System.getProperty("user.dir");
//    private static final String packageName ="Jellyfish.jpg";
//    private static final String packagePath = PROJECT_PATH + "\\testdata\\" + packageName;

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass

    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_006_NewsFeed_Upload_Picture",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);

    }

    @Test
    public void SP_TC_006_NewsFeed_Upload_Picture() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click NewsFeed menu
            _ref.sharePointHomePage.clickNewsFeedMenu(driver,BrowserName);
            // To click start conversation
            _ref.newsFeedPage.ClickStartConversation(driver, BrowserName);
            // To add image
            _ref.newsFeedPage.addImageFile(driver, BrowserName );
            // To click on post button
            _ref.newsFeedPage.clickOnPostButton(driver, BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to upload picture in newsfeed", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


