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
 * Created by vijay.nagarajan on 10/25/2016.
 */

public class SP_TC_001_Libs_Verify_Library_Tab_Menu_Options extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_001_Libs_Verify_Library_Tab_Menu_Options",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_001_Libs_Verify_Library_Tab_Menu_Options() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click one drive menu
            _ref.sharePointHomePage.clickOneDriveMenu(driver, BrowserName);
            //To click on created document
            _ref.docsPage.clickOnExistingDocument(driver);
            // To click Library Menu
            _ref.docsPage.clickLibraryMenu(driver, BrowserName);
            // To click Rss Feed Menu
            _ref.docsPage.clickRssFeedMenu(driver, BrowserName);
            // To click Library Menu
            _ref.docsPage.clickLibraryMenu(driver, BrowserName);
            // To verify Connect to Outlook Menu
            _ref.docsPage.verifyConnectToOutlookMenu(driver);
            //To verify Export to Excel Menu
            _ref.docsPage.verifyExportToExcel(driver);
            //To verify Subscribe Menu
//            _ref.blogPage.verifySubscribeMenu(driver, BrowserName);
            // To verify open with explorer menu
            _ref.docsPage.verifyOpenWithExplorerMenu(driver);
            // To click Form WebParts Menu
            _ref.docsPage.clickFormWebPartsMenu(driver, BrowserName);
            // To click Stop Editing Menu
            _ref.docsPage.clickStopEditingMenu(driver, BrowserName);
            // To click Library Menu
            _ref.docsPage.clickLibraryMenu(driver, BrowserName);
            // To verify New quick step menu
            _ref.docsPage.verifyNewQuickStepMenu(driver);
            // To verify Edit library menu
            _ref.docsPage.verifyEditLibraryMenu(driver);
            // To click Library Settings Menu
            _ref.docsPage.clickLibrarySettingsMenu(driver, BrowserName);
            // To click Permission Menu
            _ref.docsPage.clickPermissionMenu(driver, BrowserName);
            // To click Grant Permission Menu
            _ref.docsPage.verifyGrantPermissionMenu(driver, BrowserName);
            // To enter email address
//            _ref.docsPage.enterEmailAddress(driver, BrowserName, "vnagarajan@wiley.com");
            // To click Username Checkbox
//            _ref.docsPage.clickUsernameCheckbox(driver);
            // To click Remove Permission Menu
//            _ref.docsPage.clickRemovePermissionMenu(driver, BrowserName);
            // To click Signout dropdown Menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click Signout Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify Library tab menu options", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


