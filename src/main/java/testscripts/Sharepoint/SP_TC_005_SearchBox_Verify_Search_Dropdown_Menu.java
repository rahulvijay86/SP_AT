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
 * Created by manjari.muralidharan on 10/07/2016.
 */
public class SP_TC_005_SearchBox_Verify_Search_Dropdown_Menu extends ExtendedLibrary {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_005_SearchBox_Verify_Search_Dropdown_Menu",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_005_SearchBox_Verify_Search_Dropdown_Menu() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Search Dropdown menu
            _ref.sharePointHomePage.clickSearchDropdownMenu(driver, BrowserName);
            // To verify Search Dropdown menu options
            _ref.sharePointHomePage.verifySearchDropdownMenuOptions(driver,BrowserName);
            // To Click portal home menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify search dropdown menu", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

