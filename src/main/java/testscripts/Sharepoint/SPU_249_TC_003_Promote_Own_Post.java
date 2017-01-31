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
 * Created by manjari.muralidharan on 11/09/2016.
 */

public class SPU_249_TC_003_Promote_Own_Post extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","portalsiteurl"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String portalsiteurl) throws Exception {

        ResultUtil.createReport("SPU_249_TC_003_Promote_Own_Post",browserName,platform,portalsiteurl);
        driver=launchURL(platform, browserName, remoteurl, portalsiteurl);
    }

    @Test
    public void SPU_249_TC_003_Promote_Own_Post() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_FIVE")));
            // To verify Promote button
            _ref.newsFeedPage.verifyPromoteButtonPresence(driver);
            // To post comment
            _ref.newsFeedPage.postComment(Prerequsite.configMap.get("SPU_TC_249_003"),driver,BrowserName);
            // To click on Post button
            _ref.newsFeedPage.clickOnPostButton(driver,BrowserName);
            // To clic kon promote button
            _ref.newsFeedPage.clickOnPromoteButton(driver,BrowserName,Prerequsite.configMap.get("SPU_TC_249_003"));
            // To click Wiley portal menu
            _ref.groupsPage.clickWileyPortalMenu(driver,BrowserName);
            // To verify Promoted NewsFeed
            _ref.newsFeedPage.verifyPromotedNewsFeedPresence(driver,Prerequsite.configMap.get("SPU_TC_249_003"));
            // To click LogOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver,BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to Promote own posts", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
