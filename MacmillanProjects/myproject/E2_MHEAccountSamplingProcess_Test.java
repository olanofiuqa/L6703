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

public class E2_MHEAccountSamplingProcess_Test {
private ChromeDriver driver;
private GenerateData genData;
private String random;

//--------------- Contact Bulk Sample--------------------//

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

	//1st Contact Creation

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


	sfAdminNewContactsPage.clickSaveButton();
	SFAdminCreatedContactPage sfAdminCreatedContactPage = new SFAdminCreatedContactPage(driver);
	Thread.sleep(5000);
	assertTrue(sfAdminCreatedContactPage.verifyOnyxidcontact().isDisplayed());
	SFAdminCreatedAccountPage sfAdminCreatedAccountPage = new SFAdminCreatedAccountPage(driver);

	// Sampling Process Starts
	sfAdminCreatedAccountPage.clickExamSamplecontact();
	Thread.sleep(3000);
	SFAdminSamplingWizardPage sfAdminSamplingWizardPage = new SFAdminSamplingWizardPage(driver);
	Select selectPrintShippingMethod = sfAdminSamplingWizardPage.selectShippingMethod();
	selectPrintShippingMethod.selectByVisibleText("Reg Pick/Reg Ship");
	Thread.sleep(3000);
	Select selectSampleSource = sfAdminSamplingWizardPage.selectSampleSourceOption();
	selectSampleSource.selectByVisibleText("Rep");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.enterFutureDate("16/06/2017");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton();
	Thread.sleep(7000);


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
	List <WebElement> orderContacts = sfAdminOrdersPage.listCreatedcontacts();
	Thread.sleep(3000);
	orderContacts.get(2).click();
	Thread.sleep(3000);

	// Sampling Process Starts
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
	WebElement contactRec = sfAdminSamplingWizardPage.contactrecord();
	Thread.sleep(3000);
	String conname = contactRec.getText();
	System.out.println(conname);


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
	selectSampleSource3.selectByVisibleText("BRC");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.enterFutureDate("16/06/2017");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickcontactradio();
	sfAdminSamplingWizardPage.enterContactName(conname);
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