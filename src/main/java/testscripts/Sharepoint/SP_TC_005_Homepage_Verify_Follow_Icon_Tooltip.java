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
 * Created by vijay.nagarajan on 09/28/2016.
 */

public class SP_TC_005_Homepage_Verify_Follow_Icon_Tooltip extends ExtendedLibrary {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_005_Homepage_Verify_Follow_Icon_Tooltip",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_005_Homepage_Verify_Follow_Icon_Tooltip() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To verify Follow icon ToolTip message
            _ref.sharePointHomePage.verifyFollowTooltip(driver,BrowserName);
            // To click Sign Out Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click Sign out Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify follow icon tooltip", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

