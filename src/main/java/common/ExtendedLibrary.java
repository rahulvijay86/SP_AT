package common;

import actions.Browser;
import actions.ResultUtil;
import apppages.SharePointHomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ExtendedLibrary extends Browser {

    // public static final String CONFIG_FILE_PATH = "src\\config\\Config.properties";

    public static Reference _ref;

    static {
        _ref = new Reference();
//        _reference = Reference.instance();
    }

    private WebDriverWait wait;

    public static String getXPATHValue(String sKey) throws IOException {
        FileInputStream inputStream = new FileInputStream("src\\or\\OR.properties");
        Properties pro = new Properties();
        pro.load(inputStream);
        return pro.getProperty(sKey).toString().trim();

    }

    public static ExpectedCondition<Boolean> presenceOfAllElementsLocatedBy(final By locator) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(final WebDriver driver) {
                return !driver.findElements(locator).isEmpty();
            }
        };
    }

    public static ExpectedCondition<Boolean> pageToLoad(WebDriver driver) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(final WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
    }

    public static ExpectedCondition<String> appearingOfWindowAndSwitchToIt(final String title) {
        return new ExpectedCondition<String>() {
            @Override
            public String apply(final WebDriver driver) {
//                final String initialHandle = driver.getWindowHandle();
                for (final String handle : driver.getWindowHandles()) {
                    driver.switchTo().window(handle);
                    if (driver.getTitle().equals(title)) {
                        return handle;
                    }
                }
//                driver.switchTo().window(initialHandle);
                return null;
            }
        };
    }

    private static boolean needToSwitch(String initialHandle, String handle) {
        if (handle.isEmpty()) {
            return false;
        }
        return !initialHandle.equals(handle);
    }

    public void waitForWindowToBeAppearedAndSwitchToIt(WebDriver driver, String BrowserName,final String windowTitle) {
        waitFor(driver, BrowserName,appearingOfWindowAndSwitchToIt(windowTitle));
    }

    public Boolean waitForTextToBePresentInElement(final WebElement element, final String textToBePresent) {
        return waitFor(textToBePresentInElement(element, textToBePresent));
    }

    public WebElement waitForVisibilityOfElementLocatedBy(WebDriver driver, String BrowserName,final By locator) {
        return waitFor(driver, BrowserName, visibilityOfElementLocated(locator));
    }

    public WebElement waitFor1MinVisibilityOfElementLocatedBy(WebDriver driver, String BrowserName,final By locator) {
        return waitFor1Min(driver, BrowserName, visibilityOfElementLocated(locator));
    }

    public WebElement waitForVisibilityOfElement(WebDriver driver, String BrowserName,final WebElement element) {
        return waitFor(driver, BrowserName,visibilityOf(element));
    }

    public Boolean waitForInvisibilityOfElementLocatedBy(final By locator) {
        return waitFor(invisibilityOfElementLocated(locator));
    }

    public Boolean waitFor1MinInvisibilityOfElementLocatedBy(WebDriver driver, String BrowserName,final By locator) {
        return waitFor1Min(driver, BrowserName,invisibilityOfElementLocated(locator));
    }

    public <T> T waitFor(final ExpectedCondition<T> condition) {
        wait = new WebDriverWait(driver, 10);
        if (BrowserName.contains("ie")) {
            wait = new WebDriverWait(driver, 45);
        } else {
            wait = new WebDriverWait(driver, 40);
        }
        try {
            return wait.until(condition);
        } catch (UnhandledAlertException alertException) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                alert.dismiss();
            } catch (NoAlertPresentException ignored) {
                System.out.println("ignore alert");
            }
            return wait.until(condition);
        }
    }

    public <T> T waitFor(WebDriver driver, String BrowserName, final ExpectedCondition<T> condition) {
//        wait = new WebDriverWait(driver, 1);
        if (BrowserName.contains("ie")) {
            wait = new WebDriverWait(driver, 45);
        } else {
            wait = new WebDriverWait(driver, 40);
        }
        try {
            return wait.until(condition);
        } catch (UnhandledAlertException alertException) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                alert.dismiss();
            } catch (NoAlertPresentException ignored) {
                System.out.println("ignore alert");
            }
            return wait.until(condition);
        }
    }

    public <T> T waitFor1Min(WebDriver driver, String BrowserName, final ExpectedCondition<T> condition) {
        wait = new WebDriverWait(driver, 10);
        if (BrowserName.contains("ie")) {
            wait = new WebDriverWait(driver, 60);
        } else {
            wait = new WebDriverWait(driver, 60);
        }
        try {
            return wait.until(condition);
        } catch (UnhandledAlertException alertException) {
            try {
                Alert alert = driver.switchTo().alert();
//                String alertText = alert.getText();
                alert.dismiss();
            } catch (NoAlertPresentException ignored) {
                System.out.println("ignore alert");
            }
            return wait.until(condition);
        }
    }

    public WebElement waitForPresenceOfElementLocatedBy(WebDriver driver, String BrowserName, final By locator, String errorMessage) {
        try {
            WebElement resultElement = waitFor(driver, BrowserName, presenceOfElementLocated(locator));

            return resultElement;
        } catch (WebDriverException we) {
            ResultUtil.report("FAIL", "", "", errorMessage + "-" + we.getMessage(), driver);
            return null;
        }
    }

    public WebElement getParentElement(WebElement element) {
        return (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode", element);
    }

    public WebElement getParentElement(WebElement element, int numberOfLevels) {
        while (numberOfLevels > 0) {
            element = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode", element);
            numberOfLevels--;
        }
        return element;
    }

    public final Object executeScript(final String script, final Object... args) {
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }

    public final Object executeScript(WebDriver driver, final String script, final Object... args) {
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }

    public List<WebElement> waitForPresenceOfAllElementsLocatedBy(WebDriver driver, String BrowserName,final By locator) {
        waitFor(driver,BrowserName,presenceOfAllElementsLocatedBy(locator));
        return driver.findElements(locator);
    }

    public List<WebElement> waitForVisibilityOfAllElementsLocatedBy(WebDriver driver, String BrowserName,final By locator) {
        waitFor(driver,BrowserName,visibilityOfAllElementsLocatedBy(locator));
        return driver.findElements(locator);
    }

//    public Object clickWithJavaScript(WebElement elementToClick) {
//        return executeScript("arguments[0].click();", elementToClick);
//    }

    public Object clickWithJavaScript(WebDriver driver, WebElement elementToClick) {
        return executeScript(driver, "arguments[0].click();", elementToClick);
    }

    public void mouseHoverJScript(WebDriver driver, WebElement HoverElement) {
        try {
            if (isElementPresent(HoverElement)) {
                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
                ((JavascriptExecutor) driver).executeScript(mouseOverScript, HoverElement);
            }
            else {
            System.out.println("Element was not visible to hover " + "\n");

         }
        }

     catch (StaleElementReferenceException e) {
        System.out.println("Element with " + HoverElement
                + "is not attached to the page document"
                + e.getStackTrace());
    } catch (NoSuchElementException e) {
        System.out.println("Element " + HoverElement + " was not found in DOM"
                + e.getStackTrace());
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error occurred while hovering"
                + e.getStackTrace());
    }
}

    public static boolean isElementPresent(WebElement element) {
        boolean flag = false;
        try {
            if (element.isDisplayed()
                    || element.isEnabled())
                flag = true;
        } catch (NoSuchElementException e) {
            flag = false;
        } catch (StaleElementReferenceException e) {
            flag = false;
        }
        return flag;
    }



    public void waitForPageToLoad() {
        try {
            try {
                waitFor(driver, BrowserName,pageToLoad(driver));
            } catch (TimeoutException expected) {
                String readyState = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();
                ResultUtil.report("INFO", "*****ERROR***** TimeoutException occurred while waiting for page to load! return document.readyState value is '" + readyState + "' But expected to be 'complete'", "", "", driver);
//                LOGGER.error("*****ERROR***** TimeoutException occurred while waiting for page to load! return document.readyState value is '" + readyState + "' But expected to be 'complete'");
            } catch (WebDriverException e) {
                ResultUtil.report("INFO", "*****ERROR***** WebDriverException occurred while waiting for page to load!", "", "", driver);
//                LOGGER.error("*****ERROR***** WebDriverException occurred while waiting for page to load!");
            }
        } catch (Throwable unexpectedThrowable) {
            //TODO this catch should be removed by September 1 2014! Adding it to find out the reason of browsers being not closed after test
//            LOGGER.error("*****ERROR*****!!!*****ERROR*****Throwable occurred was throws during waiting for page to load!", unexpectedThrowable);
//            ResultUtil.report("INFO", "HomePage > logoutOnlineLibrary", "", "", driver);
        }
    }


    public void waitForWindowToBeAppearedByPartialTitleAndSwitchToIt(final String fullTitle) {
        waitFor(appearingOfWindowByPartialTitle(fullTitle));
    }

    public Alert waitForAlertToBeDisplayed() {
        return waitFor(alertIsPresent());
    }

    public static ExpectedCondition<String> appearingOfWindowByPartialTitle(final String fullTitle) {
        return new ExpectedCondition<String>() {
            @Override
            public String apply(final WebDriver driver) {
                final String initialHandle = driver.getWindowHandle();
                for (final String handle : driver.getWindowHandles()) {
                    if (needToSwitch(initialHandle, handle)) {
                        driver.switchTo().window(handle);
                        if (fullTitle.contains(driver.getTitle().split("\\(")[0].trim())) {
                            return handle;
                        }
                    }
                }
                driver.switchTo().window(initialHandle);
                return null;
            }
        };
    }

    public static ExpectedCondition<Alert> appearingOfAlert() {
        return new ExpectedCondition<Alert>() {
            @Override
            public Alert apply(final WebDriver driver) {
                try {
                    Alert alert = driver.switchTo().alert();
                    return alert;
                } catch (WebDriverException e) {
                    return null;
                }
            }
        };
    }

