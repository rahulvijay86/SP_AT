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
 * Created by manjari.muralidharan on 10/26/2016.
 */


public class SPU_288_TC_009_Click_On_TAndRFavs_AfterCloud extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","trurl"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String trurl) throws Exception {

        ResultUtil.createReport("SPU_288_TC_009_Click_On_TAndRFavs_AfterCloud",browserName,platform,trurl);
        driver=launchURL(platform, browserName, remoteurl, trurl);
    }

    @Test
    public void SPU_288_TC_009_Click_On_TAndRFavs_AfterCloud() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click on T and R Favs
            _ref.toolsAndResourcesPage.clickOnTandRFavs(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to login and logout", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


