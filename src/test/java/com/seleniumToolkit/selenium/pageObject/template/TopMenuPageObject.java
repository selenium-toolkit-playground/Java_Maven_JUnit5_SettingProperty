package com.seleniumToolkit.selenium.pageObject.template;

import com.seleniumToolkit.selenium.pageObject.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.seleniumToolkit.selenium.framework.driver.WebDriverManager;

import java.util.List;

public class TopMenuPageObject extends AbstractPageObject{

    @FindBy(xpath = "//header//*[contains(@class, 'fusion-header')]//*[contains(@class, 'fusion-header') and not(contains(@style,'display: none'))]")
    public List<WebElement> header;

    //Field declarations
    @FindBy(xpath="//a[@title='home']")
    public WebElement homeMenu;

    @FindBy(xpath="//a[@title='about']")
    public WebElement aboutMenu;

    @FindBy(xpath="//a[@title='solutions']")
    public WebElement solutionsMenu;

    @FindBy(xpath="//a[@title='getStarted']")
    public WebElement getStartedMenu;

    @FindBy(xpath="//a[@title='chromeExtension']")
    public WebElement chromeExtensionMenu;

    @FindBy(xpath="//a[@title='showcase']")
    public WebElement showcaseMenu;

    @FindBy(xpath="//a[@title='seleniumHelp']")
    public WebElement seleniumHelpMenu;

    public TopMenuPageObject() {
        super();
    }

    //HelperMethods
    public Home clickHomeMenu(){
        click( homeMenu);
        return new Home();
    }

    public About clickAboutMenu(){
        click( aboutMenu);
        return new About();
    }

    public Solution clickSolutionsMenu(){
        click( solutionsMenu);
        return new Solution();
    }

    public GetStarted clickGetStartedMenu(){
        click(getStartedMenu);
        return new GetStarted();
    }

    public ChromeExtension clickChromeExtensionMenu(){
        click( chromeExtensionMenu);
        return new ChromeExtension();
    }

    public Showcase clickShowcaseMenu(){
        click( showcaseMenu);
        return new Showcase();
    }

    public SeleniumHelp clickSeleniumHelpMenu(){
        click( seleniumHelpMenu);
        return new SeleniumHelp();
    }

    public void setHeaderUnfixedPos(){
        for (WebElement element: header){
            WebDriverManager.getWebdriverAsJsExecutor().executeScript("arguments[0].setAttribute('style', 'position:unset!important')", element);
        }
    }

    public void resetHeaderPos(){

        for (WebElement element: header){
            WebDriverManager.getWebdriverAsJsExecutor().executeScript("arguments[0].setAttribute('style', 'position:fixed!important')", element);
        }
    }


}
