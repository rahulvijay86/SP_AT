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
 * Created by manjari.muralidharan on 11/02/2016.
 */

public class SPU_260_TC_002_Verify_CopyRightMsg_AcrossPages extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_260_TC_002_Verify_CopyRightMsg_AcrossPages",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_260_TC_002_Verify_CopyRightMsg_AcrossPages() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To verify Copyright text
            _ref.sharePointHomePage.verifyCopyrightTextPresence(driver);
            // To click Tools menu
            _ref.sharePointHomePage.clickToolsMenuOption(driver,BrowserName);
            // To verify Copyright text
            _ref.sharePointHomePage.verifyCopyrightTextPresence(driver);
            // To verify font size
            _ref.sharePointHomePage.verifyFontSize(driver);
            // To click wiley portal menu
            _ref.groupsPage.clickWileyPortalMenu(driver,BrowserName);
            // To click project menu
            _ref.projectPage.clickProjectMenu(driver,BrowserName);
            // To verify Copyright text
            _ref.sharePointHomePage.verifyCopyrightTextPresence(driver);
            // To verify font size
            _ref.sharePointHomePage.verifyFontSize(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);

            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify Wiley Copyright message across pages", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

