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
 * Created by vijay.nagarajan on 10/27/2016.
 */

public class SPU_311_TC_005_Add_And_Verify_Tags extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_311_TC_005_Add_And_Verify_Tags",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_311_TC_005_Add_And_Verify_Tags() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            _ref.sharePointHomePage.clickAboutMeLink(driver, BrowserName);
            _ref.sharePointHomePage.clickEditLink(driver, BrowserName);
            _ref.groupsPage.clickOpenMenuInGroupsPage(driver, BrowserName);
            _ref.newsFeedPage.clickDelegationButton(driver, BrowserName);
            _ref.newsFeedPage.clickFollowedTagAndEnterValue(driver,BrowserName,"#Juda;");
            _ref.sharePointHomePage.clickSaveAllButton(driver, BrowserName);
            _ref.sharePointHomePage.clickPortalMenu(driver, BrowserName);
            _ref.sharePointHomePage.verifyFollowedTagValues(driver,"#Juda");
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify Disaster page under Functions option", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


