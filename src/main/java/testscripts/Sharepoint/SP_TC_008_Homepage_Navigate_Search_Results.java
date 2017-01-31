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

public class SP_TC_008_Homepage_Navigate_Search_Results extends ExtendedLibrary {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_008_Homepage_Navigate_Search_Results",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_008_Homepage_Navigate_Search_Results() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click search menu and enter the search text
            _ref.sharePointHomePage.clickSearchMenuAndEnterSearchText(Prerequsite.configMap.get("TC_008_Enter_Search_Text"),driver, BrowserName);
            // To verify Wiley Logo Presence
            _ref.sharePointHomePage.verifyWileyLogoPresence(driver);
            // To click Sign Out Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click Sign out Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to navigate to search results", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
