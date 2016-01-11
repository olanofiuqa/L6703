package com.MacmillanProjects.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SFAdminProductViewerPage {
private final WebDriver driver;


public SFAdminProductViewerPage(WebDriver driver) {
	this.driver = driver;
}


public WebElement verifyLongtitle() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"j_id0:j_id1:j_id2:j_id3:j_id115:j_id198:0:expander:0:j_id240\"]"));
}


public WebElement verifyISBN() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"j_id0:j_id1:j_id2:j_id3:j_id115:j_id198:0:expander:0:j_id243\"]"));
}

public void enterSearchDetails(String dataTerms) {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id1:j_id2:j_id3:j_id115:search\"]/tbody/tr[1]/td[2]/input")).clear();
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id1:j_id2:j_id3:j_id115:search\"]/tbody/tr[1]/td[2]/input")).sendKeys(dataTerms);
}

public void clickSearchButton() {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id1:j_id2:j_id3:j_id115:j_id181\"]")).click();
}

public void clickExcludeHighSchoolBox() {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:j_id200:filterOnyx\"]/tbody/tr[2]/td[4]/input")).click();
}


public void clearYear() {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:j_id200:startyear\"]")).clear();
}


public void clickProductExpander() throws InterruptedException {
	//driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:j_id200:j_id283:0:j_id285\"]")).click();
	driver.findElement(By.xpath("//input[@class='btn' and @type='image']")).click();

}

public WebElement productExpander() throws InterruptedException {
	return driver.findElement(By.xpath("//input[@class='btn' and @type='image']"));
}

public WebElement productMissinglabel() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:j_id200:searchResults\"]/label"));
}



public void clickProductCheckbox() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:j_id200:j_id283:0:expander:0:j_id321\"]")).click();
}





public void enterQuantity(String dataTerms) {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:selected:tableTopProd:0:quantityId\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:selected:tableTopProd:0:quantityId\"]")).sendKeys(dataTerms);

}



}





