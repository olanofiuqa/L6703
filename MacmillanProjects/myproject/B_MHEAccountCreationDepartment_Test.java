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

public class B_MHEAccountCreationDepartment_Test {
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
	Thread.sleep(2000);
	sfAdminLoginPage.enterSFUsername("abinav.kant@macmillan.com.qa");
	sfAdminLoginPage.enterSFPassword("Abhijazz9");
	sfAdminLoginPage.clickSFSubmitLogin();
	Thread.sleep(4000);


	// Click Accounts Button
	SFAdminHomePage sfAdminHomePage = new SFAdminHomePage(driver);
	sfAdminHomePage.clickAccountsButton();
	Thread.sleep(2000);

	// Click New Button
	SFAdminAccountsPage sfAdminAccountsePage = new SFAdminAccountsPage(driver);
	Thread.sleep(2000);
	sfAdminAccountsePage.clickNewButton();
	Thread.sleep(2000);

	// Select Account Record Type and click continue

	SFAdminAccountsSelectRecTypePage sfAdminAccountsSelectRecTypePage = new SFAdminAccountsSelectRecTypePage(driver);
	Thread.sleep(2000);
	Select selectAccount1 = sfAdminAccountsSelectRecTypePage.AccountRecordType();
	Thread.sleep(2000);
	selectAccount1.selectByVisibleText("Department - College");
	sfAdminAccountsSelectRecTypePage.clickContinueButton();
	Thread.sleep(3000);


	// New Account Page

	SFAdminNewAccountsPage sfAdminNewAccountsPage = new SFAdminNewAccountsPage(driver);
	Thread.sleep(2000);
	sfAdminNewAccountsPage.clickSaveButton();
	Thread.sleep(2000);


	// Name Field Validations
	assertEquals("Error: You must enter a value", sfAdminNewAccountsPage.verifyErrorMsgAccName().getText());
	System.out.print(" The error message for Account Name is : " + sfAdminNewAccountsPage.verifyErrorMsgAccName().getText());
	Thread.sleep(2000);
	sfAdminNewAccountsPage.enterAccountName("Abhi" + institute);
	Thread.sleep(2000);
	sfAdminNewAccountsPage.clickSaveButton();
	Thread.sleep(2000);


	// Parent Field Validations
	assertEquals("Error: You must enter a value", sfAdminNewAccountsPage.verifyErrorMsgAccParent().getText());
	System.out.println(" The error message for Parent is  : " + sfAdminNewAccountsPage.verifyErrorMsgAccParent().getText() + ";");
	Thread.sleep(2000);


// Store the current window handle
	String winHandleBefore = driver.getWindowHandle();

// Perform the click operation that opens new window
	sfAdminNewAccountsPage.clickParentAccountLookup();
	Thread.sleep(2000);

// Switch to new window opened

	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
	}

// Perform the actions on new window
	driver.switchTo().frame("searchFrame");
	Thread.sleep(2000);
	WebElement framepresent1 = sfAdminNewAccountsPage.framepresent();
	assertTrue(framepresent1.isDisplayed());
	System.out.println("Search Popup is Displayed");


	sfAdminNewAccountsPage.enterSearchParentAcc("Abhi");
	sfAdminNewAccountsPage.clickSearchParentAccGo();
	Thread.sleep(4000);


	driver.switchTo().defaultContent();

	Thread.sleep(2000);

	driver.switchTo().frame("resultsFrame");
	Thread.sleep(2000);


	//sfAdminNewAccountsPage.clickshowfilters();
	List<WebElement> viewAccountLinks = sfAdminNewAccountsPage.getShowParentAccLinks();
	Thread.sleep(2000);
	int parentaccCount = viewAccountLinks.size();

	System.out.println("Parent Account Links are   " + parentaccCount);
	Thread.sleep(2000);
	assertTrue(viewAccountLinks.size() > 0, "Parent Account were found");
	Thread.sleep(2000);

	int i = 1;
	WebElement ele = viewAccountLinks.get(i);
	Thread.sleep(2000);
	System.out.println(ele.getText());
	ele.click();
	driver.switchTo().window(winHandleBefore);
	Thread.sleep(2000);
	System.out.println("Parent Account Selected");

