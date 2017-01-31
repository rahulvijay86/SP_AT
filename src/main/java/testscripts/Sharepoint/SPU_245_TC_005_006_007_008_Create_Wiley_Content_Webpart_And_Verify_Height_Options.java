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
 * Created by vijay.nagarajan on 11/07/2016.
 */

public class SPU_245_TC_005_006_007_008_Create_Wiley_Content_Webpart_And_Verify_Height_Options extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","webparturl"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String webparturl) throws Exception {

        ResultUtil.createReport("SPU_245_TC_005_006_007_008_Create_Wiley_Content_Webpart_And_Verify_Height_Options",browserName,platform,webparturl);
        driver=launchURL(platform, browserName, remoteurl, webparturl);
    }

    @Test
    public void SPU_245_TC_005_006_007_008_Create_Wiley_Content_Webpart_And_Verify_Height_Options() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click settings menu in new page
            _ref.sharePointHomePage.clickSettingsMenuInNewPage(driver, BrowserName);
            // To click Edit page menu
            _ref.sharePointHomePage.clickEditPageMenu(driver, BrowserName);
            // To click WebPart menu
            _ref.createPage.clickWebPartMenu(driver);
            // To click menu in wiley images category
            _ref.createPage.clickMenuInWileyImagesCategory(driver, BrowserName);
            // To click menu in wiley parts
            _ref.createPage.clickMenuInWileyParts(driver,BrowserName,"Wiley Lead Image Content Block");
            // To click Add menu
            _ref.createPage.clickAddMenu(driver, BrowserName);
            // To click menu under WebPart Hover option
            _ref.createPage.clickMenuUnderWebpartHoverOption(driver);
            // To click dropdown
            _ref.createPage.clickDropdownAndSelectOption(driver, BrowserName);
//            _ref.createPage.clickAppearanceOption();
            // To verify Height Menu
            _ref.createPage.verifyHeightMenuPresence(driver);
            // To click Yes
            _ref.createPage.clickYesOption(driver);
            // To enter pixel value
            _ref.createPage.enterPixelValue(driver,"500");
            // To click Ok
            _ref.createPage.clickOkMenu(driver, BrowserName);
            // To click menu under WebPart Hover option
            _ref.createPage.clickMenuUnderWebpartHoverOption(driver);
            // To click dropdown
            _ref.createPage.clickDropdownAndSelectOption(driver, BrowserName);
//            _ref.createPage.clickAppearanceOption();
            // To click No
            _ref.createPage.clickNoOption(driver);
            // To click Ok
            _ref.createPage.clickOkMenu(driver, BrowserName);
            // To click menu under WebPart Hover option
            _ref.createPage.clickMenuUnderWebpartHoverOption(driver);
            // To click dropdown
            _ref.createPage.clickDropdownAndSelectOption(driver, BrowserName);
//            _ref.createPage.clickAppearanceOption();
            // To click Yes
            _ref.createPage.clickYesOption(driver);
            // To enter pixel value
            _ref.createPage.enterPixelValue(driver,"-10");
            // To click Ok
            _ref.createPage.clickOkMenu(driver, BrowserName);
            // To verify Height Menu
            _ref.createPage.verifyHeightErrorPresence(driver);
            // To click Cancel
            _ref.createPage.clickCancelMenu(driver, BrowserName);
            // To click Save
            _ref.createPage.clickSaveMenu(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);


            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to create wiley content webpart and verify height", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
