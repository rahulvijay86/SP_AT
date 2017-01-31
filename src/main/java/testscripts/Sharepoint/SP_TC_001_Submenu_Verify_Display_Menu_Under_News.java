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
 * Created by vijay.nagarajan on 09/29/2016.
 */
public class SP_TC_001_Submenu_Verify_Display_Menu_Under_News extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_001_Submenu_Verify_Display_Menu_Under_News",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_001_Submenu_Verify_Display_Menu_Under_News() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To Hover News menu
            _ref.sharePointHomePage.hoverNewsMenu(driver,BrowserName);
            // To verify menu under News
            _ref.sharePointHomePage.verifyMenuUnderNewsOption(driver,BrowserName);
            // To click Sign Out Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click Sign out Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify display menu under news", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}