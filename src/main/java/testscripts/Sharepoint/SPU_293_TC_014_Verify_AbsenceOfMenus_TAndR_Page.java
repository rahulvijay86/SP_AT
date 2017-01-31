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
 * Created by manjari.muralidharan on 10/31/2016.
 */

public class SPU_293_TC_014_Verify_AbsenceOfMenus_TAndR_Page extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_293_TC_014_Verify_AbsenceOfMenus_TAndR_Page",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_293_TC_014_Verify_AbsenceOfMenus_TAndR_Page() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click tools menu option
            _ref.sharePointHomePage.clickToolsMenuOption(driver, BrowserName);
            // To hover about wiley dropdown
            _ref.sharePointHomePage.hoverAboutWileyDropdown(driver, BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownOption(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);

            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify Absence of menus in T&R page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
