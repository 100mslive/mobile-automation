package com.qa.actionVariable.Android_Native;

import com.qa.Interfaces.IHomePage;
import com.qa.utils.ActionUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends ActionUtils implements IHomePage {

    //Landing Page
    @AndroidFindBy(id = "live.hms.app2:id/edit_text_meeting_url")
    public static MobileElement meetingUrlField;

    //Add later
    @AndroidFindBy(id = "live.hms.app2:id/text_input_end_icon")
    public MobileElement crossBtn;

    @AndroidFindBy(id = "live.hms.app2:id/button_join_meeting")
    public MobileElement joinMeetingBtn;

    //HomePage Participant name Popup
    @AndroidFindBy(id = "live.hms.app2:id/edit_text_name")
    public MobileElement participantNameField;

    @Override
    public void put_meeting_url(String meetingUrl) {
        assertTrue(meetingUrlField.isDisplayed(),"meetingUrlField","isDisplayed");
        sendKeys(meetingUrlField, meetingUrl, "login with " + meetingUrl);
    }

    @Override
    public void enter_name_join(String participantName) {
        assertTrue(participantNameField.isDisplayed(),"joinMeetingBtn","isDisplayed");
        sendKeys(participantNameField, participantName, "login with " + participantName);
        assertTrue(joinMeetingBtn.isDisplayed(),"joinMeetingBtn","isDisplayed");
        click(joinMeetingBtn, "joinMeetingBtn");
    }

}
