package com.MacmillanProjects.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SFAdminOrdersPage {
    private final WebDriver driver;


    public SFAdminOrdersPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterSFUsername( String dataTerms ) {
        driver.findElement( By.id( "username" ) ).clear();
        driver.findElement( By.id( "username" ) ).sendKeys( dataTerms );
    }

    public List<WebElement> listCreatedcontacts() throws InterruptedException {
        return driver.findElements(By.xpath("//*/table/tbody/tr/td[2]/a"));
    }
}

