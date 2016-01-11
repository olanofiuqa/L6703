package com.MacmillanProjects.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SFAdminOpportunityPage {
private final WebDriver driver;


public SFAdminOpportunityPage(WebDriver driver) {
	this.driver = driver;
}


public void clickNewButton() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
}

public WebElement anyOpp() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a"));
}

}