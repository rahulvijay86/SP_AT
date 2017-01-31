package apppages;


import actions.ResultUtil;
import common.ExtendedLibrary;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.List;


public class NewsFeedPage extends ExtendedLibrary {

    File file = new File("src//main//java//resources//Koala.jpg");
    File picfile = new File("src//main//java//resources//Jellyfish.jpg");

    public void startConversation(WebDriver driver,String BrowserName,String page)throws Exception {
        try {
            WebElement conv = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@title='Start a conversation']"), "Start Conversation text box is not found");
            conv.click();
            conv.sendKeys(page);
            waitInMilliSeconds(2000);
//            waitForVisibilityOfElementLocatedBy(driver, BrowserName,By.xpath("//*[@class='suggestion-match-text']")).click();
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'startConversation' method", "Should enter the Conversation", "", driver);
        }
    }

    public void addImage(WebDriver driver, String BrowserName)throws  Exception{
        try {
            WebElement add = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.id("ms-addImageButton"),"");
            clickWithJavaScript(driver, add);
            waitInMilliSeconds(2000);
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.className("ms-dlgFrame"), "");
            driver.switchTo().frame(iframeElement);
            WebElement uploadButton = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//*[@id='profileimagepickerinput']//..//input"), "Unable to find browse element.");
            uploadButton.sendKeys(file.getAbsolutePath());
            WebElement upload = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//*[@value='Upload']"), "");
            clickWithJavaScript(driver,upload);
            waitForPageToLoad();
            waitInMilliSeconds(3000);
            ResultUtil.report("PASS", "addImage", "File should be uploaded", "File is uploaded", driver);
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'addImage' method", "File should be uploaded", e.getMessage(), driver);
        }
    }

    public void clickOnPostButton(WebDriver driver, String BrowserName)throws Exception {
        try {
            WebElement post = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//*[text()='Post']"), "");
            clickWithJavaScript(driver, post);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnPostButton", "Should successfully click the PostButton", "Successfully click the PostButton", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnPostButton' method", "Should click the PostButton", e.getMessage(), driver);
        }
    }

    public void clickOnEveryOne(WebDriver driver, String BrowserName)throws  Exception{
        try {
            WebElement everyOne = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[text()='Everyone']"), "");
            clickWithJavaScript(driver, everyOne);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnEveryOne", "Should successfully click the EveryOne Menu", "Successfully click the EveryOne Menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnEveryOne' method", "Should click the EveryOne Menu", e.getMessage(), driver);
        }
    }

    public void selectTag(WebDriver driver, String BrowserName) throws  Exception{
        try {
            List<WebElement> tag = waitForPresenceOfAllElementsLocatedBy(driver,BrowserName,By.id("ms-actorElement"));
            WebElement menu = tag.get(0);
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            waitInMilliSeconds(1000);
            ResultUtil.report("SCREENSHOT", "Select the first Tag", "Tag is selected.", "", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'selectTag' method", "First Tag to be selected", "There are no Tags Available", driver);
        }
    }

    public void verifyPromoteButtonPresence(WebDriver driver) throws Exception{
        try {
            if ((findElementByNoThrow(driver,By.xpath("//*[text()='PROMOTE']")) != null)) {
                ResultUtil.report("PASS", "verifyPromoteButtonPresence", "PromoteButton should be present", "PromoteButton is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyPromoteButtonPresence", "PromoteButton should be present", "PromoteButton is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyPromoteButtonPresence' method", "", "", driver);
        }
    }

    public void clickFollowTag(WebDriver driver, String BrowserName) throws Exception {
        try {
            List<WebElement> follow = driver.findElements(By.xpath("//a[text()='Follow #WileyOnlineLibrary']"));
            if (follow.size() > 0) {
                follow.get(0).click();
                waitForPageToLoad();
                ResultUtil.report("SCREENSHOT", "Click on Follow Tag", "Clicked on Follow Tag", "", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickFollowTag' method", "Follow Tag to be Clicked", "No Follow Tag option Available", driver);
        }
    }
    public void clickUnFollowTag(WebDriver driver, String BrowserName) throws Exception {
        try {
            List<WebElement> unFollow = driver.findElements(By.xpath("//a[text()='Stop following #WileyOnlineLibrary']"));
            if (unFollow.size() > 0) {
                unFollow.get(0).click();
                waitForPageToLoad();
                ResultUtil.report("SCREENSHOT", "Click on UnFollow Tag", "Clicked on UnFollow Tag", "", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickUnFollowTag' method", "UnFollow Tag to be Clicked", "No UnFollow Tag option Available", driver);
        }
    }

    public void clickTag(WebDriver driver, String BrowserName) throws Exception {
        try {
            List<WebElement> tag = driver.findElements(By.id("ms-actorElement"));
            if (tag.size() > 0) {
                tag.get(0).click();
                waitForPageToLoad();
                ResultUtil.report("SCREENSHOT", "Select the first Tag", "Tag is selected.", "", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickTag' method", "First Tag to be selected", "There are no Tags Available", driver);
        }
    }

    public void clickOnAddRelatedTag(WebDriver driver, String BrowserName,String value) throws Exception {
        try {
            waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath(".//*[@id='txtSearch']")).click();
            waitInMilliSeconds(2000);
            WebElement tag = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//a[text()='Add']"), "");
            tag.click();
            WebElement addTag = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("ctl00_PlaceHolderMain_ctl05editableRegion"), "");
            addTag.click();
            addTag.sendKeys(value);
            waitForVisibilityOfElementLocatedBy(driver, BrowserName, By.id("ctl00_PlaceHolderMain_RelatedTags_AddBtn")).click();
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnAddRelatedTag", "Should successfully click the AddRelatedTag", "Successfully click the AddRelatedTag", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnAddRelatedTag' method", "Should click the AddRelatedTag", e.getMessage(), driver);
        }
    }

    public void ClickStartConversation(WebDriver driver,String BrowserName) throws  Exception{
        try {
            WebElement conv = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[@title='Start a conversation']"), "Start Conversation text box is not found");
            conv.click();
            ResultUtil.report("PASS", "ClickStartConversation", "Should successfully click the Start Conversation", "Successfully click the Start conversation", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'startConversation' method", "Should enter the Conversation", "", driver);
        }
    }

    public void clickLike(WebDriver driver, String BrowserName)throws  Exception{
        try {
            List<WebElement> like = driver.findElements(By.xpath("//a[text()='Like']"));
            if (like.size() > 0) {
                like.get(0).click();
                waitForPageToLoad();
                ResultUtil.report("SCREENSHOT", "Click on Like", "Clicked on Like", "", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickLike' method", "Like to be Clicked", "No Like option Available", driver);
        }
    }
    public void clickUnlike(WebDriver driver, String BrowserName)throws  Exception{
        try {
            List<WebElement> unLike = driver.findElements(By.xpath(".//a[text()='Unlike']"));
            if (unLike.size() > 0) {
                unLike.get(0).click();
                waitForPageToLoad();
                ResultUtil.report("SCREENSHOT", "Click on Unlike", "Clicked on Unlike", "", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickUnlike' method", "Unlike to be Clicked", "No Unlike option Available", driver);
        }
    }

    public void verifyActivitiesMenu(WebDriver driver) throws  Exception{
        try {
            if ((findElementByNoThrow(driver,By.xpath("//*[text()='Activities']")) != null)) {
                ResultUtil.report("PASS", "verifyActivitiesMenu", "Menu should be present", "Menu is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyActivitiesMenu", "Menu should be present", "Menu is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyActivitiesMenu' method", "", "", driver);
        }
    }

    public void clickMoreOptionsAndVerifyMenus(WebDriver driver, String BrowserName)throws  Exception{
        try {
            List<WebElement> more = waitForPresenceOfAllElementsLocatedBy(driver, BrowserName, By.xpath("//*[@class='ms-microfeed-mysitemenu-ellipsisImageParent']"));
            WebElement menu = more.get(1);
            menu.click();
            waitInMilliSeconds(3000);
            waitForVisibilityOfElement(driver,BrowserName,menu);
            if (((findElementByNoThrow(driver, By.xpath("//span[text()='Copy link to conversation']")) != null)) && ((findElementByNoThrow(driver, By.xpath("//span[text()='Follow up']")) != null)))
            ResultUtil.report("SCREENSHOT", "clickMoreOptionsAndVerifyMenus", "clickMoreOptionsAndVerifyMenus", "", driver);
        }

        catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickMoreOptionsAndVerifyMenus' method", "clickMoreOptionsAndVerifyMenus", "", driver);
        }
    }

    public void clickOnFollowingMenu(WebDriver driver, String BrowserName) throws  Exception{
        try {
            WebElement overFlow = waitForPresenceOfElementLocatedBy(driver, BrowserName,By.xpath("//*[text()='Following']"), "");
            clickWithJavaScript(driver, overFlow);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnFollowingMenu", "Should successfully click the Following Menu", "Successfully click the Following Menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnFollowingMenu' method", "Should click the Following Menu", e.getMessage(), driver);
        }
    }

    public void clickOnOverFlowMenu(WebDriver driver, String BrowserName) throws  Exception{
        try {
            WebElement overFlow = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath(".//*[@class='ms-pivotControl-overflowDot']"), "");
            clickWithJavaScript(driver,overFlow);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickOnOverFlowMenu", "Should successfully click the OverFlow Menu", "Successfully click the OverFlow Menu", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnOverFlowMenu' method", "Should click the OverFlow Menu", e.getMessage(), driver);
        }
    }

    public void postComment(String page,WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement conv = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@title='Start a conversation']"), "Start Conversation text box is not found");
            conv.click();
            conv.sendKeys(page);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'startConversation' method", "Should enter the Conversation", "", driver);
        }
    }

    public void addImageFile(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement add = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.id("ms-addImageButton"), "");
            clickWithJavaScript(driver,add);
            waitInMilliSeconds(2000);
            WebElement iframeElement = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.className("ms-dlgFrame"), "");
            driver.switchTo().frame(iframeElement);
            WebElement uploadButton = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@id='profileimagepickerinput']//..//input"), "Unable to find browse element.");
            uploadButton.sendKeys(picfile.getAbsolutePath());
            WebElement upload = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@value='Upload']"), "");
            clickWithJavaScript(driver,upload);
            waitForPageToLoad();
            ResultUtil.report("PASS", "addImage", "File should be uploaded", "File is uploaded", driver);
            waitForPageToLoad();
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'addImage' method", "File should be uploaded", e.getMessage(), driver);
        }
    }

    public String getOtherUsersPost(WebDriver driver,String user) throws Exception{
        String post = "";
        List<WebElement> promote = driver.findElements(By.xpath("//*[text()='" +user+ "']//..//..//*[text()='PROMOTE']//..//..//*[@class='ms-microfeed-postBody ms-textSmall']"));
        if (promote.size() > 0) {
            post = promote.get(0).getText().toString();
            System.out.println(post);
        }return post;
    }

    public void promoteOtherUsersPost(WebDriver driver,String BrowserName,String user) throws Exception{
        try{
            if(BrowserName.contains("safari")) {
                List<WebElement> promote = driver.findElements(By.xpath("//*[text()='" +user+ "']//..//..//a[text()='PROMOTE']"));
                WebElement menu = promote.get(0);
                ((JavascriptExecutor)driver).executeScript("confirm = function(message){return true;};");
                ((JavascriptExecutor)driver).executeScript("alert = function(message){return true;};");
                menu.click();
            } else {
                Actions action = new Actions(driver);
                List<WebElement> promote = driver.findElements(By.xpath(".//*[text()='" +user+ "']//..//..//a[text()='PROMOTE']"));
                if (promote.size() > 0) {
                    waitForPageToLoad();
                    action.click((promote.get(0))).build().perform();
                }
                waitInMilliSeconds(3000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                waitInMilliSeconds(2000);
                Alert alerts = driver.switchTo().alert();
                alerts.accept();
            }
        }catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'promoteOtherUsersPost' method", "Should Promote Other users post", e.getMessage(), driver);
        }
    }

    public String getPromotedPost(WebDriver driver,String user)throws Exception{
        String post = "";
        List<WebElement> promote = driver.findElements(By.xpath("//*[text()='" + user + "']//..//..//span[@class='ms-microfeed-postBody ms-textSmall']"));
        if (promote.size() > 0) {
            post = promote.get(0).getText().toString();
            System.out.println(post);
            waitInMilliSeconds(3000);
        }return post;
    }

    public String comparePosts(String post, String posts) {

        try {
            if (post.equals(posts)){
                ResultUtil.report("PASS", "Other user post is promoted", "", "", driver);
            }
            else{
                ResultUtil.report("FAIL", "EXCEPTION at 'comparePosts' method", "", "", driver);
            }
        }catch(Exception e) {
            ResultUtil.report("FAIL", "Exception occurred at comparePosts method.", "", "", driver);

        }return null;
    }

    public void postComment(WebDriver driver, String BrowserName,String page) throws Exception {
        try {
            WebElement conv = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath(".//*[@title='Start a conversation']"), "Start Conversation text box is not found");
            conv.click();
            conv.sendKeys(page);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'startConversation' method", "Should enter the Conversation", "", driver);
        }
    }

    public void clickOnPostTag(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement post = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@id='ms-postbutton']"), "");
            clickWithJavaScript(driver,post);
            driver.getWindowHandle();
            waitInMilliSeconds(5000);
