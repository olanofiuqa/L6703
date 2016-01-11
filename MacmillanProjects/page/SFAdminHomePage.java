package com.MacmillanProjects.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SFAdminHomePage {
    private final WebDriver driver;


    public SFAdminHomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickAccountsButton() throws InterruptedException {
        driver.findElement( By.xpath( "//*[@id=\"Account_Tab\"]/a" ) ).click();
}

    public void clickContactsButton() throws InterruptedException {
        driver.findElement( By.id("Contact_Tab") ).click();
    }


public void clickMoreApps() throws InterruptedException {
    driver.findElement( By.xpath("//*[@id=\"AllTab_Tab\"]/a/img") ).click();
}

public void clickOpportunityButton() throws InterruptedException {
    driver.findElement( By.id( "Opportunity_Tab" ) ).click();
}


public void clickProductsviewerButton() throws InterruptedException {
    driver.findElement( By.id( "01ri00000015Xcx_Tab" ) ).click();
}

    }

