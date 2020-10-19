package com.selenium.tests.fw;

import com.selenium.tests.model.Bureau;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BureauPageHelper extends HelperBase{

    public BureauPageHelper(WebDriver wd) {
        super(wd);
    }

    public void isRightPageOpened(Bureau bureau) {
        String bureauName = getText(By.name("PageTitle"));
        Assert.assertTrue(bureauName.toLowerCase().contains(bureau.getSearchBureauName())
                && bureauName.toLowerCase().contains(bureau.getSearchBureauAddress()));
    }

}
