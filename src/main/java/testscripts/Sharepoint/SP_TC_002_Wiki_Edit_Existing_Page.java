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
public class SP_TC_002_Wiki_Edit_Existing_Page extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_002_Wiki_Edit_Existing_Page",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_002_Wiki_Edit_Existing_Page() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Settings menu
            _ref.sharePointHomePage.clickSettingsMenu(driver, BrowserName);
            // To click site contents option
            _ref.wikiPage.clickSiteContentsOption(driver, BrowserName);
            // To click site pages option
            _ref.wikiPage.clickSitePagesOption(driver, BrowserName);
            // To click on existing page
            _ref.wikiPage.clickOnExistingPage(driver, BrowserName, Prerequsite.configMap.get("TC_001_Existing_Document"));
            // To click page menu
            _ref.wikiPage.clickPageMenu(driver, BrowserName);
            // To click on edit link
            _ref.wikiPage.clickOnEditLink(driver, BrowserName);
            // To click on insert menu
            _ref.wikiPage.clickOnInsertMenu(driver, BrowserName);
            // To click on add link option
            _ref.wikiPage.clickOnAddLinkOption(driver, BrowserName);
            // To add link to wiki page
            _ref.wikiPage.addLinkToWikiPage(driver, BrowserName, Prerequsite.configMap.get("TC_002_Enter_Text"), Prerequsite.configMap.get("TC_002_Enter_Link"));
            //To click page menu
            _ref.wikiPage.clickPageMenu(driver, BrowserName);
            // To click save button
            _ref.wikiPage.clickSaveButton(driver, BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to Edit existing wiki page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}



