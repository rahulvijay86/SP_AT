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

public class SPU_293_TC_015_Verify_AbsenceOfMenus_Business_KandL_Page extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_293_TC_015_Verify_AbsenceOfMenus_Business_KandL_Page",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_293_TC_015_Verify_AbsenceOfMenus_Business_KandL_Page() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To hover Business and Select KandL
            _ref.sharePointHomePage.hoverBusinessAndSelectKandL(driver,BrowserName);
            // To hover about wiley dropdown
            _ref.sharePointHomePage.hoverAboutWileyDropdown(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickLogoutMenuDropdown(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver,BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify Absence of menus in K&L page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

