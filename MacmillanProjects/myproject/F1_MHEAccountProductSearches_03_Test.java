package com.MacmillanProjects.myproject;

import com.MacmillanProjects.page.*;
import com.MacmillanProjects.utilityclass.GenerateData;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

public class F1_MHEAccountProductSearches_03_Test {
private ChromeDriver driver;
private GenerateData genData;
private String random;


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
	Thread.sleep(5000);

//---------------------------------------------------------PART 1--------------------
	// Click Contacts Button
	SFAdminHomePage sfAdminHomePage = new SFAdminHomePage(driver);
	sfAdminHomePage.clickContactsButton();
	Thread.sleep(5000);

	// Click New Button

	SFAdminContactsPage sfAdminContactsPage = new SFAdminContactsPage(driver);
	Thread.sleep(2000);
	sfAdminContactsPage.clickNewButton();
	Thread.sleep(2000);

	// Select Contact Record Type and click continue

	SFAdminContactsSelectRecTypePage sfAdminContactsSelectRecTypePage = new SFAdminContactsSelectRecTypePage(driver);
	Thread.sleep(2000);
	Select selectAccount1 = sfAdminContactsSelectRecTypePage.ContactRecordType();
	Thread.sleep(2000);
	selectAccount1.selectByVisibleText("College");
	sfAdminContactsSelectRecTypePage.clickContinueButton();
	Thread.sleep(2000);

	// New Contact Page
	SFAdminNewContactsPage sfAdminNewContactsPage = new SFAdminNewContactsPage(driver);
	Thread.sleep(2000);

	//Contact Creation

	Select selectSalutation1 = sfAdminNewContactsPage.enterNameSalutation();
	selectSalutation1.selectByVisibleText("Mr.");
	sfAdminNewContactsPage.enterFirstName("Raja1");
	Thread.sleep(2000);
	sfAdminNewContactsPage.enterLastName("Bundela" + random);
	Thread.sleep(2000);
	Select selectJobrole1 = sfAdminNewContactsPage.Jobrole();
	selectJobrole1.selectByVisibleText("Professor");
	Thread.sleep(2000);
	Select selectStatus1 = sfAdminNewContactsPage.Status();
	selectStatus1.selectByVisibleText("Active");
	Thread.sleep(2000);
	sfAdminNewContactsPage.enterEmail("abhinav1@macmillan.com");

	String winHandleBefore = driver.getWindowHandle();

// Perform the click operation that opens new window
	sfAdminNewContactsPage.clickAccountLookup();
	Thread.sleep(2000);

// Switch to new window opened

	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
	}

