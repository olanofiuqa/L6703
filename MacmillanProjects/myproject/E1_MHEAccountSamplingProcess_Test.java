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

import static org.testng.Assert.*;

public class E1_MHEAccountSamplingProcess_Test {
private ChromeDriver driver;
private GenerateData genData;
private String random;


//--------------- Department Bulk Sample--------------------//

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
	Thread.sleep(3000);
	sfAdminLoginPage.enterSFUsername("abinav.kant@macmillan.com.qa");
	sfAdminLoginPage.enterSFPassword("Abhijazz9");
	sfAdminLoginPage.clickSFSubmitLogin();
	Thread.sleep(3000);


	// Click Accounts Button
	SFAdminHomePage sfAdminHomePage = new SFAdminHomePage(driver);
	Thread.sleep(1000);
	sfAdminHomePage.clickAccountsButton();
	Thread.sleep(4000);

	//Click View All Accounts button
	SFAdminAccountsPage sfAdminAccountsePage = new SFAdminAccountsPage(driver);
	Thread.sleep(3000);
	Select allAccounts = sfAdminAccountsePage.AllAccountsOption();
	allAccounts.selectByVisibleText("All Accounts");
	sfAdminAccountsePage.clickViewAccountsGoButton();
	Thread.sleep(4000);

	WebElement accountType = sfAdminAccountsePage.choseAccountType();
	Thread.sleep(3000);
	accountType.click();
	Thread.sleep(3000);

	//Create 4 contact Records
	SFAdminCreatedAccountPage sfAdminCreatedAccountPage = new SFAdminCreatedAccountPage(driver);
	sfAdminCreatedAccountPage.clickNewContact();
	Thread.sleep(3000);
	SFAdminNewContactsPage sfAdminNewContactsPage = new SFAdminNewContactsPage(driver);
	SFAdminCreatedContactPage sfAdminCreatedContactPage = new SFAdminCreatedContactPage(driver);

	//1st Contact Creation
	Select selectSalutation1 = sfAdminNewContactsPage.enterNameSalutation();
	selectSalutation1.selectByVisibleText("Mr.");
	sfAdminNewContactsPage.enterFirstName("Raja5");
	Thread.sleep(3000);
	sfAdminNewContactsPage.enterLastName("Bundela" + random);
	Thread.sleep(3000);
	Select selectJobrole1 = sfAdminNewContactsPage.Jobrole();
	selectJobrole1.selectByVisibleText("Professor");
	Thread.sleep(3000);
	Select selectStatus1 = sfAdminNewContactsPage.Status();
	selectStatus1.selectByVisibleText("Inactive");
	Thread.sleep(3000);
	sfAdminNewContactsPage.enterEmail("abhinav5@macmillan.com");
	sfAdminNewContactsPage.clickSaveButton();
	Thread.sleep(4000);
	assertTrue(sfAdminCreatedContactPage.verifyOnyxid().isDisplayed());

	//2nd Contact Creation
	sfAdminCreatedAccountPage.clickNewContact();
	Thread.sleep(3000);
	Select selectSalutation2 = sfAdminNewContactsPage.enterNameSalutation();
	Thread.sleep(3000);
	selectSalutation2.selectByVisibleText("Mr.");
	sfAdminNewContactsPage.enterFirstName("Raja2");
	Thread.sleep(3000);
	sfAdminNewContactsPage.enterLastName("Bundela" + random);
	Thread.sleep(3000);
	Select selectJobrole2 = sfAdminNewContactsPage.Jobrole();
	selectJobrole2.selectByVisibleText("Dean");
	Thread.sleep(3000);
	sfAdminNewContactsPage.clickBookGrabberBox();
	sfAdminNewContactsPage.enterEmail("abhinav2@macmillan.com");
	sfAdminNewContactsPage.clickSaveButton();
	Thread.sleep(3000);
	assertTrue(sfAdminCreatedContactPage.verifyOnyxid().isDisplayed());