//    public void waitForNewPopUpWindowAndSwitchToIt(WebElement webElement, boolean useActions) {
//        final Set<String> currentWindowHandles = driver.getWindowHandles();
//        WebElement element = waitForVisibilityOfElementLocatedBy(By.xpath("//form[@id='acmeform']//a[@id='singleselect_link_tor_wf_sect_0_flocation']"));
//        if (useActions) {
//            Actions actions = new Actions(driver);
//            actions.moveToElement(element);
//            actions.doubleClick().build().perform();
//            waitInMilliSeconds(3000);
//            int noOfWindows = driver.getWindowHandles().size();
//            System.out.println("WindowHandles: " + noOfWindows);
//            if (noOfWindows > 2) {
//                switchToLastWindow();
//                closeCurrentBrowserWindow();
//                waitForWindowToBeAppearedByPartialTitleAndSwitchToIt("SingleSelect");
//            } else {
//                waitForWindowToBeAppearedByPartialTitleAndSwitchToIt("SingleSelect");
//            }
//
//        } else {
//            webElement.click();
//        }
//        final String windowHandle = waitFor(appearingOfWindowWithNewTitle(currentWindowHandles));
//        driver.switchTo().window(windowHandle);
//    }

    public static ExpectedCondition<String> appearingOfWindowWithNewTitle(final Set<String> oldTitle) {
        return new ExpectedCondition<String>() {
            @Override
            public String apply(final WebDriver driver) {
                Set<String> windowHandles = driver.getWindowHandles();
                if (windowHandles.containsAll(oldTitle)) {
                    windowHandles.removeAll(oldTitle);
                    if (!windowHandles.isEmpty()) {
                        return windowHandles.iterator().next();
                    }
                }
                return null;
            }
        };
    }

    /**
     * getTableHeaderColumnIndex
     *
     * @param columnName Name of the column, whose index you want to have
     * @param allHeaders Point it to the table headers
     * @return int value, which is the index of the column in the table
     */
    public int getTableHeaderColumnIndex(String columnName, List<WebElement> allHeaders) {
        int rowIndex = -1;
        for (int iterator = 0; iterator < allHeaders.size(); iterator++) {
            if (columnName.equals(allHeaders.get(iterator).getText().trim())) {
                rowIndex = iterator;
            }
        }
        return rowIndex;
    }

