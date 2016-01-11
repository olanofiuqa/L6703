package com.MacmillanProjects.myproject;

import com.MacmillanProjects.page.SFAdminHomePage;
import com.MacmillanProjects.page.SFAdminLoginPage;
import com.MacmillanProjects.page.SFAdminProductViewerPage;
import com.MacmillanProjects.utilityclass.GenerateData;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class F3_MHEAccountProductSearches_0809_Test {
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


	// Click Contacts Button
	SFAdminHomePage sfAdminHomePage = new SFAdminHomePage(driver);
	sfAdminHomePage.clickProductsviewerButton();
	Thread.sleep(5000);

   SFAdminProductViewerPage sfAdminProductViewerPage = new SFAdminProductViewerPage(driver);

	//Searching Products
	sfAdminProductViewerPage.enterSearchDetails("1429299843");
	sfAdminProductViewerPage.clickSearchButton();
	Thread.sleep(9000);
	sfAdminProductViewerPage.clickProductExpander();
	Thread.sleep(5000);
	assertTrue(sfAdminProductViewerPage.verifyISBN().isDisplayed());
	//assertTrue(sfAdminSamplingWizardPage.verifyEAN().isdisplayed());
	assertTrue(sfAdminProductViewerPage.verifyLongtitle().isDisplayed());
	//assertTrue(sfAdminSamplingWizardPage.verifyShorttitle().isdisplayed());

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