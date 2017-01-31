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
public class SP_TC_018_Project_Verification_Of_Menu_Under_Files_Option extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_018_Project_Verification_Of_Menu_Under_Files_Option",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_018_Project_Verification_Of_Menu_Under_Files_Option() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Project menu
            _ref.projectPage.clickProjectMenu(driver,BrowserName);
            // To click Project Title menu
            _ref.projectPage.clickProjectTitleMenu(driver,BrowserName,Prerequsite.configMap.get("Enter_Project_Title"));
            // To click Documents menu
            _ref.projectPage.clickDocumentsMenu(driver);
            // To click Files menu
            _ref.projectPage.clickFilesMenu(driver,BrowserName);
            // To verify files menu options in project page
            _ref.projectPage.verifyFilesMenuOptionsInProjectPage(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify files menu options", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


