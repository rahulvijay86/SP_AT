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

public class SP_TC_003_DocsPage_Create_New_Folder extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_003_DocsPage_Create_New_Folder",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_003_DocsPage_Create_New_Folder() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click One drive menu
            _ref.sharePointHomePage.clickOneDriveMenu(driver, BrowserName);
            // To click add new document
            _ref.docsPage.clickAddNewDocument(driver, BrowserName);
            // To click on new folder
            _ref.docsPage.clickOnNewFolder(driver, BrowserName);
            // To enter folder name
            _ref.docsPage.enterFolderName(driver, BrowserName, Prerequsite.configMap.get("TC_003_Add_Folder"));
            // To click On existing folder
            _ref.docsPage.clickOnExistingFolder(driver,BrowserName);
            // To click folder open menu
            _ref.docsPage.clickFolderOpenMenu(driver,BrowserName);
            // To delete the folder
            _ref.docsPage.deleteDocument(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify OneDrive page menu and create a new folder", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}






