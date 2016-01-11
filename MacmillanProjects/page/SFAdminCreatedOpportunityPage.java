package com.MacmillanProjects.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SFAdminCreatedOpportunityPage {
private final WebDriver driver;


public SFAdminCreatedOpportunityPage(WebDriver driver) {
	this.driver = driver;
}


public void clicknewContactRole() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='button' and @name='newRole']")).click();
}

public void clickSaveContact() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='submit' and @name='save']")).click();
}

public WebElement selectedcontact() throws InterruptedException {
	return driver.findElement(By.id("contact0"));
}



public void selectcontactRole() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"primary0\"]")).click();

}

public Select selectRole() {
	Select therole = new Select(driver.findElement(By.id("role0")));
	return therole;
}

public void clickOpportunitySample() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[7]")).click();
}

public void clickAddProduct() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='button' and @name='addProd']")).click();
}



public void clickEditOpp() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='button' and @name='edit']")).click();
}

public void clickDeleteOpp() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='button' and @name='del']")).click();
}

}






