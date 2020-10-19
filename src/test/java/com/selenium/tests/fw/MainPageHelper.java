package com.selenium.tests.fw;

import com.selenium.tests.model.Bureau;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageHelper extends HelperBase{

    public MainPageHelper(WebDriver wd) {
        super(wd);
    }

    public void isMainPageOpened(){
        if(!wd.getCurrentUrl().equalsIgnoreCase("https://www.gov.il/")){
            wd.navigate().to("https://www.gov.il/");
        }
    }

    public void typeInSearchBar(Bureau bureau) {
        type(By.id("SearchInput"), bureau.getSearchBureauName() + " " + bureau.getSearchBureauAddress());
    }

    public void clickSearchSuggestion() {
        click(By.className("autocomplete-suggestion"));
    }

    public void clickReceptionPointsTabInNavMenu() {
        click(By.cssSelector("#tm-4"));
    }

}
