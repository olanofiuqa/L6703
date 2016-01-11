package com.MacmillanProjects.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SFAdminAllAppsPage {
    private final WebDriver driver;


    public SFAdminAllAppsPage(WebDriver driver) {
        this.driver = driver;
    }


public void clickCampusPlanner() throws InterruptedException {
    driver.findElement( By.linkText("Campus Planner") ).click();
}




    }

