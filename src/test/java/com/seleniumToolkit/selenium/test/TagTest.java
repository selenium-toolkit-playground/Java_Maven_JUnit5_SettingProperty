package com.seleniumToolkit.selenium.test;

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert;
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest;
import com.seleniumToolkit.selenium.pageObject.GetStarted;
import com.seleniumToolkit.selenium.pageObject.Home;
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject;

public class TagTest {

    @SeleniumTest(browser = "browserName=chrome,browserName=firefox")
    public void sample() {
        Home home = AbstractSeleniumToolkitPageObject.loadSeleniumToolkitPage();
        ReportAssert.assertEquals("How Easy To Run Selenium Tests?", home.getTextOfTitle());

        GetStarted getStarted = home.topMenuPageObject.clickGetStartedMenu();
        getStarted.enterName("Michel");
    }
}
