package com.selenium.tests.fw;

import com.selenium.tests.model.Bureau;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ReceptionPointsHelper extends HelperBase{

    public ReceptionPointsHelper(WebDriver wd) {
        super(wd);
    }

    public void isReseptionPointsPageOpened() {
        String pageName = getText(By.xpath("//h1"));
        Assert.assertTrue(pageName.toLowerCase().contains("קבלת קהל"));
    }

    public void setFilterByAddress(Bureau bureau) {
        wd.findElement(By.cssSelector("[id='city']")).sendKeys(bureau.getSearchBureauAddress());
    }

    public void setFilterByBureauName(Bureau bureau) {
        wd.findElement(By.cssSelector("[id='autocompleteInput']")).sendKeys(bureau.getSearchBureauName());
        click(By.cssSelector("[id = 'suggestionsList_']"));
    }

    //open search result
    public void openPageFromSearchResults(Bureau bureau) throws InterruptedException {
        List<WebElement> searchResultsList = wd.findElements(By.cssSelector("div[role='tablist'] div[class='promoted ng-scope']"));

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
}