// Close the new window, if that window no more required

// Switch back to original browser (first window)
	//driver.switchTo().defaultContent();
	//driver.switchTo().window(winHandleBefore);

// Continue with original browser (first window)*/

	// Discipline  Field Validations
	assertEquals("Error: You must enter a value", sfAdminNewAccountsPage.verifyErrorMsgDiscipline().getText());
	System.out.println(" The error message for Discipline is : " + sfAdminNewAccountsPage.verifyErrorMsgDiscipline().getText() + ";");
	Thread.sleep(2000);
	Select selectDiscipline = sfAdminNewAccountsPage.Discipline(); ;
	selectDiscipline.selectByVisibleText("Chemistry");
	Thread.sleep(2000);

	// C-ACC Field
	sfAdminNewAccountsPage.enterCAccount("123456");
	Thread.sleep(2000);

	// Shipping Street
	sfAdminNewAccountsPage.enterShippingStreet("Layson Road");
	Thread.sleep(2000);


	// Shipping City
	sfAdminNewAccountsPage.enterShippingCity("Delhi");
	Thread.sleep(2000);


	// Shipping State
	sfAdminNewAccountsPage.enterShippingState("Jungle");
	Thread.sleep(2000);


	// Shipping Zip
	sfAdminNewAccountsPage.enterShippingZip("121232");
	Thread.sleep(2000);


	// Shipping Country Validations
	sfAdminNewAccountsPage.enterShippingCountry("India");
	sfAdminNewAccountsPage.clickSaveButton();
	Thread.sleep(2000);

	// Invalid Country Check
	assertEquals("Error: The country in the Shipping address is not valid.", sfAdminNewAccountsPage.verifyErrorMsgInvalidShippingCountry().getText());
	System.out.println(" Error: The country in the Shipping address is not valid. : " + sfAdminNewAccountsPage.verifyErrorMsgInvalidShippingCountry().getText());
	sfAdminNewAccountsPage.enterShippingCountry("US");
	sfAdminNewAccountsPage.clickSaveButton();
	Thread.sleep(2000);

	// Invalid State Check
	assertEquals("Error: Shipping State is not valid.", sfAdminNewAccountsPage.verifyErrorMsgInvalidShippingState().getText());
	System.out.println(" Error: Shipping State is not valid : " + sfAdminNewAccountsPage.verifyErrorMsgInvalidShippingState().getText());
	Thread.sleep(2000);
	sfAdminNewAccountsPage.enterShippingState("Texas");
	sfAdminNewAccountsPage.clickSaveButton();
	Thread.sleep(2000);

//Verification all information copied successfully from Parent Account
	sfAdminNewAccountsPage.clickusedParentAcc();
	Thread.sleep(2000);

	WebElement a = sfAdminNewAccountsPage.PCAccount();
	String a1 = a.getText();
	Thread.sleep(2000);
	WebElement b = sfAdminNewAccountsPage.PRegion();
	String b1 = b.getText();
	Thread.sleep(2000);
	WebElement c = sfAdminNewAccountsPage.PTerritory();
	String c1 = c.getText();
	WebElement d = sfAdminNewAccountsPage.PWeblink();
	String d1 = d.getText();
	Thread.sleep(2000);

	driver.navigate().back();
	Thread.sleep(2000);

	WebElement m = sfAdminNewAccountsPage.DCAccount();
	String m1 = m.getText();
	Thread.sleep(2000);
	WebElement n = sfAdminNewAccountsPage.DRegion();
	String n1 = n.getText();
	WebElement o = sfAdminNewAccountsPage.DTerritory();
	String o1 = o.getText();
	Thread.sleep(2000);
	WebElement p = sfAdminNewAccountsPage.DWeblink();
	String p1 = p.getText();

	assertEquals(a1, m1);
	System.out.println("Data matches for C Account");
	assertEquals(b1, n1);
	System.out.println("Data matches for Region");
	Thread.sleep(2000);
	assertEquals(c1, o1);
	System.out.println("Data matches for Territory");
	assertEquals(d1, p1);
	System.out.println("Data matches for Weblink");

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