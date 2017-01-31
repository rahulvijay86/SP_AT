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
public class SP_TC_018_Group_Follow_Group_And_Start_Conversation extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_018_Group_Follow_Group_And_Start_Conversation",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_018_Group_Follow_Group_And_Start_Conversation() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Groups menu
            _ref.groupsPage.clickGroupsMenu(driver,BrowserName);
            // To click menu in Groups page
            _ref.groupsPage.clickGroupMenuInGroupsPage(driver,BrowserName,Prerequsite.configMap.get("TC_018_Click_Group_Menu"));
            // To click Follow menu
            _ref.groupsPage.clickFollowMenu(driver,BrowserName);
            // To click NewDiscussion menu
            _ref.groupsPage.clickNewDiscussionMenu(driver,BrowserName);
            // To enter value and create Discussion
            _ref.groupsPage.enterValuesAndCreateDiscussion(driver,BrowserName,Prerequsite.configMap.get("TC_018_Enter_Discussion_Value"));
            // To click save menu
            _ref.groupsPage.clickSaveMenu(driver);
            // To click WileyPortal menu
            _ref.groupsPage.clickWileyPortalMenu(driver,BrowserName);
            // To click Sites menu
            _ref.groupsPage.clickSitesMenu(driver,BrowserName);
            // To click Stop Following menu
            _ref.groupsPage.clickStopFollowingMenu(driver,BrowserName,Prerequsite.configMap.get("TC_018_Click_Group_Menu"));
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to join and add new conversation", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

