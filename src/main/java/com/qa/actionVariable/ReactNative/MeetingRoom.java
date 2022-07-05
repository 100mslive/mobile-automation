package com.qa.actionVariable.ReactNative;

import com.qa.Interfaces.IMeetingRoom;
import com.qa.actionVariable.Flutter.PreviewPage;

public class MeetingRoom extends PreviewPage implements IMeetingRoom {


    public void goto_meetingRoom_mic_cam(String meetingUrl, String name, String cam,String mic) throws InterruptedException {
        put_meeting_url(meetingUrl);
        enter_name_join(name);
        assertTrue(micBtn.isDisplayed(),"micBtn","isDisplayed");
        assertTrue(camBtn.isDisplayed(),"camBtn","isDisplayed");
        assertTrue(joinNowBtn.isDisplayed(),"joinNowBtn","isDisplayed");


        if(cam.equalsIgnoreCase("on") && mic.equalsIgnoreCase("off"))
            click(micBtn, "micBtn");
        else if(cam.equalsIgnoreCase("off") && mic.equalsIgnoreCase("on"))
        {click(camBtn, "camBtn");Thread.sleep(5000);}
        else if(cam.equalsIgnoreCase("off") && mic.equalsIgnoreCase("off"))
        {click(micBtn, "micBtn"); click(camBtn,"camBtn");}

        click(joinNowBtn,"joinNowBtn");

    }

}
