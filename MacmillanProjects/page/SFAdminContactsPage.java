package com.MacmillanProjects.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class SFAdminContactsPage {
    private final WebDriver driver;


    public SFAdminContactsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickNewButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
    }

public Select ContactView() throws InterruptedException {
    Select viewcon = new Select(driver.findElement(By.xpath("//*[@id=\"fcf\"]")));
    return viewcon;
}
public void clickGoButton() throws InterruptedException {
    driver.findElement(By.xpath("//*[(@class='btn') and (@name='go')]")).click();
}

public void clickCampusplanner() throws InterruptedException {
	driver.findElement(By.xpath("//*[(@class='btn') and (@name='campus_planner')]")).click();
}



public List<WebElement> chocheckbox() {
return driver.findElements(By.xpath("//*[(@class=\"checkbox\")]"));
}



}