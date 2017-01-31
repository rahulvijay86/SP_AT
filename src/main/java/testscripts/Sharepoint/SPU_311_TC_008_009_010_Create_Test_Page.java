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

public class SPU_311_TC_008_009_010_Create_Test_Page extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_311_TC_008_009_010_Create_Test_Page",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_311_TC_008_009_010_Create_Test_Page() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            //Click on Settings Menu
            _ref.sharePointHomePage.clickSettingsMenu(driver,BrowserName);
            //Click On Site contents sub menu
            _ref.sharePointHomePage.clickOnSiteContents(driver,BrowserName);
            //Click On Site pages
            _ref.sharePointHomePage.clickOnSitePages(driver,BrowserName);
            //Click on a new document
            _ref.projectPage.createNewDocument(driver, BrowserName);
            //Name the test page
            _ref.projectPage.newPageMenu(driver, BrowserName,Prerequsite.configMap.get("SPU_TC_311_TC_08"));
            //Click on create button
            _ref.projectPage.clickOnCreate(driver, BrowserName);
            //Click on Insert Menu
            _ref.projectPage.clickOnInsertMenu(driver, BrowserName);
            //Click on web part
            _ref.projectPage.clickOnWebPart(driver, BrowserName);
            //Click on control roll up
            _ref.projectPage.clickOnContentRollup(driver, BrowserName);
            //Click on control search
            _ref.projectPage.clickOnContentSearch(driver, BrowserName);
            //Click on Add button
            _ref.projectPage.clickOnAddButton(driver, BrowserName);
            //Click on drop down Arrow
            _ref.projectPage.clickOnDropDownArrow(driver, BrowserName);
            //Click On Edit Web part sub menu
            _ref.projectPage.clickOnEditWebPart(driver, BrowserName);
            //Click On Change Query
            _ref.projectPage.clickOnChangeQuery(driver, BrowserName);
            //Click on switch to advance mode
            _ref.projectPage.clickOnSwitchAdvanceMode(driver, BrowserName);
            //Enter the account name1
            _ref.projectPage.accountName1(driver, BrowserName,Prerequsite.configMap.get("ACCOUNT_NAME1"));
            //Click on Add to Query
            _ref.projectPage.clickOnAddToQuery(driver, BrowserName);
            //Clears the text
            _ref.projectPage.clearText(driver, BrowserName);
            //Enter the account name2
            _ref.projectPage.accountName2(driver, BrowserName,Prerequsite.configMap.get("ACCOUNT_NAME2"));
            //Click on Add to Query
            _ref.projectPage.clickOnAddToQuery(driver, BrowserName);
            //Click on OK button
            _ref.projectPage.clickOnOkButton(driver, BrowserName);
            //Click on items and change the text
            _ref.projectPage.changeItemToPicture(driver);
            //Click on Ok
            _ref.projectPage.clickOkButton(driver, BrowserName);
            //Click on save
            _ref.projectPage.clickOnSave(driver, BrowserName);
            //Click on Portal menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver,BrowserName);
            //Click on Settings Menu
            _ref.sharePointHomePage.clickSettingsMenu(driver,BrowserName);
            //Click On Site contents sub menu
            _ref.sharePointHomePage.clickOnSiteContents(driver,BrowserName);
            //Click On Site pages
            _ref.sharePointHomePage.clickOnSitePages(driver,BrowserName);
            //Click on created page
            //_ref.projectPage.clickOnPage(driver);
            _ref.projectPage.clickOnCreatedPage(driver, BrowserName,Prerequsite.configMap.get("SPU_TC_311_TC_08"));
            //Click on open button
            //_ref.projectPage.openPage(driver, BrowserName);
            //Verify people and about me
            _ref.projectPage.verifyUser1(driver);
            //Verify people and other details
            _ref.projectPage.verifyUser2(driver);
            //To click on sign out drop down
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            //To click on sign out
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to create a page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


