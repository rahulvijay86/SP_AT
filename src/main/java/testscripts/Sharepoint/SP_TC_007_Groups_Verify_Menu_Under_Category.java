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
public class SP_TC_007_Groups_Verify_Menu_Under_Category extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform, String browserName,String remoteurl,String url ) throws Exception {

        ResultUtil.createReport("SP_TC_007_Groups_Verify_Menu_Under_Category",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_007_Groups_Verify_Menu_Under_Category() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Groups menu
            _ref.groupsPage.clickGroupsMenu(driver, BrowserName);
            // To click menu in Groups page
            _ref.groupsPage.clickMenuInGroupsPage(Prerequsite.configMap.get("TC_001_Click_Group_Menu"),driver, BrowserName);
            // To click category menu in groups page
            _ref.groupsPage.clickCategoryMenuInGroupsPage(driver, BrowserName);
            // To verify category menu in groups page
            _ref.groupsPage.verifyCategoryMenuInGroupsPage(driver);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver, BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to click Category menu and verify options under Groups Page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

