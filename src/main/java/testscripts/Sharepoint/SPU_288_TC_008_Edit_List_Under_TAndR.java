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

public class SPU_288_TC_008_Edit_List_Under_TAndR extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SPU_288_TC_008_Edit_List_Under_TAndR",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SPU_288_TC_008_Edit_List_Under_TAndR() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click Tools menu options
            _ref.sharePointHomePage.clickToolsMenuOption(driver,BrowserName);
            //To click on T and R Favs
            _ref.toolsAndResourcesPage.clickOnTandRFavs(driver,BrowserName);
            //To click on selected ID
            _ref.toolsAndResourcesPage.clickOnFirstID(driver);
            //To click on Edit list
            _ref.toolsAndResourcesPage.clickOnEditList(driver,BrowserName);
            //To click on stop editing
            _ref.toolsAndResourcesPage.clickOnStopEditing(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to add category from T and R and verify T and R Page", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


