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
 * Created by vijay.nagarajan on 10/13/2016.
 */
public class SP_TC_002_003_004_005_AddPage_Verify_Options extends Prerequsite {

    String pageValue = "run"+getRandomCode();
    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_002_003_004_005_AddPage_Verify_Options",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_002_003_004_005_AddPage_Verify_Options() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Settings menu
            _ref.sharePointHomePage.clickSettingsMenu(driver, BrowserName);
            // To click create page menu
            _ref.sharePointHomePage.clickCreatePageMenu(driver,BrowserName);
            // To enter page value and Create
            _ref.sharePointHomePage.enterPageValueAndCreate(pageValue,driver,BrowserName);
            // To verify Menu under page creation
            _ref.createPage.verifyMenuUnderPageCreation(driver,BrowserName);
            // To click WebPart Menu
            _ref.createPage.clickWebPartMenu(driver);
            // To click Images and add
            _ref.createPage.clickImagesAndAddMenu(driver,BrowserName);
            // To verify Different Create page
            _ref.createPage.verifyDifferentCreatePageMenu(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to click Add page menu and verify menu", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}