// Perform the actions on new window
	driver.switchTo().frame("searchFrame");
	Thread.sleep(2000);
	WebElement framepresent1 = sfAdminNewContactsPage.framepresent();
	Assert.assertTrue(framepresent1.isDisplayed());
	System.out.println("Search Popup is Displayed");
	Thread.sleep(2000);


	sfAdminNewContactsPage.enterSearchParentAcc("Abhi");
	sfAdminNewContactsPage.clickSearchParentAccGo();
	Thread.sleep(4000);


	driver.switchTo().defaultContent();

	Thread.sleep(2000);

	driver.switchTo().frame("resultsFrame");


	List<WebElement> viewAccountLinks = sfAdminNewContactsPage.getShowParentAccLinks();
	int parentaccCount = viewAccountLinks.size();
	Thread.sleep(2000);

	System.out.println("Account Links are   " + parentaccCount);
	Thread.sleep(2000);
	Assert.assertTrue(viewAccountLinks.size() > 0, "Accounts were found");
	Thread.sleep(2000);

	int i = 1;
	WebElement ele = viewAccountLinks.get(i);
	System.out.println(ele.getText());
	Thread.sleep(2000);
	ele.click();
	driver.switchTo().window(winHandleBefore);
	System.out.println("Account Selected");
	Thread.sleep(2000);

	// Assert Address Selector defaults to Department

	Select theAddressSelector = sfAdminNewContactsPage.SamplingAddressSelector();
	WebElement addressoption = theAddressSelector.getFirstSelectedOption();
	assertEquals(addressoption.getText(), "Department");
	System.out.println(addressoption.getText());
	Thread.sleep(2000);
	theAddressSelector.selectByVisibleText("Adjunct Address");
	Thread.sleep(2000);
	theAddressSelector.selectByVisibleText("Home");
	Thread.sleep(2000);
	sfAdminNewContactsPage.clickCopyMailingtoShippingButton();
	Thread.sleep(2000);
	sfAdminNewContactsPage.clickSaveButton();
	Thread.sleep(7000);

	SFAdminCreatedContactPage sfAdminCreatedContactPage = new SFAdminCreatedContactPage(driver);

	assertTrue(sfAdminCreatedContactPage.verifyOnyxidcontact().isDisplayed());

	SFAdminCreatedAccountPage sfAdminCreatedAccountPage = new SFAdminCreatedAccountPage(driver);

	// Sampling Process Starts

	sfAdminCreatedAccountPage.clickExamSamplecontact();
	Thread.sleep(5000);
	SFAdminSamplingWizardPage sfAdminSamplingWizardPage = new SFAdminSamplingWizardPage(driver);
	Select selectPrintShippingMethod = sfAdminSamplingWizardPage.selectShippingMethod();
	selectPrintShippingMethod.selectByVisibleText("Reg Pick/Reg Ship");
	Thread.sleep(3000);
	WebElement contactRec = sfAdminSamplingWizardPage.contactrecord();
	Thread.sleep(3000);
	String conname = contactRec.getText();
	Select selectSampleSource = sfAdminSamplingWizardPage.selectSampleSourceOption();
	selectSampleSource.selectByVisibleText("Rep");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.enterFutureDate("16/06/2017");
	sfAdminSamplingWizardPage.clickcontactradio();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.enterContactName(conname);
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSearch();
	Thread.sleep(5000);
	sfAdminSamplingWizardPage.enterContactName("Raja");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSearch();
	Thread.sleep(5000);
	List <WebElement> checkboxes = sfAdminSamplingWizardPage.verifyCheckBoxSelected();
	checkboxes.get(0);
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton();
	Thread.sleep(7000);


	//Searching Products
	sfAdminSamplingWizardPage.enterSearchDetails("1429299843");
	sfAdminSamplingWizardPage.clickSearchButton();
	Thread.sleep(9000);
	sfAdminSamplingWizardPage.clickProductExpander();
	Thread.sleep(5000);
	sfAdminSamplingWizardPage.clickProductCheckbox();
	Thread.sleep(4000);

	// Quantity checks
	sfAdminSamplingWizardPage.enterQuantity("1.5");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton1();
	Thread.sleep(3000);
	WebElement verifyImage = sfAdminSamplingWizardPage.verifyQuantityErrorImage();
	assertTrue(verifyImage.isDisplayed());
	Thread.sleep(3000);
	String capturetext3 = (verifyImage.getAttribute("title"));
	System.out.println(capturetext3);
	assertEquals(capturetext3, "(Please enter a whole number without a decimal value)");

	sfAdminSamplingWizardPage.enterQuantity("24.3");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton1();
	Thread.sleep(3000);
	WebElement verifyImage2 = sfAdminSamplingWizardPage.verifyQuantityErrorImage();
	assertTrue(verifyImage2.isDisplayed());
	Thread.sleep(3000);
	String capturetext4 = (verifyImage2.getAttribute("title"));
	System.out.println(capturetext4);
	assertEquals(capturetext4,"(Please enter a whole number without a decimal value)");
	sfAdminSamplingWizardPage.enterQuantity("3");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton1();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton2();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSaveButton();
	Thread.sleep(3000);



