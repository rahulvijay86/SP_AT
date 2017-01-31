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

public class SP_TC_010_DocsPage_Create_And_Modify_View extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_010_DocsPage_Create_And_Modify_View",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_010_DocsPage_Create_And_Modify_View() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click One drive menu
            _ref.sharePointHomePage.clickOneDriveMenu(driver,BrowserName);
            // To click on view selector menu
            _ref.docsPage.clickOnViewSelectorMenu(driver,BrowserName);
            // To click on create view
            _ref.docsPage.clickOnCreateView(driver,BrowserName);
            // To click on data sheet view
            _ref.docsPage.clickOnDataSheetView(driver,BrowserName);
            // To enter view name
            _ref.docsPage.enterViewName(driver,BrowserName,Prerequsite.configMap.get("TC_010_ViewName") + getRandomCode());
            // To click ok button
            _ref.docsPage.clickOkButton(driver,BrowserName);
            // To click on view selector menu
            _ref.docsPage.clickOnViewSelectorMenu(driver,BrowserName);
            // To click On Modify View
            _ref.docsPage.clickOnModifyView(driver,BrowserName);
            // To enter view name
            _ref.docsPage.enterViewName(driver,BrowserName,Prerequsite.configMap.get("TC_010_Edit_ViewName") + getRandomCode());
            // To click ok button
            _ref.docsPage.clickOkButton(driver,BrowserName);
            // To click on view selector menu
            _ref.docsPage.clickOnViewSelectorMenu(driver,BrowserName);
            // To click On Modify View
            _ref.docsPage.clickOnModifyView(driver,BrowserName);
            // To click Delete button
            _ref.docsPage.clickDeleteButton(driver,BrowserName);
            // To click portal menu
            _ref.docsPage.clickPortalMenu(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownOption(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to create doc page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
