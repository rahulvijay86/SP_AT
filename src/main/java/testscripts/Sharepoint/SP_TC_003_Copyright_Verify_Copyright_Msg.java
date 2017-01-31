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

public class SP_TC_003_Copyright_Verify_Copyright_Msg extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_003_Copyright_Verify_Copyright_Msg",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_003_Copyright_Verify_Copyright_Msg() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To verify CopyRight message
            _ref.sharePointHomePage.verifyCopyrightTextPresence(driver);
            // To click Tools menu
            _ref.sharePointHomePage.clickToolsMenuOption(driver,BrowserName);
            // To verify CopyRight message
            _ref.sharePointHomePage.verifyCopyrightTextPresence(driver);
            // To click wiley portal menu
            _ref.groupsPage.clickWileyPortalMenu(driver,BrowserName);
            // To click project menu
            _ref.projectPage.clickProjectMenu(driver,BrowserName);
            // To verify CopyRight message
            _ref.sharePointHomePage.verifyCopyrightTextPresence(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify Wiley Copyright message", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

