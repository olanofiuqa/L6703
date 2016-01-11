package com.MacmillanProjects.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SFAdminCreatedAccountPage {
private final WebDriver driver;


public SFAdminCreatedAccountPage(WebDriver driver) {
	this.driver = driver;
}


public void clickNewButton() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
}

public void clickNewContact() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='button' and @title='New Contact']")).click();
}

public void clickExamSample() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[6]")).click();
}
public void clickExamSamplecontact() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[7]")).click();
}


public void clickEditAccount() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='button' and @title='Edit']")).click();
}

public void clickDeleteAccount() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='button' and @title='Delete']")).click();
}


}




