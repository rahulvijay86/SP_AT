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
 * Created by manjari.muralidharan on 10/21/2016.
 */

public class SP_TC_001_Blog_CreateBlog extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_001_Blog_CreateBlog",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_001_Blog_CreateBlog() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click About me link
            _ref.sharePointHomePage.clickAboutMeLink(driver,BrowserName);
            // To click Blog menu
            _ref.blogPage.clickBlogMenu(driver,BrowserName);
            // To click add category menu
            _ref.blogPage.clickAddCategoryMenu(driver,BrowserName);
            // To enter title
            _ref.blogPage.editTitle(Prerequsite.configMap.get("TC_002_Edit_Title"),driver,BrowserName);
            // To click Save button
            _ref.blogPage.clickSaveButton(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver,BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to verify Create blog", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
