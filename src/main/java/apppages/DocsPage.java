package apppages;


import actions.ResultUtil;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.sun.imageio.plugins.wbmp.WBMPImageReader;
import common.ExtendedLibrary;
import intialize.Prerequsite;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;


public class DocsPage extends ExtendedLibrary {

  public static String DOC_Menu;

    File picfile = new File("src//main//java//resources//Jellyfish.jpg");

//
//    public void clickAddNewDocument() {
//        try {
//            WebElement doc = waitForPresenceOfElementLocatedBy(By.xpath(".//span[text()='new document']"), "");
//            clickWithJavaScript(doc);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickAddNewDocument", "Should successfully click the AddNewDocument", "Successfully click the AddNewDocument", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickAddNewDocument' method", "Should click the AddNewDocument", e.getMessage(), driver);
//        }
//    }
//
//    public void verifyDocumentTypes() {
//
//        boolean Word = false;
//        boolean Excel = false;
//        boolean PowerPoint = false;
//        boolean OneNote = false;
//        boolean NewFolder = false;
//        try {
//            driver.findElement(By.id("js-newdocWOPI-divWord-txt-WPQ2"));
//            Word = true;
//            driver.findElement(By.id("js-newdocWOPI-divExcel-txt-WPQ2"));
//            Excel = true;
//            driver.findElement(By.id("js-newdocWOPI-divPowerPoint-txt-WPQ2"));
//            PowerPoint = true;
//            driver.findElement(By.id("js-newdocWOPI-divOneNote-txt-WPQ2"));
//            OneNote = true;
//            driver.findElement(By.id("js-newdocWOPI-divFolder-txt-WPQ2"));
//            NewFolder = true;
//            ResultUtil.report("PASS", "verifyDocumentTypes", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "Exception occurred in 'verifyDocumentTypes' method", "", "", driver);
//        }
//    }
//
//    public void clickOnWordDocument() {
//        try {
//            WebElement doc = waitForPresenceOfElementLocatedBy(By.id("js-newdocWOPI-divWord-txt-WPQ2"), "");
//            clickWithJavaScript(doc);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickOnWordDocument", "Should successfully click the WordDocument", "Successfully click the WordDocument", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnWordDocument' method", "Should click the WordDocument", e.getMessage(), driver);
//        }
//    }
//
//    public void clickOnUploadExistingFile() {
//        try {
//            WebElement doc = waitForPresenceOfElementLocatedBy(By.xpath(".//*[text()='Upload existing file']"), "");
//            clickWithJavaScript(doc);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickOnUploadExistingFile", "Should successfully click the UploadExistingFile", "Successfully click the UploadExistingFile", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnUploadExistingFile' method", "Should click the UploadExistingFile", e.getMessage(), driver);
//        }
//    }
//
//    public void clickOnNewFolder() {
//        try {
//            WebElement folder = waitForPresenceOfElementLocatedBy(By.id("js-newdocWOPI-divFolder-txt-WPQ2"), "");
//            clickWithJavaScript(folder);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickOnNewFolder", "Should successfully click the newFolder", "Successfully click the newFolder", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnNewFolder' method", "Should click the newFolder", e.getMessage(), driver);
//        }
//    }
//
//    public void enterDocumentName(String title) {
//
//        try {
//            WebElement iframeElement = waitForPresenceOfElementLocatedBy(By.className("ms-dlgFrame"), "");
//            getDriver().switchTo().frame(iframeElement);
//            WebElement enterText = waitForPresenceOfElementLocatedBy(By.id("ctl00_PlaceHolderMain_ctl00_ctl01_textBoxFileName"), "");
//            enterText.click();
//            enterText.sendKeys(title);
//            waitInMilliSeconds(2000);
//            WebElement clickOk = waitForPresenceOfElementLocatedBy(By.id("ctl00_PlaceHolderMain_buttonSectionMain_RptControls_buttonOK"), "");
//            clickOk.click();
//            driver.switchTo().defaultContent();
//            ResultUtil.report("PASS", "enterDocumentName", "Should successfully enter the document name", "Successfully entered the document name ", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'enterDocumentName' method", "Should successfully enter the document name", e.getMessage(), driver);
//        }
//    }
//
//    public void enterFolderName(String title) {
//
//        try {
//            /*WebElement iframeElement = waitForPresenceOfElementLocatedBy(By.xpath("./*//*[@frameborder='0']"),"");
//            getDriver().switchTo().frame(iframeElement);*/
//            WebElement iframeElement = waitForPresenceOfElementLocatedBy(By.className("ms-dlgFrame"), "");
//            getDriver().switchTo().frame(iframeElement);
//            WebElement enterText = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@title='Name Required Field']"), "");
//            enterText.sendKeys(title);
//            waitInMilliSeconds(2000);
//            WebElement clickSave = waitForPresenceOfElementLocatedBy(By.id("ctl00_ctl32_g_43a84f98_7640_4738_a320_a644ee50b46d_ctl00_toolBarTbltop_RightRptControls_ctl01_ctl00_diidIOSaveItem"), "");
//            clickWithJavaScript(clickSave);
//            driver.switchTo().defaultContent();
//            ResultUtil.report("PASS", "enterFolderName", "Should successfully enter the Folder name", "Successfully entered the Folder name ", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'enterFolderName' method", "Should successfully enter the Folder name", e.getMessage(), driver);
//        }
//    }
//
    public void clickOkButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement ok = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@value='OK']"), "");
            clickWithJavaScript(driver,ok);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOkButton", "Should successfully click the Button", "Successfully click the Button", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOkButton' method", "Should click the Button", e.getMessage(), driver);
        }

    }

    public void clickDeleteButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement delete = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@value='Delete']"), "");
            delete.click();
            waitInMilliSeconds(1000);
            Alert alert = driver.switchTo().alert();
            alert.accept();
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickDeleteButton", "Should successfully click the Button", "Successfully click the Button", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickDeleteButton' method", "Should click the Button", e.getMessage(), driver);
        }

    }
