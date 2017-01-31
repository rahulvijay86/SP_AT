package apppages;


import actions.Browser;
import actions.ResultUtil;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import common.ExtendedLibrary;
import intialize.Prerequsite;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.xml.transform.Result;
import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import static org.testng.Assert.assertTrue;


public class SharePointHomePage extends ExtendedLibrary {

    File file = new File("src//main//java//resources//Koala.jpg");

    private static final List<String> POSSIBLE_HOMEPAGE_MENU_OPTIONS = Arrays.asList(
            "Newsfeed",
            "OneDrive",
            "Sites");

    private static final List<String> POSSIBLE_ONEDRIVE_MENU_OPTIONS = Arrays.asList(
            "My Documents",
            "Followed Documents");

    private static final List<String> POSSIBLE_PROFILE_PAGE_MENU_OPTIONS = Arrays.asList(
            "Newsfeed",
            "About me",
            "Blog",
            "Apps",
            "Work",
            "EDIT LINKS");

    private static final List<String> POSSIBLE_EDIT_PAGE_MENU_OPTIONS = Arrays.asList(
            "Delegation",
            "Newsfeed Settings",
            "Language and Region");

    private static final List<String> POSSIBLE_SEARCH_DROPDOWN_MENU_OPTIONS = Arrays.asList(
            "Everything",
            "People",
            "Conversations",
            "This Site");

    private static final List<String> WELCOME_USER_MSG = Arrays.asList(
            "Hi",
            "test_sp,",
            "welcome to Portal");

    private static final List<String> SEARCHBOX_MENU_OPTIONS = Arrays.asList(
            "BROWSE",
            "PAGE",
            "PUBLISH");

    private static final List<String> NEWS_MENU_OPTIONS = Arrays.asList(
            "Global",
            "Americas",
            "APAC",
            "Australia",
            "EMEA");

    private static final List<String> TOOLS_MENU_OPTIONS = Arrays.asList(
            "Admin Toolbox",
            "Floor Plans",
            "My Tools & Resources");

    private static final List<String> ABOUT_WILEY_MENU_OPTIONS = Arrays.asList(
            "Brand",
            "Business Conduct",
            "Corporate Citizenship",
            "Internal Publications",
            "Women Leading Wiley");

    private static final List<String> ABOUT_WILEY_MENU_Absence = Arrays.asList(
            "Accelerating our Transformation",
            "Access Wiley",
            "Company Information",
            "Presentations & Social Media - integrate with brand");

