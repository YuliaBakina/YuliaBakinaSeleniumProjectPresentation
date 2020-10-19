package com.selenium.tests.test;

import com.selenium.tests.fw.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase{

    protected static ApplicationManager appManager = new ApplicationManager();

    @BeforeSuite
    public void setUp(){
        appManager.init();
    }

    @AfterSuite(enabled = true)
    public void tearDown(){
        appManager.stop();
    }

}
