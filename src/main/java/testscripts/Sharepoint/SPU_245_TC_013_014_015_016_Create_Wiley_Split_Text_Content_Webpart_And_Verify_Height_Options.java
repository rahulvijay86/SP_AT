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
 * Created by vijay.nagarajan on 09/06/2016.
 */

public class SPU_245_TC_013_014_015_016_Create_Wiley_Split_Text_Content_Webpart_And_Verify_Height_Options extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","webparturl"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String webparturl) throws Exception {

        ResultUtil.createReport("SPU_245_TC_013_014_015_016_Create_Wiley_Split_Text_Content_Webpart_And_Verify_Height_Options",browserName,platform,webparturl);
        driver=launchURL(platform, browserName, remoteurl, webparturl);
    }

    @Test
    public void SPU_245_TC_013_014_015_016_Create_Wiley_Split_Text_Content_Webpart_And_Verify_Height_Options() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.sharePointHomePage.clickSettingsMenuInNewPage(driver,BrowserName);
            _ref.sharePointHomePage.clickEditPageMenu(driver,BrowserName);
            _ref.createPage.clickWebPartMenu(driver);
            _ref.createPage.clickMenuInWileyImagesCategory(driver,BrowserName);
            _ref.createPage.clickMenuInWileyParts(driver,BrowserName,"Wiley Split Text Content Block");
            _ref.createPage.clickAddMenu(driver,BrowserName);
            _ref.createPage.clickMenuUnderWebpartHoverOption(driver);
            _ref.createPage.clickDropdownAndSelectOption(driver,BrowserName);
//            _ref.createPage.clickAppearanceOption();
            _ref.createPage.verifyHeightMenuPresence(driver);
            _ref.createPage.clickYesOption(driver);
            _ref.createPage.enterPixelValue(driver,"500");
            _ref.createPage.clickOkMenu(driver,BrowserName);
            _ref.createPage.clickMenuUnderWebpartHoverOption(driver);
            _ref.createPage.clickDropdownAndSelectOption(driver,BrowserName);
//            _ref.createPage.clickAppearanceOption();
            _ref.createPage.clickNoOption(driver);
            _ref.createPage.clickOkMenu(driver,BrowserName);
            _ref.createPage.clickMenuUnderWebpartHoverOption(driver);
            _ref.createPage.clickDropdownAndSelectOption(driver,BrowserName);
//            _ref.createPage.clickAppearanceOption();
            _ref.createPage.clickYesOption(driver);
            _ref.createPage.enterPixelValue(driver,"-10");
            _ref.createPage.clickOkMenu(driver,BrowserName);
            _ref.createPage.verifyHeightErrorPresence(driver);
            _ref.createPage.clickCancelMenu(driver,BrowserName);
            _ref.createPage.clickSaveMenu(driver);
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);


            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to click Add page menu and verify menu", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

