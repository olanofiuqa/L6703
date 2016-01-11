package com.MacmillanProjects.myproject;

import com.MacmillanProjects.page.*;
import com.MacmillanProjects.utilityclass.GenerateData;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.*;

public class A_MHEAccountCreationInstitute_Test {
private ChromeDriver driver;
private GenerateData genData;
private String institute;


@BeforeSuite(alwaysRun = true)

public void setup() {
	driver = new ChromeDriver();
	genData = new GenerateData();
	this.institute = genData.generateCompanyName(12);
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
	Thread.sleep(4000);

	// Click Accounts Button
	SFAdminHomePage sfAdminHomePage = new SFAdminHomePage(driver);
	sfAdminHomePage.clickAccountsButton();

	// Click New Button
	SFAdminAccountsPage sfAdminAccountsePage = new SFAdminAccountsPage(driver);
	Thread.sleep(2000);
	sfAdminAccountsePage.clickNewButton();

	// Select Account Record Type and click continue

	SFAdminAccountsSelectRecTypePage sfAdminAccountsSelectRecTypePage = new SFAdminAccountsSelectRecTypePage(driver);
	Thread.sleep(2000);
	Select selectAccount1 = sfAdminAccountsSelectRecTypePage.AccountRecordType();
	selectAccount1.selectByVisibleText("Institute - HS");
	sfAdminAccountsSelectRecTypePage.clickContinueButton();
	Thread.sleep(3000);


	// New Account Page

	SFAdminNewAccountsPage sfAdminNewAccountsPage = new SFAdminNewAccountsPage(driver);
	Thread.sleep(2000);
	sfAdminNewAccountsPage.clickSaveButton();
	Thread.sleep(3000);


	// Name Field Validations
	assertEquals("Error: You must enter a value", sfAdminNewAccountsPage.verifyErrorMsgAccName().getText());
	System.out.print(" The error message for Account Name is : " + sfAdminNewAccountsPage.verifyErrorMsgAccName().getText());
	Thread.sleep(2000);
	sfAdminNewAccountsPage.enterAccountName("Abhi" + institute);
	Thread.sleep(2000);
	sfAdminNewAccountsPage.clickSaveButton();
	Thread.sleep(2000);


	// Sub Type Field Validations
	assertEquals("Error: You must enter a value", sfAdminNewAccountsPage.verifyErrorMsgAccSub().getText());
	System.out.println(" The error message for Sub Type is  : " + sfAdminNewAccountsPage.verifyErrorMsgAccSub().getText() + ";");
	Select selectAccountSub = sfAdminNewAccountsPage.AccountSubType();
	selectAccountSub.selectByVisibleText("High School");
	Thread.sleep(2000);
	sfAdminNewAccountsPage.clickSaveButton();
	Thread.sleep(2000);


	// C-ACC Field Validations
	assertEquals("Error: You must enter a value", sfAdminNewAccountsPage.verifyErrorMsgCAcc().getText());
	System.out.println(" The error message for C Account is : " + sfAdminNewAccountsPage.verifyErrorMsgCAcc().getText() + ";");
	Thread.sleep(2000);
	sfAdminNewAccountsPage.enterCAccount("123456");
	sfAdminNewAccountsPage.clickSaveButton();
	Thread.sleep(2000);


	// Region Field Validations
	assertEquals("Error: You must enter a value", sfAdminNewAccountsPage.verifyErrorMsgRegion().getText());
	System.out.println(" The error message for Region is : " + sfAdminNewAccountsPage.verifyErrorMsgRegion().getText() + ";");
	Select selectRegion = sfAdminNewAccountsPage.Region();

	//Asserting Territory is not Selectable until Region is filled
	assertFalse(sfAdminNewAccountsPage.verifyTerritoryOption().isEnabled());
	System.out.println("Territory is Disabled");

	selectRegion.selectByVisibleText("11-Chicago Region");
	sfAdminNewAccountsPage.clickSaveButton();
	Thread.sleep(2000);

	// Territory Field Validations
	assertEquals("Error: You must enter a value", sfAdminNewAccountsPage.verifyErrorMsgTerritory().getText());
	System.out.println(" The error message for Territory is : " + sfAdminNewAccountsPage.verifyErrorMsgTerritory().getText() + ";");
	Thread.sleep(2000);
	Select selectTerritory = sfAdminNewAccountsPage.Territory();
	selectTerritory.selectByVisibleText("11B-Chicago Central");
	Thread.sleep(2000);
	sfAdminNewAccountsPage.clickSaveButton();

	// Shipping Street Validations
	Thread.sleep(2000);
	assertEquals("Error: The Shipping Address is required.", sfAdminNewAccountsPage.verifyErrorMsgShippingStreet().getText());
	System.out.println(" The error message for Shipping Street is : " + sfAdminNewAccountsPage.verifyErrorMsgShippingStreet().getText() + ";");
	sfAdminNewAccountsPage.enterShippingStreet("Layson Road");
	Thread.sleep(2000);


	// Shipping City Validations
	assertEquals("Error: The Shipping Address is required.", sfAdminNewAccountsPage.verifyErrorMsgShippingCity().getText());
	System.out.println(" The error message for Shipping City is : " + sfAdminNewAccountsPage.verifyErrorMsgShippingCity
			                                                                                      ().getText() + ";");
	sfAdminNewAccountsPage.enterShippingCity("Delhi");
	Thread.sleep(2000);


	// Shipping State Validations
	assertEquals("Error: The Shipping Address is required.", sfAdminNewAccountsPage.verifyErrorMsgShippingState().getText());
	System.out.println(" The error message for Shipping State is : " + sfAdminNewAccountsPage
			                                                                 .verifyErrorMsgShippingState().getText() + ";");
	sfAdminNewAccountsPage.enterShippingState("Jungle");
	Thread.sleep(2000);


	// Shipping Zip Validations
	assertEquals("Error: The Shipping Address is required.", sfAdminNewAccountsPage.verifyErrorMsgShippingZip().getText());
	System.out.println(" The error message for Shipping Zip is : " + sfAdminNewAccountsPage.verifyErrorMsgShippingZip()
			                                                               .getText() + ";");
	sfAdminNewAccountsPage.enterShippingZip("121232");
	Thread.sleep(2000);


	// Shipping Country Validations
	assertEquals("Error: The Shipping Address is required.", sfAdminNewAccountsPage.verifyErrorMsgShippingCountry().getText());
	System.out.println(" The error message for Shipping Country is : " + sfAdminNewAccountsPage
			                                                               .verifyErrorMsgShippingCountry().getText() + ";");
	Thread.sleep(2000);
	sfAdminNewAccountsPage.enterShippingCountry("India");
	sfAdminNewAccountsPage.clickSaveButton();
	Thread.sleep(2000);

	// Invalid Country Check
	assertEquals("Error: The country in the Shipping address is not valid.", sfAdminNewAccountsPage.verifyErrorMsgInvalidShippingCountry().getText());
	System.out.println(" Error: The country in the Shipping address is not valid. : " + sfAdminNewAccountsPage.verifyErrorMsgInvalidShippingCountry().getText());
	Thread.sleep(2000);
	sfAdminNewAccountsPage.enterShippingCountry("US");
	sfAdminNewAccountsPage.clickSaveButton();
	Thread.sleep(2000);

	// Invalid State Check
	assertEquals("Error: Shipping State is not valid.", sfAdminNewAccountsPage.verifyErrorMsgInvalidShippingState().getText());
	System.out.println(" Error: Shipping State is not valid : " + sfAdminNewAccountsPage.verifyErrorMsgInvalidShippingState().getText());
	Thread.sleep(2000);
	sfAdminNewAccountsPage.enterShippingState("Texas");

	// Legacy Type Check
	assertTrue(sfAdminNewAccountsPage.verifyLegacyType().isEnabled());
	System.out.println("Legacy Type is selected");
	Thread.sleep(2000);

	// Mailing Address Checks
	sfAdminNewAccountsPage.enterMailingStreet("Stanford Road");
	sfAdminNewAccountsPage.enterMailingCity("Maimi");
	sfAdminNewAccountsPage.enterMailingState("Florida");
	sfAdminNewAccountsPage.enterMailingZip("1252423");
	sfAdminNewAccountsPage.enterMailingCountry("US");
	Thread.sleep(2000);

	// Checking the Address is copied from Mailing to Shipping Correctly
	sfAdminNewAccountsPage.clickCopyMailingtoShippingButton();
	Thread.sleep(2000);
	assertEquals(sfAdminNewAccountsPage.captureMailingState().getText(), sfAdminNewAccountsPage.captureShippingState().getText());
	Thread.sleep(2000);
	assertEquals(sfAdminNewAccountsPage.captureMailingCountry().getText(), sfAdminNewAccountsPage.captureShippingCountry().getText());
	System.out.println("Mailing Address copied to Shipping Address Successfully");

	sfAdminNewAccountsPage.clickSaveButton();
	Thread.sleep(2000);

	SFAdminCreatedAccountPage sfAdminCreatedAccountPage = new SFAdminCreatedAccountPage(driver);
	sfAdminCreatedAccountPage.clickEditAccount();
	Thread.sleep(3000);
	sfAdminNewAccountsPage.enterMailingStreet("Mall Road");
	sfAdminNewAccountsPage.enterMailingCity("NY");
	sfAdminNewAccountsPage.enterMailingState("NY");
	sfAdminNewAccountsPage.enterMailingZip("21523535");
	sfAdminNewAccountsPage.enterMailingCountry("US");
	sfAdminNewAccountsPage.clickCopyMailingtoShippingButton();
	Thread.sleep(3000);
	sfAdminNewAccountsPage.clickSaveButton();
	Thread.sleep(2000);

	sfAdminCreatedAccountPage.clickDeleteAccount();
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