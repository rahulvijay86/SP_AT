package apppages;


import actions.ResultUtil;
import common.ExtendedLibrary;
import intialize.Prerequsite;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;


public class ProjectPage extends ExtendedLibrary {
    public static String MenuName;
    public static String Page_Menu;

    private static final List<String> NEW_PROJECT_MENU_OPTIONS = Arrays.asList(
            "Home",
            "Notebook",
            "Documents",
            "Tasks",
            "Calendar",
            "Site Contents",
            "EDIT LINKS");

    private static final List<String> PROJECT_PAGE_MENU_OPTIONS = Arrays.asList(
            "BROWSE",
            "PAGE");

    public void clickProjectMenu(WebDriver driver, String BrowserName) throws Exception  {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//span[text()='Projects']"), "");
            clickWithJavaScript(driver, menu);
            waitForPageToLoad();
            waitInMilliSeconds(5000);
            ResultUtil.report("PASS", "clickProjectMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickProjectMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickProjectTitleMenu(WebDriver driver, String BrowserName, String title) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='" +title+ "']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                waitInMilliSeconds(9000);
                ResultUtil.report("PASS", "clickProjectTitleMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            } else {
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='" +title+ "']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                waitInMilliSeconds(5000);
                ResultUtil.report("PASS", "clickProjectTitleMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickProjectTitleMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyWidgetMenuInProjectPage(WebDriver driver,String BrowserName) {
        boolean shareText = false;
        boolean workText = false;
        boolean yourText = false;

        try {
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//div[text()='Share your site.']"), "");
            shareText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//div[text()='Working on a deadline?']"), "");
            workText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//div[text()='Your site. Your brand.']"),"");
            yourText = true;
            ResultUtil.report("PASS", "verifyWidgetMenuInProjectPage", "Should successfully verify all the menu", "Successfully verify all the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyWidgetMenuInProjectPage' method", "", "", driver);
        }
    }

    public void enterConversationText(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.id("ms-microbloginputbox"));
            menu.click();
            menu.sendKeys("Sharepoint Testing");
            ResultUtil.report("PASS", "clickNewsfeedMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickNewsfeedMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickPostMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.id("ms-postbutton"));
            clickWithJavaScript(driver,menu);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickPostMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickPostMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyConversationText(WebDriver driver) throws Exception{
        try {
            if ((driver.findElement(By.xpath("//textarea[text()='Start a conversation']")) != null)) {
                ResultUtil.report("PASS", "verifyConversationText", "Text message should be present", "Text message is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyConversationText", "Text message should be present", "Text message is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyConversationText' method", "", "", driver);
        }
    }

    public void verifyPageMenuUnderNewProject(WebDriver driver, String BrowserName) throws Exception {
        WebElement searchMenu = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//ul[@class='ms-cui-tts']"));
        List<WebElement> displayList = searchMenu.findElements(By.tagName("li"));
        for (WebElement menu : displayList) {
            if (PROJECT_PAGE_MENU_OPTIONS.contains(menu.getText())) {
                ResultUtil.report("PASS", "verify: Project Page menu: " + menu.getText(), "Should have the Project Page menu options from the List", "Has all the Project Page menu", driver);
            } else {
                ResultUtil.report("FAIL", "verify: Project Page menu: " + menu.getText(), "Should have the Project Page menu options from the List", "Does not contain all the Project Page menu", driver);
            }
        }
    }

    public void clickCreateNewProjectMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//strong[text()='Create New Project Site']"), "");
            menu.click();
            waitForPageToLoad();
            waitForWindowToBeAppearedAndSwitchToIt(driver, BrowserName,"Pages - Create Project Site");
            ResultUtil.report("PASS", "clickCreateNewProjectMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickCreateNewProjectMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyCreateProjectPageMenu(WebDriver driver) throws  Exception{

        boolean titleText = false;
        boolean descriptionText = false;
        boolean urlText = false;
        boolean expiryText = false;
        boolean createText = false;
        boolean cancelText = false;

        try {
            WebElement iframeElement = driver.findElement(By.xpath("//*[contains(@src, 'http://portalqa.wiley.com/sites/projects5')]"));
            driver.switchTo().frame(iframeElement);
            driver.findElement(By.id("lblTitle"));
            titleText = true;
            driver.findElement(By.xpath("//span[text()='Description:']"));
            descriptionText = true;
            driver.findElement(By.xpath("//span[text()='URL Name:']"));
            urlText = true;
            driver.findElement(By.xpath("//span[text()='Expiry Date:']"));
            expiryText = true;
            driver.findElement(By.xpath("//input[@value='Create']"));
            urlText = true;
            driver.findElement(By.xpath("//input[@value='Cancel']"));
            urlText = true;
            driver.switchTo().defaultContent();
            driver.close();
            switchToMainWindow(driver);
            ResultUtil.report("PASS", "verifyCreateProjectPageMenu", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyCreateProjectPageMenu' method", "", "", driver);
        }
    }

    public void enterValuesAndCreateTheProject(WebDriver driver, String BrowserName,String title,String date)throws Exception {
        try {
            WebElement iframeElement = driver.findElement(By.xpath("//*[contains(@src, 'http://portalqa.wiley.com/sites/projects5')]"));
            driver.switchTo().frame(iframeElement);
            WebElement titleMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("txtTitle"), "");
            titleMenu.click();
            titleMenu.sendKeys(title);
            titleMenu.sendKeys(Keys.TAB);
            waitInMilliSeconds(2000);
//            Actions action = new Actions(driver);
//            action.moveToElement(driver.findElement(By.xpath("//textarea[@id='txtDescription']"))).doubleClick().perform();
            WebElement dateMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("dtreq"), "");
            dateMenu.sendKeys(date);
            WebElement createMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//input[@id='btnSubmit']"), "");
            clickWithJavaScript(driver, createMenu);
            driver.switchTo().defaultContent();
            waitForPageToLoad();
            ResultUtil.report("PASS", "enterValuesAndCreateTheProject", "Should successfully click the menu and entered the search text", "Successfully click the menu and entered the search text", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterValuesAndCreateTheProject' method", "Should click the menu and enter the search text", e.getMessage(), driver);
        }
    }

    public void verifyProjectCreationPageRibbonMenu(WebDriver driver) throws Exception{
        boolean shareText = false;
        boolean followText = false;
        boolean syncText = false;
        boolean focusText = false;
        boolean filesText = false;
        boolean searchText = false;

        try {
            driver.findElement(By.xpath("//span[text()='Share']"));
            shareText = true;
            driver.findElement(By.xpath("//span[text()='Follow']"));
            followText = true;
            driver.findElement(By.xpath("//span[text()='Sync']"));
            syncText = true;
            driver.findElement(By.xpath("//img[@alt='Focus on Content']"));
            focusText = true;
            driver.findElement(By.xpath("//span[text()='MY FILES']"));
            filesText = true;
            driver.findElement(By.id("txtSearch"));
            searchText = true;
            ResultUtil.report("PASS", "verifyProjectCreationPageRibbonMenu", "Should successfully verify all the menu", "Successfully verify all the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyProjectCreationPageRibbonMenu' method", "", "", driver);
        }
    }

    public void verifyMenuUnderNewProjectPage(WebDriver driver, String BrowserName) throws Exception {
        WebElement searchMenu = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.id("zz16_RootAspMenu"));
        List<WebElement> displayList = searchMenu.findElements(By.tagName("li"));
        for (WebElement menu : displayList) {
            if (NEW_PROJECT_MENU_OPTIONS.contains(menu.getText())) {
                ResultUtil.report("PASS", "verify: New Project menu: " + menu.getText(), "Should have the New Project menu options from the List", "Has all the New Project menu", driver);
            } else {
                ResultUtil.report("FAIL", "verify: New Project menu: " + menu.getText(), "Should have the New Project menu options from the List", "Does not contain all the New Project menu", driver);
            }
        }
        driver.close();
        switchToMainWindow(driver);
    }

    public void clickEditLinksMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement editLinkMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Edit Links']"), "");
            clickWithJavaScript(driver, editLinkMenu);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickEditLinksMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickEditLinksMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickSubLinkMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement menu1 = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@id='zz12_MySiteUserQLMenu_2003']/table/tr/td[1]"), "");
                MenuName = menu1.getText();
                clickWithJavaScript(driver,menu1);
                waitInMilliSeconds(2000);
                ResultUtil.report("PASS", "clickSubLinkMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            } else {
                Actions actions = new Actions((driver));
                WebElement menu1 = waitForVisibilityOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@id='zz12_MySiteUserQLMenu_2003']/table/tr/td[1]"));
                MenuName = menu1.getText();
                actions.click(menu1).build().perform();
            /*WebElement editLinkMenu = waitForVisibilityOfElementLocatedBy(driver, BrowserName, By.xpath("//span[contains(text(),'" +menu+ "')]"));
            clickWithJavaScript(driver,editLinkMenu);*/
                waitInMilliSeconds(2000);
                ResultUtil.report("PASS", "clickSubLinkMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSubLinkMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void editSubLinkMenu(WebDriver driver, String BrowserName,String newMenu)throws Exception {
        try {
            if(MenuName.equals("Task"))
                newMenu="Work";
            else
                newMenu="Task";
            WebElement editLinksMenu = waitForPresenceOfElementLocatedBy(driver,BrowserName, By.xpath("//div[contains(text(),'" + MenuName + "')]"), "");
            editLinksMenu.click();
            editLinksMenu.clear();
            editLinksMenu.sendKeys(newMenu);
            WebElement editLinksMenu1 = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.id("txtSearch"), "");
            editLinksMenu1.click();
            WebElement editLinMenu = driver.findElement(By.xpath("//input[@title='Save']"));
            waitForVisibilityOfElement(driver,BrowserName,editLinMenu);
            clickWithJavaScript(driver, editLinMenu);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "editSubLinkMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'editSubLinkMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyDragAndDropMenu(WebDriver driver) throws  Exception{
        try {
            if ((driver.findElement(By.xpath("//div[text()='Drag and drop link here']")) != null)) {
                ResultUtil.report("PASS", "verifyDragAndDropMenu", "Warning message should be present", "Warning message is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyDragAndDropMenu", "Warning message should be present", "Warning message is Not present", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyDragAndDropMenu' method", "", "", driver);
        }
    }

    public void dragAndDropMenu(WebDriver driver, String BrowserName) throws  Exception {
        try {
            List<WebElement> element = driver.findElements(By.cssSelector(".static.ms-navedit-dropNode.menu-item.ms-core-listMenu-item.ms-displayInline.ms-navedit-linkNode"));
            WebElement ele = element.get(1);
            List<WebElement> target = driver.findElements(By.cssSelector(".static.ms-navedit-dropNode.menu-item.ms-core-listMenu-item.ms-displayInline.ms-navedit-linkNode"));
            WebElement tar = target.get(3);
            (new Actions(driver)).dragAndDrop(ele, tar).perform();
            waitInMilliSeconds(2000);
            WebElement editLinMenu = driver.findElement(By.xpath("//input[@title='Save']"));
            waitForVisibilityOfElement(driver,BrowserName,editLinMenu);
            clickWithJavaScript(driver, editLinMenu);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "dragAndDropMenu", "Should successfully drag and drop the menu", "Successfully drag and drop the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'dragAndDropMenu' method", "Should drag and drop the menu", e.getMessage(), driver);
        }
    }

    public void clickAddNewLinkMenu(WebDriver driver, String BrowserName) throws  Exception{
        try {
            WebElement addNewLinkMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='link']"), "");
            clickWithJavaScript(driver, addNewLinkMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickAddNewLinkMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAddNewLinkMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickEnterNewLinkValues(WebDriver driver, String BrowserName)throws  Exception{
        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.className("ms-dlgFrame"),"");
            driver.switchTo().frame(iframeElement);
            WebElement enterText = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.id("ctl00_PlaceHolderMain_StrFirst"), "");
            enterText.click();
            enterText.sendKeys("Selenium");
            WebElement enterLink = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.id("ctl00_PlaceHolderMain_StrSecond"), "");
            enterLink.click();
            enterLink.sendKeys("http://portalqa.wiley.com");
            WebElement okButton = waitForVisibilityOfElementLocatedBy(driver, BrowserName, By.id("OKButton"));
            clickWithJavaScript(driver, okButton);
            waitForPageToLoad();
            driver.switchTo().defaultContent();
            ResultUtil.report("PASS", "clickEnterNewLinkValues", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickEnterNewLinkValues' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickSaveButton(WebDriver driver, String BrowserName)throws  Exception{
        try {
            WebElement saveMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//input[@title='Save']"),"");
            clickWithJavaScript(driver,saveMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSaveButton", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSaveButton' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void enterValuesToCreateTheProject(String title, String description, WebDriver driver,String BrowserName)throws Exception{
        try {
            WebElement iframeElement = driver.findElement(By.xpath("//*[contains(@src, 'http://portalqa.wiley.com/sites/projects5')]"));
            driver.switchTo().frame(iframeElement);
            WebElement titleMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.id("txtTitle"), "");
            titleMenu.click();
            titleMenu.sendKeys(title);
            titleMenu.sendKeys(Keys.TAB);
            waitInMilliSeconds(2000);
            WebElement descMenu = driver.findElement(By.id("txtDescription"));
            descMenu.click();
            descMenu.sendKeys(description);
            WebElement createMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//input[@id='btnSubmit']"), "");
            clickWithJavaScript(driver, createMenu);
            ResultUtil.report("PASS", "enterValuesAndCreateTheProject", "Should successfully click the menu and entered the search text", "Successfully click the menu and entered the search text", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterValuesAndCreateTheProject' method", "Should click the menu and enter the search text", e.getMessage(), driver);
        }
    }

    public void verifyDateWarningMsg(WebDriver driver) throws  Exception{
        try {
            if ((driver.findElement(By.xpath("//span[text()='Please enter the expiry date.']")) != null)) {
                ResultUtil.report("PASS", "verifyDateWarningMsg", "Warning message should be present", "Warning message is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyDateWarningMsg", "Warning message should be present", "Warning message is Not present", driver);
            }
            driver.switchTo().defaultContent();
            driver.close();
            switchToMainWindow(driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyDateWarningMsg' method", "", "", driver);
        }
    }

    public void verifyProjectPageRibbonMenu(WebDriver driver) throws  Exception{
        boolean followText = false;
        boolean focusText = false;
        boolean filesText = false;
        boolean searchText = false;

        try {
            driver.findElement(By.xpath("//span[text()='Follow']"));
            followText = true;
            driver.findElement(By.xpath("//img[@alt='Focus on Content']"));
            focusText = true;
            driver.findElement(By.xpath("//span[text()='MY FILES']"));
            filesText = true;
            driver.findElement(By.id("txtSearch"));
            searchText = true;
            ResultUtil.report("PASS", "verifyProjectPageRibbonMenu", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyProjectPageRibbonMenu' method", "", "", driver);
        }
    }


    public void verifyProjectWelcomeMessage(WebDriver driver) throws  Exception{
        boolean welcomeText = false;
        boolean portalText = false;

        try {
            driver.findElement(By.xpath("//div[contains(text(), 'Welcome to')]"));
            welcomeText = true;
            driver.findElement(By.xpath("//span[text()='Portal Project Sites']"));
            portalText = true;
            ResultUtil.report("PASS", "verifyProjectWelcomeMessage", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyProjectWelcomeMessage' method", "", "", driver);
        }
    }

    public void verifyProjectPageMenu(WebDriver driver) throws  Exception{
        boolean projectText = false;
        boolean helpText = false;

        try {
            driver.findElement(By.xpath("//strong[text()='Create New Project Site']"));
            projectText = true;
            driver.findElement(By.xpath("//strong[text()='Help']"));
            helpText = true;
            ResultUtil.report("PASS", "verifyProjectPageMenu", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyProjectPageMenu' method", "", "", driver);
        }
    }

    public void clickPageMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Page']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickPageMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            } else {
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Page']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ResultUtil.report("PASS", "clickPageMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickPageMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyPageMenuOptionsInProjectPage(WebDriver driver,String BrowserName) throws  Exception{
        boolean emailText = false;
        boolean alertText = false;
        boolean Text = false;

        try {
            waitInMilliSeconds(2000);
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[contains(text(), 'E-mail')]"), "");
            emailText = true;
            waitForPresenceOfElementLocatedBy(driver,BrowserName, By.xpath("//span[contains(text(), 'Alert')]"), "");
            alertText = true;
            ResultUtil.report("PASS", "verifyPageMenuOptionsInProjectPage", "Should successfully verify all the menu", "Successfully verify all the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyPageMenuOptionsInProjectPage' method", "", "", driver);
        }
    }
    public void clickTagsAndNotesMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            waitInMilliSeconds(2000);
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//a[contains(@id, 'TagsAndNotes')]"), "");
            clickWithJavaScript(driver,menu);
            waitInMilliSeconds(1000);
            ResultUtil.report("PASS", "clickTagsAndNotesMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickTagsAndNotesMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickTagsAndNotesCloseMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            waitInMilliSeconds(2000);
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//img[@alt='Close dialog']"), "");
            clickWithJavaScript(driver, menu);
            waitInMilliSeconds(1000);
            ResultUtil.report("PASS", "clickTagsAndNotesCloseMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickTagsAndNotesCloseMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void createNewDocument(WebDriver driver,String BrowserName) {
        try {
            WebElement newdocument = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//span[text()='new document']"), "");
            clickWithJavaScript(driver, newdocument);
            ResultUtil.report("PASS", "Click on new document", "Should successfully click on the new document", "successfully click the new document", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'Click on new document' method", "Should successfully click on the new document", e.getMessage(), driver);
        }
    }

    public void newPageMenu(WebDriver driver,String BrowserName,String page)throws Exception{
        try {
            WebElement text = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@id='ctl00_PlaceHolderMain_nameInput']"), "");
            text.click();
            Page_Menu=page+getRandomCode();
            text.sendKeys(Page_Menu);

            //text.sendKeys(page);
            ResultUtil.report("PASS", "Enter the text", "Should successfully enter the text", "successfully entered the text", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception at 'new page menu' method", "Should successfully enter the text", e.getMessage(), driver);
        }
    }

    public void clickOnCreate(WebDriver driver,String BrowserName)throws Exception{
        try {
            WebElement newdocument = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@id='ctl00_PlaceHolderMain_createButton']"), "");
            clickWithJavaScript(driver,newdocument);
            waitForPageToLoad();
            ResultUtil.report("PASS", "Click on create button", "Should successfully click on the create button", "successfully click the create button", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'Click on new create' method", "Should successfully click on the create button", e.getMessage(), driver);
        }
    }

    public void clickOnInsertMenu(WebDriver driver,String BrowserName)throws Exception{
        try {
            WebElement newdocument = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//span[text()='Insert']"), "");
            clickWithJavaScript(driver, newdocument);
            ResultUtil.report("PASS", "Click on Insert", "Should successfully click on the insert menu", "successfully click the insert menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'Click on insert menu' method", "Should successfully click on the insert menu ", e.getMessage(), driver);
        }
    }

    public void clickOnWebPart(WebDriver driver,String BrowserName) throws Exception{
        try {
            WebElement submenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//a[contains (@id, 'WebPart-Large')]"), "");
            clickWithJavaScript(driver, submenu);
            ResultUtil.report("PASS", "Click on Web part", "Should successfully click on the web part button", "successfully click the web part button", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'Click on web part' method", "Should successfully click on the web part button", e.getMessage(), driver);
        }
    }

    public void clickOnContentRollup(WebDriver driver,String BrowserName)throws Exception{
        try {
            WebElement submenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//div[@title='Content Rollup']"), "");
            clickWithJavaScript(driver, submenu);
            ResultUtil.report("PASS", "Click on content roll up", "Should successfully click on the content roll up", "successfully click on the content rollup", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'Click on content rollup' method", "Should successfully click on the content rollup", e.getMessage(), driver);
        }
    }

    public void clickOnContentSearch(WebDriver driver,String BrowserName) throws Exception{
        try {
            WebElement submenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//div[@title='Content Search']"), "");
            clickWithJavaScript(driver, submenu);
            ResultUtil.report("PASS", "Click on content search ", "Should successfully click on the content search", "successfully click on the content search", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'Click on content search' method", "Should successfully click on the content search", e.getMessage(), driver);
        }
    }

    public void clickOnAddButton(WebDriver driver,String BrowserName) throws Exception{
        try {
            WebElement button = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//button[contains(text(),'Add')]"), "");
            clickWithJavaScript(driver,button);
            waitForPageToLoad();
            ResultUtil.report("PASS", "Click on Add button ", "Should successfully click on the Add button", "successfully click on the add button", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'Click on add button' method", "Should successfully click on the add button", e.getMessage(), driver);
        }
    }

    public void clickOnDropDownArrow(WebDriver driver,String BrowserName) throws Exception{
        try {
            WebElement arrow = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//a[@class='ms-webpart-menuLink']"), "");
            clickWithJavaScript(driver, arrow);
            //waitInMilliSeconds(1000);
            ResultUtil.report("PASS", "Click on Arrow button ", "Should successfully click on the Arrow button", "successfully click on the arrow button", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'Click on drop down arrow' method", "Should successfully click on the arrow button", e.getMessage(), driver);
        }
    }

    public void clickOnEditWebPart(WebDriver driver,String BrowserName) throws Exception{
        try {
            WebElement submenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//span[text()='Edit Web Part']"), "");
            clickWithJavaScript(driver,submenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "Click on Edit web part", "Should successfully click on the edit web part menu", "successfully click the edit web part menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'Click on Edit Web part' method", "Should successfully click on the edit web part menu ", e.getMessage(), driver);
        }
    }

    public void clickOnChangeQuery(WebDriver driver,String BrowserName) throws Exception{
        try {
            WebElement button = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//*[@value='Change query']"), "");
            clickWithJavaScript(driver,button);
            waitForPageToLoad();
            ResultUtil.report("PASS", "Click on Add button ", "Should successfully click on the Add button", "successfully click on the add button", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'Click on add button' method", "Should successfully click on the add button", e.getMessage(), driver);
        }
    }

    public void clickOnSwitchAdvanceMode(WebDriver driver,String BrowserName)throws Exception{
        try {
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.className("ms-dlgFrame"), "");
            driver.switchTo().frame(iframeElement);
            WebElement mode = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@id='customQueryLink']"), "");
            clickWithJavaScript(driver,mode);
            Select iSelect = new Select(driver.findElement(By.xpath(".//*[@id='ctl00_PlaceHolderMain_searchSourceDropDown']")));
            iSelect.selectByVisibleText("Local People Results (System)");
            WebElement querybox = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//*[@id='QueryBox']"), "");
            clickWithJavaScript(driver,querybox);
            querybox.clear();
            Select iProperty = new Select(driver.findElement(By.xpath(".//*[@id='ctl00_PlaceHolderMain_propertyValueId']")));
            iProperty.selectByVisibleText("--Show all managed properties--");
            Select name = new Select(driver.findElement(By.xpath(".//*[@id='ctl00_PlaceHolderMain_allqueryable']")));
            name.selectByVisibleText("AccountName");
            Select value = new Select(driver.findElement(By.xpath(".//*[@id='dynamicValueId']")));
            value.selectByVisibleText("Manual value");
            ResultUtil.report("PASS", "Click on advanced mode and select the texts", "Should have clicked and selected the texts", "Successfully clicked and selected the texts", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred at 'Click on advanced mode and select the texts' method", "Should have clicked and selected the texts", e.getMessage(), driver);
        }
    }

    public void accountName1(WebDriver driver,String BrowserName,String name1)  throws Exception
    {
        try {
            WebElement Name = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@id='manualtextinput']"), "");
            clickWithJavaScript(driver,Name);
            Name.sendKeys(name1);
            ResultUtil.report("PASS", "Enter the account name", "Name should have entered", "Name is entered", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred at 'the account name", "Name should have entered", e.getMessage(), driver);
        }
    }

    public void clearText(WebDriver driver,String BrowserName) throws Exception{
        try {
            WebElement text = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[@id='manualtextinput']"), "");
            text.clear();
            ResultUtil.report("PASS", "Clears the text", "Should clear the text", "Successfully cleared the text", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception at 'Clears the text' method", "Should clear the text", e.getMessage(), driver);
        }
    }

    public void accountName2(WebDriver driver,String BrowserName,String name2) throws Exception
    {
        try {
            WebElement name = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@id='manualtextinput']"), "");
            clickWithJavaScript(driver,name);
            name.sendKeys(name2);
            ResultUtil.report("PASS", "Enter the account name", "Name should have entered", "Name is entered", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred at 'the account name", "Name should have entered", e.getMessage(), driver);
        }
    }

    public void clickOnAddToQuery(WebDriver driver,String BrowserName)throws Exception{
        try {
            WebElement query = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@id='addtoquery']"), "");
            clickWithJavaScript(driver, query);
            ResultUtil.report("PASS", "Click on add to query", "should click on add to query", "Successfully clicked on add to query", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occured at 'Click on add to query' method", "should click on add to query", e.getMessage(), driver);
        }
    }

    public void clickOnOkButton(WebDriver driver,String BrowserName)throws Exception{
        try {
            WebElement ok = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@id='OkButton']"), "");
            clickWithJavaScript(driver,ok);
            driver.switchTo().defaultContent();
            ResultUtil.report("PASS", "Click on OK button", "Should click on OK Button", "Successfully clicked on OK Button", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred at 'click on ok button' mehtod", "Should click on OK button", e.getMessage(), driver);
        }
    }

    public void changeItemToPicture(WebDriver driver)throws Exception{
        try {
            Select item = new Select(driver.findElement(By.xpath("//select[contains (@title, 'Choose a Display Template for the individual items')]")));
            item.selectByVisibleText("UserPicture on left, About Me on right");
            ResultUtil.report("PASS", "Click on droP down", "Should click and seled the text", "Successfully clicked and selected the text", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred at 'Click on drop down' method", "Should click and seled the text", e.getMessage(), driver);
        }
    }

    public void clickOkButton(WebDriver driver,String BrowserName)throws Exception{
        try {
            WebElement button = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//input[contains (@id, 'OKBtn')]"), "");
            clickWithJavaScript(driver,button);
            waitInMilliSeconds(3000);
            ResultUtil.report("PASS", "Click OK Button", "Should click on OK button", "Successfully clicked on OK button", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred at 'Click OK Button' method", "Should click on OK button", e.getMessage(), driver);
        }
    }

    public void clickOnSave(WebDriver driver,String BrowserName)throws Exception{
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//span[text()='Save']"), "");
            clickWithJavaScript(driver,menu);
            waitInMilliSeconds(3000);
            ResultUtil.report("PASS", "Click on Save", "Should successfully click on the save menu", "successfully click the save menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'Click on save' method", "Should successfully click on the save menu ", e.getMessage(), driver);
        }
    }

    public void clickOnCreatedPage(WebDriver driver,String BrowserName, String value)throws Exception{
        try {
            WebElement page = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//a[text()='" + Page_Menu + "']"), "");
            clickWithJavaScript(driver,page);
            waitInMilliSeconds(1000);
            ResultUtil.report("PASS", "Click on the page", "Should click on the page", "successfully click the page", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred at'Click on the page' method", "Should click on the page", e.getMessage(), driver);
        }
    }

    public void clickOnPage(WebDriver driver) throws Exception{
        try {
            List<WebElement> page = driver.findElements(By.xpath("//td[@class='ms-list-itemLink-td ms-cellstyle']"));
            WebElement docMenu = page.get(0);
            clickWithJavaScript(driver,docMenu);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS","Click on the page", "Should click on the page", "successfully click the page", driver);
        } catch (Exception e){
            ResultUtil.report("FAIL", "Exception occurred at 'Click on the page' method", "Should click on the page", e.getMessage(), driver);
        }
    }

    public void openPage(WebDriver driver,String BrowserName)throws Exception{
        try {
            WebElement open = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//a[text()='Open']"),"");
            clickWithJavaScript(driver,open);
            ResultUtil.report("PASS","Click on the open page", "Should click on the open page", "successfully click the page", driver);
        }catch (Exception e){
            ResultUtil.report("PASS","Exception occurred at 'Click on the open page", "Should click on the open page", "successfully click the page", driver);
        }
    }

    public void verifyUser1(WebDriver driver) throws Exception{
        try {
            if ((driver.findElement(By.xpath("//div[text()='About me section #testing..']")) != null)) {
                ResultUtil.report("PASS", "Verifies About  me", "Should verify the user about me section", "successfully verifies", driver);
            } else {
                ResultUtil.report("FAIL", "Exception occurred at 'Verifies About  me' method", "Should verify the user about me section","", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("PASS", "Verifies About  me", "Should verify the user about me section", e.getMessage(), driver);
        }
    }

    public void verifyUser2(WebDriver driver) throws Exception{
        try {
            if ((driver.findElement(By.xpath("//div[@title='Sarah']")) != null)) {
                ResultUtil.report("PASS", "Verifies department & number", "Should verify the user details", "successfully verifies", driver);
            } else {
                ResultUtil.report("FAIL", "Exception occurred at 'Verifies About  me' method", "Should verify the user details","", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("PASS", "Verifies About  me", "Should verify the user about me section", e.getMessage(), driver);
        }
    }

    public void enterValuesToCreateTheProject(WebDriver driver,String BrowserName,String title, String description) {
        try {
            WebElement titleMenu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//input[@class='txtTitle']"), "");
            titleMenu.click();
            titleMenu.sendKeys(title);
            WebElement descMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//textarea[contains(@id,'txtDescription')]"), "");
            descMenu.click();
            descMenu.sendKeys(description);
            WebElement createMenu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//input[@value='Create']"), "");
            clickWithJavaScript(driver, createMenu);
            ResultUtil.report("PASS", "enterValuesAndCreateTheProject", "Should successfully click the menu and entered the search text", "Successfully click the menu and entered the search text", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterValuesAndCreateTheProject' method", "Should click the menu and enter the search text", e.getMessage(), driver);
        }
    }

    public void clickDocumentsMenu(WebDriver driver) throws Exception {
        try {
            List<WebElement> menu = driver.findElements(By.xpath("//span[text()='Documents']"));
            WebElement docMenu = menu.get(0);
            clickWithJavaScript(driver, docMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickDocumentsMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickDocumentsMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickFilesMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Files']"));
            clickWithJavaScript(driver,menu);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickFilesMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickFilesMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyFilesMenuOptionsInProjectPage(WebDriver driver) throws Exception {
        boolean newDocText = false;
        boolean addDocText = false;
        boolean newfolText = false;
        boolean alertText = false;
        boolean popText = false;
        boolean shareText = false;
        boolean tagText = false;

        try {
            driver.findElements(By.xpath("//span[@id='Ribbon.Documents.New.NewDocument-Large']/a[2]/span"));
            newDocText = true;
            driver.findElement(By.xpath("//*[@id='Ribbon.Documents.New.AddDocument-Large']/span[2]"));
            addDocText = true;
            driver.findElement(By.xpath("//*[@id='Ribbon.Documents.New.NewFolder-Large']/span[2]"));
            newfolText = true;
            driver.findElement(By.xpath("//span[contains(text(), 'Alert')]"));
            alertText = true;
            driver.findElement(By.xpath("//span[contains(text(), 'Popularity')]"));
            popText = true;
            driver.findElement(By.xpath("//*[@id='Ribbon.Documents.Share.ShareItem-Large']/span[2]"));
            shareText = true;
            driver.findElement(By.xpath("//*[@id='Ribbon.Documents.TagsAndNotes.TagsAndNotes-Large']/span[2]"));
            tagText = true;
            ResultUtil.report("PASS", "verifyFilesMenuOptionsInProjectPage", "Should successfully verify all the menu", "Successfully verify all the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyFilesMenuOptionsInProjectPage' method", "", "", driver);
        }
    }

}





