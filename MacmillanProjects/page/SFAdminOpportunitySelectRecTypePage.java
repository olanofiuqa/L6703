package com.MacmillanProjects.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class SFAdminOpportunitySelectRecTypePage {
    private final WebDriver driver;


    public SFAdminOpportunitySelectRecTypePage(WebDriver driver) {
        this.driver = driver;
    }


    public Select OpportunityRecordType() {
        Select theAccount = new Select(driver.findElement(By.id("p3")));
        return theAccount;
    }

    public void clickContinueButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();


    }
}