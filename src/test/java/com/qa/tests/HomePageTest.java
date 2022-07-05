package com.qa.tests;


import com.qa.BasePO;
import com.qa.Interfaces.IHomePage;
import com.qa.utils.ActionUtils;
import com.qa.utils.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class HomePageTest extends BasePO{

    IHomePage homePage;

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
    public void beforeMethod(Method m, String env) throws Exception{
        closeApp();
        launchApp();
        System.out.println(env);
        utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
        sa = new SoftAssert();
        homePage = ActionUtils.getClassFromEnv(  env, "HomePage");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        sa.assertAll();
    }


    @Test
    public void Test_HomePage() throws InterruptedException, IOException {
      System.out.println("Verify Meeting url space Visible");
        Thread.sleep(2000);

        homePage.put_meeting_url(meetingDetail.getJSONObject("valid").getString("meeting_url"));
        homePage.enter_name_join(meetingDetail.getJSONObject("valid").getString("username"));

    }

}
