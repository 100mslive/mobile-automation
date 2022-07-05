package com.qa.tests;

import com.qa.BasePO;
import com.qa.Interfaces.IHomePage;
import com.qa.Interfaces.IPreviewPage;
import com.qa.utils.ActionUtils;
import com.qa.utils.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.InputStream;
import java.lang.reflect.Method;

public class PreviewPageTest extends BasePO {

    IHomePage homePage;
    IPreviewPage previewPage;
    JSONObject meetingDetail;
    TestUtils utils = new TestUtils();
    SoftAssert sa;

    @BeforeClass
    public void beforeClass() throws Exception {
      InputStream datais = null;
      try {
        String dataFileName = "data/meetingDetail.json";
        datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
        JSONTokener tokener = new JSONTokener(datais);
        meetingDetail = new JSONObject(tokener);
      } catch(Exception e) {
        e.printStackTrace();
        throw e;
      } finally {
        if(datais != null) {
          datais.close();
        }
      }
    }

    @AfterClass
    public void afterClass() {
    }

    @Parameters({"env"})
    @BeforeMethod
    public void beforeMethod(Method m, String env) throws Exception {
      closeApp();
      launchApp();
      utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
      sa = new SoftAssert();
        previewPage = ActionUtils.getClassFromEnv(  env, "PreviewPage");
        homePage = ActionUtils.getClassFromEnv(  env, "HomePage");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
      sa.assertAll();
    }

    @Test
    public void Test_PreviewPage() throws InterruptedException {
        System.out.println("Verify Preview page locators");

        homePage.put_meeting_url(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        homePage.enter_name_join(meetingDetail.getJSONObject("valid").getString("username"));
//        previewPage.check_networkar();
        previewPage.click_cam();
        previewPage.click_mic();
        previewPage.click_joinNowBtn();
    }

}
