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
 * Created by manjari.muralidharan on 10/24/2016.
 */


public class SP_TC_005_006_DocsPage_CheckOut_And_CheckIn_Document extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_005_006_DocsPage_CheckOut_And_CheckIn_Document",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_005_006_DocsPage_CheckOut_And_CheckIn_Document() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click One drive menu
            _ref.sharePointHomePage.clickOneDriveMenu(driver,BrowserName);
            // To click on existing folder
            _ref.docsPage.clickOnExistingDocument(driver,BrowserName,Prerequsite.configMap.get("TC_004_Edit_Doc"));
            // To verify Edit overlay options
            _ref.docsPage.verifyEditOverlayOptions(driver,BrowserName);
            // To click on open menu
            _ref.docsPage.clickOnOpenMenu(driver,BrowserName);
            // To select Checkout
            _ref.docsPage.selectCheckOut(driver,BrowserName);
            // To click on CheckedIn document
            _ref.docsPage.clickOnCheckedInDocument(driver,BrowserName,Prerequsite.configMap.get("TC_006_Edit_Doc"));
            // To click on open menu
            _ref.docsPage.clickOnOpenMenu(driver,BrowserName);
            // To select CheckIn
            _ref.docsPage.selectCheckIn(driver,BrowserName);
            // To click on CheckIn ok
            _ref.docsPage.clickOnCheckInOk(driver,BrowserName);
            // To click Portal menu
            _ref.docsPage.clickPortalMenu(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to Check in and Check out document", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

