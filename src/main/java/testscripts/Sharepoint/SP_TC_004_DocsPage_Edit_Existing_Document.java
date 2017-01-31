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


public class SP_TC_004_DocsPage_Edit_Existing_Document extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_004_DocsPage_Edit_Existing_Document",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_004_DocsPage_Edit_Existing_Document() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click One drive menu
            _ref.sharePointHomePage.clickOneDriveMenu(driver,BrowserName);
            // To click On existing folder
            _ref.docsPage.clickOpenMenu(driver,BrowserName);
            // To verify Edit overlay options
            _ref.docsPage.verifyEditOverlayOptions(driver,BrowserName);
            // To click on edit link
            _ref.docsPage.clickOnEditLink(driver,BrowserName);
            // To save the document
            _ref.docsPage.saveTheDocument(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to Edit existing document", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

