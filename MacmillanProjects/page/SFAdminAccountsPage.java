package com.MacmillanProjects.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SFAdminAccountsPage {
private final WebDriver driver;


public SFAdminAccountsPage(WebDriver driver) {
	this.driver = driver;
}


public void clickNewButton() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
}


public Select AllAccountsOption() {
	Select allaccounts = new Select(driver.findElement(By.xpath("//*[@id=\"fcf\"]")));
	return allaccounts;
}

public void clickViewAccountsGoButton() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input")).click();
}

public WebElement AccountRecordType() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ext-gen16\"]/div/table/thead/tr/td[9]/div"));
}

public WebElement choseAccountType() throws InterruptedException {
	return driver.findElement(By.xpath("//div[contains(@id,'ACCOUNT_TYPE')and contains(text(),'Department')]/preceding::div[4]"));
}

}




