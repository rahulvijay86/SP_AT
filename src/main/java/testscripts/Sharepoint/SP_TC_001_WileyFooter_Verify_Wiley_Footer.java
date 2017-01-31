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
public class SP_TC_001_WileyFooter_Verify_Wiley_Footer extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_001_WileyFooter_Verify_Wiley_Footer",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_001_WileyFooter_Verify_Wiley_Footer() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.sharePointHomePage.verifyWileyFooterMenuPresence(driver);
            _ref.sharePointHomePage.clickToolsMenuOption(driver,BrowserName);
            _ref.sharePointHomePage.verifyWileyFooterMenuPresence(driver);
            _ref.groupsPage.clickWileyPortalMenu(driver,BrowserName);
            _ref.projectPage.clickProjectMenu(driver,BrowserName);
            _ref.sharePointHomePage.verifyWileyFooterMenuPresence(driver);
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify Wiley footer menu", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}