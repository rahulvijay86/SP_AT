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

public class SP_TC_009_DocsPage_Verify_Files_Options extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_009_DocsPage_Verify_Files_Options",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_009_DocsPage_Verify_Files_Options() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.sharePointHomePage.clickOneDriveMenu(driver,BrowserName);
            _ref.docsPage.clickExistingDocument(driver,BrowserName,Prerequsite.configMap.get("TC_005_Edit_Doc"));
            _ref.docsPage.clickOnFileMenu(driver,BrowserName);
            _ref.docsPage.clickOnSendToOption(driver,BrowserName);
            _ref.docsPage.sendToOtherLocation(driver,BrowserName);
            _ref.docsPage.verifyManageCopiesMenu(driver);
            _ref.docsPage.verifyGoToSourceMenu(driver);
            _ref.docsPage.clickOnExistingDocument(driver);
            _ref.docsPage.clickOnOpenMenu(driver,BrowserName);
            _ref.docsPage.deleteDocument(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver,BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify OneDrive page menu and verify the file options", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