//    public void reloadPage(By locator, String BrowserName, WebDriver driver) {
//        WebElement element = waitForPresenceOfElementLocatedBy(locator, BrowserName,"Element locator to clicking F5 was not found");
//        getDriver().navigate().refresh();
//        waitForStalenessOf(element);
////        waitForPageToLoad();
//    }

    public Boolean waitForStalenessOf(WebDriver driver, String BrowserName,final WebElement webElement) {
        return waitFor(driver,BrowserName,stalenessOf(webElement));
    }

    public final WebElement findElementByNoThrow(WebDriver driver,final By locator) {
        try {
            return driver.findElement(locator);
        } catch (WebDriverException ignored) {
            System.out.println("[INFO] Element not found... Ignoring exception");
            return null;
        }
    }


/*    public void switchToLastWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> windowIterator = windowHandles.iterator();
        if (windowIterator.hasNext()) {
            driver.switchTo().window(windowIterator.next());
        }
    }*/

    public void selectByIndex(WebElement selectWebElement, final int index, final String errorMessage) {
        try {
            selectByIndex(selectWebElement, index);
        } catch (NoSuchElementException e) {
            ResultUtil.report("FAIL", "selectByIndex: Unable to locate the element", "", "", driver);
            // throw new AssertionError(e);
        }
    }

    public void selectByIndex(WebElement selectWebElement, final int index) {
        if (BrowserName.contains("iexplorer")) {
            String value = getOptions(selectWebElement).get(index).getText();
            selectByText(selectWebElement, value);
        } else {
            wrappedSelect(selectWebElement).selectByIndex(index);
        }
    }

    public void selectByText(WebElement selectWebElement, final String text) {
        wrappedSelect(selectWebElement).selectByVisibleText(text);
        waitForPageToLoad();
    }

    public List<WebElement> getOptions(WebElement selectWebElement) {
        try {
            return wrappedSelect(selectWebElement).getOptions();
        } catch (UndeclaredThrowableException ignored) {
            //Sometimes this test fails in ie due to such exception
            waitInMilliSeconds(3000);
            return wrappedSelect(selectWebElement).getOptions();
        }
    }

    private org.openqa.selenium.support.ui.Select wrappedSelect(WebElement selectElement) {
        return new org.openqa.selenium.support.ui.Select(selectElement);
    }

    public String getSelectedText(WebElement selectWebElement) {
        return wrappedSelect(selectWebElement).getFirstSelectedOption().getText();
    }

    public void navigateToUrl(String url) {
        try {
            waitInMilliSeconds(1000);
            getDriver().navigate().to(url);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Unable to load with " + url + "", "", "", driver);
        }
    }

    public void switchToLastWindow() {
        Iterator<String> iterator = driver.getWindowHandles().iterator();
        String window = null;
        while (iterator.hasNext()) {
            window = iterator.next();
        }
        driver.switchTo().window(window);
    }

    public void switchToMainWindow(WebDriver driver) throws  Exception{
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }

    public void closeCurrentBrowserWindow() {
        driver.close();
    }

    public String getRandomCode() {
        final String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String smallLetters = "abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        Character randomCapitalChar = capitalLetters.charAt(r.nextInt(25));
        Character randomSmallChar = smallLetters.charAt(r.nextInt(25));
        int num = r.nextInt(9);
        String randomString = "_" + String.valueOf(randomCapitalChar) + String.valueOf(randomSmallChar) + String.valueOf(num);
        return randomString;
    }

    public void clickElementWithRetry(WebDriver driver, String BrowserName,WebElement element) {
        int iterationCount = 0;
        while (iterationCount < 5) {
            element.click();
            try {
                if (waitForStalenessOf(driver,BrowserName,element)) {
                    ResultUtil.report("PASS", "Click the element", "Should be able to Click the element", " Element is Clicked: Attempt: " + iterationCount, driver);
                    return;
                }
            } catch (NoSuchElementException ignored) {
                ResultUtil.report("INFO", "*****ERROR*****NoSuchElementException occurred after clickElementWithRetry()", "", "", driver);
                return;
            } catch (TimeoutException ignored) {
                ResultUtil.report("INFO", "*****ERROR*****TimeoutException occurred after clickElementWithRetry()", "", "", driver);
            } catch (WebDriverException ignored) {
                ResultUtil.report("INFO", "*****ERROR*****WebDriverException occurred after clickElementWithRetry()", "", "", driver);
            }
            waitInMilliSeconds(3000);
            iterationCount++;
        }
    }

    public void moveToElementAndClickWithRetry(WebDriver driver, String BrowserName,WebElement element) {
        int iterationCount = 0;
        while (iterationCount < 5) {
            new Actions(driver).moveToElement(element).click().perform();
            try {
                if (waitForStalenessOf(driver,BrowserName,element)) {
                    ResultUtil.report("PASS", "Click the element", "Should be able to Click the element", " Element is Clicked: Attempt: " + iterationCount, driver);
                    return;
                }
            } catch (NoSuchElementException ignored) {
                ResultUtil.report("INFO", "*****ERROR*****NoSuchElementException occurred after clickElementWithRetry()", "", "", driver);
                return;
            } catch (TimeoutException ignored) {
                ResultUtil.report("INFO", "*****ERROR*****TimeoutException occurred after clickElementWithRetry()", "", "", driver);
            } catch (WebDriverException ignored) {
                ResultUtil.report("INFO", "*****ERROR*****WebDriverException occurred after clickElementWithRetry()", "", "", driver);
            }
            waitInMilliSeconds(3000);
            iterationCount++;
        }
    }

