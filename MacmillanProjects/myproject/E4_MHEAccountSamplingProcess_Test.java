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

public class E4_MHEAccountSamplingProcess_Test {
private ChromeDriver driver;
private GenerateData genData;
private String random;

//--------------- Alternate Address Sampling--------------------//

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
	Thread.sleep(7000);
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
	Thread.sleep(3000);


	//---------------------------------------------------------PART 2--------------------

	// Click Contacts Button
	SFAdminHomePage sfAdminHomePage1 = new SFAdminHomePage(driver);
	sfAdminHomePage1.clickContactsButton();
	Thread.sleep(5000);

	// Click New Button


	Thread.sleep(2000);
	sfAdminContactsPage.clickNewButton();
	Thread.sleep(2000);

	// Select Contact Record Type and click continue

	Thread.sleep(2000);
	Select selectAccount2 = sfAdminContactsSelectRecTypePage.ContactRecordType();
	Thread.sleep(2000);
	selectAccount2.selectByVisibleText("College");
	sfAdminContactsSelectRecTypePage.clickContinueButton();
	Thread.sleep(2000);

	// New Contact Page

	Thread.sleep(2000);

	//Contact Creation

	Select selectSalutation2 = sfAdminNewContactsPage.enterNameSalutation();
	selectSalutation2.selectByVisibleText("Mr.");
	sfAdminNewContactsPage.enterFirstName("Raja1");
	Thread.sleep(2000);
	sfAdminNewContactsPage.enterLastName("Bundela" + random);
	Thread.sleep(2000);
	Select selectJobrole2 = sfAdminNewContactsPage.Jobrole();
	selectJobrole2.selectByVisibleText("Professor");
	Thread.sleep(2000);
	Select selectStatus2 = sfAdminNewContactsPage.Status();
	selectStatus2.selectByVisibleText("Active");
	Thread.sleep(2000);
	sfAdminNewContactsPage.enterEmail("abhinav1@macmillan.com");

	String winHandleBefore1 = driver.getWindowHandle();

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
	WebElement framepresent2 = sfAdminNewContactsPage.framepresent();
	Assert.assertTrue(framepresent2.isDisplayed());
	System.out.println("Search Popup is Displayed");
	Thread.sleep(2000);


	sfAdminNewContactsPage.enterSearchParentAcc("Abhi");
	sfAdminNewContactsPage.clickSearchParentAccGo();
	Thread.sleep(4000);


	driver.switchTo().defaultContent();

	Thread.sleep(2000);

	driver.switchTo().frame("resultsFrame");


	List<WebElement> viewAccountLinks1 = sfAdminNewContactsPage.getShowParentAccLinks();
	int parentaccCount1 = viewAccountLinks.size();
	Thread.sleep(2000);

	System.out.println("Account Links are   " + parentaccCount);
	Thread.sleep(2000);
	Assert.assertTrue(viewAccountLinks1.size() > 0, "Accounts were found");
	Thread.sleep(2000);

	int j = 1;
	WebElement ele1 = viewAccountLinks1.get(j);
	System.out.println(ele1.getText());
	Thread.sleep(2000);
	ele1.click();
	driver.switchTo().window(winHandleBefore1);
	System.out.println("Account Selected");
	Thread.sleep(2000);

	// Assert Address Selector defaults to Department

	Select theAddressSelector1 = sfAdminNewContactsPage.SamplingAddressSelector();
	theAddressSelector1.selectByVisibleText("Mailing");
	Thread.sleep(2000);
	sfAdminNewContactsPage.clickCopyMailingtoShippingButton();
	Thread.sleep(2000);
	sfAdminNewContactsPage.clickSaveButton();
	Thread.sleep(7000);

	assertTrue(sfAdminCreatedContactPage.verifyOnyxidcontact().isDisplayed());

	// Sampling Process Starts
	sfAdminCreatedAccountPage.clickExamSamplecontact();
	Thread.sleep(3000);
	Select selectPrintShippingMethod1 = sfAdminSamplingWizardPage.selectShippingMethod();
	selectPrintShippingMethod1.selectByVisibleText("Reg Pick/Reg Ship");
	Thread.sleep(3000);
	Select selectSampleSource1 = sfAdminSamplingWizardPage.selectSampleSourceOption();
	selectSampleSource1.selectByVisibleText("Rep");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.enterFutureDate("16/06/2017");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton();
	Thread.sleep(5000);


	//Searching Products
	sfAdminSamplingWizardPage.enterSearchDetails("1429299843");
	sfAdminSamplingWizardPage.clickSearchButton();
	Thread.sleep(7000);
	sfAdminSamplingWizardPage.clickProductExpander();
	Thread.sleep(4000);
	sfAdminSamplingWizardPage.clickProductCheckbox();
	Thread.sleep(4000);

	// Quantity checks

	sfAdminSamplingWizardPage.enterQuantity("3");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton1();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton2();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSaveButton();
	Thread.sleep(3000);


	//---------------------------------------------------------PART 3--------------------