//
//    public void clickSaveButton() {
//        try {
//            WebElement save = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@id='qatSave-Small']"), "");
//            clickWithJavaScript(save);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickOkButton", "Should successfully click the Button", "Successfully click the Button", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOkButton' method", "Should click the Button", e.getMessage(), driver);
//        }
//
//    }
//
//    public void saveTheDocument() {
//        try {
//            WebElement iframeElement = waitForPresenceOfElementLocatedBy(By.id("WebApplicationFrame"), "");
//            getDriver().switchTo().frame(iframeElement);
//            waitInMilliSeconds(2000);
//            WebElement save = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@id='qatSave-Small']"), "");
//            clickWithJavaScript(save);
//            waitForPageToLoad();
//            WebElement exit = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@id='WACRibbon-close']"), "");
//            clickWithJavaScript(exit);
//            waitForPageToLoad();
//            driver.switchTo().defaultContent();
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'saveTheDocument' method", "Should save the document ", "", driver);
//        }
//    }
//
//    public void clickOnExistingDocument(String value) {
//        try {
//            WebElement doc = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@title='" + value + "']//..//..//*[@title='Open Menu']"), "");
//            clickWithJavaScript(doc);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickOnExistingDocument", "Should successfully click the ExistingDocument", "Successfully click the ExistingDocument", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnExistingDocument' method", "Should click the ExistingDocument", e.getMessage(), driver);
//        }
//    }
//
//
//    public void clickOnExistingFolder(String value) {
//        try {
//            WebElement doc = waitForPresenceOfElementLocatedBy(By.xpath(".//a[text()='Test Analysis']//..//..//..//img[@alt='Open Menu']"), "");
//            clickWithJavaScript(doc);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickOnExistingDocument", "Should successfully click the ExistingDocument", "Successfully click the ExistingDocument", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnExistingDocument' method", "Should click the ExistingDocument", e.getMessage(), driver);
//        }
//    }
//
//    public void verifyEditOverlayOptions() {
//
//        boolean Edit = false;
//        boolean Share = false;
//        boolean Follow = false;
//        try {
//            driver.findElement(By.xpath(".//a[text()='Edit']"));
//            Edit = true;
//            driver.findElement(By.xpath(".//a[text()='Share']"));
//            Share = true;
//            driver.findElement(By.xpath(".//a[text()='Follow']"));
//            Follow = true;
//            ResultUtil.report("PASS", "verifyEditOverlayOptions", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "Exception occurred in 'verifyEditOverlayOptions' method", "", "", driver);
//        }
//    }
//
//    public void clickOnEditLink() {
//        try {
//            WebElement edit = waitForPresenceOfElementLocatedBy(By.xpath(".//a[text()='Edit']"), "");
//            clickWithJavaScript(edit);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickOnEditLink", "Should successfully click the EditLink", "Successfully click the EditLink", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnEditLink' method", "Should click the EditLink", e.getMessage(), driver);
//        }
//    }
//
//    public void clickOnOpenMenu() {
//        try {
//            WebElement open = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@class='js-callout-footerArea']//..//a[@title='Open Menu']"), "");
//            clickWithJavaScript(open);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickOnOpenMenu", "Should successfully click the OpenMenu", "Successfully click the OpenMenu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnOpenMenu' method", "Should click the OpenMenu", e.getMessage(), driver);
//        }
//    }
//
//    public void clickFolderOpenMenu() {
//        try {
//            WebElement open = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@class='js-ellipsis25-icon']//..//img[@alt='Open Menu']"), "");
//            clickWithJavaScript(open);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickOnOpenMenu", "Should successfully click the OpenMenu", "Successfully click the OpenMenu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnOpenMenu' method", "Should click the OpenMenu", e.getMessage(), driver);
//        }
//    }
//
//    public void selectCheckOut() {
//        try {
//            WebElement open = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@id='ID_Checkout']"), "");
//            clickWithJavaScript(open);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "selectCheckOut", "Should successfully click the OpenMenu", "Successfully click the OpenMenu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'selectCheckOut' method", "Should click the OpenMenu", e.getMessage(), driver);
//        }
//    }
//
//    public void selectCheckIn() {
//        try {
//            WebElement open = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@id='ID_Checkin']"), "");
//            clickWithJavaScript(open);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "selectCheckOut", "Should successfully click the OpenMenu", "Successfully click the OpenMenu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'selectCheckOut' method", "Should click the OpenMenu", e.getMessage(), driver);
//        }
//    }
//
//    public void clickOnCheckInOk() {
//
//        try {
//            /*WebElement iframeElement = waitForPresenceOfElementLocatedBy(By.xpath("./*//*[@frameborder='0']"),"");
//            getDriver().switchTo().frame(iframeElement);*/
//            WebElement iframeElement = waitForPresenceOfElementLocatedBy(By.className("ms-dlgFrame"), "");
//            getDriver().switchTo().frame(iframeElement);
//            WebElement clickSave = waitForPresenceOfElementLocatedBy(By.id("CheckinOk"), "");
//            clickWithJavaScript(clickSave);
//            driver.switchTo().defaultContent();
//            ResultUtil.report("PASS", "clickOnCheckInOk", "Should successfully click the CheckInOK", "Successfully entered the Folder name ", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnCheckInOk' method", "Should successfully click the CheckInOK ", e.getMessage(), driver);
//        }
//    }
//
//    public void clickOnCheckedInDocument(String value) {
//        try {
//            WebElement doc = waitForPresenceOfElementLocatedBy(By.xpath(".//*[text()='" + value + "']//..//..//..//*[@title='Open Menu']"), "");
//            clickWithJavaScript(doc);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickOnCheckedInDocument", "Should successfully click the CheckedInDocument", "Successfully click the ExistingDocument", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnCheckedInDocument' method", "Should click the CheckedInDocument", e.getMessage(), driver);
//        }
//    }
//
//    public void clickPortalMenu() {
//        try {
//            WebElement portalMenu = waitForPresenceOfElementLocatedBy(By.xpath(".//*[text()='Portal']"), "");
//            clickWithJavaScript(portalMenu);
//            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
//            ResultUtil.report("PASS", "clickPortalMenu", "Should successfully click the PortalMenu", "Successfully click the PortalMenu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickPortalMenu' method", "Should click the PortalMenu", e.getMessage(), driver);
//        }
//    }
//
//    public void selectViewProperties() {
//        try {
//            WebElement view = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@id='ID_ViewProperties']"), "");
//            clickWithJavaScript(view);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "selectViewProperties", "Should successfully click the ViewProperties", "Successfully click the ViewProperties", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'selectViewProperties' method", "Should click the ViewProperties", e.getMessage(), driver);
//        }
//    }
//
//    public void selectEditProperties() {
//        try {
//            WebElement edit = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@id='ID_EditProperties']"), "");
//            clickWithJavaScript(edit);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "selectEditProperties", "Should successfully click the EditProperties", "Successfully click the EditProperties", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'selectEditProperties' method", "Should click the EditProperties", e.getMessage(), driver);
//        }
//    }
//
//    public void clickDownloadACopyMenu() {
//        try {
//            if (BrowserName.contains("ie")) {
//                WebElement exportMenu = waitForVisibilityOfElementLocatedBy(By.xpath(".//*[@id='ID_DownloadACopy']"));
//                clickWithJavaScript(exportMenu);
//                waitInMilliSeconds(2000);
//                Robot robot = new Robot();
//                // Pressing ALT + S to save the download
//                robot.keyPress(KeyEvent.VK_ALT);
//                robot.keyPress(KeyEvent.VK_S);
//                robot.keyRelease(KeyEvent.VK_ALT);
//                robot.keyRelease(KeyEvent.VK_S);
//                // Pressing ALT + Q to close the popup
//                waitInMilliSeconds(2000);
//                robot.keyPress(KeyEvent.VK_ALT);
//                robot.keyPress(KeyEvent.VK_Q);
//                robot.keyRelease(KeyEvent.VK_ALT);
//                robot.keyRelease(KeyEvent.VK_Q);
//                ResultUtil.report("SCREENSHOT", "Able to click the Export Menu", "", "", driver);
//
//            } else {
//                WebElement exportMenu = waitForVisibilityOfElementLocatedBy(By.xpath(".//*[@id='ID_DownloadACopy']"));
//                clickWithJavaScript(exportMenu);
//                waitForPageToLoad();
//                ResultUtil.report("SCREENSHOT", "Able to click the Export Menu", "", "", driver);
//            }
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickExportMenuToExportFile' in Compensation Info", "Export Menu to be selected", "", driver);
//        }
//    }
//
//    public void deleteDocument() {
//        try {
//            WebElement delete = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@id='ID_DeleteDocItem']"), "");
//            clickWithJavaScript(delete);
//            waitInMilliSeconds(1000);
//            Alert alert = driver.switchTo().alert();
//            alert.accept();
//            ResultUtil.report("PASS", "deleteDocument", "Should successfully click the DeleteOption", "Successfully click the DeleteOption", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'deleteDocument' method", "Should click the DeleteOption", e.getMessage(), driver);
//        }
//    }
//
    public String verifyCheckBoxesOfDocuments(WebDriver driver) throws Exception{
        try {
            List<WebElement> allCheckboxes = driver.findElements(By.xpath(".//*[@role='checkbox']"));
            if (allCheckboxes.size() > 0) {
                ResultUtil.report("PASS", "verifyCheckBoxesOfDocuments", "CheckBoxes should be verified.", "", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyCheckBoxesOfDocuments' method", "CheckBoxes should be verified.", "", driver);
        }
        return "";
    }

    public void clickOnViewSelectorMenu(WebDriver driver, String BrowserName) throws Exception  {
        try {
            WebElement view = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[text()='All']//..//*[@alt='Open Menu']"), "");
            clickWithJavaScript(driver,view);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnViewSelectorMenu", "Should successfully click the ViewSelectorMenu", "Successfully click the ViewSelectorMenu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnViewSelectorMenu' method", "Should click the ViewSelectorMenu", e.getMessage(), driver);
        }
    }

    public void clickOnCreateView(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement view = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//*[text()='Create View']"), "");
            clickWithJavaScript(driver,view);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnCreateView", "Should successfully click the CreateView", "Successfully click the CreateView", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnCreateView' method", "Should click the CreateView", e.getMessage(), driver);
        }

    }

    public void clickOnModifyView(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement view = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//*[text()='Modify this View']"), "");
            clickWithJavaScript(driver,view);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnModifyView", "Should successfully click the ModifyView", "Successfully click the ModifyView", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnModifyView' method", "Should click the ModifyView", e.getMessage(), driver);
        }

    }

    public void clickOnDataSheetView(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement view = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.id("onetCategoryGrid"), "");
            clickWithJavaScript(driver,view);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnDataSheetView", "Should successfully click the DataSheetView", "Successfully click the DataSheetView", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnDataSheetView' method", "Should click the DataSheetView", e.getMessage(), driver);
        }
    }

    public void enterViewName(WebDriver driver, String BrowserName,String view) throws Exception {
        try {
            WebElement viewName = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.id("ViewName"), "Title Name text box is not found");
            viewName.click();
            viewName.clear();
            viewName.sendKeys(view);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterViewName' method", "Should enter the view name", "", driver);
        }
    }

