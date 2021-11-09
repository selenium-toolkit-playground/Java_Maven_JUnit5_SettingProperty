package com.seleniumToolkit.selenium.test.screenshot;

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert;
import com.seleniumToolkit.selenium.framework.screenshot.core.Capture;
import com.seleniumToolkit.selenium.framework.screenshot.core.ScreenShootMaker;
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest;
import com.seleniumToolkit.selenium.pageObject.Home;
import com.seleniumToolkit.selenium.pageObject.Solution;
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject;

import java.io.File;

public class PageScreenshotTest extends AbstractScreenshotTest{

    @SeleniumTest()
    public void screenshotScroll() {
        String screenshotFilePath = "screenshots/PageScreenshotTest_screenshotScroll.png";
        deleteFileIfExist(screenshotFilePath);
        Home home = AbstractSeleniumToolkitPageObject.loadSeleniumToolkitPage();
        home.clickSolutionButton();

        home.prepareFixedElementsForScreenshot();
        ScreenShootMaker.page.shoot(Capture.FULL_SCROLL)
                .withName("PageScreenshotTest_screenshotScroll")
                .save();
        home.resetFixedElementsForScreenshot();

        File screenshotFile = new File(screenshotFilePath);
        ReportAssert.assertTrue("File should exist", screenshotFile.exists());
    }

    @SeleniumTest()
    public void screenshotScrollWithCutOut() {
        String screenshotFilePath = "screenshots/PageScreenshotTest_screenshotScrollWithCutOut.png";
        deleteFileIfExist(screenshotFilePath);
        Home home = AbstractSeleniumToolkitPageObject.loadSeleniumToolkitPage();
        Solution solution = home.clickSolutionButton();

        solution.prepareFixedElementsForScreenshot();
        ScreenShootMaker.page.shoot(Capture.FULL_SCROLL)
                .cutOut(solution.slider)
                .withName("PageScreenshotTest_screenshotScrollWithCutOut")
                .save();
        solution.resetFixedElementsForScreenshot();
        File screenshotFile = new File(screenshotFilePath);
        ReportAssert.assertTrue("File should exist", screenshotFile.exists());
    }


}
