package testscripts.Sharepoint;

import actions.Browser;
import actions.ResultUtil;
import common.ExtendedLibrary;

import intialize.Prerequsite;
import oracle.jdbc.proxy.annotation.Pre;
import org.openqa.selenium.Alert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import util.DataProviderUtil;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;


/**
 * Created by vijay.nagarajan on 08/03/2016
 */

public class SP_TC_001_002_Login_Logout_Page extends Prerequsite {

   @Parameters({"platform","browserName","remoteurl","url"})
   @BeforeClass
    public void browserInitialization(String platform,String browserName,String remoteurl,String url) throws Exception {

        ResultUtil.createReport("SP_TC_001_002_Login_Logout_Page",browserName,platform,url);
        driver=launchURL(platform, browserName, remoteurl, url);
    }

    @Test
    public void SP_TC_001_002_Login_Logout_Page() {
        try {
             waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            _ref.sharePointHomePage.clickSignOutDropdownMenu(driver,BrowserName);
            _ref.sharePointHomePage.clickSignOutMenu(driver, BrowserName);
            //Close browser
            driver.quit();

        } catch (Exception e) {

            ResultUtil.report("FAIL", "Execution failed", "User not able to login and logout", "" + e.getMessage(), driver);
            driver.quit();
        }
    }

}

