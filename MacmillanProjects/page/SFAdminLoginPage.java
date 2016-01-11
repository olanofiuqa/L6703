package com.MacmillanProjects.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SFAdminLoginPage {
    private final WebDriver driver;


    public SFAdminLoginPage( WebDriver driver ) {
        this.driver = driver;
    }


    public void enterSFUsername( String dataTerms ) {
        driver.findElement( By.id( "username" ) ).clear();
        driver.findElement( By.id( "username" ) ).sendKeys( dataTerms );
    }


    public void enterSFPassword( String dataTerms ) {
        driver.findElement( By.id( "password" ) ).clear();
        driver.findElement( By.id( "password" ) ).sendKeys( dataTerms );
    }


    public void clickSFSubmitLogin() throws InterruptedException {
        driver.findElement( By.id( "Login" ) ).click();
    }







    }

