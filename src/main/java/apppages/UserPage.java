package apppages;


import actions.ResultUtil;
import common.ExtendedLibrary;
import intialize.Prerequsite;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class UserPage extends ExtendedLibrary {

    public void clickSaveAndCloseButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement contact = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("ctl00_PlaceHolderMain_ProfileSave_Bottom"), "");
            clickWithJavaScript(driver, contact);
            ResultUtil.report("PASS", "clickContactInformationMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickContactInformationMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickOkButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement okMenu = waitFor1MinVisibilityOfElementLocatedBy(driver, BrowserName, By.id("ms-OkBtnDismissProfileSettingExitDlg"));
            clickWithJavaScript(driver, okMenu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickOkButton", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOkButton' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyOrgChartPresence(WebDriver driver) throws Exception{
        try {
            if ((findElementByNoThrow(driver,By.xpath("//*[text()='Org Chart']")) != null)) {
                ResultUtil.report("PASS", "verifyOrgChartPresence", "Org Chart should be present", "Org Chart is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyOrgChartPresence", "Org Chart should be present", "Org Chart is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyOrgChartPresence' method", "", "", driver);
        }
    }

    public void clickOnNewsFeedSettings(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement news = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("ID_OverflowOption_0"), "NewsFeedSettings option is not found");
            clickWithJavaScript(driver, news);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnNewsFeedSettings", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnNewsFeedSettings' method", "Should click on the NewsFeedSettings", "", driver);
        }
    }

    public void clickOnLanguageAndRegion(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement news = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[text()='Language and Region']"), "LanguageAndRegion option is not found");
            clickWithJavaScript(driver, news);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnLanguageAndRegion", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnLanguageAndRegion' method", "Should click on the LanguageAndRegion", "", driver);
        }
    }

    public void clickOnAddButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement add = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@value='Add']"), "Add option is not found");
            clickWithJavaScript(driver, add);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnAddButton", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnAddButton' method", "Should click on the Add", "", driver);
        }
    }

    public void checkOrUnCheckPeopleIFollow(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement people = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("ctl00_PlaceHolderMain_ProfileEditorEditSPS-PrivacyPeople"), "NewsFeedSettings option is not found");
            clickWithJavaScript(driver, people);
            waitForPageToLoad();
            ResultUtil.report("PASS", "checkOrUnCheckPeopleIFollow", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'checkOrUnCheckPeopleIFollow' method", "Should click on the NewsFeedSettings", "", driver);
        }
    }

    public void clickLanguageDropdownAndChooseValue(String value, WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement language = waitForVisibilityOfElementLocatedBy(driver, BrowserName, By.id("ctl00_PlaceHolderMain_ProfileEditorEditSPS-MUILanguages_DdlAnotherDisplayLanguage"));
            Select searchLanguageSelect = new Select(language);
            searchLanguageSelect.selectByVisibleText(value);
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SECOND")));
            ResultUtil.report("PASS", "clickLanguageDropdownAndChooseValue", "Should click the Language Dropdown Button and select the option", "Language Dropdown Button has been clicked and option has been selected", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickLanguageDropdownAndChooseValue' method", "Language Dropdown Button to be selected and choose the option", "", driver);
        }
    }

    public void removeLanguage(String value, WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement lang = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[text()='" + value + "']//..//*[@id='RemoveElementLink_am-ET']"), "Custom Properties option is not found");
            clickWithJavaScript(driver, lang);
            waitForPageToLoad();
            ResultUtil.report("PASS", "removeLanguage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnCustomProperties' method", "Should click on the Custom Properties", "", driver);
        }
    }

    public void clickOnFollowedTagsTextBox(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@class= 'valid-text']"), "");
            clickWithJavaScript(driver, menu);
            ResultUtil.report("PASS", "verify the followed tags", "Should successfully view the following tags", "Successfully viewed the following tags", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "verify the followed tags", "Should successfully view the following tags", "Failed to view the following tags", driver);
        }
    }

    public void verifySaveAndCloseButtonPresence(WebDriver driver) throws  Exception{
        try {
            if ((driver.findElement(By.xpath("//*[@id='ctl00_PlaceHolderMain_ProfileSave_Bottom']")) != null)) {
                ResultUtil.report("PASS", "verifySaveAndCloseButtonPresence", "SaveAndCloseButton should be present", "SaveAndCloseButton is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifySaveAndCloseButtonPresence", "SaveAndCloseButton should be present", "SaveAndCloseButton is Not present", driver);
            }
            waitInMilliSeconds(2000);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifySaveAndCloseButtonPresence' method", "", "", driver);
        }
    }

    public void clickCancelAndGoBackButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement contact = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("ctl00_PlaceHolderMain_ProfileCancel_Bottom"), "");
            clickWithJavaScript(driver,contact);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickContactInformationMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickContactInformationMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyCancelAndGoBackButtonPresence(WebDriver driver) throws  Exception{
        try {
            if ((driver.findElement(By.xpath(".//*[@id='ctl00_PlaceHolderMain_ProfileCancel_Bottom']")) != null)) {
                ResultUtil.report("PASS", "verifyCancelAndGoBackButtonPresence", "CancelAndGoBackButton should be present", "CancelAndGoBackButton is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyCancelAndGoBackButtonPresence", "CancelAndGoBackButton should be present", "CancelAndGoBackButton is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyCancelAndGoBackButtonPresence' method", "", "", driver);
        }
    }

    public void clickContactInformationMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement contact = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='Contact Information']"), "");
            clickWithJavaScript(driver,contact);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickContactInformationMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickContactInformationMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void editMobileNumber(WebDriver driver, String BrowserName, String number) throws Exception {
        try {
            WebElement mobile = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("ctl00_PlaceHolderMain_ProfileEditorEditCellPhone"), "Mobile phone text box is not found");
            mobile.clear();
            mobile.sendKeys(number);
            ResultUtil.report("PASS", "editMobileNumber", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'editMobileNumber' method", "Should edit the mobile number", "", driver);
        }
    }

    public void clickOnCustomProperties(WebDriver driver, String BrowserName) throws  Exception{
        try {
            WebElement custom = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("ID_OverflowOption_2"), "Custom Properties option is not found");
            clickWithJavaScript(driver,custom);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnCustomProperties", "Should successfully click the menu", "Successfully click the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnCustomProperties' method", "Should click on the Custom Properties", "", driver);
        }
    }

    public void clickSeeMoreMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement seeMore = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//a[text()='See more']"), "See More option is not found");
            clickWithJavaScript(driver,seeMore);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSeeMoreMenu", "Should successfully click the menu", "Successfully click the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSeeMoreMenu' method", "Should click on the SeeMoreMenu", "", driver);
        }
    }

    public void verifySilverLightView(WebDriver driver, String BrowserName) throws Exception {
        try {
            if ((findElementByNoThrow(driver,By.id("ProfileBrowserSilverlightControl")) != null)) {
                ResultUtil.report("PASS", "verifySilverLightView", "SilverLightView should be seen", "SilverLightView is seen", driver);
            } else {
                WebElement silverLight = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[text()='Silverlight View']"), "SilverLightView option is not found");
                clickWithJavaScript(driver,silverLight);
                waitForPageToLoad();
                ResultUtil.report("FAIL", "verifySilverLightView", "SilverLightView should be clicked", "SilverLightView is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifySilverLightView' method", "", "", driver);
        }
    }

    public void verifyHTMLView(WebDriver driver, String BrowserName) throws Exception {
        try {
            if ((findElementByNoThrow(driver,By.id("ProfileBrowserSilverlightControl")) != null)) {
                WebElement silverLight = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[text()='HTML View']"), "HTMLView option is not found");
                clickWithJavaScript(driver,silverLight);
                waitForPageToLoad();
                waitInMilliSeconds(2000);
                ResultUtil.report("PASS", "verifyHTMLView", "Org Chart should be present", "HTMLView is seen", driver);
            } else {
                ResultUtil.report("FAIL", "verifyHTMLView", "HTMLView should be clicked", "HTMLView is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyHTMLView' method", "", "", driver);
        }
    }

}












