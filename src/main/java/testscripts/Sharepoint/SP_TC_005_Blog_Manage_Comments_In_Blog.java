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


public class SP_TC_005_Blog_Manage_Comments_In_Blog extends Prerequsite {

    @Parameters({"platform","browserName","remoteurl","url"})
    @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_005_Blog_Manage_Comments_In_Blog",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_005_Blog_Manage_Comments_In_Blog() {
        try {
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click About me link
            _ref.sharePointHomePage.clickAboutMeLink(driver,BrowserName);
            // To click Blog menu
            _ref.blogPage.clickBlogMenu(driver,BrowserName);
            //// To click Manage comments menu
            _ref.blogPage.clickManageCommentsMenu(driver,BrowserName);
            // To select edit menu
            _ref.blogPage.selectEditMenuOfFirstComment(driver);
            // To edit title of the comments
            _ref.blogPage.editTitleForComments(driver,BrowserName,Prerequsite.configMap.get("TC_005_Edit_Comments"));
            // To click save button
            _ref.blogPage.clickSaveButton(driver,BrowserName);
            // To click SignOut Dropdown menu
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            // To click SignOut Menu
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);




            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to manage comments in blog", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}
