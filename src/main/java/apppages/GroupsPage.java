package apppages;


import actions.ResultUtil;
import common.ExtendedLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;


public class GroupsPage extends ExtendedLibrary {

    private static final List<String> GROUP_PAGE_MENU_OPTIONS = Arrays.asList(
            "Home",
            "Categories",
            "Members",
            "About");

    public void clickGroupsMenu(WebDriver driver,String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                try {
                    WebElement menu = driver.findElement(By.xpath("//span[text()='Groups']"));
                    ((JavascriptExecutor) driver).executeScript("confirm = function(message){return true;};");
                    clickWithJavaScript(driver, menu);
                    ResultUtil.report("PASS", "clickGroupsMenu", "Should successfully click the menu", "Successfully click the menu", driver);
                } catch (Exception e){
                    ResultUtil.report("PASS", "clickGroupsMenu", "Should successfully click the menu", "Successfully click the menu", driver);
                }
                } else {
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Groups']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickGroupsMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickGroupsMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickMenuInGroupsPage(WebDriver driver,String BrowserName, String text) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//h2[contains(text(), '" + text + "')]"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickMenuInGroupsPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickMenuInGroupsPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickMembersMenuInGroupsPage(WebDriver driver,String BrowserName) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Members']"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickMembersMenuInGroupsPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickMembersMenuInGroupsPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickNewMembersMenuInGroupsPage(WebDriver driver,String BrowserName) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//a[text()='New members']"), "");
            clickWithJavaScript(driver, menu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickNewMembersMenuInGroupsPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickNewMembersMenuInGroupsPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickAboutMenuInGroupsPage(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//span[text()='About']"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickAboutMenuInGroupsPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAboutMenuInGroupsPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickSiteContentMenuInGroupsPage(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//span[text()='Site Contents']"), "");
            clickWithJavaScript(driver, menu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickSiteContentMenuInGroupsPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSiteContentMenuInGroupsPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifySiteContentsOptionMenu(WebDriver driver) throws Exception{
        try {
            if ((driver.findElement(By.xpath("//span[contains (text(), 'Lists, Libraries, and other Apps')]")) != null)) {
                ResultUtil.report("PASS", "verifySiteContentsOptionMenu", "Site Contents option menu should be present", "Site Contents option menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifySiteContentsOptionMenu", "Site Contents option menu should be present", "Site Contents option menu is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifySiteContentsOptionMenu' method", "", "", driver);
        }
    }

    public void verifyTopMembersMenuInGroupsPage(WebDriver driver, String name)throws  Exception{
        boolean tcText = false;
        boolean nmText = false;
        boolean azText = false;
        boolean openMenu = false;

        try {
            driver.findElement(By.xpath("//a[text()='" +name+ "']"));
            tcText = true;
            driver.findElement(By.xpath("//img[@alt=' " +name+ "']"));
            nmText = true;
            driver.findElement(By.xpath("//a[text()='" +name+ "']/../../../../../../../../following-sibling::div[1]//*[@id='myMemberStatsDiscussions']"));
            azText = true;
            driver.findElement(By.xpath("//a[text()='" +name+ "']/../../../../../../../../following-sibling::div[2]//*[@class='ms-noWrap']"));
            openMenu = true;
            ResultUtil.report("PASS", "verifyTopMembersMenuInGroupsPage", "Should successfully verify all the menu", "Successfully verify all the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyTopMembersMenuInGroupsPage' method", "", "", driver);
        }
    }

    public void verifyTopContributorsText(WebDriver driver) throws  Exception{
        try {
            if ((driver.findElement(By.xpath("//div[text()='Top contributors']")) != null)) {
                ResultUtil.report("PASS", "verifyTopContributorsText", "Text message should be present", "Text message is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyTopContributorsText", "Text message should be present", "Text message is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyTopContributorsText' method", "", "", driver);
        }
    }

    public void verifyDiscussionWindow(WebDriver driver) throws  Exception{
        try {
            if ((driver.findElement(By.id("forum1-Post0-Root")) != null)) {
                ResultUtil.report("PASS", "verifyDiscussionWindow", "Text message should be present", "Text message is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyDiscussionWindow", "Text message should be present", "Text message is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyDiscussionWindow' method", "", "", driver);
        }
    }

    public void verifyMenuInGroupPageMenu(WebDriver driver, String BrowserName) throws Exception {
        List<WebElement> groupPageMenu = driver.findElements(By.xpath("//*[contains(@id, 'RootAspMenu')]"));
        WebElement groupMenu = groupPageMenu.get(1);
        List<WebElement> displayList = groupMenu.findElements(By.tagName("li"));
        for (WebElement menu : displayList) {
            if (GROUP_PAGE_MENU_OPTIONS.contains(menu.getText())) {
                ResultUtil.report("PASS", "verify: Display Group page menu: " + menu.getText(), "Should have the Group page menu from the List", "Has all the Group page menu", driver);
            } else {
                ResultUtil.report("FAIL", "verify: Display Group page menu: " + menu.getText(), "Should have the Group page menu from the List", "Does not contain all the Group page menu", driver);
            }
        }
    }

    public void verifySiteContentsMenu(WebDriver driver)throws Exception{
        try {
            if ((driver.findElement(By.xpath("//span[text()='Site Contents']")) != null)) {
                ResultUtil.report("PASS", "verifySiteContentsMenu", "Text message should be present", "Text message is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifySiteContentsMenu", "Text message should be present", "Text message is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifySiteContentsMenu' method", "", "", driver);
        }
    }

    public void clickCategoryMenuInGroupsPage(WebDriver driver, String BrowserName)throws  Exception{
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Categories']"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickCategoryMenuInGroupsPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickCategoryMenuInGroupsPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickZtoAMenuInGroupsPage(WebDriver driver, String BrowserName) throws  Exception{
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//a[text()='Z-A']"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickZtoAMenuInGroupsPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickZtoAMenuInGroupsPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickOpenMenuInGroupsPage(WebDriver driver, String BrowserName) {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//img[@class='ms-ellipsis-icon']"), "");
            clickWithJavaScript(driver, menu);
            waitInMilliSeconds(1000);
            ResultUtil.report("PASS", "clickOpenAndVerifyRecentMenuInGroupsPage", "Should successfully click and verify the menu", "Successfully click and verify the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOpenAndVerifyRecentMenuInGroupsPage' method", "Should click and verify the menu", e.getMessage(), driver);
        }
    }

    public void verifyRecentMenu(WebDriver driver)throws  Exception{
        try {
            if ((driver.findElement(By.xpath("//span[text()='Recent']")) != null)) {
                ResultUtil.report("PASS", "verifyRecentMenu", "Recent menu should be present", "Recent menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyRecentMenu", "Recent menu should be present", "Recent menu is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyRecentMenu' method", "", "", driver);
        }
    }

    public void clickMenuInGroupsPage(String text,WebDriver driver,String BrowserName)throws  Exception{
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//h2[contains(text(), '" + text + "')]"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickMenuInGroupsPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickMenuInGroupsPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyWileyLogo(WebDriver driver)throws  Exception{
        try {
            if ((driver.findElement(By.id("DeltaSiteLogo")) != null)) {
                ResultUtil.report("PASS", "verifyWileyLogo", "Logo should be present", "Logo is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyWileyLogo", "Logo should be present", "Logo is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyWileyLogo' method", "", "", driver);
        }
    }

    public void clickHomeMenuInGroupsPage(WebDriver driver,String BrowserName) throws  Exception{
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//span[text()='Home']"), "");
            clickWithJavaScript(driver, menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickHomeMenuInGroupsPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickHomeMenuInGroupsPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyCategoryMenuInGroupsPage(WebDriver driver) throws  Exception{
        boolean azText = false;
        boolean zaText = false;
        boolean hotText = false;
        boolean openMenu = false;

        try {
            driver.findElement(By.xpath("//a[text()='A-Z']"));
            azText = true;
            driver.findElement(By.xpath("//a[text()='Z-A']"));
            zaText = true;
            driver.findElement(By.xpath("//a[contains (text(), 'hot')]"));
            hotText = true;
            driver.findElement(By.xpath("//img[@class='ms-ellipsis-icon']"));
            openMenu = true;
            ResultUtil.report("PASS", "verifyCategoryMenuInGroupsPage", "Should successfully verify all the menu", "Successfully verify all the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyCategoryMenuInGroupsPage' method", "", "", driver);
        }
    }

    public void clickAtoZMenuInGroupsPage(WebDriver driver,String BrowserName)throws Exception{
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='A-Z']"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickAtoZMenuInGroupsPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAtoZMenuInGroupsPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyGroupsPageText(WebDriver driver)throws  Exception{
        try {
            if ((driver.findElement(By.xpath("//div[contains(text(), 'Portal Social Groups')]")) != null)) {
                ResultUtil.report("PASS", "verifyGroupsPageText", "Text message should be present", "Text message is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyGroupsPageText", "Text message should be present", "Text message is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyGroupsPageText' method", "", "", driver);
        }
    }

    public void verifyGroupsOptionInFollowingMenu(WebDriver driver) throws  Exception{
        try {
            if ((driver.findElements(By.xpath("//a[text()='Groups']")).size()>0)) {
                ResultUtil.report("PASS", "verifyGroupsOptionInFollowingMenu", "Groups option menu should be present", "Groups option menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyGroupsOptionInFollowingMenu", "Groups option menu should be present", "Groups option menu is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyGroupsOptionInFollowingMenu' method", "", "", driver);
        }
    }

    public void verifyMembersMenuInGroupsPage(WebDriver driver) {
        boolean tcText = false;
        boolean nmText = false;
        boolean azText = false;
        boolean openMenu = false;

        try {
            driver.findElement(By.xpath("//a[text()='Top contributors']"));
            tcText = true;
            driver.findElement(By.xpath("//a[text()='New members']"));
            nmText = true;
            driver.findElement(By.xpath("//a[text()='A-Z']"));
            azText = true;
            driver.findElement(By.xpath("//img[@class='ms-ellipsis-icon']"));
            openMenu = true;
            ResultUtil.report("PASS", "verifyMembersMenuInGroupsPage", "Should successfully verify all the menu", "Successfully verify all the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyMembersMenuInGroupsPage' method", "", "", driver);
        }
    }

    public void clickWhatsHotMenuInGroupsPage(WebDriver driver, String BrowserName) throws Exception{
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//a[contains (text(),'hot')]"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickWhatsHotMenuInGroupsPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickWhatsHotMenuInGroupsPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifySiteContentsMenuInGroupsPage(WebDriver driver)  throws Exception {
        boolean siteText = false;
        boolean recycleText = false;

        try {
            driver.findElement(By.xpath("//span[text()='Site Workflows']"));
            siteText = true;
            driver.findElement(By.xpath("//span[contains(text(),'Recycle Bin')]"));
            recycleText = true;
            ResultUtil.report("PASS", "verifySiteContentsMenuInGroupsPage", "Should successfully verify all the menu", "Successfully verify all the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifySiteContentsMenuInGroupsPage' method", "", "", driver);
        }
    }

    public void clickGroupMenuInGroupsPage(WebDriver driver, String BrowserName,String name) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//h2[contains(text(),'" +name+ "')]"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickGroupMenuInGroupsPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickGroupMenuInGroupsPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickNewDiscussionMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='new discussion']"), "");
            clickWithJavaScript(driver, menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickNewDiscussionMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickNewDiscussionMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void enterValuesAndCreateDiscussion(WebDriver driver, String BrowserName,String title) throws Exception {
        try {
            WebElement titleMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//input[@title='Subject Required Field']"), "");
            titleMenu.click();
            titleMenu.sendKeys(title);
            ResultUtil.report("PASS", "enterValuesAndCreateDiscussion", "Should successfully entered the title text", "Successfully entered the title text", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterValuesAndCreateDiscussion' method", "Should enter the title text", e.getMessage(), driver);
        }
    }

    public void clickSaveMenu(WebDriver driver) throws Exception {
        try {
            List<WebElement> portalMenu = driver.findElements(By.xpath("//input[@value='Save']"));
            WebElement menu = portalMenu.get(0);
            clickWithJavaScript(driver, menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSaveMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSaveMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickFollowMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Follow']"), "");
            clickWithJavaScript(driver, menu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickFollowMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickFollowMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public synchronized void clickWileyPortalMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                try {
                    List<WebElement> portalMenu = waitForPresenceOfAllElementsLocatedBy(driver, BrowserName, By.xpath("//a[text()='Wiley Portal']"));
                    WebElement menu = portalMenu.get(0);
                    ((JavascriptExecutor) driver).executeScript("confirm = function(message){return true;};");
                    clickWithJavaScript(driver, menu);
                    waitForPageToLoad();
                    waitInMilliSeconds(2000);
                    ResultUtil.report("PASS", "clickWileyPortalMenu", "Should successfully click the menu", "Successfully click the menu", driver);
                } catch (Exception e){
                    ResultUtil.report("PASS", "clickWileyPortalMenu", "Should click the menu", "Successfully click the menu", driver);
                }
            } else {
                List<WebElement> portalMenu = waitForPresenceOfAllElementsLocatedBy(driver,BrowserName,By.xpath("//a[text()='Wiley Portal']"));
                WebElement menu = portalMenu.get(0);
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                waitInMilliSeconds(5000);
                ResultUtil.report("PASS", "clickWileyPortalMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickWileyPortalMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickSitesMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement menu = driver.findElement(By.xpath("//*[contains(@id, 'ShellSites')]"));
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickSitesMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            } else {
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='Sites']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickSitesMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSitesMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickStopFollowingMenu(WebDriver driver, String BrowserName,String title) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                try {
                    WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='" +title+ "']/../following-sibling::a"), "");
                    clickWithJavaScript(driver, menu);
                    waitForPageToLoad();
                    ResultUtil.report("PASS", "clickStopFollowingMenu", "Should successfully click the menu", "Successfully click the menu", driver);
                } catch (Exception e){
                    ResultUtil.report("PASS", "clickStopFollowingMenu", "Should successfully click the menu", "Successfully click the menu", driver);
                }
            } else {
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='" +title+ "']/../following-sibling::a"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickStopFollowingMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickStopFollowingMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

}





