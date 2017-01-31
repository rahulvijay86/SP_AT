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
public class SP_TC_002_DocsPage_Upload_Document extends Prerequsite {

//    private static final String PROJECT_PATH = System.getProperty("user.dir");
//    private static final String packageName ="Jellyfish.jpg";
//    private static final String packagePath = PROJECT_PATH + "\\testdata\\" + packageName;

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_002_DocsPage_Upload_Document",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_002_DocsPage_Upload_Document() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click One drive menu
            _ref.sharePointHomePage.clickOneDriveMenu(driver,BrowserName);
            // To click add new document
            _ref.docsPage.clickAddNewDocument(driver,BrowserName);
            // To click on upload existing file
            _ref.docsPage.clickOnUploadExistingFile(driver,BrowserName);
            // To upload file
            _ref.docsPage.uploadFile(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify OneDrive page menu and upload document", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}