package com.MacmillanProjects.myproject;

import com.MacmillanProjects.page.*;
import com.MacmillanProjects.utilityclass.GenerateData;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
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

import static org.junit.Assert.assertTrue;

public class C_MHEAccountCreationContact_Test {
private ChromeDriver driver;
private GenerateData genData;
private String random;


@BeforeSuite(alwaysRun = true)

public void setup() {
	driver = new ChromeDriver();
	genData = new GenerateData();
	this.random = genData.generateRandomNumber(6);
}

@Test(groups = {"sf", "qa" , "functest"})
public void test_a() throws InterruptedException, IOException {
	driver.get("https://mhe--qa.cs24.my.salesforce.com");

// SF - login //
	SFAdminLoginPage sfAdminLoginPage = new SFAdminLoginPage(driver);
	Thread.sleep(2000);
	sfAdminLoginPage.enterSFUsername("abinav.kant@macmillan.com.qa");
	sfAdminLoginPage.enterSFPassword("Abhijazz9");
	sfAdminLoginPage.clickSFSubmitLogin();
	Thread.sleep(4000);



	    // Click Contacts Button
	    SFAdminHomePage sfAdminHomePage = new SFAdminHomePage(driver);
	    sfAdminHomePage.clickContactsButton();
	    Thread.sleep(2000);

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
	    Thread.sleep(3000);

	    // New Contact Page
	    SFAdminNewContactsPage sfAdminNewContactsPage = new SFAdminNewContactsPage(driver);
	    Thread.sleep(2000);
	    sfAdminNewContactsPage.clickSaveButton();
	    Thread.sleep(2000);


	    // Name Field Validations
	    Select selectSalutation = sfAdminNewContactsPage.enterNameSalutation();
	    selectSalutation.selectByVisibleText("Mr.");

	    sfAdminNewContactsPage.enterFirstName("Raja");
	    Thread.sleep(2000);

	    Assert.assertEquals("Error: You must enter a value", sfAdminNewContactsPage.verifyErrorMsgLastName().getText());
	    System.out.print(" The error message for Last Name is : " + sfAdminNewContactsPage.verifyErrorMsgLastName().getText());
	    Thread.sleep(2000);
	    sfAdminNewContactsPage.enterLastName("Bundela" + random);
	    Thread.sleep(2000);
	    sfAdminNewContactsPage.clickSaveButton();
	    Thread.sleep(3000);

//Account Field Validations
	    Assert.assertEquals("Error: You must enter a value", sfAdminNewContactsPage.verifyErrorMsgAccName().getText());
	    System.out.print(" The error message for Account Name is : " + sfAdminNewContactsPage.verifyErrorMsgAccName().getText());
	    Thread.sleep(3000);


// Store the current window handle
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

// Close the new window, if that window no more required

// Switch back to original browser (first window)
	    //driver.switchTo().defaultContent();
	    //driver.switchTo().window(winHandleBefore);

// Continue with original browser (first window)*//*

//Validating the options of Home Address, Adjunct Address and Adjunct Account Lookup exist

	    assertTrue(sfAdminNewContactsPage.verifyAdjunctAccountLookup().isDisplayed());
	    System.out.println("Adjunct Account Lookup exists");
	    Thread.sleep(2000);

	    Select theAdjunctoption = sfAdminNewContactsPage.SamplingAddressSelector();
	    theAdjunctoption.selectByVisibleText("Adjunct Address");
	    Thread.sleep(2000);
	    theAdjunctoption.selectByVisibleText("Home");
	    Thread.sleep(2000);
	    theAdjunctoption.selectByVisibleText("Department");


// Validating that the Contact Mailing address defaults to the Department Shipping Address.

	    Thread.sleep(2000);
	    WebElement state = sfAdminNewContactsPage.verifyCMailingState();
	    assertTrue(state.getSize() != null);
	    Thread.sleep(2000);

	    WebElement country = sfAdminNewContactsPage.verifyCMailingCountry();
	    assertTrue(country.getText() != null);
	    Thread.sleep(2000);

// Job role validations

	    Select selectJobrole = sfAdminNewContactsPage.Jobrole();
	    Thread.sleep(2000);
	    selectJobrole.selectByVisibleText("Professor");
	    sfAdminNewContactsPage.clickSaveButton();
	    Thread.sleep(2000);


	    // Email Field Validations
	    Assert.assertEquals("Error: You must enter a value", sfAdminNewContactsPage.verifyErrorMsgEmail().getText());
	    System.out.println(" The error message for Email is : " + sfAdminNewContactsPage.verifyErrorMsgEmail().getText() + ";");
	    Thread.sleep(2000);
	    sfAdminNewContactsPage.enterEmail("abhinav@macmillan.com");
	    Thread.sleep(2000);

	    sfAdminNewContactsPage.clickSaveButton();
	    Thread.sleep(3000);

	    SFAdminCreatedContactPage sfAdminCreatedContactPage = new SFAdminCreatedContactPage(driver);
	    sfAdminCreatedContactPage.clickEditContact();
	    Thread.sleep(2000);
	    Select newRole = sfAdminNewContactsPage.Jobrole();
	    Thread.sleep(2000);
	    newRole.selectByVisibleText("Bookstore Manager");
	    Thread.sleep(2000);
	    sfAdminNewContactsPage.clickUnsolicitedSamples();
	    Thread.sleep(2000);
	    sfAdminNewContactsPage.clickSaveButton();
	    Thread.sleep(2000);

	    sfAdminCreatedContactPage.clickDeleteContact();
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