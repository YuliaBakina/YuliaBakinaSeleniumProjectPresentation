package com.selenium.tests;

import com.selenium.tests.object.Bureau;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.List;

public class TestBase{

    protected static ApplicationManager appManager = new ApplicationManager();

    @BeforeSuite
    public void setUp(){
        appManager.init();
    }

    //checking opened pages
    public void isMainPageOpened(){
       if(!appManager.wd.getCurrentUrl().equalsIgnoreCase("https://www.gov.il/")){
           appManager.wd.navigate().to("https://www.gov.il/");
       }
    }

    public void clickReceptionPointsTabInNavMenu() {
        click(By.cssSelector("#tm-4"));
    }

    public void isRightPageOpened(Bureau bureau) {
        String bureauName = getText(By.name("PageTitle"));
        Assert.assertTrue(bureauName.toLowerCase().contains(bureau.getSearchBureauName())
                && bureauName.toLowerCase().contains(bureau.getSearchBureauAddress()));
    }

    public void isReseptionPointsPageOpened() {
        String pageName = getText(By.xpath("//h1"));
        Assert.assertTrue(pageName.toLowerCase().contains("קבלת קהל"));
    }

    //performing searches
    public void typeInSearchBar(Bureau bureau) {
        type(By.id("SearchInput"), bureau.getSearchBureauName() + " " + bureau.getSearchBureauAddress());
    }

    public void setFilterByAddress(Bureau bureau) {
        appManager.wd.findElement(By.cssSelector("[id='city']")).sendKeys(bureau.getSearchBureauAddress());
    }

    public void setFilterByBureauName(Bureau bureau) {
        appManager.wd.findElement(By.cssSelector("[id='autocompleteInput']")).sendKeys(bureau.getSearchBureauName());
        click(By.cssSelector("[id = 'suggestionsList_']"));
    }

    public void clickSearchSuggestion() {
        click(By.className("autocomplete-suggestion"));
    }

    //open search result
    public void openPageFromSearchResults(Bureau bureau) throws InterruptedException {
        List<WebElement> searchResultsList = appManager.wd.findElements(By.cssSelector("div[role='tablist'] div[class='promoted ng-scope']"));

        for(WebElement element: searchResultsList){
            if(element.getText().toLowerCase().contains(bureau.getSearchBureauAddress()))
            {
                element.click();
                delay(1000);
                element.findElement(By.cssSelector("[class='d-block nounderline']")).click();
                return;
            }

        }
    }

    //methods - helpers
    private String getText(By locator) {
        return appManager.wd.findElement(locator).getText();
    }

    public void delay(int timeout) throws InterruptedException {
        Thread.sleep(timeout);
    }

    public void type(By locator, String text) {
        click(locator);
        appManager.wd.findElement(locator).clear();
        if(text != null){
            appManager.wd.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator){
        appManager.wd.findElement(locator).click();
    }


    @AfterSuite(enabled = true)
    public void tearDown(){
        appManager.stop();
    }

}
