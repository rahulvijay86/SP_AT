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
 * Created by vijay.nagarajan on 08/03/2016.
 */

public class SPU_293_TC_015_AboutWiley_Verify_AbsenceOfMenus_Business_KandL_Page extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_293_TC_015_AboutWiley_Verify_AbsenceOfMenus_Business_KandL_Page",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_TC_015_293_AboutWiley_Verify_AbsenceOfMenus_Business_KandL_Page() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.sharePointHomePage.hoverBusinessAndSelectKandL(driver, BrowserName);
            _ref.sharePointHomePage.hoverAboutWileyDropdown(driver, BrowserName);
            _ref.sharePointHomePage.clickSignOutDropdownOption(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify the Site Contents menu", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
