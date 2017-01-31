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
 * Created by vijay.nagarajan on 10/06/2016.
 */
public class SP_TC_017_Groups_Verify_Menu_Under_Site_Content extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_017_Groups_Verify_Menu_Under_Site_Content",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_017_Groups_Verify_Menu_Under_Site_Content() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Groups menu
            _ref.groupsPage.clickGroupsMenu(driver,BrowserName);
            // To click menu in Groups page
            _ref.groupsPage.clickMenuInGroupsPage(driver,BrowserName,Prerequsite.configMap.get("TC_001_Click_Group_Menu"));
            // To click SiteContent in group page
            _ref.groupsPage.clickSiteContentMenuInGroupsPage(driver,BrowserName);
            // To verify SiteContents option menu
            _ref.groupsPage.verifySiteContentsOptionMenu(driver);
            // To verify SiteContents menu in group page
            _ref.groupsPage.verifySiteContentsMenuInGroupsPage(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to click Site Contents menu and verify options under Groups Page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

