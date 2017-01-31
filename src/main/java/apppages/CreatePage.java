package apppages;


import actions.ResultUtil;
import common.ExtendedLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;


public class CreatePage extends ExtendedLibrary {

    private static final List<String> POSSIBLE_CREATE_PAGE_MENU_OPTIONS = Arrays.asList(
            "BROWSE",
            "PAGE",
            "PUBLISH",
            "FORMAT TEXT INSERT",
            "FORMAT TEXT",
            "INSERT");

    public void clickViewAllPagesMenu(WebDriver driver, String BrowserName) throws Exception{
        try {
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.id("Ribbon.WikiPageTab.LibrarySettings.ViewAllPages-Large"));
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickViewAllPagesMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickViewAllPagesMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickCreatedPage(String pageTitle, WebDriver driver,String BrowserName) throws Exception{
        try {
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='" + pageTitle + "']"));
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickCreatedPage", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickCreatedPage' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyMenuUnderPageCreation(WebDriver driver, String BrowserName)throws Exception {
        boolean homeText = false;
        boolean documentsText = false;
        boolean recentText = false;
        boolean contentSearch = false;
        boolean toolsSearch = false;
        boolean siteSearch = false;

        try {
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Home']"), "");
            homeText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Documents']"), "");
            documentsText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Recent']"), "");
            recentText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Content Technology Support Links']"), "");
            contentSearch = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Tools and Resources FAQ']"), "");
            toolsSearch = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Site Contents']"), "");
            siteSearch = true;
            ResultUtil.report("PASS", "verifyMenuUnderPageCreation", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyMenuUnderPageCreation' method", "", "", driver);
        }
    }

    public void clickImagesAndAddMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement imagesMenu = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//div[@title='Images']"));
            imagesMenu.click();
            waitInMilliSeconds(2000);
            WebElement addMenu = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//button[contains(text(),'Add')]"));
            clickWithJavaScript(driver, addMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickImagesAndAddMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickImagesAndAddMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyDifferentCreatePageMenu(WebDriver driver, String BrowserName)throws Exception {
        boolean homeText = false;
        boolean documentsText = false;
        boolean recentText = false;
        boolean contentSearch = false;
        boolean toolsSearch = false;
        try {
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Browse']"), "");
            homeText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Page']"), "");
            documentsText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Publish']"), "");
            recentText = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Format Text']"), "");
            contentSearch = true;
            waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//span[text()='Insert']"), "");
            toolsSearch = true;
            ResultUtil.report("PASS", "verifyDifferentCreatePageMenu", "Should successfully verify all the menu", "Successfully verify all the menu", driver);
            waitInMilliSeconds(2000);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyDifferentCreatePageMenu' method", "", "", driver);
        }
    }

    public void clickSaveMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement save = waitForVisibilityOfElementLocatedBy(driver, BrowserName, By.xpath("//a[@title='Save']"));
            clickWithJavaScript(driver, save);
            waitForPageToLoad();
            waitInMilliSeconds(5000);
            ResultUtil.report("PASS", "clickSaveMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSaveMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickMenuInWileyImagesCategory(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//div[@title='Wiley Web Parts']"));
            clickWithJavaScript(driver,menu);
            waitInMilliSeconds(1000);
            ResultUtil.report("PASS", "clickWileyImagesAndAddMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickWileyImagesAndAddMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickMenuInWileyParts(WebDriver driver, String BrowserName,String title) throws Exception {
        try {
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//div[@title='" + title + "']"));
            clickWithJavaScript(driver,menu);
            waitInMilliSeconds(1000);
            ResultUtil.report("PASS", "clickMenuInWileyParts", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickMenuInWileyParts' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickAddMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement addMenu = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//button[contains(text(),'Add')]"));
            clickWithJavaScript(driver,addMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickAddMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickAddMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickMenuUnderWebpartHoverOption(WebDriver driver) throws Exception {
        try {
            List <WebElement> hoverMenu = driver.findElements(By.xpath("//span[contains(@id, 'WebPartTitleWPQ')]"));
            WebElement hover = hoverMenu.get(0);
            Actions action = new Actions(driver);
            action.moveToElement(hover).build().perform();
            List <WebElement> menu = driver.findElements(By.xpath("//input[@type='checkbox']"));
            WebElement checkbox = menu.get(0);
            clickWithJavaScript(driver,checkbox);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickMenuUnderWebpartHoverOption", "Should successfully hover the Webpart menu and clicked the option", "Successfully hovered the News menu and clicked the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickMenuUnderWebpartHoverOption' method", "Should hover the Webpart menu and click the option", e.getMessage(), driver);
        }
    }

    public void clickDropdownAndSelectOption(WebDriver driver, String BrowserName) throws Exception {
        try {
            List<WebElement> menu = driver.findElements(By.xpath("//a[contains(@id, 'MenuLink')]"));
            WebElement dropdown = menu.get(0);
            dropdown.click();
            waitInMilliSeconds(2000);
            WebElement editMenu = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Edit Web Part']"));
            clickWithJavaScript(driver,editMenu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickDropdownAndSelectOption", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickDropdownAndSelectOption' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyHeightErrorPresence(WebDriver driver) throws Exception {
        try {
            if ((driver.findElement(By.xpath("//div[contains(@id, 'Height_ERROR')]")) != null)) {
                ResultUtil.report("PASS", "verifyHeightErrorPresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyHeightErrorPresence", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyHeightErrorPresence' method", "", "", driver);
        }
    }

    public void clickCancelMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//input[contains(@id, 'CnclBtn')]"));
            clickWithJavaScript(driver,menu);
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickCancelMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickCancelMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void verifyHeightMenuPresence(WebDriver driver) throws Exception {
        try {
            if ((driver.findElement(By.xpath("//label[text()='Height']")) != null)) {
                ResultUtil.report("PASS", "verifyHeightMenuPresence", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyHeightMenuPresence", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyHeightMenuPresence' method", "", "", driver);
        }
    }

    public void clickYesOption(WebDriver driver) throws Exception {
        try {
            List<WebElement> yesMenu = driver.findElements(By.xpath("//input[@value='YesOption']"));
            WebElement menu = yesMenu.get(0);
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickYesOption", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickYesOption' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickNoOption(WebDriver driver) throws Exception {
        try {
            List<WebElement> yesMenu = driver.findElements(By.xpath("//input[contains(@id, 'NoOption')]"));
            WebElement menu = yesMenu.get(0);
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickNoOption", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickNoOption' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void enterPixelValue(WebDriver driver,String value) throws Exception {
        try {
            List<WebElement> yesMenu = driver.findElements(By.xpath("//input[contains(@id, 'SizeTextBox')]"));
            WebElement menu = yesMenu.get(0);
            menu.click();
            menu.sendKeys(value);
            waitForPageToLoad();
            ResultUtil.report("PASS", "enterPixelValue", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'enterPixelValue' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickOkMenu(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//input[@value='OK']"));
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            waitInMilliSeconds(2000);
            ResultUtil.report("PASS", "clickOkMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOkMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickSaveMenu(WebDriver driver) throws Exception {
        try {
            List <WebElement> menu = driver.findElements(By.xpath("//span[text()='Save']"));
            WebElement save = menu.get(0);
            clickWithJavaScript(driver,save);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickSaveMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickSaveMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }

    public void clickWebPartMenu(WebDriver driver) throws Exception {
        try {
            List<WebElement> webPartMenu = driver.findElements(By.xpath("//span[text()='Add a Web Part']"));
            WebElement menu = webPartMenu.get(0);
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickWebPartMenu", "Should successfully click the menu", "Successfully click the menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickWebPartMenu' method", "Should click the menu", e.getMessage(), driver);
        }
    }
}









