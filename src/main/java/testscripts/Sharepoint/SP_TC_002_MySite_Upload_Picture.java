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

public class SP_TC_002_MySite_Upload_Picture extends Prerequsite {
//    private static final String PROJECT_PATH = System.getProperty("user.dir");
//    private static final String packageName ="Koala.jpg";
//    private static final String packagePath = PROJECT_PATH + "\\testdata\\" + packageName;

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_002_MySite_Upload_Picture",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_002_MySite_Upload_Picture() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Sites menu option
            _ref.sharePointHomePage.clickSitesMenuOption(driver,BrowserName);
            // To hover picture menu and click upload
            _ref.sharePointHomePage.hoverPictureMenuAndClickUpload(driver,BrowserName);
            // To upload profile Image
            _ref.sharePointHomePage.profileImageUpload(driver, BrowserName);
            // To Click save all button
            _ref.sharePointHomePage.clickSaveAllButton(driver, BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to upload profile picture", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


