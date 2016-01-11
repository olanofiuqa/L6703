package com.MacmillanProjects.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class SFAdminNewContactsPage {
private final WebDriver driver;


public SFAdminNewContactsPage(WebDriver driver) {
	this.driver = driver;
}

public Select enterNameSalutation() {
	Select theSalutation = new Select(driver.findElement(By.id("name_salutationcon2")));
	return theSalutation;
}

public void enterFirstName(String dataTerms) {
	driver.findElement(By.id("name_firstcon2")).clear();
	driver.findElement(By.id("name_firstcon2")).sendKeys(dataTerms);
}

public void enterLastName(String dataTerms) {
	driver.findElement(By.id("name_lastcon2")).clear();
	driver.findElement(By.id("name_lastcon2")).sendKeys(dataTerms);
}


public void clickSaveButton() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]")).click();
}


public WebElement verifyErrorMsgLastName() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[2]/td[2]/div/div[2]"));
}


public WebElement verifyErrorMsgAccName() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[3]/td[2]/div/div[2]"));
}

public Select AccountSubType() {
	Select theAccountsub = new Select(driver.findElement(By.id("00Ni000000COui2")));
	return theAccountsub;
}

public WebElement verifyErrorMsgAccSub() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[2]/table/tbody/tr[4]/td[4]/div/div[2]"));
}


public void enterCAccount(String dataTerms) {
	driver.findElement(By.id("00Ni000000COuhi")).clear();
	driver.findElement(By.id("00Ni000000COuhi")).sendKeys(dataTerms);
}

public WebElement verifyErrorMsgCAcc() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[2]/table/tbody/tr[4]/td[4]/div/div[2]"));
}


public Select Jobrole() {
	Select theJobrole = new Select(driver.findElement(By.id("00Ni000000COuir")));
	return theJobrole;
}

public Select Status() {
	Select theJobrole = new Select(driver.findElement(By.id("00Ni000000COuiq")));
	return theJobrole;
}



public void enterEmail(String dataTerms) {
	driver.findElement(By.id("con15")).clear();
	driver.findElement(By.id("con15")).sendKeys(dataTerms);
}

public WebElement verifyErrorMsgEmail() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[7]/td[2]/div/div[2]"));
}


public Select SamplingAddressSelector() {
	Select theSas = new Select(driver.findElement(By.id("00Ni000000EGOsk")));
	return theSas;
}


public void clickCopyMailingtoShippingButton() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"head_2_ep\"]/span/span/a")).click();

}

public WebElement verifyAdjunctAccountLookup() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"CF00Ni000000EGOsl_lkwgt\"]/img"));
}

//--------------------------------------------------------------------------------------

public WebElement verifyErrorMsgAccParent() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div/div[2]"));
}


public void clickAccountLookup() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"con4_lkwgt\"]/img")).click();

}


public void clickAdjuncLookup() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"CF00Ni000000EGOsl_lkwgt\"]/img")).click();

}


public void enterSearchParentAcc(String dataTerms) {
	driver.findElement(By.id("lksrch")).clear();
	driver.findElement(By.id("lksrch")).sendKeys(dataTerms);
}


public void clickSearchParentAccGo() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"theForm\"]/div/div[2]/input[2]")).click();
}

public void clickCloseParentAccWindow() throws InterruptedException {
	driver.findElement(By.className("closeDOMWindow")).click();
}

private boolean checkElementClassExists(String ElementClass) {
	WebElement elementIdExists = null;
	try {
		elementIdExists = driver.findElement(By.className(ElementClass));
		return elementIdExists.isDisplayed();
	} catch (NoSuchElementException e) {
		return false;
	}
}

public boolean verifyParentAccWindowOpens() {
	return checkElementClassExists("closeDOMWindow");
}


public void clickshowfilters() throws InterruptedException {
	driver.findElement(By.id("showFiltersIdAccount")).click();
}


public List<WebElement> getShowParentAccLinks() {
	return driver.findElements(By.partialLinkText("Abhi"));
}

public WebElement framepresent() {
	return driver.findElement(By.xpath("//*[@id=\"theForm\"]/div/div[1]/div/div/img"));

}

public void clickClearResults() throws InterruptedException {
	driver.findElement(By.className("clearResults")).click();
}


public void clickusedParentAcc() throws InterruptedException {
	driver.findElement(By.partialLinkText("AbhiCompany")).click();
}

public WebElement verifyCMailingState() {
	return driver.findElement(By.id("con19state"));
}


public WebElement verifyCMailingCountry() {
	return driver.findElement(By.id("con19country"));
}


public void clickReminderwindowoption() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"editPage\"]/div/div[2]/input[2]")).click();
}

public void clickBookGrabberBox() throws InterruptedException {
	driver.findElement(By.id("00Ni000000COuiY")).click();
}
public void clickUnsolicitedSamples() throws InterruptedException {
	driver.findElement(By.id("00Ni000000COuih")).click();
}

}





