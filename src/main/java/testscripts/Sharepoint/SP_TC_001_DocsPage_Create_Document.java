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
public class SP_TC_001_DocsPage_Create_Document extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_001_DocsPage_Create_Document",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_001_DocsPage_Create_Document() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click One drive menu
            _ref.sharePointHomePage.clickOneDriveMenu(driver, BrowserName);
            // To click add new document
            _ref.docsPage.clickAddNewDocument(driver, BrowserName);
            // To verify document types
            _ref.docsPage.verifyDocumentTypes(driver, BrowserName);
            // To click on word document
            _ref.docsPage.clickOnWordDocument(driver, BrowserName);
            // To enter document name
            _ref.docsPage.enterDocumentName(driver,BrowserName,Prerequsite.configMap.get("TC_001_Add_Doc") + getRandomCode());
            // To save the document
            _ref.docsPage.saveTheDocument(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver,BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify OneDrive page menu and create a new document", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}