	// 3rd Contact Creation
	Thread.sleep(3000);
	sfAdminCreatedAccountPage.clickNewContact();
	Thread.sleep(3000);
	Select selectSalutation3 = sfAdminNewContactsPage.enterNameSalutation();
	selectSalutation3.selectByVisibleText("Mr.");
	sfAdminNewContactsPage.enterFirstName("Raja3");
	Thread.sleep(3000);
	sfAdminNewContactsPage.enterLastName("Bundela" + random);
	Thread.sleep(3000);
	Select selectJobrole3 = sfAdminNewContactsPage.Jobrole();
	selectJobrole3.selectByVisibleText("Instructor");
	Thread.sleep(3000);
	sfAdminNewContactsPage.clickUnsolicitedSamples();
	sfAdminNewContactsPage.enterEmail("abhinav3@macmillan.com");
	sfAdminNewContactsPage.clickSaveButton();
	Thread.sleep(3000);
	assertTrue(sfAdminCreatedContactPage.verifyOnyxid().isDisplayed());

	// 4th Contact Creation
	Thread.sleep(3000);
	sfAdminCreatedAccountPage.clickNewContact();
	Thread.sleep(3000);
	Select selectSalutation4 = sfAdminNewContactsPage.enterNameSalutation();
	selectSalutation4.selectByVisibleText("Mr.");
	sfAdminNewContactsPage.enterFirstName("Raja4");
	Thread.sleep(3000);
	sfAdminNewContactsPage.enterLastName("Bundela" + random);
	Thread.sleep(3000);
	Select selectJobrole4 = sfAdminNewContactsPage.Jobrole();
	selectJobrole4.selectByVisibleText("Secretary");
	Thread.sleep(3000);
	sfAdminNewContactsPage.enterEmail("abhinav4@macmillan.com");
	sfAdminNewContactsPage.clickSaveButton();
	Thread.sleep(3000);
	assertTrue(sfAdminCreatedContactPage.verifyOnyxid().isDisplayed());

	// Sampling Process Starts
	sfAdminCreatedAccountPage.clickExamSample();
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

	//Verify inactive accounts are not shown
	List<WebElement> inactivenotexits = sfAdminSamplingWizardPage.verifyInactiveAccount();
	assertTrue(inactivenotexits.isEmpty());
	Thread.sleep(3000);
	List<WebElement> checkboxes = sfAdminSamplingWizardPage.verifyCheckBoxSelected();
	for (WebElement checkbox : checkboxes) {
		if (!checkbox.isSelected()) {
			Thread.sleep(1000);
			checkbox.click();

		}
	}

	// verifying the contact records are selected
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton();
	Thread.sleep(3000);

	//Verifying the images & messages for the different accounts

	/* Book Grabber Account*/
	WebElement verifyBookacc = sfAdminSamplingWizardPage.verifyBookgrabberAccount();
	assertTrue(verifyBookacc.isDisplayed());
	Thread.sleep(3000);
	String capturetext1 = (verifyBookacc.getAttribute("title"));
	System.out.println(capturetext1);
	assertEquals(capturetext1, "(The Contact is a Book Grabber)");

	/* Unsolicited Samples Account*/
	WebElement verifyUnsolictiedacc = sfAdminSamplingWizardPage.verifyUnsolictedSamplesAccount();
	assertTrue(verifyUnsolictiedacc.isDisplayed());
	Thread.sleep(3000);
	String capturetext2 = (verifyUnsolictiedacc.getAttribute("title"));
	System.out.println(capturetext2);
	assertEquals(capturetext2, "(The Contact has requested No Unsolicited Samples and cannot receive a Sample from a Rep, see Sample Source.)");

	/* Confirmed Account*/
	WebElement verifyConfirmacc = sfAdminSamplingWizardPage.verifyPerfectAccount();
	assertTrue(verifyConfirmacc.isDisplayed());
	Thread.sleep(3000);

	// Workaround for removing the Unsolicted Samples error
	Select selectSampleSource2 = sfAdminSamplingWizardPage.selectSampleSourceOption();
	Thread.sleep(3000);
	selectSampleSource2.selectByVisibleText("Convention");
	WebElement contactRec = sfAdminSamplingWizardPage.contactrecord();
	Thread.sleep(3000);
	String conname = contactRec.getText();
	System.out.println(conname);
	sfAdminSamplingWizardPage.clickNextButton();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton();
	Thread.sleep(3000);

