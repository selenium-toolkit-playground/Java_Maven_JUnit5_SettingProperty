package com.seleniumToolkit.selenium.test.screenshot;

import java.io.File;

public class AbstractScreenshotTest {
    public void deleteFileIfExist(String filePath){
        File file = new File(filePath);
        if(file.exists()){
            file.delete();
        }
    }
}
