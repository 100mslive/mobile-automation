package com.qa.actionVariable.ReactNative;

import com.qa.Interfaces.IPreviewPage;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PreviewPage extends HomePage implements IPreviewPage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='platform_view[0]']/XCUIElementTypeOther/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//android.view.View[1]/android.widget.FrameLayout")
    public MobileElement videoTile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='Flutter 100ms']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]")
    @AndroidFindBy(xpath = "//android.view.View[2]")
    public MobileElement camBtn;

    @iOSXCUITFindBy(accessibility = "previewMuteAudio")
    @AndroidFindBy(xpath = "//android.view.View[3]")
    public MobileElement micBtn;

    @iOSXCUITFindBy(accessibility = "previewModalJoin")
    @AndroidFindBy(accessibility = "Join Now")
    public MobileElement joinNowBtn;

    @iOSXCUITFindBy(accessibility = "previewModalJoin")
    @AndroidFindBy(xpath = "//android.widget.Button[1]")
    public MobileElement previewList;

    @iOSXCUITFindBy(accessibility = "previewModalJoin")
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ImageView")
    public MobileElement networkBar;

    @iOSXCUITFindBy(accessibility = "Back")
    @AndroidFindBy(accessibility = "Back")
    public MobileElement backBtn;

    @iOSXCUITFindBy(accessibility = "Preview")
    @AndroidFindBy(accessibility = "Preview")
    public MobileElement previewPageHeading;

    public void click_mic(){
        ActionUtils.assertTrue(micBtn.isDisplayed(),"micBtn","isDisplayed");
        ActionUtils.click(micBtn, "micBtn");
    }
    public void click_cam() {
        ActionUtils.assertTrue(camBtn.isDisplayed(),"camBtn","isDisplayed");
        ActionUtils.click(camBtn, "camBtn");
    }
    public void click_joinNowBtn() {
        ActionUtils.assertTrue(joinNowBtn.isDisplayed(),"joinNowBtn","isDisplayed");
        ActionUtils.click(joinNowBtn, "joinNowBtn");
    }
    public void click_backBtn() {
        ActionUtils.assertTrue(joinNowBtn.isDisplayed(),"joinNowBtn","isDisplayed");
        ActionUtils.click(joinNowBtn, "joinNowBtn");
    }
    public void check_networkBar() {
        ActionUtils.assertTrue(networkBar.isDisplayed(),"joinNowBtn","isDisplayed");
    }
}
