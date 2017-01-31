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

public class SP_TC_006_SearchBox_Verify_DW_SearchBox extends ExtendedLibrary {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_006_SearchBox_Verify_DW_SearchBox",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_006_SearchBox_Verify_DW_SearchBox() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click search menu and enter text
            _ref.sharePointHomePage.clickSearchMenuAndEnterSearchText(Prerequsite.configMap.get("TC_002_Enter_Document"),driver, BrowserName);
            // To verify DW search box
            _ref.sharePointHomePage.verifyDWSearchBoxPresence(driver);
            // To click portal home menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver, BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify DW search box", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

