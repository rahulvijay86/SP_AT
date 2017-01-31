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
 * Created by vijay.nagarajan on 10/11/2016.
 */

public class SP_TC_007_UsernamePage_Verify_Edit_Menu_Options extends ExtendedLibrary {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_007_UsernamePage_Verify_Edit_Menu_Options",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_007_UsernamePage_Verify_Edit_Menu_Options() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click About me link
            _ref.sharePointHomePage.clickAboutMeLink(driver, BrowserName);
            // To click edit link
            _ref.sharePointHomePage.clickEditLink(driver, BrowserName);
            // To verify Edit menu options
            _ref.sharePointHomePage.verifyEditMenuOptions(driver);
            // To click HiddenMenu link
            _ref.sharePointHomePage.clickHiddenMenuLink(driver, BrowserName);
            // To verify Edit HiddenMenu options
            _ref.sharePointHomePage.verifyEditMenuHiddenOptions(driver, BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify edit menu options", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

