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



public class SP_TC_012_UsernamePage_Verify_Custom_Properties_Settings extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_012_UsernamePage_Verify_Custom_Properties_Settings",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_012_UsernamePage_Verify_Custom_Properties_Settings() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickAboutMeLink(driver,BrowserName);
            _ref.sharePointHomePage.clickEditLink(driver,BrowserName);
            _ref.sharePointHomePage.clickHiddenMenuLink(driver,BrowserName);
            _ref.userPage.clickOnCustomProperties(driver,BrowserName);
            _ref.userPage.clickSaveAndCloseButton(driver,BrowserName);
            _ref.userPage.clickOkButton(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver,BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to Make changes in the custom properties", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