//    public void clickAddNewObjectiveForIE() {
//        final By NEW_OBJECTIVE_LOCATOR = By.xpath("//div[@id='tgm-action-bar']//a[contains(text(),'Create a New Development Objective')]");
//        int iterationCount = 0;
//        while (iterationCount < 5) {
//            WebElement newObjective = waitForVisibilityOfElementLocatedBy(NEW_OBJECTIVE_LOCATOR);
//            newObjective.click();
//            waitInMilliSeconds(1000);
//            try {
//                if (driver.getWindowHandles().size() > 1) {
//                    ResultUtil.report("PASS", "Click Add New Objective", "Should be able to Click Add New Objective", "Add New Objective is Clicked: Attempt: " + iterationCount, driver);
//                    return;
//                }
//            } catch (NoSuchElementException ignored) {
//                ResultUtil.report("INFO", "*****ERROR*****NoSuchElementException occurred after clickAddNewObjectiveForIE()", "", "", driver);
//                return;
//            } catch (TimeoutException ignored) {
//                ResultUtil.report("INFO", "*****ERROR*****TimeoutException occurred after clickAddNewObjectiveForIE()", "", "", driver);
//            } catch (WebDriverException ignored) {
//                ResultUtil.report("INFO", "*****ERROR*****WebDriverException occurred after clickAddNewObjectiveForIE()", "", "", driver);
//            }
//            waitInMilliSeconds(1000);
//            iterationCount++;
//        }
//    }

    public void clickEditObjectiveForIE(WebElement element) {
        int iterationCount = 1;
        while (iterationCount < 5) {
            element.click();
//            ResultUtil.report("INFO", "Click Edit Objectives", "Should be able to Click Edit Objectives", "Edit Objectives is Clicked: Attempt: " + iterationCount, driver);
            try {
                if (driver.getWindowHandles().size() > 1) {
                    ResultUtil.report("PASS", "Click Edit Objectives", "Should be able to Click Edit Objectives", "Edit Objectives is Clicked: Attempt: " + iterationCount, driver);
                    return;
                }
            } catch (NoSuchElementException ignored) {
                ResultUtil.report("INFO", "*****ERROR*****NoSuchElementException occurred after clickAddNewObjectiveForIE()", "", "", driver);
                return;
            } catch (TimeoutException ignored) {
                ResultUtil.report("INFO", "*****ERROR*****TimeoutException occurred after clickAddNewObjectiveForIE()", "", "", driver);
            } catch (WebDriverException ignored) {
                ResultUtil.report("INFO", "*****ERROR*****WebDriverException occurred after clickAddNewObjectiveForIE()", "", "", driver);
            }
            waitInMilliSeconds(3000);
            iterationCount++;
        }
    }

