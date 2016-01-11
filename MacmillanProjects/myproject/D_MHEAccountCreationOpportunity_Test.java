package com.MacmillanProjects.myproject;

import com.MacmillanProjects.page.*;
import com.MacmillanProjects.utilityclass.GenerateData;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class D_MHEAccountCreationOpportunity_Test {
private ChromeDriver driver;
private GenerateData genData;


@BeforeSuite(alwaysRun = true)

public void setup() {
	driver = new ChromeDriver();
}

@Test(groups = {"sf", "qa", "functest"})
public void test_a() throws InterruptedException, IOException {
	driver.get("https://mhe--qa.cs24.my.salesforce.com");

	// SF - login //
	SFAdminLoginPage sfAdminLoginPage = new SFAdminLoginPage(driver);
	Thread.sleep(2000);
	sfAdminLoginPage.enterSFUsername("abinav.kant@macmillan.com.qa");
	sfAdminLoginPage.enterSFPassword("Abhijazz9");
	sfAdminLoginPage.clickSFSubmitLogin();
	Thread.sleep(4000);

	// Click Accounts Button
	SFAdminHomePage sfAdminHomePage = new SFAdminHomePage(driver);
	sfAdminHomePage.clickOpportunityButton();
	Thread.sleep(2000);

	// Click New Button
	SFAdminOpportunityPage sfAdminOpportunityPage = new SFAdminOpportunityPage(driver);
	Thread.sleep(1000);
	sfAdminOpportunityPage.clickNewButton();
	Thread.sleep(2000);

	// Select Opportunity Record Type and click continue

	SFAdminOpportunitySelectRecTypePage sfAdminOpportunitySelectRecTypePage = new SFAdminOpportunitySelectRecTypePage(driver);
	Thread.sleep(2000);
	Select selectOpportunity1 = sfAdminOpportunitySelectRecTypePage.OpportunityRecordType();
	Thread.sleep(2000);
	selectOpportunity1.selectByVisibleText("College");
	sfAdminOpportunitySelectRecTypePage.clickContinueButton();
	Thread.sleep(3000);


	// New Opportunity Page

	SFAdminNewOpportunityPage sfAdminNewOpportunityPage = new SFAdminNewOpportunityPage(driver);
	Thread.sleep(2000);
	sfAdminNewOpportunityPage.clickSaveButton();
	Thread.sleep(3000);


	// Parent Field Validations
	assertEquals("Error: You must enter a value", sfAdminNewOpportunityPage.verifyErrorMsgAccParent().getText());
	System.out.println(" The error message for Parent is  : " + sfAdminNewOpportunityPage.verifyErrorMsgAccParent().getText() + ";");
	Thread.sleep(2000);

	// Store the current window handle
	String winHandleBefore = driver.getWindowHandle();

	// Perform the click operation that opens new window
	sfAdminNewOpportunityPage.clickParentAccountLookup();
	Thread.sleep(2000);

	// Switch to new window opened

	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
	}

	// Perform the actions on new window
	driver.switchTo().frame("searchFrame");
	WebElement framepresent1 = sfAdminNewOpportunityPage.framepresent();
	Thread.sleep(2000);
	assertTrue(framepresent1.isDisplayed());
	System.out.println("Search Popup is Displayed");


	sfAdminNewOpportunityPage.enterSearchParentAcc("Abhi");
	Thread.sleep(2000);
	sfAdminNewOpportunityPage.clickSearchParentAccGo();
	Thread.sleep(4000);


	driver.switchTo().defaultContent();

	Thread.sleep(2000);

	driver.switchTo().frame("resultsFrame");


	sfAdminNewOpportunityPage.clickshowresults();
	Thread.sleep(2000);

	List<WebElement> viewAccountLinks = sfAdminNewOpportunityPage.getShowParentAccLinks();
	int parentaccCount = viewAccountLinks.size();
	Thread.sleep(2000);

	System.out.println("Parent Account Links are   " + parentaccCount);
	Thread.sleep(2000);
	assertTrue(viewAccountLinks.size() > 0, "Parent Account were found");
	Thread.sleep(2000);

	int i = 1;
	WebElement ele = viewAccountLinks.get(i);
	System.out.println(ele.getText());
	Thread.sleep(2000);
	ele.click();
	Thread.sleep(2000);
	driver.switchTo().window(winHandleBefore);
	System.out.println("Parent Account Selected");

// Close the new window, if that window no more required

// Switch back to original browser (first window)
	//driver.switchTo().defaultContent();
	//driver.switchTo().window(winHandleBefore);

// Continue with original browser (first window)*/


	// Opportunity  Type
	Select selectOpportunity = sfAdminNewOpportunityPage.OpportunityType();
	Thread.sleep(2000);
	selectOpportunity.selectByVisibleText("Rollover");


	// Stage  Field Validations
	assertEquals("Error: You must enter a value", sfAdminNewOpportunityPage.verifyErrorMsgStage().getText());
	System.out.println(" The error message for Stage is : " + sfAdminNewOpportunityPage.verifyErrorMsgStage().getText() + ";");
	Thread.sleep(2000);
	Select selectStage = sfAdminNewOpportunityPage.Stage();
	selectStage.selectByVisibleText("High Interest");
	sfAdminNewOpportunityPage.clickSaveButton();
	Thread.sleep(2000);


	//Closing Date Field Validations with the DATE SELECTOR
	assertEquals("Error: You must enter a value", sfAdminNewOpportunityPage.verifyErrorMsgClosingDate().getText());
	System.out.println(" The error message for Closing Date is : " + sfAdminNewOpportunityPage.verifyErrorMsgClosingDate().getText() + ";");
	sfAdminNewOpportunityPage.clickClosingDate();
	Thread.sleep(2000);

	Select selectDateYear = sfAdminNewOpportunityPage.CloseYear();
	selectDateYear.selectByVisibleText("2016");
	Thread.sleep(2000);
	sfAdminNewOpportunityPage.clickClosingSelectedDate();
	sfAdminNewOpportunityPage.clickSaveButton();
	Thread.sleep(2000);


	//Lead Source Field
	Select selectLsource = sfAdminNewOpportunityPage.leadSource();
	selectLsource.selectByVisibleText("Campus Plan");
	Thread.sleep(2000);
	sfAdminNewOpportunityPage.clickSaveButton();
	Thread.sleep(2000);


	//LMS Field
	Select selectLMS = sfAdminNewOpportunityPage.LMS();
	selectLMS.selectByVisibleText("Yes");
	sfAdminNewOpportunityPage.clickSaveButton();
	Thread.sleep(2000);


	// Campus Course Field
	assertEquals("Error: You must enter a value", sfAdminNewOpportunityPage.verifyErrorMsgCampusCourse().getText());
	System.out.println(" The error message for Campus Course is : " + sfAdminNewOpportunityPage.verifyErrorMsgCampusCourse().getText() + ";");
	sfAdminNewOpportunityPage.enterCampusCourse("No 12345b");
	Thread.sleep(2000);


	// Campus Type Field
	assertEquals("Error: You must enter a value", sfAdminNewOpportunityPage.verifyErrorMsgCourseType().getText());
	System.out.println(" The error message for Campus Type is : " + sfAdminNewOpportunityPage.verifyErrorMsgCampusCourse().getText() + ";");
	Select selectCourseType = sfAdminNewOpportunityPage.CourseType();
	selectCourseType.selectByVisibleText("Individual Choice");
	sfAdminNewOpportunityPage.clickSaveButton();
	Thread.sleep(2000);


	// Course Discipline Field
	assertEquals("Error: You must enter a value", sfAdminNewOpportunityPage.verifyErrorMsgCourseDiscipline().getText());
	System.out.println(" The error message for Course Discipline is : " + sfAdminNewOpportunityPage
			                                                                      .verifyErrorMsgCourseDiscipline().getText() + ";");
	Select selectCourseDiscipline = sfAdminNewOpportunityPage.Discipline();
	selectCourseDiscipline.selectByVisibleText("Chemistry");
	sfAdminNewOpportunityPage.clickSaveButton();
	Thread.sleep(2000);


	//Selecting Random MHE Course Field
	Select selectMHECourse = sfAdminNewOpportunityPage.MHECourse();
//	List <WebElement> links = sfAdminNewOpportunityPage.MHECourseLinks();
//	Random randomGenerator = new Random();
//	int randomInt = randomGenerator.nextInt(links.size());
	selectMHECourse.selectByIndex(3);

	// Course Status Field
	Select selectCourseStatus = sfAdminNewOpportunityPage.CourseStatus();
	selectCourseStatus.selectByVisibleText("Active");
	sfAdminNewOpportunityPage.clickSaveButton();
	Thread.sleep(2000);


	// Course Term Field
	Select selectCourseTerm = sfAdminNewOpportunityPage.CourseTerm();
	selectCourseTerm.selectByVisibleText("Winter");
	sfAdminNewOpportunityPage.clickSaveButton();
	Thread.sleep(2000);


	// Course Year Field
	Select selectCourseYear = sfAdminNewOpportunityPage.CourseYear();
	selectCourseYear.selectByVisibleText("2014");
	sfAdminNewOpportunityPage.clickSaveButton();
	Thread.sleep(2000);


	// Opportunity  Enrollment Field validations
	assertEquals("Error: You must enter a value", sfAdminNewOpportunityPage.verifyErrorMsgOppEnrollement().getText());
	System.out.println(" The error message for Opportunity Enrollment is : " + sfAdminNewOpportunityPage.verifyErrorMsgOppEnrollement().getText() + ";");
	sfAdminNewOpportunityPage.enterOppEnrollment("06/14");
	sfAdminNewOpportunityPage.clickSaveButton();
	Thread.sleep(2000);

	assertEquals("Error: Invalid number", sfAdminNewOpportunityPage.verifyErrorMsgOppEnrollementForWrongEntry().getText());
	System.out.println(" The error message for Opportunity Enrollment is : " + sfAdminNewOpportunityPage.verifyErrorMsgOppEnrollementForWrongEntry().getText() + ";");
	Thread.sleep(2000);
	sfAdminNewOpportunityPage.enterOppEnrollment("50");
	sfAdminNewOpportunityPage.clickSaveButton();
	Thread.sleep(2000);

	assertTrue(sfAdminNewOpportunityPage.verifyOpportunityNamePresent().isDisplayed());
	System.out.println("Opportunity Successfully Created");
	SFAdminCreatedOpportunityPage sfAdminCreatedOpportunityPage = new SFAdminCreatedOpportunityPage(driver);
	sfAdminCreatedOpportunityPage.clickEditOpp();
	Thread.sleep(3000);
	Select selectCourseStatus1 = sfAdminNewOpportunityPage.CourseStatus();
	selectCourseStatus1.selectByVisibleText("Archived");
	Select selectCourseType1 = sfAdminNewOpportunityPage.CourseType();
	selectCourseType1.selectByVisibleText("Committee Choice");
	sfAdminNewOpportunityPage.clickSaveButton();
	Thread.sleep(2000);


	sfAdminCreatedOpportunityPage.clickDeleteOpp();
	Thread.sleep(2000);
	Alert alert = driver.switchTo().alert();
	alert.accept();
	Thread.sleep(4000);

}

@AfterSuite(alwaysRun = true)

public void teardown() {
	//driver.close();
}


@AfterMethod
public void catchExceptions(ITestResult result) {
	System.out.println("result" + result);
	String methodName = result.getName();
	System.out.println(methodName);

	if (!result.isSuccess()) {

		try {

			File scrFile = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\MacmillanProjects\\target\\TestArtefacts\\Test_failing-shot.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}

}