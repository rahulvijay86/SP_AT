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
 * Created by manjari.muralidharan on 10/25/2016.
 */
public class SP_TC_003_Wiki_Verify_Wiki_Publish extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_003_Wiki_Verify_Wiki_Publish",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_003_Wiki_Verify_Wiki_Publish() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Settings menu
            _ref.sharePointHomePage.clickSettingsMenu(driver,BrowserName);
            // To click site contents option
            _ref.wikiPage.clickSiteContentsOption(driver,BrowserName);
            // To click site pages option
            _ref.wikiPage.clickSitePagesOption(driver,BrowserName);
            // To select first site page
            _ref.wikiPage.selectFirstSitePage(driver);
            // To click Files menu
            _ref.wikiPage.clickFilesMenu(driver,BrowserName);
            // To verify publish menu
            _ref.wikiPage.verifyPublishMenuPresence(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify publish menu in wiki", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

