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
 * Created by vijay.nagarajan on 11/03/2016.
 */

public class SPU_270_TC_002A_Verification_Of_Expiry_Date_Msg extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_270_TC_002A_Verification_Of_Expiry_Date_Msg",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_270_TC_002A_Verification_Of_Expiry_Date_Msg() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click project Menu
            _ref.projectPage.clickProjectMenu(driver,BrowserName);
            // To click create new project
            _ref.projectPage.clickCreateNewProjectMenu(driver,BrowserName);
            // To enter values and create project
            _ref.projectPage.enterValuesToCreateTheProject(Prerequsite.configMap.get("TC_004_005_Project_Creation_Name") + getRandomCode(), Prerequsite.configMap.get("TC_004_005_Project_Creation_Description"), driver, BrowserName);
            // To verify date warning message
            _ref.projectPage.verifyDateWarningMsg(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify Expiry date msg", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
