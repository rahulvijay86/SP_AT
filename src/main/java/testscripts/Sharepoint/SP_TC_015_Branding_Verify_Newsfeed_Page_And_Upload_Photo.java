package testscripts.Sharepoint;

import actions.Browser;
import actions.ResultUtil;
import common.ExtendedLibrary;
import intialize.Prerequsite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import util.DataProviderUtil;

import java.io.File;
import java.util.Map;

/**
 * Created by vijay.nagarajan on 09/23/2016.
 */

public class SP_TC_015_Branding_Verify_Newsfeed_Page_And_Upload_Photo extends Prerequsite {

//    private static final String PROJECT_PATH = System.getProperty("user.dir");
//File file = new File("src//main//java//resources//Koala.jpg");
//private static final String PROJECT_PATH = System.getProperty("user.dir") + "src//main//java//resources//Koala.jpg";
//    private static final String packageName ="Koala.jpg";
//    private static final String packagePath = PROJECT_PATH + "\\testdata\\" + packageName;
//private static final String packagePath = PROJECT_PATH + packageName;

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_015_Branding_Verify_Newsfeed_Page_And_Upload_Photo",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test

    public void SP_TC_015_Branding_Verify_Newsfeed_Page_And_Upload_Photo() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.sharePointHomePage.clickNewsFeedMenu(driver,BrowserName);
            _ref.newsFeedPage.startConversation(driver, BrowserName,Prerequsite.configMap.get("TC_001_Start_Conversation"));
            _ref.newsFeedPage.addImage(driver, BrowserName);
            _ref.newsFeedPage.clickOnPostButton(driver, BrowserName);
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify Newsfeed page and upload photo", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


