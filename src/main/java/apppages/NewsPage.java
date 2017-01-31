package apppages;


import actions.ResultUtil;
import common.ExtendedLibrary;
import intialize.Prerequsite;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;


public class NewsPage extends ExtendedLibrary {

    public void clickOnFullStory(WebDriver driver, String BrowserName) throws Exception {
        try {
            List<WebElement> story = waitForVisibilityOfAllElementsLocatedBy(driver,BrowserName,By.xpath("//*[text()='Full Story']"));
            WebElement menu = story.get(0);
            clickWithJavaScript(driver,menu);
            ResultUtil.report("INFO", "Select the Full Story", "First Site Page is selected.", "", driver);
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickOnFullStory' method", "Full Story to be selected", "There are no Full Stories", driver);
        }
    }

    public int getLikes(WebDriver driver, String BrowserName) throws Exception {
        int like = 0; //it was 0 before
        try {
            waitInMilliSeconds(5000);
            WebElement likesNumber = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@class='LikesNumber']/b"), "Unable to find Likes Number.");
            like = Integer.parseInt(likesNumber.getText());
            System.out.println(like);
        }catch(Exception e){
            ResultUtil.report("FAIL", "Exception occurred at getLikes method.", "", "", driver);
        }
        return like;
    }

    public int likesIncrement(WebDriver driver,int Unlike, int like) {

        try {
            if (Unlike < like){
                ResultUtil.report("PASS", "The value is incremented", "", "", driver);
            }
            else{
                ResultUtil.report("FAIL", "EXCEPTION at 'likesIncrement' method", "", "", driver);
            }
        }catch(Exception e) {
            ResultUtil.report("FAIL", "Exception occurred at likesIncrement method.", "", "", driver);

        }return 0;
    }

    public int verifyZeroLikes(WebDriver driver,int Unlike) {

        try {
            if (Unlike == 0){
                ResultUtil.report("PASS", "The article is with zero likes", "", "", driver);
            }
            else{
                ResultUtil.report("FAIL", "EXCEPTION at 'verifyZeroLikes' method", "", "", driver);
            }
        }catch(Exception e) {
            ResultUtil.report("FAIL", "Exception occurred at verifyZeroLikes method.", "", "", driver);

        }return 0;
    }

    public int likesDecrement(WebDriver driver,int liked, int unliked) throws Exception {

        try {
            if (liked > unliked){
                ResultUtil.report("PASS", "The value is Decremented", "", "", driver);
            }
            else{
                ResultUtil.report("FAIL", "EXCEPTION at 'likesDecrement' method", "", "", driver);
            }
        }catch(Exception e) {
            ResultUtil.report("FAIL", "Exception occurred at likesDecrement method.", "", "", driver);

        }return 0;
    }

    public void verifyLikeButtonPresence(WebDriver driver) throws Exception {
        try {
            if ((findElementByNoThrow(driver, By.xpath("//*[@class='LikeDiv']")) != null)) {
                ResultUtil.report("PASS", "verifyLikeButtonPresence", "LikeButton should be present", "LikeButton is present", driver);
            } else {
                ResultUtil.report("FAIL", "verifyLikeButtonPresence", "LikeButton should be present", "LikeButton is Not present", driver);
            }
            waitInMilliSeconds(2000);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "Exception occurred in 'verifyLikeButton' method", "", "", driver);
        }
    }

    public void verifyLikeButton(WebDriver driver,String BrowserName) throws Exception {
        try {
            if ((waitForVisibilityOfAllElementsLocatedBy(driver, BrowserName, By.xpath("//*[@class='LikeImage']")).size()>0)) {
                ResultUtil.report("PASS", "verifyLikeButton", "Verify Like button option", "Like button option selected", driver);
            } else {
                waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@class='LikedImage']")).click();
                waitInMilliSeconds(2000);
            }

        } catch (Exception e) {
            waitForVisibilityOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@class='LikedImage']")).click();
            ResultUtil.report("PASS", "verifyLikeButton", "Verify Like button option", "Like button option selected", driver);
        }
    }
    public void clickLikeButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement like = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@class='LikeImage']"), "");
            clickWithJavaScript(driver,like);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickLikeButton", "Should successfully click like", "Successfully click like", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickLikeButton' method", "Should click like", e.getMessage(), driver);
        }
    }

    public void clickUnLikeButton(WebDriver driver, String BrowserName) throws Exception {
        try {
            WebElement unlike = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//*[@class='LikedImage']"), "");
            clickWithJavaScript(driver,unlike);
            waitForPageToLoad();
            ResultUtil.report("PASS", "clickUnLikeButton", "Should successfully click Unlike", "Successfully click Unlike", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'clickUnLikeButton' method", "Should click Unlike", e.getMessage(), driver);
        }
    }

    public void verifyTooltipAfterLike(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement tooltip = waitForPresenceOfElementLocatedBy(driver,BrowserName,By.xpath("//div[@class='LikeDiv']"),"");
                mouseHoverJScript(driver,tooltip);
                String toolTipText = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@class='LikedImage']"), "").getAttribute("title");
                System.out.println(toolTipText);
                String expected_tooltip = "Click to remove your like from this content";
                Assert.assertEquals(toolTipText, expected_tooltip);
                System.out.println("Message verified");
                ResultUtil.report("PASS", "verify: Tooltip Msg: " + toolTipText, "Should successfully verify the tooltip message", "Successfully verified the tooltip message", driver);
            } else {
                WebElement tooltip = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//div[@class='LikeDiv']"), "");
                Actions toolAct = new Actions(driver);
                toolAct.moveToElement(tooltip).build().perform();
                String toolTipText = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@class='LikedImage']"), "").getAttribute("title");
                System.out.println(toolTipText);
                String expected_tooltip = "Click to remove your like from this content";
                Assert.assertEquals(toolTipText, expected_tooltip);
                System.out.println("Message verified");
                ResultUtil.report("PASS", "verify: Tooltip Msg: " + toolTipText, "Should successfully verify the tooltip message", "Successfully verified the tooltip message", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyTooltipAfterLike' method", "Should verify the tooltip message", e.getMessage(), driver);
        }
    }

    public void verifyTooltipBeforeLike(WebDriver driver, String BrowserName) throws Exception {
        try {
            if(BrowserName.contains("safari")) {
                WebElement tooltip = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//div[@class='LikeDiv']"), "");
                mouseHoverJScript(driver,tooltip);
                String toolTipText = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@class='LikeImage']"), "").getAttribute("title");
                System.out.println(toolTipText);
                String expected_tooltip = "Click to show others you like this content";
                Assert.assertEquals(toolTipText, expected_tooltip);
                System.out.println("Message verified");
                ResultUtil.report("PASS", "verify: Tooltip Msg: " + toolTipText, "Should successfully verify the tooltip message", "Successfully verified the tooltip message", driver);
            } else {
                WebElement tooltip = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//div[@class='LikeDiv']"), "");
                Actions toolAct = new Actions(driver);
                toolAct.moveToElement(tooltip).build().perform();
                String toolTipText = waitForPresenceOfElementLocatedBy(driver, BrowserName, By.xpath("//*[@class='LikeImage']"),"").getAttribute("title");
                System.out.println(toolTipText);
                String expected_tooltip = "Click to show others you like this content";
                Assert.assertEquals(toolTipText, expected_tooltip);
                System.out.println("Message verified");
                ResultUtil.report("PASS", "verify: Tooltip Msg: " + toolTipText, "Should successfully verify the tooltip message", "Successfully verified the tooltip message", driver);
            }
        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyTooltipBeforeLike' method", "Should verify the tooltip message", e.getMessage(), driver);
        }
    }
    public void verifyLikeColor(WebDriver driver) throws Exception {
        try {
            String likeColor = driver.findElement(By.xpath("//*[@class='LikedImage']")).getCssValue("color");
            Assert.assertEquals("", "rgb(51, 51, 51)", likeColor);
            ResultUtil.report("PASS", "verifyLinkColor", "Should successfully verify the color", "Successfully verified the color", driver);

        } catch (Exception e) {
            ResultUtil.report("FAIL", "EXCEPTION at 'verifyLinkColor' method", "Should verify the color", e.getMessage(), driver);
        }
    }

}









