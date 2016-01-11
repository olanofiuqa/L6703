package com.MacmillanProjects.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class SFAdminNewOpportunityPage {
private final WebDriver driver;


public SFAdminNewOpportunityPage(WebDriver driver) {
	this.driver = driver;
}

public void enterOpportunityName(String dataTerms) {
	driver.findElement(By.id("opp3")).clear();
	driver.findElement(By.id("opp3")).sendKeys(dataTerms);
}

public void clickSaveButton() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]")).click();
}

public Select Stage() {
	Select theStage = new Select(driver.findElement(By.id("opp11")));
	return theStage;
}


public WebElement verifyErrorMsgStage() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[4]/td[2]/div/div[2]"));
}


public Select OpportunityType() {
	Select theOppType = new Select(driver.findElement(By.id("00Ni000000COujY")));
	return theOppType;
}


public WebElement verifyErrorMsgClosingDate() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[5]/td[2]/div/div[2]"));
}


public void clickClosingDate() throws InterruptedException {
	driver.findElement(By.id("opp9")).click();
}

public Select CloseYear() {
	Select theyear = new Select(driver.findElement(By.id("calYearPicker")));
	return theyear;
}

public void clickClosingSelectedDate() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"calRow4\"]/td[4]")).click();
}


public Select leadSource() {
	Select thesource = new Select(driver.findElement(By.id("opp6")));
	return thesource;
}

public Select LMS() {
	Select theLms = new Select(driver.findElement(By.id("00Ni000000GLknE")));
	return theLms;
}

public WebElement verifyErrorMsgCampusCourse() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[5]/table/tbody/tr[1]/td[2]/div/div[2]"));
}


public void enterCampusCourse(String dataTerms) {
	driver.findElement(By.id("00Ni000000EGOtE")).clear();
	driver.findElement(By.id("00Ni000000EGOtE")).sendKeys(dataTerms);
}


public WebElement verifyErrorMsgCourseType() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[5]/table/tbody/tr[2]/td[2]/div/div[2]"));
}

public Select CourseType() {
	Select theLms = new Select(driver.findElement(By.id("opp5")));
	return theLms;
}


public WebElement verifyErrorMsgCourseDiscipline() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[5]/table/tbody/tr[3]/td[2]/div/div[2]"));
}

public Select Discipline() {
	Select theDiscipline = new Select(driver.findElement(By.id("00Ni000000EGOtL")));
	return theDiscipline;
}


//public Select MHECourse() {
//	Select theMHE = new Select(driver.findElement(By.id("00Ni000000EGOtU")));
//	return theMHE;
//}


public Select MHECourse() {
	Select theCourse = new Select(driver.findElement(By.id("00Ni000000EGOtU")));
	return theCourse;
}

public List <WebElement>  MHECourseLinks() throws InterruptedException {
	return (driver.findElements(By.id("00Ni000000EGOtU")));
}

public Select CourseStatus() {
	Select theCourseStatus = new Select(driver.findElement(By.id("00Ni000000EGOtJ")));
	return theCourseStatus;
}

public Select CourseTerm() {
	Select theCourseTerm = new Select(driver.findElement(By.id("00Ni000000COuja")));
	return theCourseTerm;
}

public Select CourseYear() {
	Select theCourseYear = new Select(driver.findElement(By.id("00Ni000000COujc")));
	return theCourseYear;
}

public WebElement verifyErrorMsgOppEnrollement() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[5]/table/tbody/tr[4]/td[4]/div/div[2]"));
}

public WebElement verifyErrorMsgOppEnrollementForWrongEntry() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[5]/table/tbody/tr[4]/td[4]/div/div[2]"));
}

public void enterOppEnrollment(String dataTerms) {
	driver.findElement(By.id("00Ni000000COujZ")).clear();
	driver.findElement(By.id("00Ni000000COujZ")).sendKeys(dataTerms);
}


//--------------------------------------------------------------------------------------

public WebElement verifyErrorMsgAccParent() throws InterruptedException {
	return driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[2]/td[2]/div/div[2]"));
}


public void clickParentAccountLookup() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"opp4_lkwgt\"]/img")).click();

}


public void clickContactLookup() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"contact0_lkwgt\"]/img")).click();

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


public void clickshowresults() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"msgBox\"]/table/tbody/tr/td[2]/div/div/a")).click();
}


public List<WebElement> getShowParentAccLinks() {
	return driver.findElements(By.partialLinkText("Abhi"));
}


public List<WebElement> getShowContactLinks() {
	return driver.findElements(By.partialLinkText("Raja"));
}

public WebElement framepresent() {
	return driver.findElement(By.xpath("//*[@id=\"theForm\"]/div/div[1]/div/div/img"));

}

public WebElement verifyOpportunityNamePresent() {
	return driver.findElement(By.id("opp3_ileinner"));

}

}





