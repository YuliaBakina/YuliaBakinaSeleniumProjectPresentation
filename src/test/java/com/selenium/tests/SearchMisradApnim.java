package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchMisradApnim {

    WebDriver wd; //driver field


    @BeforeMethod // annotation for before
    public void setUp(){
        //wd = new ChromeDriver();
        wd = new FirefoxDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        wd.navigate().to("https://www.gov.il/");

    }

    @Test
    public void searchFromNavMenu(){
        wd.findElement(By.cssSelector("#tm-4")).click();
        String pageTitle = wd.findElement(By.cssSelector("h1 span")).getText();
        System.out.println("Page title: " + pageTitle);

    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        wd.quit();
    }

}
