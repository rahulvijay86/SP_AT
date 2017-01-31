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
public class SP_TC_001_Wiki_Create_Wiki_Page extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_001_Wiki_Create_Wiki_Page",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_001_Wiki_Create_Wiki_Page() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Settings menu
            _ref.sharePointHomePage.clickSettingsMenu(driver,BrowserName);
            // To click site contents option
            _ref.wikiPage.clickSiteContentsOption(driver,BrowserName);
            // To click site pages option
            _ref.wikiPage.clickSitePagesOption(driver,BrowserName);
            // To click Add new document
            _ref.wikiPage.clickAddNewDocument(driver,BrowserName);
            // To enter Page name
            _ref.wikiPage.enterPageName(Prerequsite.configMap.get("TC_001_Enter_PageName"),driver,BrowserName);
            // To click create button
            _ref.wikiPage.clickCreateButton(driver,BrowserName);
            // To select bold option
            _ref.wikiPage.selectBoldOption(driver,BrowserName);
            // To enter page content
            _ref.wikiPage.enterPageContent(Prerequsite.configMap.get("TC_001_Enter_PageContent"),driver,BrowserName);
            // To select Styles
            _ref.wikiPage.selectStyles(driver,BrowserName);
            // To click save button
            _ref.wikiPage.clickSaveButton(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to create wiki page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
