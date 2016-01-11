package com.MacmillanProjects.myproject;

import com.MacmillanProjects.page.*;
import com.MacmillanProjects.utilityclass.GenerateData;
import org.apache.commons.io.FileUtils;
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

public class E3_MHEAccountSamplingProcess_Test {
private ChromeDriver driver;
private GenerateData genData;
private String random;

//--------------- Opportunity Bulk Sample--------------------//

@BeforeSuite(alwaysRun = true)

public void setup() {
	driver = new ChromeDriver();
	genData = new GenerateData();
	this.random = genData.generateRandomNumber(6);
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
	Thread.sleep(4000);

	// Click New Button
	SFAdminOpportunityPage sfAdminOpportunityPage = new SFAdminOpportunityPage(driver);
	Thread.sleep(3000);
	sfAdminOpportunityPage.clickNewButton();
	Thread.sleep(3000);

	// Select Opportunity Record Type and click continue

	SFAdminOpportunitySelectRecTypePage sfAdminOpportunitySelectRecTypePage = new SFAdminOpportunitySelectRecTypePage(driver);
	Thread.sleep(2000);
	Select selectOpportunity1 = sfAdminOpportunitySelectRecTypePage.OpportunityRecordType();
	Thread.sleep(2000);
	selectOpportunity1.selectByVisibleText("College");
	sfAdminOpportunitySelectRecTypePage.clickContinueButton();
	Thread.sleep(2000);


	// New Opportunity Page

	SFAdminNewOpportunityPage sfAdminNewOpportunityPage = new SFAdminNewOpportunityPage(driver);
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

	int i = 2;
	WebElement ele = viewAccountLinks.get(i);
	System.out.println(ele.getText());
	Thread.sleep(2000);
	ele.click();
	Thread.sleep(2000);
	driver.switchTo().window(winHandleBefore);
	System.out.println("Parent Account Selected");


	// Opportunity  Type
	Select selectOpportunity = sfAdminNewOpportunityPage.OpportunityType();
	Thread.sleep(2000);
	selectOpportunity.selectByVisibleText("Rollover");

	Select selectStage = sfAdminNewOpportunityPage.Stage();
	selectStage.selectByVisibleText("High Interest");
	Thread.sleep(2000);
	sfAdminNewOpportunityPage.clickClosingDate();
	Thread.sleep(2000);

	Select selectDateYear = sfAdminNewOpportunityPage.CloseYear();
	selectDateYear.selectByVisibleText("2016");
	Thread.sleep(2000);
	sfAdminNewOpportunityPage.clickClosingSelectedDate();
	Thread.sleep(2000);

	//Lead Source Field
	Select selectLsource = sfAdminNewOpportunityPage.leadSource();
	selectLsource.selectByVisibleText("Campus Plan");
	Thread.sleep(2000);

	//LMS Field
	Select selectLMS = sfAdminNewOpportunityPage.LMS();
	selectLMS.selectByVisibleText("Yes");
	Thread.sleep(2000);


	sfAdminNewOpportunityPage.enterCampusCourse("No 12345b");
	Thread.sleep(2000);

	Select selectCourseType = sfAdminNewOpportunityPage.CourseType();
	selectCourseType.selectByVisibleText("Individual Choice");
	Thread.sleep(2000);

	Select selectCourseDiscipline = sfAdminNewOpportunityPage.Discipline();
	selectCourseDiscipline.selectByVisibleText("Chemistry");
	Thread.sleep(2000);

	//Selecting Random MHE Course Field
	Select selectMHECourse = sfAdminNewOpportunityPage.MHECourse();
	selectMHECourse.selectByIndex(3);

	// Course Status Field
	Select selectCourseStatus = sfAdminNewOpportunityPage.CourseStatus();
	selectCourseStatus.selectByVisibleText("Active");
	Thread.sleep(2000);

	// Course Term Field
	Select selectCourseTerm = sfAdminNewOpportunityPage.CourseTerm();
	selectCourseTerm.selectByVisibleText("Winter");
	Thread.sleep(2000);


	// Course Year Field
	Select selectCourseYear = sfAdminNewOpportunityPage.CourseYear();
	selectCourseYear.selectByVisibleText("2014");
	Thread.sleep(2000);

	sfAdminNewOpportunityPage.enterOppEnrollment("50");
	Thread.sleep(2000);

	sfAdminNewOpportunityPage.clickSaveButton();
	Thread.sleep(5000);
	assertTrue(sfAdminNewOpportunityPage.verifyOpportunityNamePresent().isDisplayed());
	System.out.println("Opportunity Successfully Created");
	Thread.sleep(6000);

	SFAdminCreatedOpportunityPage sfAdminCreatedOpportunityPage = new SFAdminCreatedOpportunityPage(driver);
	sfAdminCreatedOpportunityPage.clicknewContactRole();
	Thread.sleep(3000);
	sfAdminCreatedOpportunityPage.selectcontactRole();
	Thread.sleep(2000);


	// Store the current window handle
	String winHandleBefore1 = driver.getWindowHandle();

	// Perform the click operation that opens new window
	sfAdminNewOpportunityPage.clickContactLookup();
	Thread.sleep(2000);

	// Switch to new window opened

	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
	}


