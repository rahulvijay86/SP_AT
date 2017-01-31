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
 * Created by vijay.nagarajan on 09/06/2016.
 */

public class SP_TC_001_News_Click_News_Page_Menu extends Prerequsite {

    @Parameters({"platform", "browserName", "remoteurl", "url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName, String remoteurl, String url) throws Exception {

        ResultUtil.createReport("SP_TC_001_News_Click_News_Page_Menu", browserName, platform, url);
        driver = launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_001_News_Click_News_Page_Menu() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click News Menu
            _ref.sharePointHomePage.clickNewsMenuOption(driver, BrowserName);
            // To verify News Room menu
            _ref.sharePointHomePage.verifyNewsRoomMenuPresence(driver);
            // To click SignOut dropdown
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to click News Page menu", "" + e.getMessage(), driver);
            driver.quit();
        }
    }
}