//    public void clickFinishUntilWindowDisappear() {
//        int iterationCount = 1;
//        System.out.println("clickFinishUntilWindowDisappear - WindowSize " + driver.getWindowHandles().size());
//        if (driver.getWindowHandles().size() > 1) {
//            String windowTitle = driver.getTitle();
//            System.out.println("clickFinishUntilWindowDisappear - windowTitle " + windowTitle);
//            if (!windowTitle.equals("SingleSelect")) {
////                switchToMainWindow();
//                System.out.println("clickFinishUntilWindowDisappear - inside if ");
//                waitForWindowToBeAppearedAndSwitchToIt("SingleSelect");
//            }
//            WebElement element = waitForVisibilityOfElementLocatedBy(By.xpath(".//*[@id='wizNextButtonsingleSelect']"));
//            while (iterationCount < 5) {
////            element.click();
//                Actions actions = new Actions(driver);
//                actions.moveToElement(element);
//                actions.doubleClick().build().perform();
//                waitInMilliSeconds(3000);
////            ResultUtil.report("INFO", "Click Edit Objectives", "Should be able to Click Edit Objectives", "Edit Objectives is Clicked: Attempt: " + iterationCount, driver);
//                try {
//                    if (driver.getWindowHandles().size() == 1) {
//                        ResultUtil.report("PASS", "Click Finish button", "Should be able to Click Finish button", "Finish Button is Clicked: Attempt: " + iterationCount, driver);
//                        break;
//                    }
//                } catch (NoSuchElementException ignored) {
//                    ResultUtil.report("INFO", "*****ERROR*****NoSuchElementException occurred after clickCustomSelectUntilWindowAppears()", "", "", driver);
//                    return;
//                } catch (TimeoutException ignored) {
//                    ResultUtil.report("INFO", "*****ERROR*****TimeoutException occurred after clickCustomSelectUntilWindowAppears()", "", "", driver);
//                } catch (WebDriverException ignored) {
//                    ResultUtil.report("INFO", "*****ERROR*****WebDriverException occurred after clickCustomSelectUntilWindowAppears()", "", "", driver);
//                }
//                iterationCount++;
//            }
//        } else {
//            ResultUtil.report("FAIL", "Click Finish button", "Should be able to Click Finish button", "Custome Select Window is not present", driver);
//        }
//
//    }

}