//    public void clickDocumentOptionMenu(String name) {
//        try {
//            List<WebElement> newsFeedMenu = waitForPresenceOfAllElementsLocatedBy(By.xpath("//a[text()='" + name + "']//..//..//following-sibling::td//a[@title='Open Menu']"));
//            WebElement menu = newsFeedMenu.get(0);
//            clickWithJavaScript(menu);
//            waitInMilliSeconds(1000);
//            ResultUtil.report("PASS", "clickDocumentOptionMenu", "Should successfully click the menu", "Successfully click the menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickDocumentOptionMenu' method", "Should click the menu", e.getMessage(), driver);
//        }
//    }
//
//    public void clickFollowMenu() {
//        try {
//            WebElement menu = waitForPresenceOfElementLocatedBy(By.xpath("//a[text()='Follow']"), "");
//            clickWithJavaScript(menu);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickFollowMenu", "Should successfully click the menu", "Successfully click the menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickFollowMenu' method", "Should click the menu", e.getMessage(), driver);
//        }
//    }
//
//    public void clickWileyPortalMenu() {
//        try {
//            WebElement portalMenu = waitForPresenceOfElementLocatedBy(By.xpath("//a[text()='Portal']"), "");
//            clickWithJavaScript(portalMenu);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickWileyPortalMenu", "Should successfully click the menu", "Successfully click the menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickWileyPortalMenu' method", "Should click the menu", e.getMessage(), driver);
//        }
//    }
//
//    public void verifyDocInFollowingMenu() {
//        try {
//            if ((findElementByNoThrow(By.xpath("//a[text()='Test M.docx']")) != null)) {
//                ResultUtil.report("PASS", "verifyDocInFollowingMenu", "Groups option menu should be present", "Groups option menu is present", driver);
//            } else {
//                ResultUtil.report("FAIL", "verifyDocInFollowingMenu", "Groups option menu should be present", "Groups option menu is Not present", driver);
//            }
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "Exception occurred in 'verifyDocInFollowingMenu' method", "", "", driver);
//        }
//    }
//
//    public void clickDocumentsMenu() {
//        try {
//            WebElement menu = waitForPresenceOfElementLocatedBy(By.xpath("//a[text()='Documents']"), "");
//            clickWithJavaScript(menu);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickDocumentsMenu", "Should successfully click the menu", "Successfully click the menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickDocumentsMenu' method", "Should click the menu", e.getMessage(), driver);
//        }
//    }
//
//
//    public void uploadFile(String fileNameWithAbsolutePath) {
//        try {
//            WebElement iframeElement = waitForPresenceOfElementLocatedBy(By.className("ms-dlgFrame"), "");
//            getDriver().switchTo().frame(iframeElement);
//            WebElement uploadButton = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@id='ctl00_PlaceHolderMain_ctl01_ctl04_InputFile']//..//input"), "Unable to find browse element.");
//            uploadButton.sendKeys(fileNameWithAbsolutePath);
//            WebElement ok = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@value='OK']"), "");
//            clickWithJavaScript(ok);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "uploadFile", "File should be uploaded", "File is uploaded", driver);
//            waitForPageToLoad();
//            driver.switchTo().defaultContent();
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'uploadFile' method", "File should be uploaded", e.getMessage(), driver);
//        }
//    }
//
//    public void checkExistingDocument(String value) {
//        try {
//            WebElement doc = waitForPresenceOfElementLocatedBy(By.xpath(".//div[@title='" + value + "']//..//..//div[@role='checkbox']"), "");
//            clickWithJavaScript(doc);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickOnExistingDocument", "Should successfully click the ExistingDocument", "Successfully click the ExistingDocument", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnExistingDocument' method", "Should click the ExistingDocument", e.getMessage(), driver);
//        }
//    }
//
//    public void clickOnFileMenu() {
//        try {
//            WebElement file = waitForPresenceOfElementLocatedBy(By.xpath(".//*[text()='Files']"), "");
//            clickWithJavaScript(file);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickOnFileMenu", "Should successfully clickOnFileMenu", "Successfully clickOnFileMenu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnFileMenu' method", "Should clickOnFileMenu", e.getMessage(), driver);
//        }
//    }
//
//    public void clickOnSendToOption() {
//        try {
//            WebElement link = waitForPresenceOfElementLocatedBy(By.xpath(".//span[text()='Send To ']"), "");
//            clickWithJavaScript(link);
//            waitForPageToLoad();
//            WebElement otherLoc = waitForPresenceOfElementLocatedBy(By.xpath(".//*[text()='Other Location']"), "");
//            clickWithJavaScript(otherLoc);
//            waitInMilliSeconds(2000);
//            ResultUtil.report("PASS", "clickOnSendToOption", "Should successfully click the SendToOption", "Successfully click the SendToOption", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnSendToOption' method", "Should click the SendToOption", e.getMessage(), driver);
//        }
//    }
//
//    public void sendToOtherLocation() {
//
//        try {
//            WebElement iframeElement = waitForPresenceOfElementLocatedBy(By.className("ms-dlgFrame"), "");
//            getDriver().switchTo().frame(iframeElement);
//            WebElement ok = waitForPresenceOfElementLocatedBy(By.xpath(".//*[@value='OK']"), "");
//            clickWithJavaScript(ok);
//            driver.switchTo().defaultContent();
//            WebElement iframElement = waitForPresenceOfElementLocatedBy(By.className("ms-dlgFrame"), "");
//            getDriver().switchTo().frame(iframElement);
//            WebElement copyOk = waitForPresenceOfElementLocatedBy(By.id("ctl00_PlaceHolderMain_ctl19_RptControls_BtnCopyOk"), "");
//            clickWithJavaScript(copyOk);
//            driver.switchTo().defaultContent();
//            WebElement iframesElement = waitForPresenceOfElementLocatedBy(By.className("ms-dlgFrame"), "");
//            getDriver().switchTo().frame(iframesElement);
//            WebElement done = waitFor1MinVisibilityOfElementLocatedBy(By.id("ctl00_PlaceHolderMain_ctl00_RptControls_done_LinkText"));
//            clickWithJavaScript(done);
//            driver.switchTo().defaultContent();
//            ResultUtil.report("PASS", "sendToOtherLocation", "Should successfully sendToOtherLocation", "Successfully sendToOtherLocation", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'sendToOtherLocation' method", "Should successfully sendToOtherLocation", e.getMessage(), driver);
//        }
//    }
//
//    public void verifyManageCopiesMenu() {
//        try {
//            if ((findElementByNoThrow(By.xpath(".//*[text()='Manage Copies']")) != null)) {
//                ResultUtil.report("PASS", "verifyManageCopiesMenu", "ManageCopies  menu should be present", "ManageCopies  menu is present", driver);
//            } else {
//                ResultUtil.report("FAIL", "verifyManageCopiesMenu", "ManageCopies  menu should be present", "ManageCopies  menu is Not present", driver);
//            }
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "Exception occurred in 'verifyManageCopiesMenu' method", "", "", driver);
//        }
//    }
//
//    public void verifyGoToSourceMenu() {
//        try {
//            if ((findElementByNoThrow(By.xpath(".//*[text()='Go To Source']")) != null)) {
//                ResultUtil.report("PASS", "verifyGoToSourceMenu", "GoToSource  menu should be present", "GoToSource  menu is present", driver);
//            } else {
//                ResultUtil.report("FAIL", "verifyGoToSourceMenu", "GoToSource  menu should be present", "GoToSource  menu is Not present", driver);
//            }
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "Exception occurred in 'verifyGoToSourceMenu' method", "", "", driver);
//        }
//    }
//
//    public void clickOnOpenTitleMenu(String title) {
//        try {
//            WebElement openMenu = waitForPresenceOfElementLocatedBy(By.xpath("//a[text()='" + title + "']/../../following-sibling::td//*[@title='Open Menu']"), "");
//            openMenu.click();
//            waitInMilliSeconds(2000);
//            WebElement menu = waitForVisibilityOfElementLocatedBy(By.xpath("//img[@class='js-ellipsis25-icon']"));
//            clickWithJavaScript(menu);
//            ResultUtil.report("PASS", "clickOnOpenTitleMenu", "Should successfully click the menu", "Successfully click the menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnOpenTitleMenu' method", "Should click the menu", e.getMessage(), driver);
//        }
//    }
//
//    public void clickCheckInCheckOutMenu() {
//        try {
//            List<WebElement> newsFeedMenu = waitForPresenceOfAllElementsLocatedBy(By.cssSelector(".ms-core-menu-title"));
//            WebElement menu = newsFeedMenu.get(2);
//            clickWithJavaScript(menu);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickCheckInCheckOutMenu", "Should successfully click the menu", "Successfully click the menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickCheckInCheckOutMenu' method", "Should click the menu", e.getMessage(), driver);
//        }
//    }
//
//    public void enterCommentAndClickOkMenu(String text) {
//        try {
//            WebElement iframeElement = waitForPresenceOfElementLocatedBy(By.className("ms-dlgFrame"), "");
//            getDriver().switchTo().frame(iframeElement);
//            WebElement comment = waitForVisibilityOfElementLocatedBy(By.cssSelector("#CheckinDescription"));
//            comment.sendKeys(text);
//            WebElement menu = waitForVisibilityOfElementLocatedBy(By.cssSelector("#CheckinOk"));
//            clickWithJavaScript(menu);
//            driver.switchTo().defaultContent();
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "enterCommentAndClickOnMenu", "Should successfully click the menu", "Successfully click the menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'enterCommentAndClickOnMenu' method", "Should click the menu", e.getMessage(), driver);
//        }
//    }
//
//    public void clickLibraryMenu() {
//        try {
//            WebElement file = waitForPresenceOfElementLocatedBy(By.xpath("//span[text()='Library']"), "");
//            clickWithJavaScript(file);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickLibraryMenu", "Should successfully click on Library menu", "Successfully click on Library menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickLibraryMenu' method", "Should click on Library menu", e.getMessage(), driver);
//        }
//    }
//
//    public void clickRssFeedMenu() {
//        try {
//            WebElement menu = waitForPresenceOfElementLocatedBy(By.id("Ribbon.Library.Share.ViewRSSFeed-Large"), "");
//            clickWithJavaScript(menu);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickRssFeedMenu", "Should successfully click the menu", "Successfully click the menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickRssFeedMenu' method", "Should click the menu", e.getMessage(), driver);
//        }
//    }
//
//    public void verifyConnectToOutlookMenu() {
//        try {
//            if ((findElementByNoThrow(By.id("Ribbon.Library.Actions.ConnectToClient-Large")) != null)) {
//                ResultUtil.report("PASS", "verifyConnectToOutlookMenu", "Menu should be present", "Menu is present", driver);
//            } else {
//                ResultUtil.report("FAIL", "verifyConnectToOutlookMenu", "Menu should be present", "Menu is Not present", driver);
//            }
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "Exception occurred in 'verifyConnectToOutlookMenu' method", "", "", driver);
//        }
//    }
//
//    public void verifyOpenWithExplorerMenu() {
//        try {
//            if ((findElementByNoThrow(By.xpath("//span[text()='Open with Explorer']")) != null)) {
//                ResultUtil.report("PASS", "verifyOpenWithExplorerMenu", "Menu should be present", "Menu is present", driver);
//            } else {
//                ResultUtil.report("FAIL", "verifyOpenWithExplorerMenu", "Menu should be present", "Menu is Not present", driver);
//            }
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "Exception occurred in 'verifyOpenWithExplorerMenu' method", "", "", driver);
//        }
//    }
//
//    public void clickFormWebPartsMenu() {
//        try {
//            WebElement menu = waitForPresenceOfElementLocatedBy(By.id("Ribbon.Library.CustomizeLibrary.EditDefaultForms-Large"), "");
//            menu.click();
//            WebElement subMenu = waitForVisibilityOfElementLocatedBy(By.xpath("//span[text()='Default Display Form']"));
//            clickWithJavaScript(subMenu);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickFormWebPartsMenu", "Should successfully click the menu", "Successfully click the menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickFormWebPartsMenu' method", "Should click the menu", e.getMessage(), driver);
//        }
//    }
//
//    public void clickStopEditingMenu() {
//        try {
//            WebElement menu = waitForVisibilityOfElementLocatedBy(By.xpath("//span[text()='Stop']"));
//            clickWithJavaScript(menu);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickStopEditingMenu", "Should successfully click the menu", "Successfully click the menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickStopEditingMenu' method", "Should click the menu", e.getMessage(), driver);
//        }
//    }
//
//    public void verifyNewQuickStepMenu() {
//        try {
//            if ((findElementByNoThrow(By.id("Ribbon.Library.CustomizeLibrary.AddButton-Large")) != null)) {
//                ResultUtil.report("PASS", "verifyNewQuickStepMenu", "Menu should be present", "Menu is present", driver);
//            } else {
//                ResultUtil.report("FAIL", "verifyNewQuickStepMenu", "Menu should be present", "Menu is Not present", driver);
//            }
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "Exception occurred in 'verifyNewQuickStepMenu' method", "", "", driver);
//        }
//    }
//
//    public void verifyEditLibraryMenu() {
//        try {
//            if ((findElementByNoThrow(By.id("Ribbon.Library.CustomizeLibrary.EditList-Large")) != null)) {
//                ResultUtil.report("PASS", "verifyEditLibraryMenu", "Menu should be present", "Menu is present", driver);
//            } else {
//                ResultUtil.report("FAIL", "verifyEditLibraryMenu", "Menu should be present", "Menu is Not present", driver);
//            }
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "Exception occurred in 'verifyEditLibraryMenu' method", "", "", driver);
//        }
//    }
//
//    public void clickLibrarySettingsMenu() {
//        try {
//            WebElement menu = waitForPresenceOfElementLocatedBy(By.id("Ribbon.Library.Settings.DocumentLibrarySettings-Large"), "");
//            clickWithJavaScript(menu);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickLibrarySettingsMenu", "Should successfully click on Library settings menu", "Successfully click on Library settings menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickLibrarySettingsMenu' method", "Should click on Library settings menu", e.getMessage(), driver);
//        }
//    }
//
//    public void clickPermissionMenu() {
//        try {
//            WebElement menu = waitForPresenceOfElementLocatedBy(By.xpath("//a[text()='Permissions for this document library']"), "");
//            clickWithJavaScript(menu);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickPermissionMenu", "Should successfully click on Permission menu", "Successfully click on Permission menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickPermissionMenu' method", "Should click on Permission menu", e.getMessage(), driver);
//        }
//    }
//
//    public void clickGrantPermissionMenu() {
//        try {
//            WebElement menu = waitForPresenceOfElementLocatedBy(By.id("Ribbon.Permission.Add.AddUser-Large"), "");
//            clickWithJavaScript(menu);
//            waitForPageToLoad();
//            ResultUtil.report("PASS", "clickGrantPermissionMenu", "Should successfully click on Permission menu", "Successfully click on Permission menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickGrantPermissionMenu' method", "Should click on Permission menu", e.getMessage(), driver);
//        }
//    }
//
//    public void enterEmailAddress(String email) {
//        try {
//            WebElement iframeElement = waitForPresenceOfElementLocatedBy(By.className("ms-dlgFrame"), "");
//            getDriver().switchTo().frame(iframeElement);
//            WebElement enterText = waitForVisibilityOfElementLocatedBy(By.id("ctl00_PlaceHolderMain_peoplePicker_TopSpan"));
//            enterText.sendKeys(Keys.RETURN);
//            enterText.sendKeys(email);
//            WebElement element = driver.findElement(By.id("ctl00_PlaceHolderMain_peoplePicker_TopSpan"));
//            JavascriptExecutor executor = (JavascriptExecutor) driver;
//            executor.executeScript("arguments[0].setAttribute('value', 'textBoxValue')", element);
//            waitInMilliSeconds(1000);
//            WebElement shareMenu = waitForPresenceOfElementLocatedBy(By.xpath("//input[@value='Share']"), "");
//            shareMenu.click();
//            waitForPageToLoad();
//            driver.switchTo().defaultContent();
//            ResultUtil.report("PASS", "enterEmailAddress", "Should successfully enter the document name", "Successfully entered the document name ", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'enterEmailAddress' method", "Should successfully enter the document name", e.getMessage(), driver);
//        }
//    }
//
//    public void clickUsernameCheckbox() {
//        try {
//            List<WebElement> usernameMenu = waitForPresenceOfAllElementsLocatedBy(By.xpath("//input[@name='PrincipalId']"));
//            WebElement menu = usernameMenu.get(0);
//            clickWithJavaScript(menu);
//            ResultUtil.report("PASS", "clickUsernameCheckbox", "Should successfully click the menu", "Successfully click the menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickUsernameCheckbox' method", "Should click the menu", e.getMessage(), driver);
//        }
//    }
//
//    public void clickRemovePermissionMenu() {
//        try {
//            WebElement menu = waitForVisibilityOfElementLocatedBy(By.id("Ribbon.Permission.Modify.RemovePerms-Large"));
//            menu.click();
//            waitInMilliSeconds(1000);
//            Alert alert = driver.switchTo().alert();
//            alert.accept();
//            ResultUtil.report("PASS", "clickRemovePermissionMenu", "Should successfully click on Permission menu", "Successfully click on Permission menu", driver);
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'clickRemovePermissionMenu' method", "Should click on Permission menu", e.getMessage(), driver);
//        }
//    }
//
//    public void clickOnExistingDocument() {
//        try {
//            List<WebElement> allCheckboxes = waitForPresenceOfAllElementsLocatedBy(By.xpath(".//*[@role='checkbox']"));
//            WebElement menu = allCheckboxes.get(0);
//            clickWithJavaScript(menu);
//            ResultUtil.report("PASS", "ClickOnExistingDocument", "Should successfully click On Existing Document", "Successfully click the first Existing Document", driver);
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'ClickOnExistingDocument' method", "Should click the Existing Document", e.getMessage(), driver);
//        }
//    }
//
//    public void verifyEmailLinkMenu() {
//        try {
//            if ((findElementByNoThrow(By.id("Ribbon.Library.Share.EmailLibraryLink-Large")) != null))
//            {
//                ResultUtil.report("PASS", "verifyEmailLinkMenu", "Menu should be present", "Menu is present", driver);
//            } else {
//                ResultUtil.report("FAIL", "verifyEmailLinkMenu", "Menu should be present", "Menu is Not present", driver);
//            }
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'verifyEmailLinkMenu' method", "Should verify the menu", e.getMessage(), driver);
//        }
//    }

    public void verifyManageCopiesMenu(WebDriver driver)throws  Exception{
        try {
            if ((driver.findElement(By.xpath(".//*[text()='Manage Copies']")) != null)) {
                ResultUtil.report("PASS", "verifyManageCopiesMenu", "ManageCopies  menu should be present", "ManageCopies  menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyManageCopiesMenu", "ManageCopies  menu should be present", "ManageCopies  menu is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyManageCopiesMenu' method", "", "", driver);
        }
    }

    public void verifyGoToSourceMenu(WebDriver driver)throws  Exception {
        try {
            if ((driver.findElement(By.xpath(".//*[text()='Go To Source']")) != null)) {
                ResultUtil.report("PASS", "verifyGoToSourceMenu", "GoToSource  menu should be present", "GoToSource  menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyGoToSourceMenu", "GoToSource  menu should be present", "GoToSource  menu is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyGoToSourceMenu' method", "", "", driver);
        }
    }

    public void verifyEmailLinkMenu(WebDriver driver)throws  Exception{
        try {
            if ((driver.findElement(By.id("Ribbon.Library.Share.EmailLibraryLink-Large")) != null))
            {
                ResultUtil.report("PASS", "verifyEmailLinkMenu", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyEmailLinkMenu", "Menu should be present", "Menu is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyEmailLinkMenu' method", "Should verify the menu", e.getMessage(), driver);
        }
    }

    public void verifyExportToExcel(WebDriver driver)throws Exception{
        try {
            if ((driver.findElement(By.xpath("//span[text()='Export to Excel']")) != null))
            {
                ResultUtil.report("PASS", "verifyExportToExcel", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyExportToExcel", "Menu should be present", "Menu is Not present", driver);
            }
        }catch (Exception e){
            ResultUtil.report("FAIL", "verifyExportToExcel", "Menu should be present", "Menu is Not present", driver);
        }
    }

    public void enterEmailAddress(WebDriver driver, String BrowserName,String email)throws Exception{
        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.className("ms-dlgFrame"), "");
            driver.switchTo().frame(iframeElement);
            WebElement enterText = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.id("ctl00_PlaceHolderMain_peoplePicker_TopSpan"));
            enterText.sendKeys(Keys.RETURN);
            enterText.sendKeys(email);
            WebElement element = driver.findElement(By.id("ctl00_PlaceHolderMain_peoplePicker_TopSpan"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].setAttribute('value', 'textBoxValue')", element);
            waitInMilliSeconds(1000);
            WebElement shareMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//input[@value='Share']"), "");
            shareMenu.click();
            waitForPageToLoad();
            driver.switchTo().defaultContent();
            ResultUtil.report("PASS", "enterEmailAddress", "Should successfully enter the document name", "Successfully entered the document name ", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterEmailAddress' method", "Should successfully enter the document name", e.getMessage(), driver);
        }
    }

    public void clickAddNewDocument(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement doc = waitFor1MinVisibilityOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@id='js-newdocWOPI-Hero-WPQ2']/span[2]"));
                doc.click();
                waitForPageToLoad();
                waitInMilliSeconds(3000);
                ResultUtil.report("PASS", "clickAddNewDocument", "Should successfully click the AddNewDocument", "Successfully click the AddNewDocument", driver);
            } else {
                WebElement doc = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='new document']"), "");
                clickWithJavaScript(driver, doc);
                waitForPageToLoad();
                waitInMilliSeconds(3000);
//            waitForVisibilityOfElementLocatedBy(driver, BrowserName, By.id("cojs-newdocWOPI-WPQ2_callout-content"));
                ResultUtil.report("PASS", "clickAddNewDocument", "Should successfully click the AddNewDocument", "Successfully click the AddNewDocument", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAddNewDocument' method", "Should click the AddNewDocument", e.getMessage(), driver);
        }
    }

    public void clickOnNewFolder(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement folder = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//h3[text()='New folder']"), "");
            clickWithJavaScript(driver, folder);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickOnNewFolder", "Should successfully click the newFolder", "Successfully click the newFolder", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnNewFolder' method", "Should click the newFolder", e.getMessage(), driver);
        }
    }

    public void enterFolderName(WebDriver driver, String BrowserName,String title) throws Exception {
        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.className("ms-dlgFrame"), "");
            driver.switchTo().frame(iframeElement);
            WebElement enterText = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@title='Name Required Field']"), "");
            clickWithJavaScript(driver,enterText);
            DOC_Menu = title + getRandomCode();
            enterText.sendKeys(DOC_Menu);
            waitInMilliSeconds(2000);
            WebElement clickSave = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//input[contains(@id,'SaveItem')]"), "");
            clickWithJavaScript(driver, clickSave);
            driver.switchTo().defaultContent();
            ResultUtil.report("PASS", "enterFolderName", "Should successfully enter the Folder name", "Successfully entered the Folder name ", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterFolderName' method", "Should successfully enter the Folder name", e.getMessage(), driver);
        }
    }

    public void saveTheDocument(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver, BrowserName,(By.id("WebApplicationFrame")), "");
            driver.switchTo().frame(iframeElement);
            WebElement save = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//*[@id='qatSave-Small']"), "");
            clickWithJavaScript(driver, save);
            waitInMilliSeconds(2000);
            WebElement exit = waitForPresenceOfElementLocatedBy(driver, BrowserName,(By.xpath("//*[@id='WACRibbon-close']")), "");
            clickWithJavaScript(driver, exit);
            waitForPageToLoad();
            driver.switchTo().defaultContent();

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'saveTheDocument' method", "Should save the document ", "", driver);
        }
    }

    public void clickOnExistingFolder(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement doc = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//a[text()='" +DOC_Menu+ "']//..//..//..//img[@alt='Open Menu']"), "");
            clickWithJavaScript(driver, doc);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnExistingDocument", "Should successfully click the ExistingDocument", "Successfully click the ExistingDocument", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnExistingDocument' method", "Should click the ExistingDocument", e.getMessage(), driver);
        }
    }

    public void verifyEditOverlayOptions(WebDriver driver, String BrowserName)throws Exception{

        boolean Edit = false;
        boolean Share = false;
        boolean Follow = false;
        try {
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='Edit']"), "");
            Edit = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='Share']"), "");
            Share = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='Follow']"), "");
            Follow = true;
            ResultUtil.report("PASS", "verifyEditOverlayOptions", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyEditOverlayOptions' method", "", "", driver);
        }
    }

    public void clickOnEditLink(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement edit = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//a[text()='Edit']"), "");
            clickWithJavaScript(driver, edit);
            waitForPageToLoad();
            waitInMilliSeconds(1000);
            ResultUtil.report("PASS", "clickOnEditLink", "Should successfully click the EditLink", "Successfully click the EditLink", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnEditLink' method", "Should click the EditLink", e.getMessage(), driver);
        }
    }

    public void clickOnOpenMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement open = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@class='js-callout-footerArea']//..//a[@title='Open Menu']"), "");
            clickWithJavaScript(driver,open);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnOpenMenu", "Should successfully click the OpenMenu", "Successfully click the OpenMenu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnOpenMenu' method", "Should click the OpenMenu", e.getMessage(), driver);
        }
    }

    public void clickFolderOpenMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement open = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//*[@class='js-ellipsis25-icon']//..//img[@alt='Open Menu']"), "");
            clickWithJavaScript(driver,open);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickFolderOpenMenu", "Should successfully click the OpenMenu", "Successfully click the OpenMenu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickFolderOpenMenu' method", "Should click the OpenMenu", e.getMessage(), driver);
        }
    }

    public void selectCheckOut(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement open = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@id='ID_Checkout']"), "");
            clickWithJavaScript(driver,open);
            waitForPageToLoad();
            ResultUtil.report("PASS", "selectCheckOut", "Should successfully click the OpenMenu", "Successfully click the OpenMenu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'selectCheckOut' method", "Should click the OpenMenu", e.getMessage(), driver);
        }
    }

    public void selectCheckIn(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement open = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@id='ID_Checkin']"), "");
            clickWithJavaScript(driver,open);
            waitForPageToLoad();
            ResultUtil.report("PASS", "selectCheckOut", "Should successfully click the OpenMenu", "Successfully click the OpenMenu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'selectCheckOut' method", "Should click the OpenMenu", e.getMessage(), driver);
        }
    }

    public void clickOnCheckInOk(WebDriver driver, String BrowserName) throws Exception {

        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.className("ms-dlgFrame"), "");
            getDriver().switchTo().frame(iframeElement);
            WebElement clickSave = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("CheckinOk"), "");
            clickWithJavaScript(driver,clickSave);
            driver.switchTo().defaultContent();
            ResultUtil.report("PASS", "clickOnCheckInOk", "Should successfully click the CheckInOK", "Successfully entered the Folder name ", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnCheckInOk' method", "Should successfully click the CheckInOK ", e.getMessage(), driver);
        }
    }

    public void clickOnCheckedInDocument(WebDriver driver, String BrowserName,String value) throws Exception {
        try {
            WebElement doc = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[text()='"+value+"']//..//..//..//*[@title='Open Menu']"), "");
            clickWithJavaScript(driver,doc);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnCheckedInDocument", "Should successfully click the CheckedInDocument", "Successfully click the ExistingDocument", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnCheckedInDocument' method", "Should click the CheckedInDocument", e.getMessage(), driver);
        }
    }

    public void deleteDocument(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement delete = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[@id='ID_DeleteDocItem']"), "");
            delete.click();
            waitInMilliSeconds(2000);
            Alert alert = driver.switchTo().alert();
            alert.accept();
            ResultUtil.report("PASS", "deleteDocument", "Should successfully click the DeleteOption", "Successfully click the DeleteOption", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'deleteDocument' method", "Should click the DeleteOption", e.getMessage(), driver);
        }
    }

    public void clickOnExistingDocument(WebDriver driver) throws Exception {
        try {
            List<WebElement> allCheckboxes = driver.findElements(By.xpath("//*[@role='checkbox']"));
            WebElement menu = allCheckboxes.get(3);
            menu.click();
            ResultUtil.report("PASS", "ClickOnExistingDocument", "Should successfully click On Existing Document", "Successfully click the first Existing Document", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'ClickOnExistingDocument' method", "Should click the Existing Document", e.getMessage(), driver);
        }
    }

    public void clickOpenMenu(WebDriver driver,String BrowserName) throws Exception {
        try {
            List<WebElement> flyOverMenu = waitForPresenceOfAllElementsLocatedBy(driver, BrowserName, By.xpath("//*[@alt='Open Menu']"));
            WebElement menu = flyOverMenu.get(6);
            clickWithJavaScript(driver,menu);
            ResultUtil.report("PASS", "clickOnOpenMenu", "Should successfully click On Existing Document", "Successfully click the first Existing Document", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnOpenMenu' method", "Should click the Existing Document", e.getMessage(), driver);
        }
    }

    public void clickExistingDocument(WebDriver driver, String BrowserName,String value ) throws Exception {
        try {
//            WebElement doc = driver.findElement(By.xpath("//div[@title='" + value + "']//../..//div[@role='checkbox']"));
//            WebElement doc = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//div[@title='Test MM']/span"), "");
//            clickWithJavaScript(driver, doc);
            List<WebElement> docs = waitForPresenceOfAllElementsLocatedBy(driver,BrowserName,By.xpath("//*[@role='checkbox']"));
            WebElement document = docs.get(3);
            document.click();
//            waitInMilliSeconds(2000);
//            document = driver.findElements(By.xpath("//input[@type='password']")).get(3);
//            waitForVisibilityOfElement(driver,BrowserName,document);
//            clickWithJavaScript(driver,document);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnExistingDocument", "Should successfully click the ExistingDocument", "Successfully click the ExistingDocument", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnExistingDocument' method", "Should click the ExistingDocument", e.getMessage(), driver);
        }
    }

    public void clickOnFileMenu(WebDriver driver, String BrowserName) throws Exception  {
        try {
            WebElement file = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[text()='Files']"), "");
            clickWithJavaScript(driver,file);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnFileMenu", "Should successfully clickOnFileMenu", "Successfully clickOnFileMenu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnFileMenu' method", "Should clickOnFileMenu", e.getMessage(), driver);
        }
    }

    public void clickOnSendToOption(WebDriver driver, String BrowserName) throws Exception  {
        try {
            WebElement link = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Send To ']"), "");
            clickWithJavaScript(driver,link);
            waitForPageToLoad();
            WebElement otherLoc = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[text()='Other Location']"), "");
            clickWithJavaScript(driver,otherLoc);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickOnSendToOption", "Should successfully click the SendToOption", "Successfully click the SendToOption", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnSendToOption' method", "Should click the SendToOption", e.getMessage(), driver);
        }
    }

    public void sendToOtherLocation(WebDriver driver, String BrowserName)throws Exception {

        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.className("ms-dlgFrame"), "");
            driver.switchTo().frame(iframeElement);
            WebElement ok = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@value='OK']"), "");
            clickWithJavaScript(driver,ok);
            driver.switchTo().defaultContent();
            WebElement iframElement = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.className("ms-dlgFrame"), "");
            driver.switchTo().frame(iframElement);
            WebElement copyOk = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.id("ctl00_PlaceHolderMain_ctl19_RptControls_BtnCopyOk"), "");
            clickWithJavaScript(driver,copyOk);
            driver.switchTo().defaultContent();
            WebElement iframesElement = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.className("ms-dlgFrame"), "");
            driver.switchTo().frame(iframesElement);
            WebElement done = waitFor1MinVisibilityOfElementLocatedBy(driver,BrowserName,By.id("ctl00_PlaceHolderMain_ctl00_RptControls_done_LinkText"));
            clickWithJavaScript(driver,done);
            driver.switchTo().defaultContent();
            ResultUtil.report("PASS", "sendToOtherLocation", "Should successfully sendToOtherLocation", "Successfully sendToOtherLocation", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'sendToOtherLocation' method", "Should successfully sendToOtherLocation", e.getMessage(), driver);
        }
    }

