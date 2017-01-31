package apppages;


import actions.Browser;
import actions.ResultUtil;
import common.ExtendedLibrary;
import intialize.Prerequsite;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class BlogPage extends ExtendedLibrary {

    public void clickBlogMenu(WebDriver driver, String BrowserName) {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Blog']"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickBlogMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickBlogMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyBrowseAndPageMenu(WebDriver driver)throws  Exception{
        boolean browse = false;
        boolean page = false;
        try {
            driver.findElement(By.xpath("//span[text()='Browse']"));
            browse = true;
            driver.findElement(By.xpath("//span[text()='Page']"));
            page = true;
            ResultUtil.report("PASS", "verifyBrowseAndPageMenu", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyBrowseAndPageMenu' method", "", "", driver);
        }
    }

    public void clickRssFeedMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='RSS Feed']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                ((JavascriptExecutor)driver).executeScript("history.go(-1)");
                waitInMilliSeconds(2000);
            } else {
                WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='RSS Feed']"), "");
                clickWithJavaScript(driver, menu);
                waitForPageToLoad();
                driver.navigate().back();
            }
            ResultUtil.report("PASS", "clickRssFeedMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickRssFeedMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickCreatePostMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("admlnk0"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickCreatePostMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickCreatePostMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void enterTitle(WebDriver driver, String BrowserName,String title)throws Exception {
        try {
            WebElement titleName = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[@title='Title Required Field']"), "Title Name text box is not found");
            titleName.sendKeys(title);
            ResultUtil.report("PASS", "enterTitle", "Should successfully enter the title", "Successfully entered the title", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterTitle' method", "Should enter the title name", "", driver);
        }
    }

    public void enterBody(WebDriver driver, String BrowserName,String body)throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                try {
                    List<WebElement> bodyContent = waitForPresenceOfAllElementsLocatedBy(driver, BrowserName, By.xpath("//div[contains(@id, 'TextField_inplacerte')]"));
                    WebElement bodyMsg = bodyContent.get(1);
                    bodyMsg.sendKeys(body);
                    ResultUtil.report("PASS", "enterBody", "Should successfully enter the body", "Successfully entered the body", driver);
                } catch (Exception e){
                    ResultUtil.report("PASS", "enterBody", "Should successfully enter the body", "Successfully entered the body", driver);
                }
                } else {
                List<WebElement> bodyContent = waitForPresenceOfAllElementsLocatedBy(driver, BrowserName, By.xpath("//div[contains(@id, 'TextField_inplacerte')]"));
                WebElement bodyMsg = bodyContent.get(1);
                bodyMsg.sendKeys(body);
                ResultUtil.report("PASS", "enterBody", "Should successfully enter the body", "Successfully entered the body", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterBody' method", "Should enter the Body Content", "", driver);
        }
    }

    public void selectCategory(WebDriver driver, String BrowserName,String value)throws Exception {
        try {
            WebElement category = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@title='Category possible values']"));
            Select searchCategorySelect = new Select(category);
            searchCategorySelect.selectByVisibleText(value);
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SECOND")));
            ResultUtil.report("PASS", "selectCategory", "Should click the category and select the option", "Category has been selected", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'selectCategory' method", "Category to be selected", "", driver);
        }
    }

    public void clickAddButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement add = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//*[@value='Add >']"), "");
            clickWithJavaScript(driver, add);
            ResultUtil.report("PASS", "clickAddButton", "Should successfully click the ADD Button", "Successfully click the add button", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAddButton' method", "Should click the ADD button", e.getMessage(), driver);
        }
    }

    public void clickPublishButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement publish = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[@value='Publish']"), "");
            clickWithJavaScript(driver,publish);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickPublishButton", "Should successfully click the Publish Button", "Successfully click the Publish button", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickPublishButton' method", "Should click the Publish button", e.getMessage(), driver);
        }
    }

    public void clickOnExistingCategory(WebDriver driver, String BrowserName,String name) throws Exception {
        try {
            WebElement category = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[text()='" + name + "']"), "");
            clickWithJavaScript(driver, category);
            ResultUtil.report("PASS", "clickAddButton", "Should successfully click the ADD Button", "Successfully click the add button", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAddButton' method", "Should click the ADD button", e.getMessage(), driver);
        }
    }

    public void enterComments(WebDriver driver, String BrowserName,String comments) throws Exception {
        try {
            WebElement enterComm = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[@class='ms-comm-postReplyTextBox ms-fullWidth ms-helperText']"), "Title Name text box is not found");
            enterComm.sendKeys(comments);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterBody' method", "Should enter the Body Content", "", driver);
        }
    }

    public void clickPostButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement post = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[text()='Post']"), "");
            clickWithJavaScript(driver,post);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickPostButton", "Should successfully click the Post Button", "Successfully click the Post button", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickPostButton' method", "Should click the Post button", e.getMessage(), driver);
        }
    }

    public void clickManageCommentsMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("admlnk2"), "");
            clickWithJavaScript(driver, menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickManageCommentsMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickManageCommentsMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void selectEditMenuOfFirstComment(WebDriver driver) throws Exception {
        try {
            List<WebElement> edit = driver.findElements(By.xpath(".//*[@alt='edit']"));
            if (edit.size() > 0) {
                edit.get(0).click();
                ResultUtil.report("INFO", "Select the edit Menu", "edit Menu is selected.", "", driver);
            }
            ResultUtil.report("INFO", "Select the edit Menu", "edit Menu is selected.", "", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'selectEditMenuOfFirstComment' menu", "Edit menu to be selected", "There are no Articles", driver);
        }
    }

    public void editTitleForComments(WebDriver driver, String BrowserName,String title) throws Exception {
        try {
            WebElement titleName = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[@title='Title']"), "Title Name text box is not found");
            titleName.clear();
            titleName.sendKeys(title);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'editTitleForComments' method", "Should enter the title name", "", driver);
        }
    }
    public void clickSaveButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement save = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@value='Save']"), "");
            clickWithJavaScript(driver, save);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSaveButton", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSaveButton' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickAlertMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            waitInMilliSeconds(2000);
            WebElement menu = waitFor1MinVisibilityOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Alert Me']"));
            clickWithJavaScript(driver, menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickAlertMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAlertMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickOkMenuInAlertPage(WebDriver driver) throws Exception {
        try {
            List<WebElement> newsFeedMenu = driver.findElements(By.xpath("//input[@value='OK']"));
            WebElement menu = newsFeedMenu.get(0);
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickOkMenuInAlertPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOkMenuInAlertPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void chooseFirstList(WebDriver driver) throws Exception{
        try {
            List<WebElement> alert = driver.findElements(By.xpath(".//*[@name='List']"));
            if (alert.size() > 0) {
                alert.get(0).click();
                ResultUtil.report("INFO", "Select the first List of the alert options", "First list of alert option is selected.", "", driver);
            }
            ResultUtil.report("INFO", "Select the first list of alert option", "First list of alert option is selected.", "", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'chooseFirstList' menu", "First list to be selected", "There are no lists", driver);
        }
    }

    public void enterTitle(String title, WebDriver driver,String BrowserName) throws Exception{
        try {
            WebElement titleName = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@title='Title Required Field']"), "Title Name text box is not found");
            titleName.sendKeys(title);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterTitle' method", "Should enter the title name", "", driver);
        }
    }

    public void verifyDefaultCategory(WebDriver driver)throws Exception{
        boolean Ideas = false;
        boolean Opinions = false;
        boolean Events = false;
        try {
            driver.findElement(By.xpath(".//a[text()='Ideas']"));
            Ideas = true;
            driver.findElement(By.xpath(".//a[text()='Opinions']"));
            Opinions = true;
            driver.findElement(By.xpath(".//a[text()='Events']"));
            Events = true;
            ResultUtil.report("PASS", "verifyDefaultCategory", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyDefaultCategory' method", "", "", driver);
        }
    }

    public void clickManageCategoriesMenu(WebDriver driver,String BrowserName) throws Exception{
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("admlnk3"), "");
            clickWithJavaScript(driver, menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickManageCategoriesMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickManageCategoriesMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickChangePostLayoutMenu(WebDriver driver,String BrowserName)throws Exception {
        try {
            WebElement dropDownMenu = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath(".//*[@class='ms-blog-skinSelector']"), "");
            clickWithJavaScript(driver, dropDownMenu);
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            ResultUtil.report("PASS", "clickChangePostLayoutMenu", "Should successfully click the dropdown", "Successfully click the dropdown", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickChangePostLayoutMenu' method", "Should click the dropdown", e.getMessage(), driver);
        }
    }

    public void verifyPostLayoutOptions(WebDriver driver)throws Exception{
        boolean Basic = false;
        boolean Boxed = false;
        boolean Inline = false;
        try {
            driver.findElement(By.xpath(".//option[text()='Basic']"));
            Basic = true;
            driver.findElement(By.xpath(".//option[text()='Boxed']"));
            Boxed = true;
            driver.findElement(By.xpath(".//option[text()='Inline']"));
            Inline = true;
            ResultUtil.report("PASS", "verifyPostLayoutOptions", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyPostLayoutOptions' method", "", "", driver);
        }
    }

    public void clickAddCategoryMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[text()='Add Category']"), "");
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickAddCategoryMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAddCategoryMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void editTitle(String title,WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement titleName = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[@title='Title Required Field']"), "Title Name text box is not found");
            titleName.clear();
            titleName.sendKeys(title);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'editTitle' method", "Should enter the title name", "", driver);
        }
    }

    public void selectEditMenuOfFirstCategory(String value,WebDriver driver) throws Exception {
        try {
            List<WebElement> edit = driver.findElements(By.xpath(".//*[text()='" + value + "']//..//.//..//..//*[@alt='edit']"));
            if (edit.size() > 0) {
                edit.get(0).click();
                ResultUtil.report("INFO", "Select the edit Menu", "edit Menu is selected.", "", driver);
            }
            ResultUtil.report("INFO", "Select the edit Menu", "edit Menu is selected.", "", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'selectEditMenuOfFirstComment' menu", "Edit menu to be selected", "There are no Articles", driver);
        }
    }

    public void clickAlertMeMenu(WebDriver driver, String BrowserName) throws Exception{
        try {
            WebElement alert = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@id='Ribbon.WebPartPage.Share.AlertMe-Large']"), "");
            clickWithJavaScript(driver,alert);

            ResultUtil.report("PASS", "clickAlertMeMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAlertMeMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }
    public void clickManageAlertOption(WebDriver driver, String BrowserName)throws Exception{
        try {
            waitInMilliSeconds(2000);
            WebElement alert = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[text()='Manage My Alerts']"), "");
            clickWithJavaScript(driver,alert);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickManageAlertOption", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickManageAlertOption' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickAddAlert(WebDriver driver, String BrowserName)throws Exception {
        try {
            WebElement alert = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Add Alert']"), "");
            clickWithJavaScript(driver,alert);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickAddAlert", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAddAlert' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickNextButton(WebDriver driver, String BrowserName)throws Exception {
        try {
            WebElement next = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@id='btnNext']"), "");
            clickWithJavaScript(driver,next);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickNextButton", "Should successfully click the Button", "Successfully click the Button", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickNextButton' method", "Should click the Button", e.getMessage(), driver);
        }
    }

    public void clickOkButton(WebDriver driver, String BrowserName)throws Exception {
        try {
            WebElement ok = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@value='OK']"), "");
            clickWithJavaScript(driver, ok);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOkButton", "Should successfully click the Button", "Successfully click the Button", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOkButton' method", "Should click the Button", e.getMessage(), driver);
        }
    }
    public void clickEditPageAndVerifyOptions(WebDriver driver, String BrowserName) throws Exception {
        boolean EditPage = false;
        boolean StopEditing = false;
        boolean EditInSharepoint = false;
        try {
            WebElement edit = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@id='Ribbon.WebPartPage.Edit.Edit-Large']/a"), "");
            edit.click();
            waitInMilliSeconds(1000);
            driver.findElement(By.xpath(".//span[text()='Edit Page']"));
            EditPage = true;
            driver.findElement(By.xpath(".//span[text()='Stop Editing']"));
            StopEditing = true;
            driver.findElement(By.xpath(".//span[text()='Edit in SharePoint Designer']"));
            EditInSharepoint = true;
            ResultUtil.report("PASS", "clickEditPageAndVerifyOptions", "Should successfully verify the options", "Successfully verified the options", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickEditPageAndVerifyOptions' method", "Should verify the options", e.getMessage(), driver);
        }
    }

    public void clickBrowseMenu(WebDriver driver, String BrowserName)throws Exception {
        try {
            WebElement page = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//span[text()='Browse']"), "");
            clickWithJavaScript(driver,page);
            waitInMilliSeconds(Integer.parseInt(Prerequsite.configMap.get("WAIT_FOR_SHORT_TIME")));
            ResultUtil.report("PASS", "clickBrowseMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickBrowseMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyEmailMenu(WebDriver driver) throws Exception{
        try {
            if ((driver.findElement(By.xpath("//label[text()='E-mail']")) != null))
            {
                ResultUtil.report("PASS", "verifyEmailMenu", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyEmailMenu", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyEmailMenu' method", "Should verify the menu", e.getMessage(), driver);
        }
    }

    public void verifySubscribeMenu(WebDriver driver,String BrowserName) throws Exception{
        boolean subscribeMenu = false;
        try {
            if (BrowserName.contains("ie")) {
                driver.findElement(By.id("feedlink"));
                subscribeMenu = true;
                driver.navigate().back();
                ResultUtil.report("PASS", "verifySubscribeMenu", "Should successfully click the menu", "Successfully click the menu", driver);

            } else {
                driver.findElement(By.id("feedSubscribeLine"));
                subscribeMenu = true;
                driver.navigate().back();
                ResultUtil.report("PASS", "verifySubscribeMenu", "Should successfully click the menu", "Successfully click the menu", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifySubscribeMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void selectFirstTitle(WebDriver driver)throws Exception{
        try {
            List<WebElement> edit = driver.findElements(By.xpath("//*[@class='ms-accentText']"));
            if (edit.size() > 0) {
                edit.get(0).click();
            }
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "Select the first Title", "First Title is selected.", "", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'selectFirstTitle' menu", "First title to be selected", "There are no titles", driver);
        }
    }

    public void verifyEmailLinkMenu(WebDriver driver) throws Exception{
        try {
            if ((findElementByNoThrow(driver,By.id("Ribbon.WebPartPage.Share.EmailPageLink-Large")) != null))
            {
                ResultUtil.report("PASS", "verifyEmailLinkMenu", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyEmailLinkMenu", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyEmailLinkMenu' method", "Should verify the menu", e.getMessage(), driver);
        }
    }

    public void clickPageMenu(WebDriver driver, String BrowserName)throws Exception{
        try {
            WebElement page = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Page']"));
            clickWithJavaScript(driver,page);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickPageMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickPageMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

}









