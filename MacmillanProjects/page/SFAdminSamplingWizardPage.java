package com.MacmillanProjects.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SFAdminSamplingWizardPage {
private final WebDriver driver;


public SFAdminSamplingWizardPage(WebDriver driver) {
	this.driver = driver;
}


public void clickNewButton() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
}

public void clickNewContact() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"massActionForm_00119000009VyMj_RelatedContactList\"]/div[1]/table/tbody/tr/td[2]/input[1]")).click();
}

public void clickExamSample() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[6]")).click();
}


public Select selectShippingMethod() {
	Select themethod = new Select(driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id361:j_id365:ShipMethod\"]")));
	return themethod;
}

public Select selectSampleSourceOption() {
	Select thesource = new Select(driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id361:j_id365:SampleSource\"]")));
	return thesource;
}



public void enterFutureDate(String dataTerms) {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id361:j_id365\"]/div/table/tbody/tr[2]/td[2]/input")).sendKeys(dataTerms);
}

public void enterContactName(String dataTerms) {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id401:j_id420\"]/input[1]")).clear();
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id401:j_id420\"]/input[1]")).sendKeys(dataTerms);
}


public List<WebElement> verifyCheckBoxSelected() throws InterruptedException {
	return driver.findElements(By.xpath("//*[@type=\"checkbox\"]"));
}

public WebElement verifyCheckBoxSelect() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@type=\"checkbox\"]"));
}

public void clickcontactbox() throws InterruptedException {
	driver.findElement(By.xpath("//*[@type=\"checkbox\"]")).click();
}

public WebElement checkBoxSelect() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id339:j_id347\"]/table/thead/tr/th[1]/input"));
}


public WebElement contactrecord() throws InterruptedException {
	return driver.findElement(By.id("j_id0:j_id31:j_id372:j_id373:0:j_id391"));
}

public void clickSelectAll() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id401:j_id424\"]/div/a[1]")).click();
}

public void clickSearch() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).click();

}

public void clickSearchnew() throws InterruptedException {
driver.findElement(By.xpath("//*[@id=\"j_id0:OppFrm:j_id31:j_id32:j_id144:j_id210\"]")).click();

}

public void clickcontactradio() throws InterruptedException {
	driver.findElement(By.id("j_id0:j_id31:j_id401:j_id404:2")).click();
}


public void clickNextButton() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='submit' and @value='Next']")).click();
}

public void clickNextButton1() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='submit' and @value='Next']")).click();
}

public void clickNextButton2() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id339:j_id342\"]/input[3]")).click();
}

public void clickSaveButton() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:selected:j_id117:SaveButton\"]")).click();
}


public void clickSaveButtonnew() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"j_id0:OppFrm:j_id31:j_id32:selected:j_id61:SaveButton\"]")).click();
}


public void clickSaveNewButton() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:selected:j_id117:saveNewBtn\"]")).click();
}

public void clickBacktolist() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[1]/div[2]/a")).click();
}

public List<WebElement> verifyInactiveAccount() throws InterruptedException {
	return driver.findElements(By.xpath("//tr[@class=\"dataRow\"]/following::td[contains(text(),'abhinav5@macmillan" +
			                                    ".com')]"));
}

public List<WebElement> allDuplicatesList() throws InterruptedException {
	return driver.findElements(By.xpath("//tr[contains (@class,'dataRow')]/following::td[contains(text(),'Convention')]"));
}

public List<WebElement> allDuplicates() throws InterruptedException {
	return driver.findElements(By.xpath("//tr[contains (@class,'dataRow')]/following::td[contains(text(),'Rep')]"));
}


public WebElement verifyBookgrabberAccount() throws InterruptedException {
	return driver.findElement(By.xpath("//tr[contains (@class,'dataRow')]/following::td[contains(text(),'abhinav2@macmillan.com')]/preceding::td/span/img[contains(@src,'/img/msg_icons/warning16.png')]"));
}

public WebElement verifyUnsolictedSamplesAccount() throws InterruptedException {
	return driver.findElement(By.xpath("//tr[contains (@class,'dataRow')]/following::td[contains(text(),'abhinav3@macmillan.com')]/preceding::td/span/img[contains(@src,'/img/msg_icons/error16.png')]"));
}


public WebElement verifyBookgrabberImage() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:selected:tableTopProd:0:j_id138\"]/img"));
}


public WebElement verifyQuantityErrorImage() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@src=\"/img/msg_icons/error16.png\"]"));
}

public WebElement verifyUnsolictedSamplesImage() throws InterruptedException {
	return driver.findElement(By.xpath("//*span/img[contains(@src,'/img/msg_icons/error16.png')]"));
}

public WebElement verifyLongtitle() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:j_id200:j_id283:0:expander:0:j_id325\"]"));
}


public WebElement verifyISBN() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:j_id200:j_id283:0:expander:0:j_id328\"]"));
}

public WebElement verifyPerfectAccount() throws InterruptedException {
	return driver.findElement(By.xpath("//tr[contains (@class,'dataRow')]/following::td[contains(text(),'abhinav4@macmillan.com')]/preceding::td/span/img[contains(@src,'/img/msg_icons/confirm16.png')]"));
}


public void enterSearchDetails(String dataTerms) {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:j_id200:search\"]/tbody/tr[1]/td[2]/input")).clear();
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:j_id200:search\"]/tbody/tr[1]/td[2]/input")).sendKeys(dataTerms);
}




public void enterSearchDetailsnew(String dataTerms) {
	driver.findElement(By.xpath("//input[@type='text' and @name='j_id0:OppFrm:j_id31:j_id32:j_id144:j_id150']")).clear();
	driver.findElement(By.xpath("//input[@type='text' and @name='j_id0:OppFrm:j_id31:j_id32:j_id144:j_id150']")).sendKeys(dataTerms);
}


public void clickSearchButton() {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:j_id200:j_id266\"]")).click();
}

public void clickExcludeHighSchoolBox() {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:j_id200:filterOnyx\"]/tbody/tr[2]/td[4]/input")).click();
}

public void clickExcludeHighSchoolBoxnew() {
	driver.findElement(By.xpath("//*[@id=\"j_id0:OppFrm:j_id31:j_id32:j_id144:filterOnyx\"]/tbody/tr[2]/td[4]/input")).click();
}


public void clearYear() {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:j_id200:startyear\"]")).clear();
}

public void clearYearnew() {
	driver.findElement(By.xpath("//*[@id=\"j_id0:OppFrm:j_id31:j_id32:j_id144:startyear\"]")).clear();
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

public WebElement productMissinglabelnew() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"j_id0:OppFrm:j_id31:j_id32:j_id144:searchResults\"]/label"));
}

public void clickProductCheckbox() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:j_id200:j_id283:0:expander:0:j_id321\"]")).click();
}

public void clickProductCheckboxnew() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"j_id0:OppFrm:j_id31:j_id32:j_id144:j_id227:0:expander:0:pref\"]")).click();
}





public void enterQuantity(String dataTerms) {
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:selected:tableTopProd:0:quantityId\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"j_id0:j_id31:j_id87:j_id88:selected:tableTopProd:0:quantityId\"]")).sendKeys(dataTerms);

}

public void enterQuantitynew(String dataTerms) {
	driver.findElement(By.xpath("//*[@id=\"j_id0:OppFrm:j_id31:j_id32:selected:tableTopProd:0:quantityId\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"j_id0:OppFrm:j_id31:j_id32:selected:tableTopProd:0:quantityId\"]")).sendKeys(dataTerms);
}


}





