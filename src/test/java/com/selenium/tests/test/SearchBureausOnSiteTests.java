package com.selenium.tests.test;

import com.selenium.tests.TestBase;
import com.selenium.tests.object.Bureau;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBureausOnSiteTests extends TestBase {

    Bureau bureau = new Bureau()
            .setSearchBureauName("רשות האוכלוסין")
            .setSearchBureauAddress("ירושלים מרכז");

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        isMainPageOpened();
        delay(2000);
    }

    @Test(enabled = true)
    public void searchFromSearchBar() throws InterruptedException {
        System.out.println("Search bar test begins");

        //send searching info into the search bar
        typeInSearchBar(bureau);

        delay(2000);

        clickSearchSuggestion();

        //check if the right page is opened
        isRightPageOpened(bureau);

        System.out.println("Search bar test ends");
    }

    @Test
    public void searchFromFilters() throws InterruptedException {
        System.out.println("Filters test begins");

        //open filters page
        clickReceptionPointsTabInNavMenu();
        isReseptionPointsPageOpened();

        //send searching info into the filters
        setFilterByBureauName(bureau);
        setFilterByAddress(bureau);

        delay(2000);

        //choose the filters result
        openPageFromSearchResults(bureau);

        delay(2000);

        //check the right page is opened
        isRightPageOpened(bureau);

        System.out.println("Filter test ends");

    }


}
