package com.seleniumToolkit.selenium.pageObject.template;

import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.seleniumToolkit.selenium.framework.driver.WebDriverManager;

public abstract class AbstractPageObject {

    public AbstractPageObject() {
        PageFactory.initElements(WebDriverManager.getWebdriver(), this);
    }

    protected void click(WebElement element){
        element.click();
    }

    protected void enter(WebElement element, CharSequence... input){
        element.sendKeys(input);
    }

    protected void enterRepalace(WebElement element, CharSequence input){
        element.clear();
        enter(element, input);
    }

    protected String getValueOfInput(WebElement element){
        return element.getAttribute("value");
    }

    protected void selectByValue(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

    protected void selectByLabel(WebElement element, String label) {
        new Select(element).selectByVisibleText(label);
    }

    protected void selectByIndex(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    protected String getText(WebElement element){
        return element.getText();
    }

    public void waitUntilUrlContains(String text) {
        Wait< WebDriver > wait = new WebDriverWait(WebDriverManager.getWebdriver(), 30);
        try {
            wait.until(driver -> driver.getCurrentUrl().contains(text));
        } catch (Throwable pageLoadWaitError) {
            ReportAssert.fail("Timeout during page load");
        }
    }


}