//---------------------------------------------------------PART 2--------------------


	// Click Accounts Button
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
	String winHandleBefore1 = driver.getWindowHandle();

	// Perform the click operation that opens new window
	sfAdminNewOpportunityPage.clickParentAccountLookup();
	Thread.sleep(2000);

	// Switch to new window opened

	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
	}

	// Perform the actions on new window
	driver.switchTo().frame("searchFrame");
	WebElement framepresent2 = sfAdminNewOpportunityPage.framepresent();
	Thread.sleep(2000);
	assertTrue(framepresent2.isDisplayed());


	sfAdminNewOpportunityPage.enterSearchParentAcc("Abhi");
	Thread.sleep(2000);
	sfAdminNewOpportunityPage.clickSearchParentAccGo();
	Thread.sleep(4000);


	driver.switchTo().defaultContent();

	Thread.sleep(2000);

	driver.switchTo().frame("resultsFrame");


	sfAdminNewOpportunityPage.clickshowresults();
	Thread.sleep(2000);

	List<WebElement> viewAccountLinks1 = sfAdminNewOpportunityPage.getShowParentAccLinks();
	int parentaccCount1 = viewAccountLinks1.size();
	Thread.sleep(2000);

	System.out.println("Parent Account Links are   " + parentaccCount1);
	Thread.sleep(2000);
	assertTrue(viewAccountLinks1.size() > 0, "Parent Account were found");
	Thread.sleep(2000);

	int j = 2;
	WebElement ele3 = viewAccountLinks1.get(j);
	System.out.println(ele3.getText());
	Thread.sleep(2000);
	ele3.click();
	Thread.sleep(2000);
	driver.switchTo().window(winHandleBefore1);
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
	String winHandleBefore2 = driver.getWindowHandle();

	// Perform the click operation that opens new window
	sfAdminNewOpportunityPage.clickContactLookup();
	Thread.sleep(2000);

	// Switch to new window opened

	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
	}


	driver.switchTo().frame("resultsFrame");
	List<WebElement> viewContactLinks = sfAdminNewOpportunityPage.getShowContactLinks();
	int k = 0;
	WebElement elem = viewContactLinks.get(k);
	System.out.println(elem.getText());
	Thread.sleep(2000);
	elem.click();
	Thread.sleep(2000);
	driver.switchTo().window(winHandleBefore2);
	System.out.println("Contact Selected");


	WebElement contactRec1 = sfAdminCreatedOpportunityPage.selectedcontact();
	Thread.sleep(3000);
	String conname1 = contactRec1.getText();
	System.out.println(conname1);

	Select conrole = sfAdminCreatedOpportunityPage.selectRole();
	conrole.selectByVisibleText("Decision Maker");
	Thread.sleep(3000);
	sfAdminCreatedOpportunityPage.clickSaveContact();
	Thread.sleep(3000);

	// Sampling Process Starts
   sfAdminCreatedOpportunityPage.clickAddProduct();
	Thread.sleep(3000);

	//Searching Products
	sfAdminSamplingWizardPage.enterSearchDetailsnew("1429299843");
	sfAdminSamplingWizardPage.clickSearch();
	Thread.sleep(9000);
	sfAdminSamplingWizardPage.clickProductExpander();
	Thread.sleep(5000);
	sfAdminSamplingWizardPage.clickProductCheckboxnew();
	Thread.sleep(4000);

	// Quantity checks
	sfAdminSamplingWizardPage.enterQuantitynew("1.5");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSaveButtonnew();
	Thread.sleep(3000);
	WebElement verifyImage1 = sfAdminSamplingWizardPage.verifyQuantityErrorImage();
	assertTrue(verifyImage1.isDisplayed());
	Thread.sleep(3000);
	String capturetext5 = (verifyImage1.getAttribute("title"));
	System.out.println(capturetext5);
	assertEquals(capturetext5, "Please enter a whole number without a decimal value");

	sfAdminSamplingWizardPage.enterQuantitynew("24.3");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSaveButtonnew();
	Thread.sleep(3000);
	WebElement verifyImage6 = sfAdminSamplingWizardPage.verifyQuantityErrorImage();
	assertTrue(verifyImage6.isDisplayed());
	Thread.sleep(3000);
	String capturetext6 = (verifyImage6.getAttribute("title"));
	System.out.println(capturetext6);
	assertEquals(capturetext6, "Please enter a whole number without a decimal value");
	sfAdminSamplingWizardPage.enterQuantitynew("3");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSaveButtonnew();

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