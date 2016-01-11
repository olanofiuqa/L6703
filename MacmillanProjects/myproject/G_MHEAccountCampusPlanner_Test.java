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
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class G_MHEAccountCampusPlanner_Test {
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
	sfAdminHomePage.clickContactsButton();
	Thread.sleep(5000);
	SFAdminContactsPage sfAdminContactsPage = new SFAdminContactsPage(driver);
	Select viewContacts = sfAdminContactsPage.ContactView();
	viewContacts.selectByVisibleText("All Contacts");
	sfAdminContactsPage.clickGoButton();
	Thread.sleep(4000);
	Random random = new Random();

	List<WebElement> checkboxes = sfAdminContactsPage.chocheckbox(); {
		for (int i = 0; i <= 2; i++) {
			int n = random.nextInt(44 - 1 + 1) + 1;
			checkboxes.get(n).click();
		}
	}
	sfAdminContactsPage.clickCampusplanner();
	Thread.sleep(2000);
	SFAdminCampusPlannerPage sfAdminCampusPlannerpage = new SFAdminCampusPlannerPage(driver);
	Thread.sleep(2000);

	sfAdminCampusPlannerpage.clickCreateTasks();
	Thread.sleep(2000);
	WebElement accountmsg = sfAdminCampusPlannerpage.accounterror();
	assertEquals(accountmsg.getText(), "Error:\nPlease select a related Account (School/Dept) before continuing.");
    System.out.println(accountmsg.getText());

// Store the current window handle
	String winHandleBefore = driver.getWindowHandle();

// Perform the click operation that opens new window
	sfAdminCampusPlannerpage.clickSearchParentAcc();
	Thread.sleep(2000);

// Switch to new window opened

	SFAdminNewAccountsPage sfAdminNewAccountsPage = new SFAdminNewAccountsPage(driver);

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

	// entering no date message check
	sfAdminCampusPlannerpage.clickCreateTasks();
	Thread.sleep(2000);
	WebElement futdate = sfAdminCampusPlannerpage.errorwrongDate();
	assertEquals(futdate.getText(),"Error:\nPlease enter a future Date before continuing.");
	System.out.println(futdate.getText());

	// entering earlier date message check
	sfAdminCampusPlannerpage.enterDate("31/07/2015");
    sfAdminCampusPlannerpage.clickCreateTasks();
	Thread.sleep(2000);
	WebElement futdate1 = sfAdminCampusPlannerpage.errorwrongDate();
	assertEquals(futdate1.getText(), "Error:\nPlease enter a future Date before continuing.");
	System.out.println(futdate1.getText());

	// entering correct date
	sfAdminCampusPlannerpage.enterDate("31/10/2015");
	sfAdminCampusPlannerpage.clickCreateTasks();
	Thread.sleep(2000);

	//success message
	WebElement successmsg = sfAdminCampusPlannerpage.successmessage();
	assertTrue(successmsg.isDisplayed());
	Thread.sleep(2000);

	sfAdminCampusPlannerpage.clickFinish();
	Thread.sleep(2000);

	// editing and sampling.
	sfAdminHomePage.clickMoreApps();
	Thread.sleep(2000);
    SFAdminAllAppsPage sfAdminAllAppsPage = new SFAdminAllAppsPage(driver);
	sfAdminAllAppsPage.clickCampusPlanner();
	Thread.sleep(2000);
	Select dropdown = sfAdminCampusPlannerpage.campusVisitlist();
	List <WebElement> opts = dropdown.getOptions();
	for (WebElement opt:opts)
	{
		if(opt.getText().contains("AbhiCompany"))
		{
		opt.click();
		break;
	}
	}

	List<WebElement> checkContacts = sfAdminCampusPlannerpage.chocontactsbox();
	Thread.sleep(2000);
	{
		for (int k = 0; k <= 2; k++) {
			int n = random.nextInt(10 - 1 + 1) + 1;
			checkContacts.get(n).click();
		}
	}







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