	driver.switchTo().frame("resultsFrame");
	List<WebElement> viewContactLinks = sfAdminNewOpportunityPage.getShowContactLinks();
	int j = 1;
	WebElement elem = viewContactLinks.get(j);
	System.out.println(elem.getText());
	Thread.sleep(2000);
	elem.click();
	Thread.sleep(2000);
	driver.switchTo().window(winHandleBefore1);
	System.out.println("Contact Selected");


	WebElement contactRec = sfAdminCreatedOpportunityPage.selectedcontact();
	Thread.sleep(3000);
	String conname = contactRec.getText();
	System.out.println(conname);

	Select conrole = sfAdminCreatedOpportunityPage.selectRole();
	conrole.selectByVisibleText("Decision Maker");
	Thread.sleep(3000);
	sfAdminCreatedOpportunityPage.clickSaveContact();
	Thread.sleep(3000);

	// Sampling Process Starts
	sfAdminCreatedOpportunityPage.clickOpportunitySample();
	Thread.sleep(3000);
	SFAdminSamplingWizardPage sfAdminSamplingWizardPage = new SFAdminSamplingWizardPage(driver);
	Select selectPrintShippingMethod = sfAdminSamplingWizardPage.selectShippingMethod();
	selectPrintShippingMethod.selectByVisibleText("Reg Pick/Reg Ship");
	Thread.sleep(3000);
	Select selectSampleSource = sfAdminSamplingWizardPage.selectSampleSourceOption();
	selectSampleSource.selectByVisibleText("BRC");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.enterFutureDate("16/06/2017");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton();
	Thread.sleep(7000);

	/*sfAdminSamplingWizardPage.clickcontactradio();
	sfAdminSamplingWizardPage.enterContactName(conname);
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSearch();
	Thread.sleep(8000);
	sfAdminSamplingWizardPage.clickcontactbox();
	Thread.sleep(3000);*/
	sfAdminSamplingWizardPage.clickNextButton();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton1();
	Thread.sleep(3000);

	//Searching Products
	sfAdminSamplingWizardPage.enterSearchDetails("1429299843");
	sfAdminSamplingWizardPage.clickSearchButton();
	Thread.sleep(10000);
	sfAdminSamplingWizardPage.clickProductExpander();
	Thread.sleep(5000);
	sfAdminSamplingWizardPage.clickProductCheckbox();
	Thread.sleep(4000);

	// Quantity checks
	sfAdminSamplingWizardPage.enterQuantity("10");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton1();
	Thread.sleep(3000);
	WebElement verifyImage = sfAdminSamplingWizardPage.verifyBookgrabberImage();
	assertTrue(verifyImage.isDisplayed());
	Thread.sleep(3000);
	String capturetext3 = (verifyImage.getAttribute("title"));
	System.out.println(capturetext3);
	assertEquals(capturetext3, "(The Quantity for the Product is 9 or above, please check this is correct)");

	sfAdminSamplingWizardPage.enterQuantity("52");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton1();
	Thread.sleep(3000);
	WebElement verifyImage2 = sfAdminSamplingWizardPage.verifyQuantityErrorImage();
	assertTrue(verifyImage2.isDisplayed());
	Thread.sleep(3000);
	String capturetext4 = (verifyImage2.getAttribute("title"));
	System.out.println(capturetext4);
	assertEquals(capturetext4, "(The Quantity for the Product is greater than 50. Samples must be below this number)");
	sfAdminSamplingWizardPage.enterQuantity("3");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton1();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton2();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSaveButton();


//DUPLICATES WORKFLOW---------------------------------------------------------------------------------------

