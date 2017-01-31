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
 * Created by vijay.nagarajan on 10/05/2016.
 */
public class SP_TC_006_Groups_Click_Home_Link extends ExtendedLibrary {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_006_Groups_Click_Home_Link",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_006_Groups_Click_Home_Link() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Groups menu
            _ref.groupsPage.clickGroupsMenu(driver, BrowserName);
            // To click menu in Groups page
            _ref.groupsPage.clickMenuInGroupsPage(Prerequsite.configMap.get("TC_001_Click_Group_Menu"),driver, BrowserName);
            // To clcik home Menu in groups page
            _ref.groupsPage.clickHomeMenuInGroupsPage(driver, BrowserName);
            // To verify Menu in group page menu
//            _ref.groupsPage.verifyMenuInGroupPageMenu(driver, BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to click Home menu under Groups Page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

