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
public class SP_TC_003_MySite_Edit_Link_Menu extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_003_MySite_Edit_Link_Menu",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_003_MySite_Edit_Link_Menu() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Sites menu option
            _ref.sharePointHomePage.clickSitesMenuOption(driver,BrowserName);
            // To click profile picture menu
            _ref.sharePointHomePage.clickProfilePictureMenu(driver,BrowserName);
            // To click Edit links menu
            _ref.projectPage.clickEditLinksMenu(driver,BrowserName);
            // To click SubLink menu
            _ref.projectPage.clickSubLinkMenu(driver,BrowserName);
            // To edit SubLink menu
            _ref.projectPage.editSubLinkMenu(driver,BrowserName,Prerequsite.configMap.get("TC_003_Enter_New_Project_Menu"));
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to edit Site page links", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

