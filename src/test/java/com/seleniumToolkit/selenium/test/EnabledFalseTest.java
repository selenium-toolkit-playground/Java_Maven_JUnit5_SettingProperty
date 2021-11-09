package com.seleniumToolkit.selenium.test;

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert;
import com.seleniumToolkit.selenium.framework.driver.WebDriverManager;
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest;
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;

public class EnabledFalseTest {

    @Disabled
    @SeleniumTest()
    @Feature("Enabled False")
    public void webseiteVerfügbar(){
        AbstractSeleniumToolkitPageObject.loadSeleniumToolkitPage();
        ReportAssert.assertEquals(WebDriverManager.getWebdriver().getTitle(), "Selenium-Toolkit");
    }

}
