package com.seleniumToolkit.selenium.pageObject.template;

import java.util.concurrent.TimeUnit;

import com.seleniumToolkit.selenium.pageObject.Home;
import com.google.common.base.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;
import com.seleniumToolkit.selenium.framework.dataLoader.TestDataProvider;
import com.seleniumToolkit.selenium.framework.driver.WebDriverManager;

public abstract class AbstractSeleniumToolkitPageObject extends AbstractPageObject{

    public TopMenuPageObject topMenuPageObject = new TopMenuPageObject();

    private By titleBy = By.xpath("//*[@data-type='text']");

    @FindBy(id = "sliders-container")
    public WebElement slider;
    @FindBy(id = "hubspot-messages-iframe-container")
    public WebElement chatButton;

    public AbstractSeleniumToolkitPageObject() {
        PageFactory.initElements(WebDriverManager.getWebdriver(), this);
    }

    public String getTextOfTitle(){
        WebDriverWait wait = new WebDriverWait(WebDriverManager.getWebdriver(), 10);
        wait.until(driver -> !Strings.isNullOrEmpty(getText(driver.findElement(titleBy))));
        return getText(WebDriverManager.getWebdriver().findElement(titleBy));
    }

    public static Home loadSeleniumToolkitPage(){
        WebDriverManager.getWebdriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverManager.getWebdriver().get(TestDataProvider.getTestData("startUrl"));
        return new Home();
    }


    public void prepareFixedElementsForScreenshot(){
        WebDriverManager.getWebdriverAsJsExecutor().executeScript("arguments[0].setAttribute('style', 'position:unset!important;')", chatButton);
        topMenuPageObject.setHeaderUnfixedPos();
    }

    public void resetFixedElementsForScreenshot(){
        WebDriverManager.getWebdriverAsJsExecutor().executeScript("arguments[0].setAttribute('style', 'position:fixed!important;')", chatButton);
        topMenuPageObject.resetHeaderPos();
    }
}
