package com.qa.actionVariable.Flutter;

import com.qa.Interfaces.IHomePage;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends ActionUtils implements IHomePage {
    //Landing Page
    @iOSXCUITFindBy(accessibility = "Enter Room URL")
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public MobileElement meetingUrlField;

    //Add later
    @iOSXCUITFindBy(accessibility = "removeText")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText/android.widget.Button")
    public MobileElement crossBtn;

    @iOSXCUITFindBy(accessibility = "joinButton")
    @AndroidFindBy(accessibility = "Join Now")
    public MobileElement joinMeetingBtn;

    @iOSXCUITFindBy(accessibility = "Get Started")
    @AndroidFindBy(accessibility = "Get Started")
    public MobileElement getStartedBtn;

    public void put_meeting_url(String meetingUrl){
        assertTrue(meetingUrlField.isDisplayed(),"meetingUrlField","isDisplayed");
//        sendKeys(meetingUrlField, meetingUrl, "login with " + meetingUrl);
        click(meetingUrlField, "meetingUrlField");

        sendKeys(meetingUrlField, meetingUrl, "login with " + meetingUrl);
        ActionUtils.default_back();
    }

    public void enter_name_join(String participantName) {
        assertTrue(joinMeetingBtn.isDisplayed(),"meetingUrlField","isDisplayed");
        click(joinMeetingBtn, "joinMeetingBtn");
        assertTrue(participantNameField.isDisplayed(),"participantNameField","isDisplayed");
        sendKeys(participantNameField, participantName, "Participant name- " + participantName);

        sendKeys(participantNameField, participantName, "Participant name- " + participantName);
        click(getStartedBtn, "getStartedBtn");
    }

    //HomePage Participant name Popup
    @iOSXCUITFindBy(accessibility = "Enter your Name")
    @AndroidFindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText")
    public MobileElement participantNameField;

    @iOSXCUITFindBy(accessibility = "OK")
    @AndroidFindBy(accessibility = "OK")
    public MobileElement nameOKbtn;

    @iOSXCUITFindBy(accessibility = "Cancel")
    @AndroidFindBy(accessibility = "Cancel")
    public MobileElement nameCancelbtn;


}
