package com.qa.actionVariable.ReactNative;

import com.qa.Interfaces.IHomePage;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends ActionUtils implements IHomePage {

    //Landing Page
    @iOSXCUITFindBy(accessibility = "roomIdInput")
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public static MobileElement meetingUrlField;

    //Add later
    @iOSXCUITFindBy(accessibility = "removeText")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"removeText\"]/android.widget.TextView")
    public MobileElement crossBtn;

    @iOSXCUITFindBy(accessibility = "joinButton")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[4]")
    public MobileElement joinMeetingBtn;

    @iOSXCUITFindBy(accessibility = "Get Started")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]")
    public MobileElement getStartedBtn;

    @Override
    public void put_meeting_url(String meetingUrl) {
        sendKeys(meetingUrlField, "https://qaroy1.qa.app.100ms.live/preview/ocu-ubk-oyu", "login with " + meetingUrl);
    }

    @Override
    public void enter_name_join(String participantName) throws InterruptedException {
        assertTrue(joinMeetingBtn.isDisplayed(),"meetingUrlField","isDisplayed");
        click(joinMeetingBtn, "joinMeetingBtn");
        Thread.sleep(2000);
        assertTrue(participantNameField.isDisplayed(),"participantNameField","isDisplayed");

        sendKeys(participantNameField, participantName, "Participant name- " + participantName);
        Thread.sleep(2000);
        assertTrue(getStartedBtn.isDisplayed(),"getStartedBtn","isDisplayed");

        click(getStartedBtn, "getStartedBtn");
    }

    //HomePage Participant name Popup
    @iOSXCUITFindBy(accessibility = "usernameInput")
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public MobileElement participantNameField;

    @iOSXCUITFindBy(accessibility = "joinButtonWithName")
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]")
    public MobileElement nameOKbtn;

    @iOSXCUITFindBy(accessibility = "cancelJoinButton")
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]")
    public MobileElement nameCancelbtn;


//    public PreviewPage goto_previewPage(String meetingUrl, String name) throws InterruptedException {
//      goto_enterName(meetingUrl);
//      put_participant_name(name);
//      click(nameOKbtn);
//      accept_permission();
//      return new PreviewPage();
//    }

    //HomePage OS permission
//    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
//    public MobileElement permissionCamMic;
//
//    public void accept_permission() throws InterruptedException {
//        String platform = ActionUtils.selectPlatform();
//        if (platform.equalsIgnoreCase("Android")) {
//          Assert.assertTrue(permissionCamMic.isDisplayed());
//          permissionCamMic.click();
//          permissionCamMic.click();
//          Thread.sleep(2000);
//        } else if (platform.equalsIgnoreCase("iOS")) {}
//    }
}
