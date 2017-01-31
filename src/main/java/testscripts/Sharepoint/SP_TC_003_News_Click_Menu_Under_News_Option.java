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
 * Created by vijay.nagarajan on 09/08/2016.
 */

public class SP_TC_003_News_Click_Menu_Under_News_Option extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_003_News_Click_Menu_Under_News_Option",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_003_News_Click_Menu_Under_News_Option() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            //To click Americas under News Hover
            _ref.sharePointHomePage.clickAmericasMenuUnderNewsHoverOption(driver, BrowserName);
            // To verify America nBulletin
            _ref.sharePointHomePage.verifyAmericanBulletinMenuPresence(driver);
            // To click SignOut dropdown
            _ref.sharePointHomePage.clickLogoutMenuDropdown(driver,BrowserName);
            // To click SignOut
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to click Americas menu under news option", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
