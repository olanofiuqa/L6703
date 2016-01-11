package com.MacmillanProjects.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SFAdminCreatedContactPage {
private final WebDriver driver;


public SFAdminCreatedContactPage(WebDriver driver) {
	this.driver = driver;
}

public WebElement verifyOnyxid() throws InterruptedException {
	return driver.findElement(By.id("00Ni000000COuhq_ileinner"));
}

public WebElement verifyOnyxidcontact() throws InterruptedException {
	return driver.findElement(By.id("00Ni000000COuii_ileinner"));
}

public void clickEditContact() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='button' and @title='Edit']")).click();

}

public void clickDeleteContact() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='button' and @title='Delete']")).click();
}

}








