package apppages;


import actions.ResultUtil;
import common.ExtendedLibrary;
import intialize.Prerequsite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;


public class WikiPage extends ExtendedLibrary {
    public static String PageName;

    public void clickSiteContentsOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement siteContent = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[text()='Site contents']"), "");
            clickWithJavaScript(driver,siteContent);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSiteContentsOption", "Should successfully click the Option", "Successfully click the Option", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSiteContentsOption' Option", "Should click the Option", e.getMessage(), driver);
        }
    }

    public void clickSitePagesOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement sitePage = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@title='Site Pages']"), "");
            clickWithJavaScript(driver,sitePage);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSitePagesOption", "Should successfully click the Option", "Successfully click the Option", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSitePagesOption' Option", "Should click the Option", e.getMessage(), driver);
        }
    }

    public void clickSaveButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement save = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//*[text()='Save']"));
            clickWithJavaScript(driver,save);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSaveButton", "Should successfully click the Button", "Successfully click the Button", driver);
            waitInMilliSeconds(3000);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSaveButton' method", "Should click the Button", e.getMessage(), driver);
        }
    }

    public void selectFirstSitePage(WebDriver driver) throws Exception {
        try {
            List<WebElement> articleIdCheckboxes = driver.findElements(By.xpath("//*[@role='checkbox']"));
            WebElement page = articleIdCheckboxes.get(0);
            page.click();
            ResultUtil.report("PASS", "selectFirstSitePage", "First Site Page should be selected", "First Site Page is selected", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'selectFirstSitePage' method", "First Site Page checkbox to be selected", "There are no site pages", driver);
        }
    }

    public void clickFilesMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement file = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[text()='Files']"), "");
            clickWithJavaScript(driver,file);
            ResultUtil.report("PASS", "clickFilesMenu", "Should successfully click the Files", "Successfully click the Menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickFilesMenu' method", "Should click the Files Menu", e.getMessage(), driver);
        }
    }

    public void clickPageMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement page = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[text()='Page']"), "");
            clickWithJavaScript(driver, page);
            ResultUtil.report("PASS", "clickPageMenu", "Should successfully click the Files", "Successfully click the Menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickPageMenu' method", "Should click the Files Menu", e.getMessage(), driver);
        }
    }

    public void verifyPublishMenuPresence(WebDriver driver)throws Exception {
        try {
            if ((driver.findElement(By.xpath(".//span[text()='Publish']")) != null)) {
                ResultUtil.report("PASS", "verifyPublishMenuPresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyPublishMenuPresence", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyPublishMenuPresence' method", "", "", driver);
        }
    }

    public void clickOnExistingPage(WebDriver driver, String BrowserName,String value) throws Exception {
        try {
            WebElement doc = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[text()='" +PageName+ "']"), "");
            clickWithJavaScript(driver,doc);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnExistingPage", "Should successfully click the ExistingPage", "Successfully click the ExistingPage", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnExistingPage' method", "Should click the ExistingPage", e.getMessage(), driver);
        }
    }

    public void clickOnEditLink(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement edit = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Edit']"), "");
            clickWithJavaScript(driver,edit);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnEditLink", "Should successfully click the EditLink", "Successfully click the EditLink", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnEditLink' method", "Should click the EditLink", e.getMessage(), driver);
        }
    }

    public void clickOnInsertMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement insert = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[text()='Insert']"), "");
            clickWithJavaScript(driver,insert);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnInsertMenu", "Should successfully click the InsertMenu", "Successfully click the InsertMenu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnInsertMenu' method", "Should click the InsertMenu", e.getMessage(), driver);
        }
    }

    public void clickOnAddLinkOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement link = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[text()='Link']"), "");
            clickWithJavaScript(driver,link);
            waitForPageToLoad();
            WebElement fromAdd = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[text()='From Address']"), "");
            clickWithJavaScript(driver,fromAdd);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickOnInsertMenu", "Should successfully click the InsertMenu", "Successfully click the InsertMenu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnInsertMenu' method", "Should click the InsertMenu", e.getMessage(), driver);
        }
    }

    public void addLinkToWikiPage(WebDriver driver, String BrowserName,String text, String link)throws Exception {

        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.className("ms-dlgFrame"),"");
            driver.switchTo().frame(iframeElement);
            WebElement enterText = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.id("ctl00_PlaceHolderMain_StrFirst"), "");
            enterText.click();
            enterText.sendKeys(text);
            waitInMilliSeconds(2000);
            WebElement enterLink = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.id("ctl00_PlaceHolderMain_StrSecond"), "");
            enterLink.click();
            enterLink.sendKeys(link);
            WebElement ok = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@value='OK']"), "");
            clickWithJavaScript(driver,ok);
            driver.switchTo().defaultContent();
            ResultUtil.report("PASS", "addLinkToWikiPage", "Should successfully Add Link to the Page", "Successfully Added Link to the Page ", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'addLinkToWikiPage' method", "Should successfully Add Link to the Page", e.getMessage(), driver);
        }
    }

    public void clickAddNewDocument (WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement doc = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//span[text()='new document']"), "");
            clickWithJavaScript(driver, doc);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickAddNewDocument", "Should successfully click the AddNewDocument", "Successfully click the AddNewDocument", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAddNewDocument' method", "Should click the AddNewDocument", e.getMessage(), driver);
        }
    }

    public void enterPageName(String page,WebDriver driver, String BrowserName) throws Exception  {
        try {
            WebElement pageName = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.id("ctl00_PlaceHolderMain_nameInput"), "Page Name text box is not found");
            pageName.click();
            PageName=page+getRandomCode();
            pageName.sendKeys(PageName);
            ResultUtil.report("PASS", "enterPageName", "Should successfully enter the Page name", "Successfully entered the Page name", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterPageName' method", "Should enter the Page name", "", driver);
        }
    }

    public void enterPageContent(String page,WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                try {
                    WebElement pageContent = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@role='textbox']"), "Page Content text box is not found");
//            pageContent.click();
                    pageContent.sendKeys(page);
                    waitInMilliSeconds(2000);
                } catch (Exception e){
                    ResultUtil.report("PASS", "enterPageContent", "Should enter the Page Content", "", driver);
                }
            } else{
                WebElement pageContent = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@role='textbox']"), "Page Content text box is not found");
//            pageContent.click();
                pageContent.sendKeys(page);
                waitInMilliSeconds(2000);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterPageContent' method", "Should enter the Page Content", "", driver);
        }
    }

    public void clickCreateButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement create = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//*[@value='Create']"), "");
            clickWithJavaScript(driver,create);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickCreateButton", "Should successfully click the Button", "Successfully clicked the Create Button", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickCreateButton' method", "Should clicked the Create Button", e.getMessage(), driver);
        }

    }

    public void selectBoldOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement bold = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//label[text()='Bold']"), "");
            clickWithJavaScript(driver,bold);
            ResultUtil.report("PASS", "selectBoldOption", "Should successfully click the BoldOption", "Successfully clicked the BoldOption", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'selectBoldOption' method", "Should clicked the BoldOption", e.getMessage(), driver);
        }
    }

    public void selectStyles(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement style = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//*[text()='Heading 1']"), "");
            clickWithJavaScript(driver,style);
            ResultUtil.report("PASS", "selectStyles", "Should successfully Select the Styles", "Successfully Select the Styles", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'selectStyles' method", "Should Select the Styles", e.getMessage(), driver);
        }
    }
}