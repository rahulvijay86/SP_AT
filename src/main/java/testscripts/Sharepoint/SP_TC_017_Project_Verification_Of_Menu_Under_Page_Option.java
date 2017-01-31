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
 * Created by vijay.nagarajan on 10/04/2016.
 */

public class SP_TC_017_Project_Verification_Of_Menu_Under_Page_Option extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_017_Project_Verification_Of_Menu_Under_Page_Option",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_017_Project_Verification_Of_Menu_Under_Page_Option() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Project menu
            _ref.projectPage.clickProjectMenu(driver,BrowserName);
            // To click Project Title menu
            _ref.projectPage.clickProjectTitleMenu(driver,BrowserName,Prerequsite.configMap.get("Enter_Project_Title"));
            // To click Page menu
            _ref.projectPage.clickPageMenu(driver,BrowserName);
            // To verify page menu options in project page
            _ref.projectPage.verifyPageMenuOptionsInProjectPage(driver,BrowserName);
            // To click tags and notes menu
            _ref.projectPage.clickTagsAndNotesMenu(driver,BrowserName);
            // To click close tags and notes menu
            _ref.projectPage.clickTagsAndNotesCloseMenu(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify menu under page option", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

