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

public class SP_TC_009_UsernamePage_EditUserDetails_Click_SaveAndClose extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_009_UsernamePage_EditUserDetails_Click_SaveAndClose",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_009_UsernamePage_EditUserDetails_Click_SaveAndClose() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click About Me menu
            _ref.sharePointHomePage.clickAboutMeLink(driver, BrowserName);
            // To click Edit menu
            _ref.sharePointHomePage.clickEditLink(driver,BrowserName);
            // To click contact Information menu
            _ref.userPage.clickContactInformationMenu(driver,BrowserName);
            // To edit mobile number
            _ref.userPage.editMobileNumber(driver,BrowserName,Prerequsite.configMap.get("TC_009_Edit_User_Details"));
            // To click Save and Close menu
            _ref.userPage.clickSaveAndCloseButton(driver,BrowserName);
            // To click Ok menu
            _ref.userPage.clickOkButton(driver,BrowserName);
            // To click Signout dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click Signout Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver,BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify save and close", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
