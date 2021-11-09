package com.seleniumToolkit.selenium.test;

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert;
import com.seleniumToolkit.selenium.framework.driver.WebDriverManager;
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest;
import com.seleniumToolkit.selenium.pageObject.Home;
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject;
import io.qameta.allure.Feature;

import java.util.concurrent.TimeUnit;

public class InitialTest {

    @SeleniumTest()
    @Feature("InitialTest other depends on this")
    public void websiteIsUpAndRunning(){
        WebDriverManager.getWebdriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Home home = AbstractSeleniumToolkitPageObject.loadSeleniumToolkitPage();
        ReportAssert.assertEquals("How Easy To Run Selenium Tests?", home.getTextOfTitle());
    }
}