	// Click Contacts Button
	SFAdminHomePage sfAdminHomePage2 = new SFAdminHomePage(driver);
	sfAdminHomePage2.clickContactsButton();
	Thread.sleep(5000);

	// Click New Button


	Thread.sleep(2000);
	sfAdminContactsPage.clickNewButton();
	Thread.sleep(2000);

	// Select Contact Record Type and click continue

	Thread.sleep(2000);
	Select selectAccount3 = sfAdminContactsSelectRecTypePage.ContactRecordType();
	Thread.sleep(2000);
	selectAccount3.selectByVisibleText("College");
	sfAdminContactsSelectRecTypePage.clickContinueButton();
	Thread.sleep(2000);

	// New Contact Page

	Thread.sleep(2000);

	//Contact Creation

	Select selectSalutation3 = sfAdminNewContactsPage.enterNameSalutation();
	selectSalutation3.selectByVisibleText("Mr.");
	sfAdminNewContactsPage.enterFirstName("Raja1");
	Thread.sleep(2000);
	sfAdminNewContactsPage.enterLastName("Bundela" + random);
	Thread.sleep(2000);
	Select selectJobrole3 = sfAdminNewContactsPage.Jobrole();
	selectJobrole3.selectByVisibleText("Professor");
	Thread.sleep(2000);
	Select selectStatus3 = sfAdminNewContactsPage.Status();
	selectStatus3.selectByVisibleText("Active");
	Thread.sleep(2000);
	sfAdminNewContactsPage.enterEmail("abhinav1@macmillan.com");

	String winHandleBefore2 = driver.getWindowHandle();

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
	WebElement framepresent3 = sfAdminNewContactsPage.framepresent();
	Assert.assertTrue(framepresent3.isDisplayed());
	System.out.println("Search Popup is Displayed");
	Thread.sleep(2000);


	sfAdminNewContactsPage.enterSearchParentAcc("Abhi");
	sfAdminNewContactsPage.clickSearchParentAccGo();
	Thread.sleep(4000);


	driver.switchTo().defaultContent();

	Thread.sleep(2000);

	driver.switchTo().frame("resultsFrame");


	List<WebElement> viewAccountLinks2 = sfAdminNewContactsPage.getShowParentAccLinks();
	int parentaccCount2 = viewAccountLinks2.size();
	Thread.sleep(2000);

	System.out.println("Account Links are   " + parentaccCount2);
	Thread.sleep(2000);
	Assert.assertTrue(viewAccountLinks2.size() > 0, "Accounts were found");
	Thread.sleep(2000);

	int k = 1;
	WebElement ele2 = viewAccountLinks2.get(k);
	System.out.println(ele2.getText());
	Thread.sleep(2000);
	ele2.click();
	driver.switchTo().window(winHandleBefore2);
	System.out.println("Account Selected");
	Thread.sleep(2000);

	// Assert Address Selector defaults to Department

	Select theAddressSelector2 = sfAdminNewContactsPage.SamplingAddressSelector();
	theAddressSelector2.selectByVisibleText("Adjunct Address");
	Thread.sleep(2000);
//	sfAdminNewContactsPage.clickCopyMailingtoShippingButton();
//	Thread.sleep(2000);

	sfAdminNewContactsPage.clickAdjuncLookup();
	Thread.sleep(2000);

	// Switch to new window opened

	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
	}


	driver.switchTo().frame("resultsFrame");
	SFAdminNewOpportunityPage sfAdminNewOpportunityPage = new SFAdminNewOpportunityPage(driver);
	List<WebElement> viewAccountLinks5 = sfAdminNewOpportunityPage.getShowParentAccLinks();
	Thread.sleep(2000);

	int l = 1;
	WebElement ele5 = viewAccountLinks5.get(l);
	System.out.println(ele5.getText());
	Thread.sleep(2000);
	ele5.click();
	Thread.sleep(2000);
	driver.switchTo().window(winHandleBefore);
	System.out.println("Parent Account Selected");

	sfAdminNewContactsPage.clickSaveButton();
	Thread.sleep(7000);



	// Sampling Process Starts
	sfAdminCreatedAccountPage.clickExamSamplecontact();
	Thread.sleep(3000);
	Select selectPrintShippingMethod2 = sfAdminSamplingWizardPage.selectShippingMethod();
	selectPrintShippingMethod2.selectByVisibleText("Reg Pick/Reg Ship");
	Thread.sleep(3000);
	Select selectSampleSource2 = sfAdminSamplingWizardPage.selectSampleSourceOption();
	selectSampleSource2.selectByVisibleText("Rep");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.enterFutureDate("16/06/2017");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton();
	Thread.sleep(7000);


	//Searching Products
	sfAdminSamplingWizardPage.enterSearchDetails("1429299843");
	sfAdminSamplingWizardPage.clickSearchButton();
	Thread.sleep(7000);
	sfAdminSamplingWizardPage.clickProductExpander();
	Thread.sleep(4000);
	sfAdminSamplingWizardPage.clickProductCheckbox();
	Thread.sleep(4000);

	// Quantity checks

	sfAdminSamplingWizardPage.enterQuantity("3");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton1();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton2();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSaveButton();



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