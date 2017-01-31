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

public class SP_TC_006_AddPage_CheckIn_Checkout_Option extends ExtendedLibrary {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_006_AddPage_CheckIn_Checkout_Option",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_006_AddPage_CheckIn_Checkout_Option() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click page menu
            _ref.sharePointHomePage.clickPageMenu(driver, BrowserName);
            // To click view all page menu
            _ref.sharePointHomePage.clickViewAllPagesMenu(driver, BrowserName);
            // To click open title menu
            _ref.docsPage.clickOnOpenTitleMenu(Prerequsite.configMap.get("TC_006_Click_Project_Title"), driver, BrowserName);
            // To click CheckInCheckOut menu
            _ref.docsPage.clickCheckInCheckOutMenu(driver);
            // To enter comment and click ok menu
            _ref.docsPage.enterCommentAndClickOkMenu(Prerequsite.configMap.get("TC_006_Enter_Comment"), driver, BrowserName);
            // To click open title menu
            _ref.docsPage.clickOnOpenTitleMenu(Prerequsite.configMap.get("TC_006_Click_Project_Title"), driver, BrowserName);
            // To click CheckInCheckOut menu
            _ref.docsPage.clickCheckInCheckOutMenu(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to CheckIn and CheckOut document", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
