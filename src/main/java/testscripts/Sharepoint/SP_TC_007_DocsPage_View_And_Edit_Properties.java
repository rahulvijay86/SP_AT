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
public class SP_TC_007_DocsPage_View_And_Edit_Properties extends ExtendedLibrary {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_007_DocsPage_View_And_Edit_Properties",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_007_DocsPage_View_And_Edit_Properties() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click One drive menu
            _ref.sharePointHomePage.clickOneDriveMenu(driver, BrowserName);
            // To click On existing folder
            _ref.docsPage.clickOnExistingDocument(driver, BrowserName,Prerequsite.configMap.get("TC_004_Edit_Doc"));
            // To click on open menu
            _ref.docsPage.clickOnOpenMenu(driver, BrowserName);
            // To select view properties
            _ref.docsPage.selectViewProperties(driver, BrowserName);
            // To click One drive menu
            _ref.sharePointHomePage.clickOneDriveMenu(driver, BrowserName);
            // To click On existing folder
            _ref.docsPage.clickOnExistingDocument(driver, BrowserName,Prerequsite.configMap.get("TC_004_Edit_Doc"));
            // To click on open menu
            _ref.docsPage.clickOnOpenMenu(driver, BrowserName);//
            // To select Edit properties
            _ref.docsPage.selectEditProperties(driver, BrowserName);
            // To click One drive menu
            _ref.sharePointHomePage.clickOneDriveMenu(driver, BrowserName);
            // To click On existing folder
            _ref.docsPage.clickOnExistingDocument(driver, BrowserName,Prerequsite.configMap.get("TC_004_Edit_Doc"));
            // To click on open menu
            _ref.docsPage.clickOnOpenMenu(driver, BrowserName);
            // To click download a copy menu
            _ref.docsPage.clickDownloadACopyMenu(driver, BrowserName);
            // To click portal menu
            _ref.docsPage.clickPortalMenu(driver, BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to view and edit properties of a document", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