//            Alert alert = driver.switchTo().alert();
//            alert.accept();
            ResultUtil.report("PASS", "clickOnPostButton", "Should successfully click the PostButton", "Successfully click the PostButton", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnPostButton' method", "Should click the PostButton", e.getMessage(), driver);
        }
    }

    public void verifyPromoteButtonAbsence(WebDriver driver) throws Exception {
        try {
            if ((findElementByNoThrow(driver,By.xpath("//*[text()='PROMOTE']")) == null)) {
                ResultUtil.report("PASS", "verifyPromoteButtonAbsence", "PromoteButton should be Absent", "PromoteButton is Absent", driver);
            } else {
                ResultUtil.report("FAIL", "verifyPromoteButtonAbsence", "PromoteButton should be Absent", "PromoteButton is Not Absent", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyPromoteButtonAbsence' method", "", "", driver);
        }
    }

    public void clickOnPromoteButton(WebDriver driver, String BrowserName,String value) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                List<WebElement> promote = waitForPresenceOfAllElementsLocatedBy(driver,BrowserName,By.xpath("//*[text()='" + value + "']//..//..//*[text()='PROMOTE']"));
                WebElement menu = promote.get(0);
                ((JavascriptExecutor)driver).executeScript("confirm = function(message){return true;};");
                ((JavascriptExecutor)driver).executeScript("alert = function(message){return true;};");
                clickWithJavaScript(driver,menu);
                ResultUtil.report("PASS", "clickOnPromoteButton", "Should successfully click the PromoteButton", "Successfully click the PromoteButton", driver);
            } else {
                Actions actions = new Actions(driver);
                List<WebElement> promote = driver.findElements(By.xpath("//*[text()='" + value + "']//..//..//*[text()='PROMOTE']"));
                actions.click(promote.get(0)).build().perform();
                waitInMilliSeconds(3000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                waitInMilliSeconds(2000);
                Alert alerts = driver.switchTo().alert();
                alerts.accept();
                ResultUtil.report("PASS", "clickOnPromoteButton", "Should successfully click the PromoteButton", "Successfully click the PromoteButton", driver);
            }

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnPromoteButton' method", "Should click the PromoteButton", e.getMessage(), driver);
        }
    }

    public void verifyPromotedNewsFeedPresence(WebDriver driver, String value) throws Exception {
        try {
            if ((findElementByNoThrow(driver,By.xpath("//*[text()='"+value+"']")) != null)) {
                ResultUtil.report("PASS", "verifyPromotedNewsFeedPresence", "PromotedNewsFeed should be present", "PromotedNewsFeed is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyPromotedNewsFeedPresence", "PromotedNewsFeed should be present", "PromotedNewsFeed is Not present", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyPromotedNewsFeedPresence' method", "", "", driver);
        }
    }

    public void clickDelegationButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement menu = waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//span[text()='Delegation']"));
            clickWithJavaScript(driver,menu);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickDelegationButton", "Should successfully click the Delegation Button", "Successfully click the Delegation Button", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickDelegationButton' method", "Should click the Delegation Button", e.getMessage(), driver);
        }
    }

    public void clickFollowedTagAndEnterValue(WebDriver driver, String BrowserName,String value) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement addTag = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//div[@title='Followed #Tags']/div"), "");
                //addTag.click();
                addTag.sendKeys(value);
                ResultUtil.report("PASS", "clickFollowedTagAndEnterValue", "Should successfully clicked and entered the value", "Successfully clicked and entered the value", driver);
            } else {
                WebElement addTag = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//div[@title='Followed #Tags']/div"), "");
                //addTag.click();
                addTag.sendKeys(value);
                ResultUtil.report("PASS", "clickFollowedTagAndEnterValue", "Should successfully clicked and entered the value", "Successfully clicked and entered the value", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickFollowedTagAndEnterValue' method", "Should click and enter the value", e.getMessage(), driver);
        }
    }

}