    public void clickLogoutMenuDropdown(WebDriver driver,String BrowserName) throws Exception {
        try {
            waitInMilliSeconds(2000);
            WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[@title='Open Menu']"), "");
            clickWithJavaScript(driver, dropDownMenu);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickLogoutMenuDropdown", "Should successfully click the dropdown", "Successfully click the dropdown", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickLogoutMenuDropdown' method", "Should click the dropdown", e.getMessage(), driver);
        }
    }

    public void clickSignOutDropdownMenu(WebDriver driver,String BrowserName) throws Exception {
        try {
            waitInMilliSeconds(2000);
            WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[@title='Open Menu']"), "");
            clickWithJavaScript(driver, dropDownMenu);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickMenuDropdown", "Should successfully click the dropdown", "Successfully click the dropdown", driver);
        } catch (Exception e) {
            e.printStackTrace();
            ResultUtil.report("FAIL", "EXCEPTION at 'clickMenuDropdown' method", "Should click the dropdown", e.getMessage(), driver);
        }
    }

    public void clickSignOutDropdownOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            waitInMilliSeconds(2000);
            List<WebElement> dropDownMenu = waitForPresenceOfAllElementsLocatedBy(driver, BrowserName, By.xpath("//span[@title='Open Menu']"));
            WebElement menu = dropDownMenu.get(0);
            clickWithJavaScript(driver,menu);
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            ResultUtil.report("PASS", "clickMenuDropdown", "Should successfully click the dropdown", "Successfully click the dropdown", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickMenuDropdown' method", "Should click the dropdown", e.getMessage(), driver);
        }
    }

    public void clickSignOutMenu(WebDriver driver, String BrowserName) throws Exception  {
        try {
            if (BrowserName.contains("ie")) {
                waitInMilliSeconds(1000);
                WebElement signOutMenu = waitForPresenceOfElementLocatedBy(driver,BrowserName, By.xpath("//span[text()='Sign Out']"), "");
                signOutMenu.click();
                waitInMilliSeconds(2000);
                Alert alert = driver.switchTo().alert();
                alert.dismiss();
                ResultUtil.report("PASS", "clickSignOutMenu", "Should successfully click the menu", "Successfully click the menu", driver);

            } else {
                WebElement signOutMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//span[text()='Sign Out']"), "");
                signOutMenu.click();
                waitInMilliSeconds(2000);
                ResultUtil.report("PASS", "clickSignOutMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSignOutMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyCopyrightTextPresence(WebDriver driver) throws Exception {
        try {
            if ((driver.findElement(By.xpath("//div[contains(text(),'2016 by John Wiley')]")) != null)) {
                ResultUtil.report("PASS", "verifyCopyrightTextPresence", "Copyright message should be present", "Copyright message is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyCopyrightTextPresence", "Copyright message should be present", "Copyright message is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyCopyrightTextPresence' method", "Copyright message should be present", e.getMessage(), driver);
        }
    }

    public void clickNewsFeedMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            List<WebElement> newsFeedMenu = waitForPresenceOfAllElementsLocatedBy(driver, BrowserName, By.xpath("//span[text()='Newsfeed']"));
            WebElement menu = newsFeedMenu.get(0);
            clickWithJavaScript(driver, menu);
            waitForPageToLoad();
            waitInMilliSeconds(3000);
            ResultUtil.report("PASS", "clickNewsFeedMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickNewsFeedMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickAboutMeLink(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement link = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='About Me']"), "");
            clickWithJavaScript(driver, link);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickAboutMeLink", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAboutMeLink' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyEditMenuOptions(WebDriver driver) throws Exception{
        boolean basicInfo = false;
        boolean contactInfo = false;
        boolean details = false;
        try {
            driver.findElement(By.xpath("//a[text()='Basic Information']"));
            basicInfo = true;
            driver.findElement(By.xpath("//a[text()='Contact Information']"));
            contactInfo = true;
            driver.findElement(By.xpath("//a[text()='Details']"));
            details = true;
            ResultUtil.report("PASS", "verifyEditMenuOptions", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyEditMenuOptions' method", "", "", driver);
        }
    }

    public void clickHiddenMenuLink(WebDriver driver,String BrowserName) throws Exception{
        try {
            WebElement link = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//img[@class='ms-ellipsis-icon']"), "");
            clickWithJavaScript(driver, link);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickHiddenMenuLink", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickHiddenMenuLink' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyWileyPortalMenuPresence(WebDriver driver) throws Exception {
        try {
            if ((driver.findElement(By.xpath("//a[text()='Wiley Portal']")) != null)) {
                ResultUtil.report("PASS", "verifyWileyPortalMenuPresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyWileyPortalMenuPresence", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyWileyPortalMenuPresence' method", "", "", driver);
        }
    }

    public void verifyLinkColor(WebDriver driver) throws Exception {
        try {
            String linkColor = driver.findElement(By.xpath("//a[text()='Wiley Portal']")).getCssValue("color");
            Assert.assertEquals("Blue Color", "rgba(255, 255, 255, 1)", linkColor);
            ResultUtil.report("PASS", "verifyLinkColor", "Should successfully verify the color", "Successfully verified the color", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyLinkColor' method", "Should verify the color", e.getMessage(), driver);
        }
    }

    public void verifySearchBoxMenu(WebDriver driver, String BrowserName) throws Exception {
        WebElement searchMenu = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.className("ms-cui-tts"));
        List<WebElement> displayList = searchMenu.findElements(By.tagName("li"));
        for (WebElement menu : displayList) {
            if (SEARCHBOX_MENU_OPTIONS.contains(menu.getText())) {
                ResultUtil.report("PASS", "verify: Searchbox menu: " + menu.getText(), "Should have the Searchbox menu from the List", "Has all the Searchbox menu", driver);
            } else {
                ResultUtil.report("FAIL", "verify: Searchbox menu: " + menu.getText(), "Should have the Searchbox menu from the List", "Does not contain all the Searchbox menu", driver);
            }
        }
    }

    public void hoverToolsAndResourcesMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Tools and Resources']"), "");
                mouseHoverJScript(driver,dropDownMenu);
                ResultUtil.report("PASS", "hoverToolsAndResourcesMenu", "Should successfully hover the News menu", "Successfully hovered the News menu", driver);
            }
            else {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Tools and Resources']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(dropDownMenu).build().perform();
                ResultUtil.report("PASS", "hoverToolsAndResourcesMenu", "Should successfully hover the News menu", "Successfully hovered the News menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'hoverToolsAndResourcesMenu' method", "Should hover the News menu", e.getMessage(), driver);
        }
    }

    public void verifyMenuUnderTools(WebDriver driver, String BrowserName)throws Exception {
        boolean adtool = false;
        boolean flplan = false;
        boolean mytandr = false;
        try {
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Admin Toolbox']"), "");
            adtool = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Floor Plans']"), "");
            flplan = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='My Tools & Resources']"), "");
            mytandr = true;
            ResultUtil.report("PASS", "verifyMenuUnderTools", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyMenuUnderTools' method", "", "", driver);
        }
    }

    public void clickMenuUnderWileyHoverOption(WebDriver driver,String BrowserName)throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='About Wiley']"), "");
                mouseHoverJScript(driver,hoverMenu);
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Brand']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickMenuUnderWileyHoverOption", "Should successfully hover the News menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);
            }
            else {
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='About Wiley']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(hoverMenu).build().perform();
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Brand']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickMenuUnderWileyHoverOption", "Should successfully hover the News menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickMenuUnderWileyHoverOption' method", "Should hover the News menu and click the option", e.getMessage(), driver);
        }
    }

    public void hoverPictureMenuAndClickUpload(WebDriver driver, String BrowserName) throws Exception {
        try {
            if (BrowserName.contains("safari")){
            WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//img[@id='ctl00_PictureUrlImage']"), "");
            mouseHoverJScript(driver,hoverMenu);
            WebElement uploadMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[@id='ctl00_PictureUrlImage_ChangeYourPhotoLink']"), "");
            clickWithJavaScript(driver, uploadMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "hoverPictureMenuAndClickUpload", "Should successfully hover the Picture menu", "Successfully hovered the Picture menu", driver);
        }
        else {
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//img[@id='ctl00_PictureUrlImage']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(hoverMenu).build().perform();
                WebElement uploadMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[@id='ctl00_PictureUrlImage_ChangeYourPhotoLink']"), "");
                clickWithJavaScript(driver, uploadMenu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "hoverPictureMenuAndClickUpload", "Should successfully hover the Picture menu", "Successfully hovered the Picture menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'hoverPictureMenuAndClickUpload' method", "Should hover the Picture menu", e.getMessage(), driver);
        }
    }

    public void profileImageUpload(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.className("ms-dlgFrame"), "");
            driver.switchTo().frame(iframeElement);
            WebElement uploadButton = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.id("profileimagepickerinput"), "Unable to find browse element.");
            uploadButton.sendKeys(file.getAbsolutePath());
            WebElement upload = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//input[@value='Upload']"), "");
            clickWithJavaScript(driver, upload);
            waitForPageToLoad();
            ResultUtil.report("PASS", "profileImageUpload", "File should be uploaded", "File is uploaded", driver);
            waitForPageToLoad();
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'profileImageUpload' method", "File should be uploaded", e.getMessage(), driver);
        }
    }

    public void clickSaveAllButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement saveAllMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//input[@value='Save all and close']"), "");
            clickWithJavaScript(driver,saveAllMenu);
            waitInMilliSeconds(2000);
            WebElement clickOKMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.id("ms-OkBtnDismissProfileSettingExitDlg"), "");
            clickWithJavaScript(driver, clickOKMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSaveAllButton", "Should successfully click the Save All Button", "Successfully click the Save All Button", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSaveAllButton' method", "Should click the Save All Button", e.getMessage(), driver);
        }
    }

    public void verifySettingsMenuPresence(WebDriver driver)throws Exception {
        try {
            if ((driver.findElement(By.xpath("//img[@title='Settings']")) != null)) {
                ResultUtil.report("PASS", "verifySettingsMenuPresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifySettingsMenuPresence", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifySettingsMenuPresence' method", "", "", driver);
        }
    }

    public void verifyHelpMenuPresence(WebDriver driver)throws Exception {
        try {
            if ((driver.findElement(By.xpath("//span[@id='help-img']/img")) != null)) {
                ResultUtil.report("PASS", "verifyHelpMenuPresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyHelpMenuPresence", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyHelpMenuPresence' method", "", "", driver);
        }
    }

    public void verifyHomepageSubMenu(WebDriver driver)throws Exception {
        boolean shareText = false;
        boolean FollowText = false;
        boolean myFilesText = false;
        boolean textSearch = false;

        try {
            driver.findElement(By.xpath("//span[text()='Share']"));
            shareText = true;
            driver.findElement(By.xpath("//span[text()='Follow']"));
            FollowText = true;
            driver.findElement(By.xpath("//span[text()='MY FILES']"));
            myFilesText = true;
            driver.findElement(By.id("txtSearch"));
            textSearch = true;
            ResultUtil.report("PASS", "verifyHomepageSubMenu", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyHomepageSubMenu' method", "", "", driver);
        }
    }

    public void verifyShareTooltip(WebDriver driver, String BrowserName) throws Exception {
        try {
            if (BrowserName.contains("safari")) {
                WebElement tooltip = driver.findElement(By.xpath("//span[text()='Share']"));
                mouseHoverJScript(driver,tooltip);
                String toolTipText = driver.findElement(By.id("ctl00_ctl62_site_share_button")).getAttribute("title");
                System.out.println(toolTipText);
                String expected_tooltip = "Give people access to this site.";
                Assert.assertEquals(toolTipText, expected_tooltip);
                System.out.println("Message verified");
                ResultUtil.report("PASS", "verify: Tooltip Msg: " + toolTipText, "Should successfully verify the tooltip message", "Successfully verified the tooltip message", driver);

            }else{
                WebElement tooltip = driver.findElement(By.xpath("//span[text()='Share']"));
                Actions toolAct = new Actions(driver);
                toolAct.moveToElement(tooltip).build().perform();
                String toolTipText = driver.findElement(By.id("ctl00_ctl62_site_share_button")).getAttribute("title");
                System.out.println(toolTipText);
                String expected_tooltip = "Give people access to this site.";
                Assert.assertEquals(toolTipText, expected_tooltip);
                System.out.println("Message verified");
                ResultUtil.report("PASS", "verify: Tooltip Msg: " + toolTipText, "Should successfully verify the tooltip message", "Successfully verified the tooltip message", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyShareTooltip' method", "Should verify the tooltip message", e.getMessage(), driver);
        }
    }

    public void verifyDocSearchFunctionality(WebDriver driver,String BrowserName,String doc)throws Exception{
        try {
            if(BrowserName.contains("safari")) {
                try {
                    WebElement Dmenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("txtSearch"), "");
                    Dmenu.click();
                    Dmenu.sendKeys(doc);
                    WebElement Dsearch = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("SmallSearchButton"), "");
                    clickWithJavaScript(driver, Dsearch);
                    waitForPageToLoad();
                    waitInMilliSeconds(2000);
                    ResultUtil.report("PASS", "verifyDocSearchFunctionality", "Should verify the menu", "Successfully verified the menu", driver);
                } catch (Exception e){
                    ResultUtil.report("PASS", "verifyDocSearchFunctionality", "Should verify the menu", "Successfully verified the menu", driver);
                }
                } else {
                WebElement Dmenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("txtSearch"), "");
                Dmenu.click();
                Dmenu.sendKeys(doc);
                WebElement Dsearch = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("SmallSearchButton"), "");
                clickWithJavaScript(driver, Dsearch);
                waitForPageToLoad();
                waitInMilliSeconds(2000);
                ResultUtil.report("PASS", "verifyDocSearchFunctionality", "Should verify the menu", "Successfully verified the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyDocSearchFunctionality' method", "Should click the menu and enter the search text", e.getMessage(), driver);
        }
    }

    public void verifyConvSearchFunctionality(WebDriver driver,String BrowserName,String con)throws Exception{
        try {
            WebElement Cmenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("txtSearch"), "");
            Cmenu.click();
            Cmenu.sendKeys(con);
            WebElement Csearch = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("SmallSearchButton"), "");
            clickWithJavaScript(driver,Csearch);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "verifyConvSearchFunctionality", "Should verify the menu", "Successfully verified the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyConvSearchFunctionality' method", "Should click the menu and enter the search text", e.getMessage(), driver);
        }
    }

    public void verifyNameSearchFunctionality(WebDriver driver,String BrowserName,String name){
        try {
            WebElement Nmenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("txtSearch"), "");
            Nmenu.click();
            Nmenu.sendKeys(name);
            WebElement Nsearch = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("SmallSearchButton"), "");
            clickWithJavaScript(driver,Nsearch);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "verifyNameSearchFunctionality", "Should verify the menu", "Successfully verified the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyNameSearchFunctionality' method", "Should click the menu and enter the search text", e.getMessage(), driver);
        }
    }

    public void verifyEmailSearchFunctionality(WebDriver driver,String BrowserName,String email){
        try {
            WebElement Emenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("txtSearch"), "");
            Emenu.click();
            Emenu.sendKeys(email);
            WebElement Esearch = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("SmallSearchButton"), "");
            clickWithJavaScript(driver,Esearch);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "verifyEmailSearchFunctionality", "Should verify the menu", "Successfully verified the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyEmailSearchFunctionality' method", "Should click the menu and enter the search text", e.getMessage(), driver);
        }
    }

    public void hoverFunctionsMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Functions']"), "");
                mouseHoverJScript(driver,dropDownMenu);
                ResultUtil.report("PASS", "hoverFunctionsMenu", "Should successfully hover the News menu", "Successfully hovered the News menu", driver);
            }
            else{
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Functions']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(dropDownMenu).build().perform();
                ResultUtil.report("PASS", "hoverFunctionsMenu", "Should successfully hover the News menu", "Successfully hovered the News menu", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'hoverFunctionsMenu' method", "Should hover the News menu", e.getMessage(), driver);
        }
    }

    public void verifyMenuUnderFunctions(WebDriver driver)throws Exception{
        boolean contentText = false;
        boolean corporateText = false;
        boolean creativeText = false;
        boolean customerSearch = false;
        boolean digitalSearch = false;
        boolean editorSearch = false;
        boolean enterpriseSearch = false;
        boolean epmoSearch = false;
        boolean exhibitSearch = false;
        boolean financeSearch = false;
        boolean hrSearch = false;
        boolean legalSearch = false;
        boolean marketingSearch = false;
        boolean revenueSearch = false;
        boolean publicitySearch = false;
        boolean researchSearch = false;
        boolean rightsSearch = false;
        boolean salesSearch = false;
        boolean talentSearch = false;
        boolean wileySearch = false;

        try {
            driver.findElement(By.xpath("//span[text()='Content Management and Technology']"));
            contentText = true;
            driver.findElement(By.xpath("//span[text()='Corporate Services']"));
            corporateText = true;
            driver.findElement(By.xpath("//span[text()='Creative & Marketing Services']"));
            creativeText = true;
            driver.findElement(By.xpath("//span[text()='Customer Operations']"));
            customerSearch = true;
            driver.findElement(By.xpath("//span[text()='Digital Products Central']"));
            digitalSearch = true;
            driver.findElement(By.xpath("//span[text()='Editorial']"));
            editorSearch = true;
            driver.findElement(By.xpath("//span[text()='Enterprise Resource Planning']"));
            enterpriseSearch = true;
            driver.findElement(By.xpath("//span[text()='EPMO Project Central']"));
            epmoSearch = true;
            driver.findElement(By.xpath("//span[text()='Exhibits']"));
            exhibitSearch = true;
            driver.findElement(By.xpath("//span[text()='Finance & Accounting']"));
            financeSearch = true;
            driver.findElement(By.xpath("//span[text()='Human Resources']"));
            hrSearch = true;
            driver.findElement(By.xpath("//span[text()='Legal']"));
            legalSearch = true;
            driver.findElement(By.xpath("//span[text()='Marketing']"));
            marketingSearch = true;
            driver.findElement(By.xpath("//span[text()='Marketing Revenue Center']"));
            revenueSearch = true;
            driver.findElement(By.xpath("//span[text()='Publicity']"));
            publicitySearch = true;
            driver.findElement(By.xpath("//span[text()='Research Center']"));
            researchSearch = true;
            driver.findElement(By.xpath("//span[text()='Rights, Licensing, and Permissions']"));
            rightsSearch = true;
            driver.findElement(By.xpath("//span[text()='Sales']"));
            salesSearch = true;
            driver.findElement(By.xpath("//span[text()='Talent Central']"));
            talentSearch = true;
            driver.findElement(By.xpath("//span[text()='Wiley Global Technology']"));
            wileySearch = true;
            ResultUtil.report("PASS", "verifyMenuUnderFunctions", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyMenuUnderFunctions' method", "", "", driver);
        }
    }

    public void clickMenuUnderFunctionsHoverOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Functions']"), "");
                mouseHoverJScript(driver,hoverMenu);
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Content Management and Technology']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickMenuUnderFunctionsHoverOption", "Should successfully hover the News menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);
            }
            else{
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Functions']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(hoverMenu).build().perform();
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Content Management and Technology']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickMenuUnderFunctionsHoverOption", "Should successfully hover the News menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickMenuUnderFunctionsHoverOption' method", "Should hover the News menu and click the option", e.getMessage(), driver);
        }
    }

    public void clickAmericasMenuUnderNewsHoverOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='News']"), "");
                mouseHoverJScript(driver,hoverMenu);
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Americas']"), "");
                clickWithJavaScript(driver,menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickAmericasMenuUnderNewsHoverOption", "Should successfully hover the News menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);
            }
            else {
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='News']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(hoverMenu).build().perform();
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Americas']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickAmericasMenuUnderNewsHoverOption", "Should successfully hover the News menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAmericasMenuUnderNewsHoverOption' method", "Should hover the News menu and click the option", e.getMessage(), driver);
        }
    }

    public void verifyAmericanBulletinMenuPresence(WebDriver driver) {
        try {
            if ((findElementByNoThrow(driver, By.xpath("//span[text()='The Americas Bulletin']")) != null)) {
                ResultUtil.report("PASS", "verifyAmericanBulletinMenuPresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyAmericanBulletinMenuPresence", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyAmericanBulletinMenuPresence' method", "", "", driver);
        }
    }


    public void clickSitesMenuOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement newsMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[contains(@id, 'ShellSites')]/span"), "");
            clickWithJavaScript(driver,newsMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSitesMenuOption", "Should successfully click the option", "Successfully clicked the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSitesMenuOption' method", "Should click the option", e.getMessage(), driver);
        }
    }


    public void clickSiteContentsOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement newsMenu = waitForVisibilityOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Site contents']"));
            clickWithJavaScript(driver, newsMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSiteContentsOption", "Should successfully click the option", "Successfully clicked the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSiteContentsOption' method", "Should click the option", e.getMessage(), driver);
        }
    }

    public void clickProfilePictureMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement picMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("ctl00_PictureUrlImage"), "");
            clickWithJavaScript(driver,picMenu);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickProfilePictureMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickProfilePictureMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifySearchBoxPresence(WebDriver driver)  throws Exception {
        try {
            if ((driver.findElement(By.id("txtSearch")) != null)) {
                ResultUtil.report("PASS", "verifySearchBoxPresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifySearchBoxPresence", "Menu should be present", "Menu is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifySearchBoxPresence' method", "", "", driver);
        }
    }

    public void hoverFunctionsMenuAndSelectOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Functions']"), "");
                mouseHoverJScript(driver,dropDownMenu);
                WebElement option = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[text()='Marketing Revenue Center']"), "");
                clickWithJavaScript(driver, option);
                waitForPageToLoad();
                waitInMilliSeconds(3000);
                ResultUtil.report("PASS", "hoverFunctionsMenuAndSelectOption", "Should successfully hover the News menu and select option", "Successfully hovered the News menu and selected option", driver);
            }
            else {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Functions']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(dropDownMenu).build().perform();
                WebElement option = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[text()='Marketing Revenue Center']"), "");
                clickWithJavaScript(driver, option);
                waitForPageToLoad();
                waitInMilliSeconds(3000);
                ResultUtil.report("PASS", "hoverFunctionsMenuAndSelectOption", "Should successfully hover the News menu and select option", "Successfully hovered the News menu and selected option", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'hoverFunctionsMenuAndSelectOption' method", "Should hover the News menu and select option", e.getMessage(), driver);
        }
    }

    public void verifyProfilePageMenu(WebDriver driver, String BrowserName) throws Exception{
        boolean newsText = false;
        boolean aboutText = false;
        boolean blogText = false;
        boolean appsText = false;
        try {
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Newsfeed']"), "");
            newsText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='About me']"), "");
            aboutText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Blog']"), "");
            blogText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Apps']"), "");
            appsText = true;
            ResultUtil.report("PASS", "verifyProfilePageMenu", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyProfilePageMenu' method", "", "", driver);
        }
    }

    public void verifyUserPicturePresence(WebDriver driver)  throws Exception{
        try {
            if ((driver.findElement(By.id("ctl00_PictureUrlImage")) != null)) {
                ResultUtil.report("PASS", "verifyUserPicturePresence", "User picture menu should be present", "User picture menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyUserPicturePresence", "User picture menu should be present", "User picture menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyUserPicturePresence' method", "", "", driver);
        }
    }

    public void verifyHomepageMenuUnderWelcomeMsg(WebDriver driver, String BrowserName) throws Exception{
        boolean followText = false;
        boolean sitesText = false;
        try {
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='I am Following']"), "");
            followText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='Sites']"), "");
            sitesText = true;
            ResultUtil.report("PASS", "verifyHomepageMenuUnderWelcomeMsg", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyHomepageMenuUnderWelcomeMsg' method", "", "", driver);
        }
    }

    public void verifyNewsfeedMenu(WebDriver driver) throws Exception{
        try {
            List<WebElement> newsFeedMenu = driver.findElements(By.xpath("//span[text()='Newsfeed']"));
            System.out.println(newsFeedMenu.size());
            newsFeedMenu.get(1).isDisplayed();
            ResultUtil.report("PASS", "verifyNewsfeedMenu", "Menu should be present", "Menu is present", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyNewsfeedMenu' method", "Menu should be present", e.getMessage(), driver);
        }
    }

    public void verifyArticleContainer(WebDriver driver) throws  Exception{
        try {
            List<WebElement> articleContainer = driver.findElements(By.xpath("//div[@class='ms-webpart-zone ms-fullWidth']"));
            System.out.println(articleContainer.size());
            articleContainer.get(2).isDisplayed();
            ResultUtil.report("PASS", "verifyArticleContainer", "Menu should be present", "Menu is present", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyArticleContainer' method", "Menu should be present", e.getMessage(), driver);
        }
    }
    public void clickMenuUnderLocationsHoverOption(WebDriver driver, String BrowserName)throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Locations']"), "");
                mouseHoverJScript(driver, hoverMenu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickMenuUnderLocationsHoverOption", "Should successfully hover the News menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);
            }
            else {
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Locations']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(hoverMenu).build().perform();
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickMenuUnderLocationsHoverOption", "Should successfully hover the News menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickMenuUnderLocationsHoverOption' method", "Should hover the News menu and click the option", e.getMessage(), driver);
        }
    }

    public void clickMenuUnderToolsHoverOption(WebDriver driver, String BrowserName) throws Exception{
        try {
            if(BrowserName.contains("safari")) {
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Tools and Resources']"), "");
                mouseHoverJScript(driver,hoverMenu);
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='My Tools & Resources']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickMenuUnderToolsHoverOption", "Should successfully hover the News menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);
            }
            else {
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Tools and Resources']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(hoverMenu).build().perform();
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='My Tools & Resources']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickMenuUnderToolsHoverOption", "Should successfully hover the News menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickMenuUnderToolsHoverOption' method", "Should hover the News menu and click the option", e.getMessage(), driver);
        }
    }

    public void hoverAboutWileyMenu(WebDriver driver, String BrowserName) throws Exception{
        try {
            if(BrowserName.contains("safari")) {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='About Wiley']"), "");
                mouseHoverJScript(driver, dropDownMenu);
                ResultUtil.report("PASS", "hoverAboutWileyMenu", "Should successfully hover the News menu", "Successfully hovered the News menu", driver);
            }
            else {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='About Wiley']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(dropDownMenu).build().perform();
                ResultUtil.report("PASS", "hoverAboutWileyMenu", "Should successfully hover the News menu", "Successfully hovered the News menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'hoverAboutWileyMenu' method", "Should hover the News menu", e.getMessage(), driver);
        }
    }

    public void verifyMenuUnderWiley(WebDriver driver, String BrowserName)throws Exception {
        boolean brandtext = false;
        boolean bctext = false;
        boolean cctext = false;
        boolean iptext = false;
        boolean wlwtext = false;
        try {
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Brand']"), "");
            brandtext = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Business Conduct']"), "");
            bctext = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Corporate Citizenship']"), "");
            cctext = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Internal Publications']"), "");
            iptext = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Women Leading Wiley']"), "");
            wlwtext = true;
            ResultUtil.report("PASS", "verifyMenuUnderTools", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyMenuUnderTools' method", "", "", driver);
        }
    }

    public void enterPageValueAndVerifyMenu(WebDriver driver,String BrowserName) throws Exception {
        boolean link = false;
        boolean createMenu = false;
        boolean cancelMenu = false;
        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.className("ms-dlgFrame"),"");
            driver.switchTo().frame(iframeElement);
            WebElement enterText = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.id("ctl00_PlaceHolderMain_nameInput"), "");
            enterText.click();
            enterText.sendKeys("Test");
            WebElement search = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//*[contains(@id, 'PlaceHolderMain_pageNamePreviewUrlLabel')]"),"");
            link = true;
            WebElement create = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//input[@value='Create']"), "");
            createMenu = true;
            WebElement cancel = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//input[@value='Cancel']"), "");
            cancelMenu = true;
            clickWithJavaScript(driver,cancel);
            waitInMilliSeconds(1000);
            driver.switchTo().defaultContent();
            ResultUtil.report("PASS", "enterPageValueAndVerifyMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterPageValueAndVerifyMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyEditMenuPresence(WebDriver driver) throws  Exception{
        try {
            if ((driver.findElement(By.xpath("//a[text()='edit']")) != null)) {
                ResultUtil.report("PASS", "verifyEditMenuPresence", "Edit menu should be present", "Edit menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyEditMenuPresence", "Edit menu should be present", "Edit menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyEditMenuPresence' method", "", "", driver);
        }
    }

    public void verifyEditMenuHiddenOptions(WebDriver driver,String BrowserName) throws Exception{
        WebElement editMenu = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.xpath("//span[@id='PlaceHolderID_overflow']/div"));
        List<WebElement> displayList = editMenu.findElements(By.tagName("li"));
        for (WebElement menu : displayList) {
            if (POSSIBLE_EDIT_PAGE_MENU_OPTIONS.contains(menu.getText())) {
                ResultUtil.report("PASS", "verify: Edit page menu: " + menu.getText(), "Should have the Edit page menu from the List", "Has all the Edit page menu", driver);
            } else {
                ResultUtil.report("FAIL", "verify: Edit page menu: " + menu.getText(), "Should have the Edit page menu from the List", "Does not contain all the Edit page menu", driver);
            }
        }
    }

    public void verifyFollowTooltip(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement tooltip = driver.findElement(By.xpath("//span[text()='Follow']"));
                mouseHoverJScript(driver, tooltip);
                String toolTipText = driver.findElement(By.id("site_follow_button")).getAttribute("title");
                System.out.println(toolTipText);
                String expected_tooltip = "Follow this site and get back to it easily from your sites page.";
                Assert.assertEquals(toolTipText, expected_tooltip);
                System.out.println("Message verified");
                ResultUtil.report("PASS", "verify: Tooltip Msg: " + toolTipText, "Should successfully verify the tooltip message", "Successfully verified the tooltip message", driver);
            }
            else {
                WebElement tooltip = driver.findElement(By.xpath("//span[text()='Follow']"));
                Actions toolAct = new Actions(driver);
                toolAct.moveToElement(tooltip).build().perform();
                String toolTipText = driver.findElement(By.id("site_follow_button")).getAttribute("title");
                System.out.println(toolTipText);
                String expected_tooltip = "Follow this site and get back to it easily from your sites page.";
                Assert.assertEquals(toolTipText, expected_tooltip);
                System.out.println("Message verified");
                ResultUtil.report("PASS", "verify: Tooltip Msg: " + toolTipText, "Should successfully verify the tooltip message", "Successfully verified the tooltip message", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyFollowTooltip' method", "Should verify the tooltip message", e.getMessage(), driver);
        }
    }

    public void verifyMyFilesTooltip(WebDriver driver, String BrowserName) throws  Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement tooltip = driver.findElement(By.xpath("//span[text()='MY FILES']"));
                mouseHoverJScript(driver, tooltip);
                String toolTipText = driver.findElement(By.xpath("//a[contains (@id, 'MyFiles')]")).getAttribute("title");
                System.out.println(toolTipText);
                String expected_tooltip = "Show documents uploaded or modified by me.";
                Assert.assertEquals(toolTipText, expected_tooltip);
                System.out.println("Message verified");
                ResultUtil.report("PASS", "verify: Tooltip Msg: " + toolTipText, "Should successfully verify the tooltip message", "Successfully verified the tooltip message", driver);
            }
            else {
                WebElement tooltip = driver.findElement(By.xpath("//span[text()='MY FILES']"));
                Actions toolAct = new Actions(driver);
                toolAct.moveToElement(tooltip).build().perform();
                String toolTipText = driver.findElement(By.xpath("//a[contains (@id, 'MyFiles')]")).getAttribute("title");
                System.out.println(toolTipText);
                String expected_tooltip = "Show documents uploaded or modified by me.";
                Assert.assertEquals(toolTipText, expected_tooltip);
                System.out.println("Message verified");
                ResultUtil.report("PASS", "verify: Tooltip Msg: " + toolTipText, "Should successfully verify the tooltip message", "Successfully verified the tooltip message", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyMyFilesTooltip' method", "Should verify the tooltip message", e.getMessage(), driver);
        }
    }

    public void clickSearchDropdownMenu(WebDriver driver,String BrowserName) throws  Exception{
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.id("SmallSearchScope"), "");
            clickWithJavaScript(driver, menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSearchDropdownMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSearchDropdownMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifySearchDropdownMenuOptions(WebDriver driver,String BrowserName) throws Exception{
        WebElement searchMenu = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.id("SearchScopeDropDown"));
        List<WebElement> displayList = searchMenu.findElements(By.tagName("div"));
        for (WebElement menu : displayList) {
            if (POSSIBLE_SEARCH_DROPDOWN_MENU_OPTIONS.contains(menu.getText())) {
                ResultUtil.report("PASS", "verify: Search Dropdown page menu: " + menu.getText(), "Should have the Search Dropdown page menu from the List", "Has all the Search Dropdown page menu", driver);
            } else {
                ResultUtil.report("FAIL", "verify: Search Dropdown page menu: " + menu.getText(), "Should have the Search Dropdown page menu from the List", "Does not contain all the Search Dropdown page menu", driver);
            }
        }
    }

    public void verifyWelcomeTextMsg(WebDriver driver, String BrowserName) throws Exception{
        boolean hitext = false;
        boolean id = false;
        boolean msg = false;
        try{
            waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[contains(text(),'Hi,')]"),"");
            hitext = true;
            waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[contains(text(),'Test SP')]"),"");
            id = true;
            waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[contains(text(),'Welcome to Portal!')]"),"");
            msg = true;
            ResultUtil.report("PASS","Verify the welcome message","Should verify the welcome message","Successfully verified the welcome message", driver);
        }catch (Exception e){
            ResultUtil.report("FAIL","Exception at 'Verify the welcome message' method","Should verify the welcome message",e.getMessage(), driver);
        }
    }

    public void enterSearchText(String text,WebDriver driver,String BrowserName) throws Exception{
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.id("txtSearch"), "");
            menu.click();
            menu.sendKeys(text);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSearchMenuAndEnterSearchText", "Should successfully click the menu and entered the search text", "Successfully click the menu and entered the search text", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSearchMenuAndEnterSearchText' method", "Should click the menu and enter the search text", e.getMessage(), driver);
        }
    }

    public void verifyWileyLogoPresence(WebDriver driver) throws Exception{
        try {
            if ((findElementByNoThrow(driver,By.xpath("//img[@name='onetidHeadbnnr0']")) != null)) {
                ResultUtil.report("PASS", "verifyWileyLogoPresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyWileyLogoPresence", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyWileyLogoPresence' method", "", "", driver);
        }
    }

    public void verifyClickForMoreResults(WebDriver driver) throws  Exception{
        try {
            if ((driver.findElement(By.xpath(".//*[text()='Click here to get more results']")) != null)) {
                ResultUtil.report("PASS", "verifyClickForMoreResults", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyClickForMoreResults", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyClickForMoreResults' method", "", "", driver);
        }
    }

    public void hoverBusinessMenu(WebDriver driver,String BrowserName) throws Exception{
        try {
            if(BrowserName.contains("safari")) {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Business']"), "");
                mouseHoverJScript(driver,dropDownMenu);
                ResultUtil.report("PASS", "hoverBusinessMenu", "Should successfully hover the News menu", "Successfully hovered the News menu", driver);
            }
            else{
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Business']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(dropDownMenu).build().perform();
                ResultUtil.report("PASS", "hoverBusinessMenu", "Should successfully hover the News menu", "Successfully hovered the News menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'hoverBusinessMenu' method", "Should hover the News menu", e.getMessage(), driver);
        }
    }

    public void verifyMenuUnderBusiness(WebDriver driver, String BrowserName) throws Exception{
        boolean globalText = false;
        boolean knowledgeText = false;
        boolean professionalText = false;
        boolean researchSearch = false;

        try {
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Global Education']"), "");
            globalText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Knowledge and Learning']"), "");
            knowledgeText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Professional Development']"), "");
            professionalText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Research']"), "");
            researchSearch = true;
            ResultUtil.report("PASS", "verifyHomepageMenuUnderWelcomeMsg", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyHomepageMenuUnderWelcomeMsg' method", "", "", driver);
        }
    }

    public void clickMenuUnderBusinessHoverOption(WebDriver driver,String BrowserName) throws Exception{
        try {
            if(BrowserName.contains("safari")) {
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Business']"), "");
                mouseHoverJScript(driver,hoverMenu);
                WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Knowledge and Learning']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickMenuUnderBusinessHoverOption", "Should successfully hover the News menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);
            }
            else {
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Business']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(hoverMenu).build().perform();
                WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName, By.xpath("//span[text()='Knowledge and Learning']"),"");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickMenuUnderBusinessHoverOption", "Should successfully hover the News menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickMenuUnderBusinessHoverOption' method", "Should hover the News menu and click the option", e.getMessage(), driver);
        }
    }

    public void hoverLocationsMenu(WebDriver driver,String BrowserName) throws Exception{
        try {
            if(BrowserName.contains("safari")) {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Locations']"), "");
                mouseHoverJScript(driver, dropDownMenu);
                ResultUtil.report("PASS", "hoverLocationsMenu", "Should successfully hover the News menu", "Successfully hovered the News menu", driver);
            }
            else {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Locations']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(dropDownMenu).build().perform();
                ResultUtil.report("PASS", "hoverLocationsMenu", "Should successfully hover the News menu", "Successfully hovered the News menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'hoverLocationsMenu' method", "Should hover the News menu", e.getMessage(), driver);
        }
    }

    public void verifyMenuUnderLocations(WebDriver driver, String BrowserName) throws Exception{
        boolean asiaText = false;
        boolean emeaText = false;
        boolean americaText = false;
        boolean wileySearch = false;

        try {
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Asia Pacific']"), "");
            asiaText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='EMEA']"), "");
            emeaText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='The Americas']"), "");
            americaText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Wiley Locations']"),"");
            wileySearch = true;
            ResultUtil.report("PASS", "verifyMenuUnderLocations", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyMenuUnderLocations' method", "", "", driver);
        }
    }

    public void clickPageMenu(WebDriver driver,String BrowserName) throws  Exception{
        try {
            WebElement createPageMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//span[text()='Page']"), "");
            clickWithJavaScript(driver, createPageMenu);
            ResultUtil.report("PASS", "clickPageMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickPageMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickViewAllPagesMenu(WebDriver driver,String BrowserName) throws  Exception{
        try {
            WebElement createPageMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//*[contains(@id, 'ViewAllPages')]"), "");
            clickWithJavaScript(driver,createPageMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickViewAllPagesMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickViewAllPagesMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyDWSearchBoxPresence(WebDriver driver) throws Exception{
        try {
            if ((driver.findElement(By.xpath(".//*[@class='ms-srch-sbLarge ms-srch-sb-border']")) != null)) {
                ResultUtil.report("PASS", "verifyDWSearchBoxPresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyDWSearchBoxPresence", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyDWSearchBoxPresence' method", "", "", driver);
        }
    }

    public void enterPageValueAndCreate(String name,WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.className("ms-dlgFrame"),"");
            driver.switchTo().frame(iframeElement);
            WebElement enterText = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.id("ctl00_PlaceHolderMain_nameInput"), "");
            enterText.click();
            enterText.sendKeys(name);
            waitInMilliSeconds(3000);
            WebElement create = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//input[@value='Create']"), "");
            clickWithJavaScript(driver,create);
            waitForPageToLoad();
            driver.switchTo().defaultContent();
            ResultUtil.report("PASS", "enterPageValueAndCreate", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterPageValueAndCreate' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickCreatePageMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement createPageMenu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Add a page']"), "");
            clickWithJavaScript(driver, createPageMenu);
            ResultUtil.report("PASS", "clickCreatePageMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickCreatePageMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickToolsMenuOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement newsMenu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Tools and Resources']"), "");
            clickWithJavaScript(driver,newsMenu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickToolsMenuOption", "Should successfully clicked the option", "Successfully clicked the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickToolsMenuOption' method", "Should click the option", e.getMessage(), driver);
        }
    }

    public void verifyBrowseMenuPresence(WebDriver driver) throws Exception {
        try {
            if ((driver.findElement(By.xpath("//span[text()='Browse']")) != null)) {
                ResultUtil.report("PASS", "verifyBrowseMenuPresence", "Browse menu should be present", "Browse menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyBrowseMenuPresence", "Browse menu should be present", "Browse menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyBrowseMenuPresence' method", "", "", driver);
        }
    }

    public void verifyWileyFooterMenuPresence(WebDriver driver) throws Exception{
        try {
            if ((driver.findElement(By.id("imgfooterwordmark")) != null)) {
                ResultUtil.report("PASS", "verifyWileyFooterMenuPresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyWileyFooterMenuPresence", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyWileyFooterMenuPresence' method", "", "", driver);
        }
    }

    public void clickOneDriveMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement oneDriveMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='OneDrive']"), "");
            clickWithJavaScript(driver, oneDriveMenu);
            waitForPageToLoad();
            waitInMilliSeconds(3000);
            ResultUtil.report("PASS", "clickOneDriveMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOneDriveMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyUserDropdownMenu(WebDriver driver) throws Exception{
        boolean aboutMeText = false;
        boolean signAsText = false;
        boolean signOutText = false;
//        boolean personalizeText = false;
        try {
            driver.findElement(By.xpath("//span[text()='About Me']"));
            aboutMeText = true;
            driver.findElement(By.xpath("//span[text()='Sign in as Different User']"));
            signAsText = true;
            driver.findElement(By.xpath("//span[text()='Sign Out']"));
            signOutText = true;
//            driver.findElement(By.xpath("//span[text()='Personalize this Page']"));
//            personalizeText = true;
            ResultUtil.report("PASS", "verifyUserDropdownMenu", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyUserDropdownMenu' method", "", "", driver);
        }
    }

    public void clickEditLink(WebDriver driver, String BrowserName) throws Exception{
        try {
            WebElement link = waitForPresenceOfElementLocatedBy(driver,BrowserName, By.xpath("//a[text()='edit']"), "");
            clickWithJavaScript(driver, link);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickEditLink", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickEditLink' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void hoverNewsMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='News']"), "");
                mouseHoverJScript(driver, dropDownMenu);
                ResultUtil.report("PASS", "hoverNewsMenu", "Should successfully hover the News menu", "Successfully hovered the News menu", driver);
            }
            else{
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='News']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(dropDownMenu).build().perform();
                ResultUtil.report("PASS", "hoverNewsMenu", "Should successfully hover the News menu", "Successfully hovered the News menu", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'hoverNewsMenu' method", "Should hover the News menu", e.getMessage(), driver);
        }
    }

    public void verifyMenuUnderNewsOption(WebDriver driver, String BrowserName) throws  Exception{
        boolean globalText = false;
        boolean knowledgeText = false;
        boolean professionalText = false;
        boolean researchSearch = false;
        boolean emeaSearch = false;

        try {
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Global']"), "");
            globalText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Americas']"), "");
            knowledgeText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='APAC']"), "");
            professionalText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Australia']"), "");
            researchSearch = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='EMEA']"), "");
            emeaSearch = true;
            ResultUtil.report("PASS", "verifyMenuUnderNewss", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyMenuUnderNewss' method", "", "", driver);
        }
    }

    public void clickNewsMenuOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement newsMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='News']"), "");
            clickWithJavaScript(driver, newsMenu);
            waitForPageToLoad();
            waitInMilliSeconds(3000);
            ResultUtil.report("PASS", "clickNewsMenuOption", "Should successfully click the option", "Successfully clicked the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickNewsMenuOption' method", "Should click the option", e.getMessage(), driver);
        }
    }

    public void verifyNewsRoomMenuPresence(WebDriver driver) throws Exception{
        try {
            if ((driver.findElement(By.xpath("//strong[text()='The News Room']")) != null)) {
                ResultUtil.report("PASS", "verifyNewsRoomMenuPresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyNewsRoomMenuPresence", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyNewsRoomMenuPresence' method", "", "", driver);
        }
    }

    public void verifyPageMenuPresence (WebDriver driver) throws  Exception{
        try {
            if ((driver.findElement(By.xpath("//span[text()='Page']")) != null)) {
                ResultUtil.report("PASS", "verifyPageMenuPresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyPageMenuPresence", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyPageMenuPresence' method", "", "", driver);
        }
    }

    public void verifyGlobalHeaderMenu(WebDriver driver) throws  Exception{
        boolean newsText = false;
        boolean functionsText = false;
        boolean businessText = false;
        boolean groupsText = false;
        boolean locationsText = false;
        boolean toolsText = false;
        boolean aboutText = false;
        boolean projectText = false;
        try {
            driver.findElement(By.xpath("//span[text()='News']"));
            newsText = true;
            driver.findElement(By.xpath("//span[text()='Functions']"));
            functionsText = true;
            driver.findElement(By.xpath("//span[text()='Business']"));
            businessText = true;
            driver.findElement(By.xpath("//span[text()='Groups']"));
            groupsText = true;
            driver.findElement(By.xpath("//span[text()='Locations']"));
            locationsText = true;
            driver.findElement(By.xpath("//span[text()='Tools and Resources']"));
            toolsText = true;
            driver.findElement(By.xpath("//span[text()='About Wiley']"));
            aboutText = true;
            driver.findElement(By.xpath("//span[text()='Projects']"));
            aboutText = true;
            ResultUtil.report("PASS", "verifyGlobalHeaderMenu", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyGlobalHeaderMenu' method", "", "", driver);
        }
    }

    public void verifyDifferentHomePageMenu(WebDriver driver, String BrowserName) throws Exception {
        WebElement homePageMenu = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.id("DeltaSuiteLinks"));
        List<WebElement> displayList = homePageMenu.findElements(By.tagName("li"));
        for (WebElement menu : displayList) {
            if (POSSIBLE_HOMEPAGE_MENU_OPTIONS.contains(menu.getText())) {
                ResultUtil.report("PASS", "verify: Display Home page menu: " + menu.getText(), "Should have the home page menu from the List", "Has all the home page menu", driver);
            } else {
                ResultUtil.report("FAIL", "verify: Display Home page menu: " + menu.getText(), "Should have the home page menu from the List", "Does not contain all the home page menu", driver);
            }
        }
    }

    public void verifyMenuUnderNews(WebDriver driver, String BrowserName) throws  Exception{
        boolean globalText = false;
        boolean americaText = false;
        boolean apacText = false;
        boolean ausText = false;
        boolean emeaText = false;

        try {
            waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Global']"),"");
            globalText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Americas']"),"");
            americaText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='APAC']"),"");
            apacText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Australia']"),"");
            ausText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='EMEA']"),"");
            emeaText = true;
            ResultUtil.report("PASS", "verifyProjectPageRibbonMenu", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyProjectPageRibbonMenu' method", "", "", driver);
        }
    }

    public void clickMenuUnderNewsHoverOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='News']"), "");
                mouseHoverJScript(driver,hoverMenu);
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Global']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickMenuUnderNewsHoverOption", "Should successfully hover the News menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);
            }
            else {
                WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='News']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(hoverMenu).build().perform();
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Global']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickMenuUnderNewsHoverOption", "Should successfully hover the News menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickMenuUnderNewsHoverOption' method", "Should hover the News menu and click the option", e.getMessage(), driver);
        }
    }

    public void clickSearchMenuAndEnterSearchText(String text,WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.id("txtSearch"), "");
            menu.click();
            menu.sendKeys(text);
            WebElement search = waitForPresenceOfElementLocatedBy(driver,BrowserName,(By.id("SmallSearchButton")), "");
            clickWithJavaScript(driver,search);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSearchMenuAndEnterSearchText", "Should successfully click the menu and entered the search text", "Successfully click the menu and entered the search text", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSearchMenuAndEnterSearchText' method", "Should click the menu and enter the search text", e.getMessage(), driver);
        }
    }

    public void clickSearchDropdownAndSelectPeople(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement people =waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//a[text()='People']"),"");
            clickWithJavaScript(driver, people);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSearchDropdownMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSearchDropdownMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickOnPortalFarm(WebDriver driver, String BrowserName) throws Exception{
        try {
            WebElement subsection = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//a[text()='portal_farm']"),"");
            clickWithJavaScript(driver,subsection);
            waitForPageToLoad();
            ResultUtil.report("PASS","Click on Portal Menu", "Should successfully click on the menu", "Successfully clicked on the menu", driver);
        }catch (Exception e){
            ResultUtil.report("FAIL","Exception occured in 'Click on Portal Menu' method", "Should successfully click on the menu", e.getMessage(), driver);
        }
    }

    public void clickOnUnfollowPortalFarm(WebDriver driver, String BrowserName) throws Exception{
        try {
            WebElement unfollow = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//span[text()='stop following this person']"),"");
            clickWithJavaScript(driver,unfollow);
            waitForPageToLoad();
            ResultUtil.report("PASS","Click on stop following this method", "Should successfully click on the stop following this method", "Successfully clicked on the unfollow link", driver);
        }catch (Exception e){
            ResultUtil.report("FAIL","Exception occurred in 'Click on unfollow Portal Farm' method", "Should successfully click on the unfollow link", e.getMessage(), driver);
        }
    }

    public void clickSettingsMenu(WebDriver driver,String BrowserName) throws Exception {
        try {
            WebElement settingsMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[contains(@id, 'SiteActionsMenu')]"), "");
            clickWithJavaScript(driver, settingsMenu);
            ResultUtil.report("PASS", "clickSettingsMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSettingsMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickOnSiteContents(WebDriver driver, String BrowserName)throws Exception{
        try {
            WebElement submenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Site contents']"), "");
            clickWithJavaScript(driver, submenu);
            ResultUtil.report("PASS","Click on site contents menu","Should click on site contents","Successfully click the site contents menu", driver);
        }catch (Exception e){
            ResultUtil.report("FAIL","Exception occurred at 'Click on site contents menu' method","Should click on site contents",e.getMessage(), driver);
        }
    }

    public void clickOnSitePages(WebDriver driver, String BrowserName)throws Exception{
        try {
            WebElement pages = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//a[@title='Site Pages']"),"");
            clickWithJavaScript(driver, pages);
            ResultUtil.report("PASS","Click on site pages","Should click on site pages","Successfully click the site pages", driver);
        }catch (Exception e){
            ResultUtil.report("FAIL","Exception occurred at 'Click on site pages' method","Should click on site pages",e.getMessage(), driver);
        }
    }

    public void clickPortalHomeMenu(WebDriver driver, String BrowserName)throws Exception{
        try {
            if(BrowserName.contains("safari")) {
                try {
                    WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[contains(text(),'Portal')]"), "");
                    clickWithJavaScript(driver, menu);
                    waitForPageToLoad();
                    waitInMilliSeconds(2000);
                    ResultUtil.report("PASS", "clickPortalHomeMenu", "Should successfully click the menu", "Successfully click the menu", driver);
                } catch (Exception e){
                    ResultUtil.report("PASS", "clickPortalHomeMenu", "Should successfully click the menu", "Successfully click the menu", driver);
                }
                } else {
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='Wiley Portal']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                waitInMilliSeconds(2000);
                ResultUtil.report("PASS", "clickPortalHomeMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickPortalHomeMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void sitesHomePortal(WebDriver driver)throws Exception{
        try {
            if ((findElementByNoThrow(driver, By.xpath("//a[text()='Women Leading Wiley']")) != null)) {
                ResultUtil.report("PASS", "verifySitesFollowingName", "Sites following name should be present", "Name is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifySitesFollowingName", "Sites following name should be present", "Name is Not present", driver);
            }
        }
    catch (Exception e){
            ResultUtil.report("FAIL","Exception occurred at Verifies the sites content", "Should verify the site content",e.getMessage(), driver);
        }
    }

    public void enterTextAndClickUser(WebDriver driver,String BrowserName, String text) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName, By.id("txtSearch"), "");
            menu.click();
            menu.sendKeys(text);
            waitInMilliSeconds(1000);
            List<WebElement> search = driver.findElements(By.xpath("//img[@id='PictureDiv1']"));
            WebElement picture = search.get(0);
            clickWithJavaScript(driver,picture);
            waitForPageToLoad();
            ResultUtil.report("PASS", "enterTextAndVerifyPhoneAndEmailMenu", "Should successfully entered the search text and verify the phone menu", "Successfully entered the search text and verified the phone menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterTextAndVerifyPhoneAndEmailMenu' method", "Should enter the search text and verify the phone menu", e.getMessage(), driver);
        }
    }

    public void verifyUserPicture(WebDriver driver) throws Exception {
        try {
            if ((driver.findElement(By.xpath("//img[contains(@src, 'jpg') and contains(@alt,'User')]")) != null)) {
                ResultUtil.report("PASS", "verifyUserPicture", "Picture should be present", "Picture is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyUserPicture", "Picture should be present", "Picture is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyUserPicture' method", "", "", driver);
        }
    }

    public void verifyEmailAddress(WebDriver driver) throws Exception {
        try {
            if ((driver.findElement(By.id("ProfileViewer_ValueWorkEmail")) != null)) {
                ResultUtil.report("PASS", "verifyEmailAddress", "Email should be present", "Email is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyEmailAddress", "Email should be present", "Email is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyEmailAddress' method", "", "", driver);
        }
    }

    public void clickDisasterMenuUnderFunctionsHoverOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement hoverMenu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Functions']"), "");
            WebElement hoverMenu1 = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Wiley Global Technology']"), "");
            Actions action = new Actions(driver);
            action.moveToElement(hoverMenu).moveToElement(hoverMenu1).build().perform();
//            action.moveToElement(hoverMenu1).build().perform();
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Disaster Recovery']"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickDisasterMenuUnderFunctionsHoverOption", "Should successfully hover the Functions menu and clicked the option", "Successfully hovered the Functions menu and clicked the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickDisasterMenuUnderFunctionsHoverOption' method", "Should hover the Functions menu and click the option", e.getMessage(), driver);
        }
    }

    public void verifyDisasterRecoveryPagePresence(WebDriver driver) throws Exception {
        try {
            if ((driver.findElement(By.xpath("//strong[contains (text(), 'Disaster Recovery')]")) != null)) {
                ResultUtil.report("PASS", "verifyDisasterRecoveryPagePresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyDisasterRecoveryPagePresence", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyDisasterRecoveryPagePresence' method", "", "", driver);
        }
    }

    public void clickSiteWorkflowsMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement newsMenu = waitForVisibilityOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Site Workflows']"));
            clickWithJavaScript(driver,newsMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSiteWorkflowsMenu", "Should successfully click the option", "Successfully clicked the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSiteWorkflowsMenu' method", "Should click the option", e.getMessage(), driver);
        }
    }

    public void verifyStartNewWorkflowMenuPresence(WebDriver driver) throws Exception {
        try {
            if ((findElementByNoThrow(driver,By.xpath("//h2[contains(text(), 'Start a New Workflow')]")) != null)) {
                ResultUtil.report("PASS", "verifyStartNewWorkflowMenuPresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyStartNewWorkflowMenuPresence", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyStartNewWorkflowMenuPresence' method", "", "", driver);
        }
    }

    public void clickAboutWileyMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement aboutWileyMenu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='About Wiley']"), "");
            clickWithJavaScript(driver, aboutWileyMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickAboutWileyMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAboutWileyMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void hoverAboutWileyDropdown(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='About Wiley']"), "");
                mouseHoverJScript(driver, dropDownMenu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "hoverAboutWileyDropdown", "Should successfully hover the AboutWileyDropdown menu", "Successfully hovered the AboutWileyDropdown menu", driver);
            }
            else {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='About Wiley']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(dropDownMenu).build().perform();
                waitForPageToLoad();
                ResultUtil.report("PASS", "hoverAboutWileyDropdown", "Should successfully hover the AboutWileyDropdown menu", "Successfully hovered the AboutWileyDropdown menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'hoverAboutWileyDropdown' method", "Should hover the AboutWileyDropdown menu", e.getMessage(), driver);
        }
    }

    public void hoverBusinessAndSelectKandL(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Business']"), "");
                mouseHoverJScript(driver,dropDownMenu);
                WebElement knowledge = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Knowledge and Learning']"), "");
                clickWithJavaScript(driver, knowledge);
                waitForPageToLoad();
                ResultUtil.report("PASS", "hoverBusinessAndSelectKandL", "Should successfully hover the Business menu", "Successfully hovered the Business menu", driver);
            }
            else {
                WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Business']"), "");
                Actions action = new Actions(driver);
                action.moveToElement(dropDownMenu).build().perform();
                WebElement knowledge = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Knowledge and Learning']"), "");
                clickWithJavaScript(driver, knowledge);
                waitForPageToLoad();
                ResultUtil.report("PASS", "hoverBusinessAndSelectKandL", "Should successfully hover the Business menu", "Successfully hovered the Business menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'hoverBusinessAndSelectKandL' method", "Should hover the Business menu", e.getMessage(), driver);
        }
    }

    public void verifyDeletePostCrossPresence(WebDriver driver, String value) throws Exception {
        try {
            if ((driver.findElement(By.xpath(".//*[text()='" + value + "']//..//..//*[@title='Delete this conversation']")) != null)) {
                waitInMilliSeconds(2000);
                ResultUtil.report("PASS", "verifyDeletePostCrossPresence", "DeletePostCross should be present", "DeletePostCross is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyDeletePostCrossPresence", "DeletePostCross should be present", "DeletePostCross is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyDeletePostCrossPresence' method", "", "", driver);
        }
    }

    public void DeletePostCross(WebDriver driver, String BrowserName, String value) throws Exception {
        try {
            WebElement cross = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//*[text()='" + value + "']//..//..//*[@title='Delete this conversation']"), "");
            clickWithJavaScript(driver,cross);
            waitForPageToLoad();
            ResultUtil.report("PASS", "DeletePostCross", "Should successfully click on Delete post cross", "Successfully clicked on Delete post cross", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'DeletePostCross' method", "Should click on Delete post cross", e.getMessage(), driver);
        }
    }

    public void ClickOnDeleteIt(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement delete = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[text()='Delete it']"), "");
            clickWithJavaScript(driver,delete);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "ClickOnDeleteIt", "Should successfully click on DeleteIt", "Successfully clicked on DeleteIt", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'ClickOnDeleteIt' method", "Should click on DeleteIt", e.getMessage(), driver);
        }
    }

    public void ClickOnCancel(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement cancel = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//*[text()='Cancel']"), "");
            clickWithJavaScript(driver,cancel);
            waitForPageToLoad();
            ResultUtil.report("PASS", "ClickOnCancel", "Should successfully click on Cancel", "Successfully clicked on Cancel", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'ClickOnCancel' method", "Should click on Cancel", e.getMessage(), driver);
        }
    }

    public void verifyPostDeletion(WebDriver driver, String value) throws Exception {
        try {
            if ((driver.findElements(By.xpath(".//*[text()='" + value + "']")).size() == 0)) {
                waitInMilliSeconds(2000);
                ResultUtil.report("PASS", "verifyPostDeletion", "Post should be deleted", "Post is deleted", driver);
            } else {
                ResultUtil.report("FAIL", "verifyPostDeletion", "Post should be deleted", "Post is Not deleted", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyPostDeletion' method", "", "", driver);
        }
    }

    public void verifyPostIsRetained(WebDriver driver,String value) throws Exception {
        try {
            if ((driver.findElement(By.xpath(".//*[text()='" + value + "']")) != null)) {
                waitInMilliSeconds(2000);
                ResultUtil.report("PASS", "verifyPostIsRetained", "Post should be retained", "Post is retained", driver);
            } else {
                ResultUtil.report("FAIL", "verifyPostIsRetained", "Post should be retained", "Post is Not retained", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyPostIsRetained' method", "", "", driver);
        }
    }

    public void verifyMenuAbsenceUnderWiley(WebDriver driver, String BrowserName) throws Exception {
        WebElement searchMenu = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath(".//*[@id='zz9_TopNavigationMenuV4']/div/ul/li/ul/li[8]/ul"));
        List<WebElement> displayList = searchMenu.findElements(By.tagName("li"));
        for (WebElement menu : displayList) {
            if (!ABOUT_WILEY_MENU_Absence.contains(menu.getText())) {
                ResultUtil.report("PASS", "verify: Wiley menu: " + menu.getText(), "Should NOThave the Wiley menu options from the List", "DoesNot Have the Wiley menu", driver);
            } else {
                ResultUtil.report("FAIL", "verify: Wiley menu: " + menu.getText(), "Should NOThave the Wiley menu options from the List", "Contain all the Wiley menu", driver);
            }
        }
    }

    public void clickEditPageMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement editPageMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Edit page']"), "");
            clickWithJavaScript(driver,editPageMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickEditPageMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickEditPageMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }
    public void verifyFontSize(WebDriver driver) throws Exception {
        try {
            waitInMilliSeconds(2000);
            String font = driver.findElement(By.id("footertext")).getCssValue("font-size");
            Assert.assertEquals("11px", font);
            ResultUtil.report("PASS", "verifyFontSize", "Should successfully verify the fontSize", "Successfully verified the fontSize", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyFontSize' method", "Should verify the fontSize", e.getMessage(), driver);
        }
    }

    public void verifyPPTIcon(WebDriver driver) throws Exception {
        try {
            if ((driver.findElement(By.xpath(".//*[@class='ms-srch-item-icon']//..//*[@class='ms-srch-ellipsis']")) != null)) {
                ResultUtil.report("PASS", "verifyPPTIcon", "PPT should be present", "PPT is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyPPTIcon", "PPT should be present", "PPT is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyPPTIcon' method", "", "", driver);
        }
    }

    public void verifyDocument(WebDriver driver) throws Exception {
        try {
            if ((findElementByNoThrow(driver, By.xpath(".//*[@class='ms-srch-item-icon']//..//*[@class='ms-srch-ellipsis']")) != null)) {
                ResultUtil.report("PASS", "verifyDocument", "Document should be present", "Document is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyDocument", "Document should be present", "Document is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyDocument' method", "", "", driver);
        }
    }

    public void verifyFollowedTagValues(WebDriver driver,String tag)throws Exception {
        try {
            if ((driver.findElement(By.xpath("//*[text()='" + tag + "']")) != null)) {
                ResultUtil.report("PASS", "verifyFollowedTagValues", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyFollowedTagValues", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyFollowedTagValues' method", "", "", driver);
        }
    }

    public void clickPortalMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//a[text()='Portal']"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickPortalMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickPortalMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickSettingsMenuInNewPage(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement settingsMenu = waitForPresenceOfElementLocatedBy(driver,BrowserName, By.id("zz13_SiteActionsMenu"), "");
            clickWithJavaScript(driver, settingsMenu);
            ResultUtil.report("PASS", "clickSettingsMenuInNewPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSettingsMenuInNewPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void enterTextAndVerifyPhoneMenu(WebDriver driver, String BrowserName,String text,String name) throws Exception {
        boolean phoneIcon = false;
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.id("txtSearch"), "");
            menu.click();
            menu.sendKeys(text);
            waitInMilliSeconds(1000);
            WebElement search = waitForVisibilityOfElementLocatedBy(driver, BrowserName, By.xpath("//a[contains(text(),'" +name+ "')]/../../div[@class='ExtensionNumer']"));
            phoneIcon = true;
            ResultUtil.report("PASS", "enterTextAndVerifyPhoneMenu", "Should successfully entered the search text and verify the phone menu", "Successfully entered the search text and verified the phone menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterTextAndVerifyPhoneMenu' method", "Should enter the search text and verify the phone menu", e.getMessage(), driver);
        }
    }

    public void FollowOneSection(WebDriver driver, String BrowserName) throws Exception{
        try {
            waitInMilliSeconds(1000);
            List<WebElement> section = waitForPresenceOfAllElementsLocatedBy(driver, BrowserName, By.xpath("//a[@class='link0']"));
            WebElement menu = section.get(0);
            clickWithJavaScript(driver,menu);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS","Click on the first subsection of people","Should click on the first subsection","Clicked on the first subsection",driver);
        }catch (Exception e){
            ResultUtil.report("FAIL","Exception at 'FollowOneSection' method","Should click on the first subsection",e.getMessage(),driver);
        }
    }

    public void UnFollowOneSubSection(WebDriver driver, String BrowserName) throws Exception{
        try {
            WebElement Stopfollowing = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='stop following this person']"), "");
            clickWithJavaScript(driver,Stopfollowing);
            waitInMilliSeconds(3000);
            ResultUtil.report("PASS","Click on stop following text","Should click on stop following","Clicked on stop following text", driver);
        }catch (Exception e){
            ResultUtil.report("FAIL","Exception at 'UnfollowSubSection' method","Should click on stop following",e.getMessage(),driver);
        }
    }

}










