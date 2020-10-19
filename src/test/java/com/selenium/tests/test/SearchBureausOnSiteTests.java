package com.selenium.tests.test;

import com.selenium.tests.model.Bureau;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBureausOnSiteTests extends TestBase {

    Bureau bureau = new Bureau()
            .setSearchBureauName("רשות האוכלוסין")
            .setSearchBureauAddress("ירושלים מרכז");

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        appManager.getMainPage().isMainPageOpened();
        appManager.getMainPage().delay(2000);
    }

    @Test(enabled = true)
    public void searchFromSearchBar() throws InterruptedException {
        System.out.println("Search bar test begins");

        //send searching info into the search bar
        appManager.getMainPage().typeInSearchBar(bureau);

        appManager.getMainPage().delay(2000);

        appManager.getMainPage().clickSearchSuggestion();

        //check if the right page is opened
        appManager.getBureauPage().isRightPageOpened(bureau);

        System.out.println("Search bar test ends");
    }

    @Test
    public void searchFromFilters() throws InterruptedException {
        System.out.println("Filters test begins");

        //open filters page
        appManager.getMainPage().clickReceptionPointsTabInNavMenu();
        appManager.getReceptionPoints().isReseptionPointsPageOpened();

        //send searching info into the filters
        appManager.getReceptionPoints().setFilterByBureauName(bureau);
        appManager.getReceptionPoints().setFilterByAddress(bureau);

        appManager.getReceptionPoints().delay(2000);

        //choose the filters result
        appManager.getReceptionPoints().openPageFromSearchResults(bureau);

        appManager.getReceptionPoints().delay(2000);

        //check the right page is opened
        appManager.getBureauPage().isRightPageOpened(bureau);

        System.out.println("Filter test ends");

    }


}
