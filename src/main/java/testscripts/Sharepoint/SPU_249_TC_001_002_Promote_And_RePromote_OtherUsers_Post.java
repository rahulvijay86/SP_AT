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
 * Created by manjari.muralidharan on 11/08/2016.
 */

public class SPU_249_TC_001_002_Promote_And_RePromote_OtherUsers_Post extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","portalsiteurl"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String portalsiteurl) throws Exception {

        ResultUtil.createReport("SPU_249_TC_001_002_Promote_And_RePromote_OtherUsers_Post",browserName,platform,portalsiteurl);
        driver=launchURL(platform, browserName, remoteurl, portalsiteurl);
    }

    @Test
    public void SPU_249_TC_001_002_Promote_And_RePromote_OtherUsers_Post() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_FIVE")));
            // To verify Promote button
            _ref.newsFeedPage.verifyPromoteButtonPresence(driver);
            //To get the content of the post of other user
            String post=_ref.newsFeedPage.getOtherUsersPost(driver,Prerequsite.configMap.get("SPU_TC_001_OtherUser"));
            // To promote other user's post
            _ref.newsFeedPage.promoteOtherUsersPost(driver,BrowserName,Prerequsite.configMap.get("SPU_TC_001_OtherUser"));
            // To click Wiley portal menu
            _ref.groupsPage.clickWileyPortalMenu(driver,BrowserName);
            //To get the content of the promoted post
            String posts=_ref.newsFeedPage.getPromotedPost(driver,Prerequsite.configMap.get("SPU_TC_001_OtherUser"));
            // To compare the posts
            _ref.newsFeedPage.comparePosts(post,posts);
            // To click LogOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to promote other user's posts", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}



