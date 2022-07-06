package com.qa.actionVariable.Flutter;

import com.qa.Interfaces.IMeetingRoom;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MeetingRoom extends PreviewPage implements IMeetingRoom {

    @iOSXCUITFindBy(accessibility = "Back")
    @AndroidFindBy(accessibility =  "Ronit Roy (You)" )
    public static MobileElement myTile;

    @iOSXCUITFindBy(accessibility = "Back")
    @AndroidFindBy(accessibility =  "Ronit New Name (You)" )
    public static MobileElement myTile_nameChange;

    @iOSXCUITFindBy(accessibility = "Back")
    @AndroidFindBy(accessibility =  "//android.view.View[@content-desc='Ronit Roy (You)']/android.widget.FrameLayout" )
    public static MobileElement VideoTile_myTile;

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

        Thread.sleep(5000);
        click(joinNowBtn,"joinNowBtn");

    }

}
