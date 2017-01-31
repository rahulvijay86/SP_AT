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
 * Created by vijay.nagarajan on 08/19/2016.
 */

public class SP_TC_010_011_Project_Edit_Link_Menu extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","projecturl"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String projecturl) throws Exception {

        ResultUtil.createReport("SP_TC_010_011_Project_Edit_Link_Menu",browserName,platform,projecturl);
        driver=launchURL(platform, browserName, remoteurl, projecturl);
    }

    @Test
    public void SP_TC_010_011_Project_Edit_Link_Menu() {
        try {
             waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.projectPage.clickEditLinksMenu(driver,BrowserName);
            _ref.projectPage.clickSubLinkMenu(driver,BrowserName);
            _ref.projectPage.verifyDragAndDropMenu(driver);
            _ref.projectPage.editSubLinkMenu(driver,BrowserName,Prerequsite.configMap.get("TC_010_Click_Project_New_Menu"));
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver,BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to edit project page links", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}


