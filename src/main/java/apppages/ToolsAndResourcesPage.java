package apppages;


import actions.ResultUtil;
import common.ExtendedLibrary;
import org.openqa.selenium.*;

import java.util.List;


public class ToolsAndResourcesPage extends ExtendedLibrary {

    public void clickOnTandRFavs(WebDriver driver, String BrowserName)throws Exception
    {
        try {
            WebElement menu = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='T and R Favs']"),"");
            clickWithJavaScript(driver,menu);
            ResultUtil.report("PASS","Click on T and R FAVS","Should click on T and R FAVS", "Successfully clicked on T and R FAVS", driver);
        }catch (Exception e){
            ResultUtil.report("FAIL","Exception occurred at 'Click on T and R FAVS' method","Should click on T and R FAVS", e.getMessage(),driver);
        }
    }

    public void addCategoryToFavorites(WebDriver driver, String BrowserName) throws Exception{
        try{
            if(BrowserName.contains("safari")) {
                List<WebElement> add = waitForPresenceOfAllElementsLocatedBy(driver, BrowserName, By.xpath("//*[text()='Add']"));
                WebElement menu = add.get(0);
                ((JavascriptExecutor)driver).executeScript("confirm = function(message){return true;};");
                clickWithJavaScript(driver, menu);
                waitInMilliSeconds(1000);
                ResultUtil.report("PASS", "addCategoryToFavorites", "Should successfully Add Category to Favorites", "Successfully Added Category to Favorites", driver);

            } else {
                List<WebElement> add = waitForPresenceOfAllElementsLocatedBy(driver,BrowserName,By.xpath("//*[text()='Add']"));
                WebElement menu = add.get(0);
                menu.click();
                waitInMilliSeconds(2000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                waitForPageToLoad();
                ResultUtil.report("PASS", "addCategoryToFavorites", "Should successfully Add Category to Favorites", "Successfully Added Category to Favorites", driver);
                
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'addCategoryToFavorites' Option", "Should Add Category to Favorites", e.getMessage(), driver);
        }
    }

    public void removeCategoryFromFavorites(WebDriver driver,String BrowserName)throws Exception{
        try {
            if(BrowserName.contains("safari")) {
                List<WebElement> delete = waitForPresenceOfAllElementsLocatedBy(driver, BrowserName, By.xpath("//*[text()='delete']"));
                WebElement menu = delete.get(0);
                ((JavascriptExecutor) driver).executeScript("confirm = function(message){return true;};");
                clickWithJavaScript(driver,menu);
                waitInMilliSeconds(1000);
                ResultUtil.report("PASS", "removeCategoryToFavorites", "Should successfully Delete Category from Favorites", "Successfully Deleted Category from Favorites", driver);

            } else {
                List<WebElement> delete = waitForPresenceOfAllElementsLocatedBy(driver,BrowserName,By.xpath("//*[text()='delete']"));
                WebElement menu = delete.get(0);
                menu.click();
                waitInMilliSeconds(2000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                waitForPageToLoad();
                ResultUtil.report("PASS", "removeCategoryToFavorites", "Should successfully Delete Category from Favorites", "Successfully Deleted Category from Favorites", driver);

            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'removeCategoryToFavorites' Option", "Should Delete Category from Favorites", e.getMessage(), driver);
        }
    }

    public void verifyToolsAndResources(WebDriver driver) throws Exception{
        try {
            if ((driver.findElement(By.xpath("//h1[text()='Tools and Resources']")) != null)) {
                ResultUtil.report("PASS", "verifyToolsAndResources", "Tools should be present", "Tools are present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyToolsAndResources", "Tools should be present", "Tools is Not present", driver);
                waitInMilliSeconds(2000);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyToolsAndResources' method", "", "", driver);
        }
    }

    public void clickOnFirstID(WebDriver driver) throws Exception{
        try {
            List<WebElement> firstID = driver.findElements(By.xpath(".//*[contains(@class,'imgCbx')]"));
            if (firstID.size() > 0)
            {
                firstID.get(0).click();
                waitForPageToLoad();
                ResultUtil.report("SCREENSHOT", "Click on UnFollow Tag", "Clicked on UnFollow Tag", "", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickUnFollowTag' method", "UnFollow Tag to be Clicked", "No UnFollow Tag option Available", driver);
        }
    }

    public void clickOnEditList(WebDriver driver, String BrowserName)throws Exception{
        try {
            WebElement List = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//a[text()='edit']"),"");
            clickWithJavaScript(driver,List);
            ResultUtil.report("PASS", "Click on Edit list", "Should click on Edit list link", "Successfully clicked on edit list link", driver);
        }catch (Exception e){
            ResultUtil.report("FAIL", "Exception occurred at 'Click on Edit List'", "Should click on EDIT list link", e.getMessage(), driver);
        }
    }

    public void clickOnStopEditing(WebDriver driver, String BrowserName)throws Exception{
        try {
            WebElement List = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//a[text()='Stop']"),"");
            clickWithJavaScript(driver,List);
            ResultUtil.report("PASS","Click on Stop list","Should click on stop", "Successfully clicked on stop", driver);
        }catch (Exception e){
            ResultUtil.report("FAIL", "Exception occurred at 'Click on Stop Edit'", "Should click on stop editing link", e.getMessage(), driver);
        }
    }

    public String getToolsName(WebDriver driver) throws Exception {
        String volume = null;
        try {
            List<WebElement> tools = driver.findElements(By.xpath(".//div[@class='resourceTitle']/a"));
            if (tools.size() > 0 && !tools.isEmpty()) {
                volume = tools.get(0).getText();
                System.out.println(volume);

            }
            else{
                ResultUtil.report("FAIL", "Tools is displayed with no value.", "", "", driver);
            }

        }catch(Exception e){
            ResultUtil.report("FAIL", "Exception occurred at getToolsName method.", "", "", driver);
        }
        return volume;
    }

    public String getToolsNameInHomePage(WebDriver driver,String BrowserName) throws Exception {
        String volume = null;
        try {
            List<WebElement> tools = waitForPresenceOfAllElementsLocatedBy(driver,BrowserName,By.xpath("//*[text()='Tools & Resources']//..//..//*[@class='link4']"));
            if (tools.size() > 0 && !tools.isEmpty()) {
                volume = tools.get(0).getText();
                System.out.println(volume);

            }
            else{
                ResultUtil.report("FAIL", "Tools is displayed with no value.", "", "", driver);
            }

        }catch(Exception e){
            ResultUtil.report("FAIL", "Exception occurred at getToolsName method.", "", "", driver);
        }
        return volume;
    }

    public String compareTools(WebDriver driver,String xxx, String yyy) throws Exception{

        try {
            if (xxx.equals(yyy)){
                ResultUtil.report("PASS", "The Tools match in the home page", "", "", driver);
            }
            else{
                ResultUtil.report("FAIL", "EXCEPTION at 'compareTools' method", "", "", driver);
            }
        }catch(Exception e) {
            ResultUtil.report("FAIL", "Exception occurred at compareTools method.", "", "", driver);

        }return null;
    }

    public void verifyWebPart(WebDriver driver) throws Exception {
        try {
            List<WebElement> tools = driver.findElements(By.xpath(".//*[text()='Tools & Resources']//..//..//*[@class='spriteContainer16x16']"));
            if (tools.size() > 0 && !tools.isEmpty()) {

            } else {
                ResultUtil.report("FAIL", "Tools is displayed with no value.", "", "", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred at getToolsName method.", "", "", driver);
        }
    }

}