	//Searching Products
	sfAdminSamplingWizardPage.enterSearchDetails("1429299843");
	sfAdminSamplingWizardPage.clickSearchButton();
	Thread.sleep(15000);
	sfAdminSamplingWizardPage.clickProductExpander();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickProductCheckbox();
	Thread.sleep(3000);

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

//DUPLICATES WORKFLOW---------------------------------------------------------------------------------------



	SFAdminHomePage sfAdminHomePage1 = new SFAdminHomePage(driver);
	Thread.sleep(3000);
	sfAdminHomePage1.clickAccountsButton();
	Thread.sleep(3000);

	Alert alert = driver.switchTo().alert();
//update is executed
	alert.accept();

	//Click View All Accounts button
	SFAdminAccountsPage sfAdminAccountsePage1 = new SFAdminAccountsPage(driver);
	Thread.sleep(3000);
	Select allAccounts1 = sfAdminAccountsePage1.AllAccountsOption();
	allAccounts1.selectByVisibleText("All Accounts");
	sfAdminAccountsePage.clickViewAccountsGoButton();
	Thread.sleep(3000);

	WebElement accountType1 = sfAdminAccountsePage.choseAccountType();
	Thread.sleep(3000);
	accountType1.click();
	Thread.sleep(3000);

	// Sampling Process Starts
	sfAdminCreatedAccountPage.clickExamSample();
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
	sfAdminSamplingWizardPage.clickcontactradio();
	sfAdminSamplingWizardPage.enterContactName(conname);
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSearch();
	Thread.sleep(9000);
	sfAdminSamplingWizardPage.clickcontactbox();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton();
	Thread.sleep(4000);
	sfAdminSamplingWizardPage.clickNextButton1();
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

	//Duplicate Handling none selected.
	WebElement unSelectboxes = sfAdminSamplingWizardPage.checkBoxSelect();
	unSelectboxes.click();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton2();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSaveButton();
	Thread.sleep(3000);
	List <WebElement> allDuplicates = sfAdminSamplingWizardPage.allDuplicatesList();
	assertTrue(allDuplicates.isEmpty());
	System.out.println("Duplicates were not added in the order");

   //--------------------------------Duplicate Handling all selected.
	sfAdminSamplingWizardPage.clickBacktolist();
	Thread.sleep(5000);
	WebElement accountType2 = sfAdminAccountsePage.choseAccountType();
	Thread.sleep(3000);
	accountType2.click();
	Thread.sleep(3000);

	// Sampling Process Starts
	sfAdminCreatedAccountPage.clickExamSample();
	Thread.sleep(3000);
	SFAdminSamplingWizardPage sfAdminSamplingWizardPage2 = new SFAdminSamplingWizardPage(driver);
	Select selectPrintShippingMethod2 = sfAdminSamplingWizardPage2.selectShippingMethod();
	selectPrintShippingMethod2.selectByVisibleText("Reg Pick/Reg Ship");
	Thread.sleep(3000);
	Select selectSampleSource3 = sfAdminSamplingWizardPage.selectSampleSourceOption();
	selectSampleSource3.selectByVisibleText("BRC");
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.enterFutureDate("16/06/2017");
	Thread.sleep(3000);


	// verifying the contact records are selected
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton();
	Thread.sleep(3000);

	// Workaround for removing the Unsolicted Samples error
	Select selectSampleSource22 = sfAdminSamplingWizardPage.selectSampleSourceOption();
	Thread.sleep(3000);
	selectSampleSource22.selectByVisibleText("Convention");
	sfAdminSamplingWizardPage.clickcontactradio();
	sfAdminSamplingWizardPage.enterContactName(conname);
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSearch();
	Thread.sleep(8000);
	sfAdminSamplingWizardPage.clickcontactbox();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickNextButton1();
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
	List<WebElement > chooseboxes = sfAdminSamplingWizardPage.verifyCheckBoxSelected();
	assertTrue(chooseboxes.get(0).isSelected());
	sfAdminSamplingWizardPage.clickNextButton2();
	Thread.sleep(3000);
	sfAdminSamplingWizardPage.clickSaveButton();
	Thread.sleep(3000);
//	List <WebElement> allDuplicates1 = sfAdminSamplingWizardPage.allDuplicatesList();
//	assertFalse(allDuplicates1.isEmpty());
//	System.out.println("Duplicates were used in the order");

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