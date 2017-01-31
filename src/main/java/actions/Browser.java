package actions;

import common.ExtendedLibrary;
import intialize.Prerequsite;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import util.StringUtils;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Browser  {
    public WebDriver driver;
    public String BrowserName;

    public WebDriver launchURL(String platform, String browserName, String remoteurl, String strURL) {
        DesiredCapabilities capability = null;
        try {
             if (browserName.equalsIgnoreCase("FIREFOX")) {
                BrowserName = BrowserType.FireFox.getType();
//                 FirefoxProfile profile = new ProfilesIni().getProfile("Fire");
//                 capability = DesiredCapabilities.firefox();
//                 capability.setCapability(FirefoxDriver.PROFILE, profile);
//                 capability.setPlatform(Platform.WINDOWS);
                 File extension=new File(("src//main//java//resources//anad62oj.Fire"));
                 FirefoxProfile profile = new FirefoxProfile(extension);
                 capability=DesiredCapabilities.firefox();
                 capability.setCapability(FirefoxDriver.PROFILE,profile);
                 capability.setPlatform(Platform.WINDOWS);
             } else if (browserName.equalsIgnoreCase("IE")) {
                BrowserName = BrowserType.InternetExplore.getType();
                capability = DesiredCapabilities.internetExplorer();
                capability.setCapability("ignoreZoomSetting", true);
                capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capability.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
                capability.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                capability.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
                capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capability.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                 capability.setPlatform(Platform.WINDOWS);
            } else if (browserName.equalsIgnoreCase("CHROME")) {
                BrowserName = BrowserType.Chrome.getType();
                capability = DesiredCapabilities.chrome();
                 capability.setPlatform(Platform.WINDOWS);
            } else if (browserName.equalsIgnoreCase("SAFARI")) {
                BrowserName = BrowserType.Safari.getType();
                capability = DesiredCapabilities.safari();
                 capability.setPlatform(Platform.MAC);
             }

            driver = new RemoteWebDriver(new URL(remoteurl), capability);

            driver.manage().window().maximize();
            driver.get(strURL);
            Sync.waitForSeconds(5, driver);
            System.out.println("PASS" + "Opened <<" + strURL + ">> URL on " + browserName + " browser Machine:" + platform + driver);

        } catch (Exception e) {
//            throw new AssertionError("A clear description of the failure", e);
            e.printStackTrace();
//            ResultUtil.report("FAIL", "Unable to open URL-Exception occurred:" + e.getMessage(), "", "", driver);
     }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void waitInMilliSeconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new AssertionError("InterruptedException occurred while calling Thread.sleep for " + milliseconds + " milliseconds." + e);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public enum BrowserType {
        FireFox("*firefox"),
        Chrome("*chrome"),
        InternetExplore("*iexplore"),
        Safari("*safari"),
        Opera("*opera"),
        Android("*android"),;

        private String type;

        BrowserType(String type) {
            this.type = type;
        }

        public static BrowserType getBrowserType(String type) {
            if (type == null) {
                return BrowserType.FireFox;
            }
            for (BrowserType browserType : BrowserType.values()) {
                if (browserType.getType().contains(type.toLowerCase())) {
                    return browserType;
                }
            }
            return BrowserType.FireFox;
        }

        public String getType() {
            return this.type;
        }

    }

}