//    public void verifyManageCopiesMenu() {
//        try {
//            if ((findElementByNoThrow(By.xpath(".//*[text()='Manage Copies']")) != null)) {
//                ResultUtil.report("PASS", "verifyManageCopiesMenu", "ManageCopies  menu should be present", "ManageCopies  menu is present", driver);
//            } else {
//                ResultUtil.report("FAIL", "verifyManageCopiesMenu", "ManageCopies  menu should be present", "ManageCopies  menu is Not present", driver);
//            }
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "Exception occurred in 'verifyManageCopiesMenu' method", "", "", driver);
//        }
//    }
//
//    public void verifyGoToSourceMenu() {
//        try {
//            if ((findElementByNoThrow(By.xpath(".//*[text()='Go To Source']")) != null)) {
//                ResultUtil.report("PASS", "verifyGoToSourceMenu", "GoToSource  menu should be present", "GoToSource  menu is present", driver);
//            } else {
//                ResultUtil.report("FAIL", "verifyGoToSourceMenu", "GoToSource  menu should be present", "GoToSource  menu is Not present", driver);
//            }
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "Exception occurred in 'verifyGoToSourceMenu' method", "", "", driver);
//        }
//    }

    public void clickOnExistingDocument(WebDriver driver,String BrowserName,String value) {
        try {
            WebElement doc = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@title='" + value + "']//..//..//*[@title='Open Menu']"), "");
            clickWithJavaScript(driver,doc);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnExistingDocument", "Should successfully click the ExistingDocument", "Successfully click the ExistingDocument", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnExistingDocument' method", "Should click the ExistingDocument", e.getMessage(), driver);
        }
    }

    public void clickPortalMenu(WebDriver driver,String BrowserName) {
        try {
            WebElement portalMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//*[text()='Portal']"), "");
            clickWithJavaScript(driver,portalMenu);
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            ResultUtil.report("PASS", "clickPortalMenu", "Should successfully click the PortalMenu", "Successfully click the PortalMenu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickPortalMenu' method", "Should click the PortalMenu", e.getMessage(), driver);
        }
    }

    public void selectViewProperties(WebDriver driver,String BrowserName) {
        try {
            WebElement view = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//*[@id='ID_ViewProperties']"), "");
            clickWithJavaScript(driver,view);
            waitForPageToLoad();
            ResultUtil.report("PASS", "selectViewProperties", "Should successfully click the ViewProperties", "Successfully click the ViewProperties", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'selectViewProperties' method", "Should click the ViewProperties", e.getMessage(), driver);
        }
    }

    public void selectEditProperties(WebDriver driver,String BrowserName) {
        try {
            WebElement edit = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@id='ID_EditProperties']"), "");
            clickWithJavaScript(driver,edit);
            waitForPageToLoad();
            ResultUtil.report("PASS", "selectEditProperties", "Should successfully click the EditProperties", "Successfully click the EditProperties", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'selectEditProperties' method", "Should click the EditProperties", e.getMessage(), driver);
        }
    }

    public void clickDownloadACopyMenu(WebDriver driver,String BrowserName) {
        try {
            if (BrowserName.contains("ie")) {
                WebElement exportMenu = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@id='ID_DownloadACopy']"));
                clickWithJavaScript(driver,exportMenu);
                waitInMilliSeconds(2000);
                Robot robot = new Robot();
                // Pressing ALT + S to save the download
                robot.keyPress(KeyEvent.VK_ALT);
                robot.keyPress(KeyEvent.VK_S);
                robot.keyRelease(KeyEvent.VK_ALT);
                robot.keyRelease(KeyEvent.VK_S);
                // Pressing ALT + Q to close the popup
                waitInMilliSeconds(2000);
                robot.keyPress(KeyEvent.VK_ALT);
                robot.keyPress(KeyEvent.VK_Q);
                robot.keyRelease(KeyEvent.VK_ALT);
                robot.keyRelease(KeyEvent.VK_Q);
                ResultUtil.report("SCREENSHOT", "Able to click the Export Menu", "", "", driver);

            } else {
                WebElement exportMenu = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@id='ID_DownloadACopy']"));
                clickWithJavaScript(driver,exportMenu);
                waitForPageToLoad();
                ResultUtil.report("SCREENSHOT", "Able to click the Export Menu", "", "", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickExportMenuToExportFile' in Compensation Info", "Export Menu to be selected", "", driver);
        }
    }

    public void clickOnOpenTitleMenu(String title, WebDriver driver,String BrowserName) {
        try {
            WebElement openMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//a[text()='"+title+"']/../../following-sibling::td//*[@title='Open Menu']"), "");
            openMenu.click();
            waitInMilliSeconds(2000);
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.xpath("//img[@class='js-ellipsis25-icon']"));
            clickWithJavaScript(driver,menu);
            ResultUtil.report("PASS", "clickOnOpenTitleMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnOpenTitleMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }
    //
    public void clickCheckInCheckOutMenu(WebDriver driver) throws Exception{
        try {
            List<WebElement> newsFeedMenu = driver.findElements(By.cssSelector(".ms-core-menu-title"));
            WebElement menu = newsFeedMenu.get(2);
//            clickWithJavaScript(driver,menu);
            menu.click();
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickCheckInCheckOutMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickCheckInCheckOutMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void enterCommentAndClickOkMenu(String text, WebDriver driver,String BrowserName) {
        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.className("ms-dlgFrame"), "");
            driver.switchTo().frame(iframeElement);
            WebElement comment = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.cssSelector("#CheckinDescription"));
            comment.sendKeys(text);
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.cssSelector("#CheckinOk"));
            menu.click();
            driver.switchTo().defaultContent();
            waitForPageToLoad();
            ResultUtil.report("PASS", "enterCommentAndClickOnMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterCommentAndClickOnMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

//    public void verifyEmailLinkMenu() {
//        try {
//            if ((findElementByNoThrow(By.id("Ribbon.Library.Share.EmailLibraryLink-Large")) != null))
//            {
//                ResultUtil.report("PASS", "verifyEmailLinkMenu", "Menu should be present", "Menu is present", driver);
//            } else {
//                ResultUtil.report("FAIL", "verifyEmailLinkMenu", "Menu should be present", "Menu is Not present", driver);
//            }
//
//        } catch (Exception e) {
//            ResultUtil.report("FAIL", "EXCEPTION at 'verifyEmailLinkMenu' method", "Should verify the menu", e.getMessage(), driver);
//        }
//    }

    public void verifyDocumentTypes(WebDriver driver, String BrowserName) {

        boolean Word = false;
        boolean Excel = false;
        boolean PowerPoint = false;
        boolean OneNote = false;
        boolean NewFolder = false;
        try {
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("js-newdocWOPI-divWord-txt-WPQ2"), "");
            Word = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("js-newdocWOPI-divExcel-txt-WPQ2"),"");
            Excel = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("js-newdocWOPI-divPowerPoint-txt-WPQ2"), "");
            PowerPoint = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("js-newdocWOPI-divOneNote-txt-WPQ2"), "");
            OneNote = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("js-newdocWOPI-divFolder-txt-WPQ2"), "");
            NewFolder = true;
            ResultUtil.report("PASS", "verifyDocumentTypes", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyDocumentTypes' method", "", "", driver);
        }
    }

    public void clickOnWordDocument(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement doc = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.id("js-newdocWOPI-divWord-txt-WPQ2"), "");
            clickWithJavaScript(driver, doc);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickOnWordDocument", "Should successfully click the WordDocument", "Successfully click the WordDocument", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnWordDocument' method", "Should click the WordDocument", e.getMessage(), driver);
        }
    }

    public void enterDocumentName(WebDriver driver, String BrowserName,String title) throws Exception {
        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.className("ms-dlgFrame"), "");
            driver.switchTo().frame(iframeElement);
            WebElement enterText = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.id("ctl00_PlaceHolderMain_ctl00_ctl01_textBoxFileName"), "");
            enterText.click();
            enterText.sendKeys(title);
            waitInMilliSeconds(1000);
            WebElement clickOk = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.id("ctl00_PlaceHolderMain_buttonSectionMain_RptControls_buttonOK"), "");
            clickWithJavaScript(driver,clickOk);
            waitForPageToLoad();
            waitInMilliSeconds(3000);
            driver.switchTo().defaultContent();
            ResultUtil.report("PASS", "enterDocumentName", "Should successfully enter the document name", "Successfully entered the document name ", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterDocumentName' method", "Should successfully enter the document name", e.getMessage(), driver);
        }
    }

    public void clickDocumentOptionMenu(String name,WebDriver driver, String BrowserName) throws Exception {
        try {
            List<WebElement> newsFeedMenu = waitForPresenceOfAllElementsLocatedBy(driver, BrowserName, By.xpath("//a[text()='" + name + "']//..//..//following-sibling::td//a[@title='Open Menu']"));
            WebElement menu = newsFeedMenu.get(0);
            clickWithJavaScript(driver,menu);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickDocumentOptionMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickDocumentOptionMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickFollowMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='Follow']"));
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickFollowMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickFollowMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }
    public void clickWileyPortalMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement portalMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//a[text()='Portal']"), "");
            clickWithJavaScript(driver,portalMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickWileyPortalMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickWileyPortalMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyDocInFollowingMenu(WebDriver driver, String doc) {
        try {
            if ((findElementByNoThrow(driver, By.xpath("//a[contains(text(),'" + doc + "')]")) != null)) {
                ResultUtil.report("PASS", "verifyDocInFollowingMenu", "Groups option menu should be present", "Groups option menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyDocInFollowingMenu", "Groups option menu should be present", "Groups option menu is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyDocInFollowingMenu' method", "", "", driver);
        }
    }

    public void clickDocumentsMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName, By.xpath("//a[text()='Documents']"), "");
            clickWithJavaScript(driver, menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickDocumentsMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickDocumentsMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }
    public void clickLibraryMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement file = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//span[text()='Library']"), "");
            clickWithJavaScript(driver,file);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickLibraryMenu", "Should successfully click on Library menu", "Successfully click on Library menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickLibraryMenu' method", "Should click on Library menu", e.getMessage(), driver);
        }
    }

    public void clickRssFeedMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            if (BrowserName.contains("firefox")) {
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("Ribbon.Library.Share.ViewRSSFeed-Large"), "");
                menu.click();
                driver.navigate().back();
                ResultUtil.report("PASS", "clickRssFeedMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            }
            else if (BrowserName.contains("safari")) {
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("Ribbon.Library.Share.ViewRSSFeed-Large"), "");
                clickWithJavaScript(driver, menu);
                ((JavascriptExecutor)driver).executeScript("history.go(-1)");
                ResultUtil.report("PASS", "clickRssFeedMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            }
            else{
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("Ribbon.Library.Share.ViewRSSFeed-Large"), "");
                menu.click();
                driver.navigate().back();
                ResultUtil.report("PASS", "clickRssFeedMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickRssFeedMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyConnectToOutlookMenu(WebDriver driver) {
        try {
            if ((driver.findElement(By.id("Ribbon.Library.Actions.ConnectToClient-Large")) != null)) {
                ResultUtil.report("PASS", "verifyConnectToOutlookMenu", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyConnectToOutlookMenu", "Menu should be present", "Menu is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyConnectToOutlookMenu' method", "", "", driver);
        }
    }

    public void verifyOpenWithExplorerMenu(WebDriver driver) {
        try {
            if ((driver.findElement(By.xpath("//span[text()='Open with Explorer']")) != null)) {
                ResultUtil.report("PASS", "verifyOpenWithExplorerMenu", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyOpenWithExplorerMenu", "Menu should be present", "Menu is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyOpenWithExplorerMenu' method", "", "", driver);
        }
    }

    public void clickFormWebPartsMenu(WebDriver driver, String BrowserName) throws Exception  {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.id("Ribbon.Library.CustomizeLibrary.EditDefaultForms-Large"), "");
            menu.click();
            WebElement subMenu = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.xpath("//span[text()='Default Display Form']"));
            clickWithJavaScript(driver,subMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickFormWebPartsMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickFormWebPartsMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickStopEditingMenu(WebDriver driver, String BrowserName) throws Exception  {
        try {
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.xpath("//span[text()='Stop']"));
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickStopEditingMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickStopEditingMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyNewQuickStepMenu(WebDriver driver) {
        try {
            if ((driver.findElement(By.id("Ribbon.Library.CustomizeLibrary.AddButton-Large")) != null)) {
                ResultUtil.report("PASS", "verifyNewQuickStepMenu", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyNewQuickStepMenu", "Menu should be present", "Menu is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyNewQuickStepMenu' method", "", "", driver);
        }
    }

    public void verifyEditLibraryMenu(WebDriver driver) {
        try {
            if ((driver.findElement(By.id("Ribbon.Library.CustomizeLibrary.EditList-Large")) != null)) {
                ResultUtil.report("PASS", "verifyEditLibraryMenu", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyEditLibraryMenu", "Menu should be present", "Menu is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyEditLibraryMenu' method", "", "", driver);
        }
    }

    public void clickLibrarySettingsMenu(WebDriver driver, String BrowserName) throws Exception  {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.id("Ribbon.Library.Settings.DocumentLibrarySettings-Large"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickLibrarySettingsMenu", "Should successfully click on Library settings menu", "Successfully click on Library settings menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickLibrarySettingsMenu' method", "Should click on Library settings menu", e.getMessage(), driver);
        }
    }

    public void clickPermissionMenu(WebDriver driver, String BrowserName) throws Exception  {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//a[text()='Permissions for this document library']"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickPermissionMenu", "Should successfully click on Permission menu", "Successfully click on Permission menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickPermissionMenu' method", "Should click on Permission menu", e.getMessage(), driver);
        }
    }

    public void verifyGrantPermissionMenu(WebDriver driver, String BrowserName) throws Exception  {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.id("Ribbon.Permission.Add.AddUser-Large"), "");
            Assert.assertEquals("Grant Permission Menu", menu, menu);
            ResultUtil.report("PASS", "verifyGrantPermissionMenu", "Should successfully verify Permission menu", "Successfully verify Permission menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyGrantPermissionMenu' method", "Should verify Permission menu", e.getMessage(), driver);
        }
    }

    public void enterEmailAddress(String email,WebDriver driver, String BrowserName) throws Exception  {
        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.className("ms-dlgFrame"), "");
            getDriver().switchTo().frame(iframeElement);
            WebElement enterText = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.id("ctl00_PlaceHolderMain_peoplePicker_TopSpan"));
            enterText.sendKeys(Keys.RETURN);
            enterText.sendKeys(email);
            WebElement element = driver.findElement(By.id("ctl00_PlaceHolderMain_peoplePicker_TopSpan"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].setAttribute('value', 'textBoxValue')", element);
            waitInMilliSeconds(1000);
            WebElement shareMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//input[@value='Share']"), "");
            shareMenu.click();
            waitForPageToLoad();
            driver.switchTo().defaultContent();
            ResultUtil.report("PASS", "enterEmailAddress", "Should successfully enter the document name", "Successfully entered the document name ", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterEmailAddress' method", "Should successfully enter the document name", e.getMessage(), driver);
        }
    } public void clickUsernameCheckbox(WebDriver driver) throws Exception  {
        try {
            List<WebElement> usernameMenu = driver.findElements(By.xpath("//input[@name='PrincipalId']"));
            WebElement menu = usernameMenu.get(0);
            clickWithJavaScript(driver,menu);
            ResultUtil.report("PASS", "clickUsernameCheckbox", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickUsernameCheckbox' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickRemovePermissionMenu(WebDriver driver, String BrowserName) throws Exception  {
        try {
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.id("Ribbon.Permission.Modify.RemovePerms-Large"));
            menu.click();
            waitInMilliSeconds(1000);
            Alert alert = driver.switchTo().alert();
            alert.accept();
            ResultUtil.report("PASS", "clickRemovePermissionMenu", "Should successfully click on Permission menu", "Successfully click on Permission menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickRemovePermissionMenu' method", "Should click on Permission menu", e.getMessage(), driver);
        }
    }

    public void clickOnUploadExistingFile(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement doc = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[text()='Upload existing file']"), "");
            clickWithJavaScript(driver,doc);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnUploadExistingFile", "Should successfully click the UploadExistingFile", "Successfully click the UploadExistingFile", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnUploadExistingFile' method", "Should click the UploadExistingFile", e.getMessage(), driver);
        }
    }
    public void uploadFile(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.className("ms-dlgFrame"), "");
            driver.switchTo().frame(iframeElement);
            WebElement uploadButton = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@id='ctl00_PlaceHolderMain_ctl01_ctl04_InputFile']//..//input"), "Unable to find browse element.");
            uploadButton.sendKeys(picfile.getAbsolutePath());
            WebElement ok = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@value='OK']"), "");
            clickWithJavaScript(driver,ok);
            waitForPageToLoad();
            ResultUtil.report("PASS", "uploadFile", "File should be uploaded", "File is uploaded", driver);
            waitForPageToLoad();
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'uploadFile' method", "File should be uploaded", e.getMessage(), driver);
        }
    }

}









