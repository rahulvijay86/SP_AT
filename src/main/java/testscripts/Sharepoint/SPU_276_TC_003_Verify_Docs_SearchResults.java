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

public class SPU_276_TC_003_Verify_Docs_SearchResults extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_276_TC_003_Verify_Docs_SearchResults",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_276_TC_003_Verify_Docs_SearchResults() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To hover functions menu and select option
            _ref.sharePointHomePage.hoverFunctionsMenuAndSelectOption(driver,BrowserName);
            // To click search and enter text
            _ref.sharePointHomePage.clickSearchMenuAndEnterSearchText(Prerequsite.configMap.get("SPU_TC_002_Enter_Document"),driver,BrowserName);
            // To verify Document
            _ref.sharePointHomePage.verifyDocument(driver);
            // To click portal home menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify Docs in the search results page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
