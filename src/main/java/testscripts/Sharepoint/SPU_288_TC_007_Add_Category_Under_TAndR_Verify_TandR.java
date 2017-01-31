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
 * Created by manjari.muralidharan on 10/26/2016.
 */

public class SPU_288_TC_007_Add_Category_Under_TAndR_Verify_TandR extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_288_TC_007_Add_Category_Under_TAndR_Verify_TandR",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_288_TC_007_Add_Category_Under_TAndR_Verify_TandR() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Tools menu options
            _ref.sharePointHomePage.clickToolsMenuOption(driver,BrowserName);
            // To add category to favourites
            _ref.toolsAndResourcesPage.addCategoryToFavorites(driver,BrowserName);
            // To remove category to favourites
            _ref.toolsAndResourcesPage.removeCategoryFromFavorites(driver,BrowserName);
            //To verify tools and resources page
            _ref.toolsAndResourcesPage.verifyToolsAndResources(driver);
            //To click Signout dropdown Menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            //To click Signout Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to add category from T and R and verify T and R Page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


