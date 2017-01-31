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

public class SP_TC_007_SearchBox_Verify_ClickFor_MoreResults extends ExtendedLibrary {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_007_SearchBox_Verify_ClickFor_MoreResults",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_007_SearchBox_Verify_ClickFor_MoreResults() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To enter search text
            _ref.sharePointHomePage.enterSearchText(Prerequsite.configMap.get("TC_007_Enter_Search_Text"),driver, BrowserName);
            // To click for more results
            _ref.sharePointHomePage.verifyClickForMoreResults(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify Click for more results.", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

