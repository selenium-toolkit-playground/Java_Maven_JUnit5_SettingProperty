package com.seleniumToolkit.selenium.test;

import com.google.common.base.Strings;
import com.seleniumToolkit.selenium.framework.assertBase.ReportAssert;
import com.seleniumToolkit.selenium.framework.tag.SeleniumTest;
import com.seleniumToolkit.selenium.helper.ExcelAdapter;
import com.seleniumToolkit.selenium.pageObject.GetStarted;
import com.seleniumToolkit.selenium.pageObject.Home;
import com.seleniumToolkit.selenium.pageObject.template.AbstractSeleniumToolkitPageObject;
import io.qameta.allure.Feature;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DataProviderTest_Contact {

    @SeleniumTest
    @MethodSource("contactProvider")
    @Feature("DataProvider")
    public void contactWithStandardDataproviderParallel(String name
                                               ,String email
                                               ,String phone
                                               ,String message
                                               ,int errorSize){
        testContact(name, email, phone, message, errorSize);
    }

    @SeleniumTest
    @MethodSource("contactProviderFromExcel")
    @Feature("DataProvider")
    public void contactWithExcelDataproviderNotParallel(String name
                                               ,String email
                                               ,String phone
                                               ,String message
                                               ,int errorSize){
        testContact(name, email, phone, message, errorSize);
    }

    private void testContact(String name
            ,String email
            ,String phone
            ,String message
            ,int errorSize){
        Home home = AbstractSeleniumToolkitPageObject.loadSeleniumToolkitPage();

        GetStarted getStarted = home.topMenuPageObject.clickGetStartedMenu();

        if(!Strings.isNullOrEmpty(name)){
            getStarted.enterName(name);
        }
        if(!Strings.isNullOrEmpty(email)){
            getStarted.enterEmail(email);
        }
        if(!Strings.isNullOrEmpty(phone)){
            getStarted.enterPhoneNumber(phone);
        }
        if(!Strings.isNullOrEmpty(message)){
            getStarted.enterMessage(message);
        }
        getStarted.clickSubmitButton();
        ReportAssert.assertEquals("Test the Size of Errorlist", getStarted.getErrorFieldSize(), errorSize);
    }

    public static Stream<Arguments> contactProvider() {
        return Stream.of(
                Arguments.of("Michel", "no Vailid", "052 000 00 00", "", 3),
                Arguments.of("Michel", "info@selenium-toolkit.com", "", "", 2)
        );
    }

    public static Object[][] contactProviderFromExcel() throws Exception {
        Object[][] testObjArray = ExcelAdapter.getTableArray("testdata/contactInput.xlsx","Daten");
        return testObjArray;

    }

}
