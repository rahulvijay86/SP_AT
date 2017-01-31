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
public class SP_TC_002_SearchBox_Verify_Search_Functionality extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_002_SearchBox_Verify_Search_Functionality",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_002_SearchBox_Verify_Search_Functionality() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click search and enter text
            _ref.sharePointHomePage.clickSearchMenuAndEnterSearchText(Prerequsite.configMap.get("TC_002_Enter_Document"),driver,BrowserName);
            // To click portal home menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver,BrowserName);
            // To click search and enter text
            _ref.sharePointHomePage.clickSearchMenuAndEnterSearchText(Prerequsite.configMap.get("TC_002_Enter_Conversation"),driver,BrowserName);
            // To click portal home menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver,BrowserName);
            // To click search and enter text
            _ref.sharePointHomePage.clickSearchMenuAndEnterSearchText(Prerequsite.configMap.get("TC_002_Enter_Name"),driver,BrowserName);
            // To click portal home menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver,BrowserName);
            // To click search and enter text
            _ref.sharePointHomePage.clickSearchMenuAndEnterSearchText(Prerequsite.configMap.get("TC_002_Enter_email"),driver,BrowserName);
            // To click search dropdown and select people
            _ref.sharePointHomePage.clickSearchDropdownAndSelectPeople(driver,BrowserName);
            // To click portal home menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify the search functionality", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
