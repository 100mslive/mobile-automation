package com.qa.actionVariable.Android_Native;

import com.qa.Interfaces.IPreviewPage;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PreviewPage extends HomePage implements IPreviewPage {

    @AndroidFindBy(xpath = "live.hms.app2:id/preview_view")
    public MobileElement videoTile;

    @AndroidFindBy(id = "live.hms.app2:id/button_toggle_video")
    public MobileElement camBtn;

    @AndroidFindBy(id = "live.hms.app2:id/button_toggle_audio")
    public MobileElement micBtn;

    @AndroidFindBy(id = "live.hms.app2:id/button_join_meeting")
    public MobileElement joinNowBtn;

    @AndroidFindBy(id = "live.hms.app2:id/action_participants")
    public MobileElement previewList;

    @AndroidFindBy(xpath = "//android.view.View/android.widget.ImageView")
    public MobileElement networkBar;

    @AndroidFindBy(id = "live.hms.app2:id/action_volume")
    public MobileElement toggleSpeaker;

    @AndroidFindBy(accessibility = "live.hms.app2:id/toolbar")
    public MobileElement previewPageToolbar;

    public void click_mic(){
        ActionUtils.assertTrue(micBtn.isDisplayed(),"micBtn","isDisplayed");
        ActionUtils.click(micBtn, "micBtn");
    }
    public void click_cam() {
        ActionUtils.assertTrue(camBtn.isDisplayed(),"camBtn","isDisplayed");
        ActionUtils.click(camBtn, "camBtn");
    }
    public void click_joinNowBtn(){
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
