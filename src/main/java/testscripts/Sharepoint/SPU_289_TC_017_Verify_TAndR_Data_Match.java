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
 * Created by manjari.muralidharan on 10/31/2016.
 */

public class SPU_289_TC_017_Verify_TAndR_Data_Match extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_289_TC_017_Verify_TAndR_Data_Match",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_289_TC_017_Verify_TAndR_Data_Match() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click tools menu option
            _ref.sharePointHomePage.clickToolsMenuOption(driver,BrowserName);
            // To add category to favorites
            _ref.toolsAndResourcesPage.addCategoryToFavorites(driver,BrowserName);
            // To get tools name
            String xxx= _ref.toolsAndResourcesPage.getToolsName(driver);
            // To click portal home menu
            _ref.sharePointHomePage.clickPortalHomeMenu(driver,BrowserName);
            // To get tools name in home page
            String yyy= _ref.toolsAndResourcesPage.getToolsNameInHomePage(driver,BrowserName);
            // To compare the tools name
            _ref.toolsAndResourcesPage.compareTools(driver,xxx, yyy);
            // To click tools menu option
            _ref.sharePointHomePage.clickToolsMenuOption(driver,BrowserName);
            // To remove category from favorites
            _ref.toolsAndResourcesPage.removeCategoryFromFavorites(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to compare the tools and resources data match", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
