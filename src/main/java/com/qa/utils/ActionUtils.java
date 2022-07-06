package com.qa.utils;

import com.aventstack.extentreports.Status;
import com.qa.BasePO;
import com.qa.reports.ExtentReport;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.HashMap;

public class ActionUtils extends BasePO {
    static TestUtils utils = new TestUtils();

    public static void waitForVisibility(MobileElement e) {
//	  WebDriverWait wait = new WebDriverWait(getDriver(), TestUtils.WAIT);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(15))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisibility(WebElement e){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public static void clear(MobileElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public void click(MobileElement e) {
        waitForVisibility(e);
        e.click();
    }

    public static void click(MobileElement e, String msg) {
        waitForVisibility(e);
        utils.log().info("Clicked: " + msg);
        ExtentReport.getTest().log(Status.INFO, "Clicked: "+ msg);
        e.click();
    }

    public void sendKeys(MobileElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public static void sendKeys(MobileElement e, String txt, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        ExtentReport.getTest().log(Status.INFO, msg);
        e.sendKeys(txt);
    }

    public String getAttribute(MobileElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getText(MobileElement e, String msg) {
        String txt = null;
        switch(getPlatform()) {
            case "Android":
                txt = getAttribute(e, "text");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
        }
        utils.log().info(msg + txt);
        ExtentReport.getTest().log(Status.INFO, msg + txt);
        return txt;
    }

    public String getContextDesc(MobileElement e, String msg) {
        String txt = null;
        switch(getPlatform()) {
            case "Android":
                txt = getAttribute(e, "content-desc");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
        }
        utils.log().info(msg + txt);
        ExtentReport.getTest().log(Status.INFO, msg + txt);
        return txt;
    }

    public static void assertTrue(boolean b, String e, String condition) {
        if(b==true){
            utils.log().info(e + "- " + condition + " =" + b);
            ExtentReport.getTest().log(Status.INFO, e + "- " + condition + " =" + b);
        }
        else{
            utils.log().info(e + "- " + condition + " =" + b);
            ExtentReport.getTest().log(Status.INFO, e + "- " + condition + " =" + b);
        }
    }


    public MobileElement scrollToElement() {
        return (MobileElement) ((FindsByAndroidUIAutomator) getDriver()).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector().description(\"test-Price\"));");
    }

    public void iOSScrollToElement() {
        RemoteWebElement element = (RemoteWebElement)getDriver().findElement(By.name("test-ADD TO CART"));
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID);
//	  scrollObject.put("direction", "down");
//	  scrollObject.put("predicateString", "label == 'ADD TO CART'");
//	  scrollObject.put("name", "test-ADD TO CART");
        scrollObject.put("toVisible", "sdfnjksdnfkld");
        getDriver().executeScript("mobile:scroll", scrollObject);
    }


    public static String selectPlatform(){
        String platform = getDriver().getPlatformName();
        return platform;
    }

    public static void default_back() {
        getDriver().navigate().back();
    }

    public static <T> T getClassFromEnv(String env, String className) throws Exception
    {
        String path = "com.qa.actionVariable.";
        System.out.println(env);
        switch (env) {
            case "Android_Flutter":
            case "iOS_Flutter":
                path += "Flutter"; break;

            case "Android_RN":
            case "iOS_RN":
                path += "ReactNative"; break;

            case "Android_Native":
                path += "Android_Native"; break;
            case "iOS_Native":
                path += "iOS_Native"; break;
        }
        path += "." + className;
        System.out.println(path);
        return (T) Class.forName(path).getConstructor().newInstance();
    }

}
