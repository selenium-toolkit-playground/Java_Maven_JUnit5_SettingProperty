package com.seleniumToolkit.selenium.setting;

import com.seleniumToolkit.selenium.framework.interceptor.driver.WebDriverInterceptor;
import io.appium.java_client.android.AndroidOptions;
import io.appium.java_client.ios.IOSOptions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariOptions;

public class CustomWebDriverInterceptor implements com.seleniumToolkit.selenium.framework.interceptor.driver.WebDriverInterceptor {

    @Override
    public ChromeOptions chromeInterceptor(ChromeOptions chromeOptions, boolean localExecution) {
        return chromeOptions;
    }

    @Override
    public FirefoxOptions firefoxInterceptor(FirefoxOptions firefoxOptions, boolean localExecution) {
        return firefoxOptions;
    }

    @Override
    public InternetExplorerOptions internetExplorerInterceptor(InternetExplorerOptions internetExplorerOptions, boolean localExecution) {
        return internetExplorerOptions;
    }

    @Override
    public EdgeOptions edgeInterceptor(EdgeOptions edgeOptions, boolean localExecution) {
        return edgeOptions;
    }

    @Override
    public OperaOptions operaInterceptor(OperaOptions operaOptions, boolean localExecution) {
        return operaOptions;
    }

    @Override
    public SafariOptions safariInterceptor(SafariOptions safariOptions, boolean localExecution) {
        return safariOptions;
    }

    @Override
    public AndroidOptions androidInterceptor(AndroidOptions androidOptions, boolean localExecution) {
        return androidOptions;
    }

    @Override
    public IOSOptions iosInterceptor(IOSOptions iOSOptions, boolean localExecution) {
        return iOSOptions;
    }
}
