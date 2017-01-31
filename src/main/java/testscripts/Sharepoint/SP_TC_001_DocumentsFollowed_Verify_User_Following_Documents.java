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

public class SP_TC_001_DocumentsFollowed_Verify_User_Following_Documents extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_001_DocumentsFollowed_Verify_User_Following_Documents",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_001_DocumentsFollowed_Verify_User_Following_Documents() {
        try {
             waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.sharePointHomePage.clickOneDriveMenu(driver,BrowserName);
            //Need to check the document name here which is dummy now
            _ref.docsPage.clickDocumentOptionMenu(Prerequsite.configMap.get("SPU_TC_001_Enter_Document"),driver,BrowserName);
            _ref.docsPage.clickFollowMenu(driver,BrowserName);
            _ref.docsPage.clickWileyPortalMenu(driver,BrowserName);
            _ref.docsPage.verifyDocInFollowingMenu(driver,Prerequsite.configMap.get("SPU_TC_001_Enter_Document"));
            _ref.docsPage.clickDocumentsMenu(driver,BrowserName);
            _ref.groupsPage.clickStopFollowingMenu(driver,BrowserName,Prerequsite.configMap.get("SPU_TC_001_Enter_Document"));
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify followed sites", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
