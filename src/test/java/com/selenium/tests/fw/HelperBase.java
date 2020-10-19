package com.selenium.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    //methods - helpers
    public String getText(By locator) {
        return wd.findElement(locator).getText();
    }

    public void delay(int timeout) throws InterruptedException {
        Thread.sleep(timeout);
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        if(text != null){
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

}
