package com.selenium.tests.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    BureauPageHelper bureauPage;
    MainPageHelper mainPage;
    ReceptionPointsHelper receptionPoints;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        openSite("https://www.gov.il/");

        bureauPage = new BureauPageHelper(wd);
        mainPage = new MainPageHelper(wd);
        receptionPoints = new ReceptionPointsHelper(wd);

    }

    public BureauPageHelper getBureauPage() {
        return bureauPage;
    }

    public MainPageHelper getMainPage() {
        return mainPage;
    }

    public ReceptionPointsHelper getReceptionPoints() {
        return receptionPoints;
    }

    public void openSite(String url) {
        wd.navigate().to(url);
    }

    public void stop() {
        wd.quit();
    }
}
