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
 * Created by vijay.nagarajan on 10/03/2016.
 */

public class SP_TC_007_Project_Login_With_New_Project_URL extends ExtendedLibrary {

    @Parameters({"platform","browserName","remoteurl","projecturl"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String projecturl ) throws Exception {

        ResultUtil.createReport("SP_TC_007_Project_Login_With_New_Project_URL",browserName,platform,projecturl);
        driver=launchURL(platform, browserName, remoteurl, projecturl);
    }

    @Test
    public void SP_TC_007_Project_Login_With_New_Project_URL() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to login to new project url", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
