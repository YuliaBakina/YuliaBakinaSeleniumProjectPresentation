package com.selenium.tests.model;

public class Bureau {
    private String searchBureauName;
    private String searchBureauAddress;

    public Bureau setSearchBureauName(String searchBureauName) {
        this.searchBureauName = searchBureauName;
        return this;
    }

    public Bureau setSearchBureauAddress(String searchBureauAddress) {
        this.searchBureauAddress = searchBureauAddress;
        return this;
    }

    public String getSearchBureauName()
    {
        return searchBureauName;
    }

    public String getSearchBureauAddress()
    {
        return searchBureauAddress;
    }
}
