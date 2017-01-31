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
 * Created by vijay.nagarajan on 09/06/2016.
 */

public class SP_TC_006_Common_New_Page_Check_Option extends ExtendedLibrary {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_006_Common_New_Page_Check_Option",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_006_Common_New_Page_Check_Option() {
        try {
             waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.projectPage.clickPageMenu(driver, BrowserName);
            _ref.createPage.clickViewAllPagesMenu(driver, BrowserName);
            _ref.createPage.clickCreatedPage(Prerequsite.configMap.get("TC_006_Common_Click_Page_Name"), driver, BrowserName);
            _ref.sharePointHomePage.clickSettingsMenuInNewPage(driver, BrowserName);
            _ref.sharePointHomePage.clickEditPageMenu(driver, BrowserName);
            _ref.createPage.clickWebPartMenu(driver);
            _ref.createPage.clickImagesAndAddMenu(driver, BrowserName);
            _ref.createPage.verifyDifferentCreatePageMenu(driver, BrowserName);
            _ref.createPage.clickSaveMenu(driver, BrowserName);
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to click Add page menu and verify menu", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