	SFAdminOrdersPage sfAdminOrdersPage = new SFAdminOrdersPage(driver);
	Thread.sleep(3000);
	List<WebElement> orderContacts = sfAdminOrdersPage.listCreatedcontacts();
	Thread.sleep(3000);
	orderContacts.get(2).click();
	Thread.sleep(3000);


	// Sampling Process Starts
	SFAdminCreatedAccountPage sfAdminCreatedAccountPage = new SFAdminCreatedAccountPage(driver);
	sfAdminCreatedAccountPage.clickExamSamplecontact();
	Thread.sleep(3000);
	SFAdminSamplingWizardPage sfAdminSamplingWizardPage1 = new SFAdminSamplingWizardPage(driver);
	Select selectPrintShippingMethod1 = sfAdminSamplingWizardPage.selectShippingMethod();
	selectPrintShippingMethod1.selectByVisibleText("Reg Pick/Reg Ship");
	Thread.sleep(3000);
	Select selectSampleSource1 = sfAdminSamplingWizardPage.selectSampleSourceOption();
	selectSampleSource1.selectByVisibleText("BRC");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.enterFutureDate("16/06/2017");
	Thread.sleep(3000);
	WebElement contactRec1 = sfAdminSamplingWizardPage.contactrecord();
	Thread.sleep(3000);
	String conname1 = contactRec1.getText();
	System.out.println(conname1);


	// verifying the contact records are selected
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton();
	Thread.sleep(3000);

	//Searching Products
	sfAdminSamplingWizardPage.enterSearchDetails("1429299843");
	sfAdminSamplingWizardPage.clickSearchButton();
	Thread.sleep(10000);
	sfAdminSamplingWizardPage.clickProductExpander();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickProductCheckbox();
	Thread.sleep(3000);

	// Quantity checks
	sfAdminSamplingWizardPage.enterQuantity("3");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton1();
	Thread.sleep(3000);

	//Duplicate Handling none selected.
	WebElement unSelectboxes = sfAdminSamplingWizardPage.checkBoxSelect();
	unSelectboxes.click();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton2();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSaveNewButton();
	Thread.sleep(3000);
	List <WebElement> allDuplicates = sfAdminSamplingWizardPage.allDuplicatesList();
	assertTrue(allDuplicates.isEmpty());
	System.out.println("Duplicates were not added in the order");

	//--------------------------------Duplicate Handling all selected.

	// Sampling Process Starts


	SFAdminSamplingWizardPage sfAdminSamplingWizardPage2 = new SFAdminSamplingWizardPage(driver);
	Select selectPrintShippingMethod2 = sfAdminSamplingWizardPage2.selectShippingMethod();
	selectPrintShippingMethod2.selectByVisibleText("Reg Pick/Reg Ship");
	Thread.sleep(3000);
	Select selectSampleSource3 = sfAdminSamplingWizardPage.selectSampleSourceOption();
	selectSampleSource3.selectByVisibleText("Convention");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.enterFutureDate("16/06/2017");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickcontactradio();
	sfAdminSamplingWizardPage.enterContactName(conname1);
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSearch();
	Thread.sleep(10000);
	sfAdminSamplingWizardPage.clickcontactbox();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton();
	Thread.sleep(3000);



	//Searching Products
	sfAdminSamplingWizardPage.enterSearchDetails("1429299843");
	sfAdminSamplingWizardPage.clickSearchButton();
	Thread.sleep(5000);
	sfAdminSamplingWizardPage.clickProductExpander();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickProductCheckbox();
	Thread.sleep(3000);

	// Quantity checks
	sfAdminSamplingWizardPage.enterQuantity("3");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton1();
	Thread.sleep(3000);
	List<WebElement> chooseboxes = sfAdminSamplingWizardPage.verifyCheckBoxSelected();
	assertTrue(chooseboxes.get(0).isSelected());
	sfAdminSamplingWizardPage.clickNextButton2();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSaveButton();

}

@AfterSuite(alwaysRun = true)

public void teardown() {
	driver.close();
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