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
 * Created by vijay.nagarajan on 10/07/2016.
 */

public class SPU_316_TC_013_014_Verify_Phone_And_Email extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_316_TC_013_014_Verify_Phone_And_Email",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_316_TC_013_014_Verify_Phone_And_Email() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To enter text and verify phone menu
            _ref.sharePointHomePage.enterTextAndClickUser(driver,BrowserName,Prerequsite.configMap.get("SPU_TC_001_Enter_UserName"));
            // To verify User Picture
            _ref.sharePointHomePage.verifyUserPicture(driver);
            // To verify Email Address
            _ref.sharePointHomePage.verifyEmailAddress(driver);
            // To click Signout Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click Signout Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver,BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify phone menu under Search option", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
