package com.MacmillanProjects.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;



public class SFAdminNewAccountsPage {
    private final WebDriver driver;


    public SFAdminNewAccountsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterAccountName(String dataTerms) {
        driver.findElement(By.id("acc2")).clear();
        driver.findElement(By.id("acc2")).sendKeys(dataTerms);
    }

    public void clickSaveButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]")).click();
    }

    public WebElement verifyErrorMsgAccName() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[2]/table/tbody/tr[1]/td[2]/div/div[2]" ));
    }

    public Select AccountSubType() {
        Select theAccountsub = new Select(driver.findElement(By.id("00Ni000000COui2")));
        return theAccountsub ;
    }

    public WebElement verifyErrorMsgAccSub() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[2]/table/tbody/tr[4]/td[4]/div/div[2]" ));
    }


    public void enterCAccount(String dataTerms) {
        driver.findElement(By.id("00Ni000000COuhi")).clear();
        driver.findElement(By.id("00Ni000000COuhi")).sendKeys(dataTerms);
    }

    public WebElement verifyErrorMsgCAcc() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[2]/table/tbody/tr[4]/td[4]/div/div[2]" ));
    }


    public Select Discipline() {
        Select theDiscipline = new Select (driver.findElement(By.id("00Ni000000COuhh")));
        return theDiscipline;
    }


    public WebElement verifyErrorMsgDiscipline() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[2]/table/tbody/tr[3]/td[2]/div/div[2]" ));
    }


    public Select Region() {
        Select theRegion = new Select(driver.findElement(By.id("00Ni000000COuhv")));
        return theRegion ;
    }

    public WebElement verifyErrorMsgRegion() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[2]/table/tbody/tr[5]/td[4]/div/div[2]"));
    }


    public WebElement verifyTerritoryOption() throws InterruptedException {
        return driver.findElement(By.id("00Ni000000COui4"));
    }
    public Select Territory() {
        Select theTerritory = new Select(driver.findElement(By.id("00Ni000000COui4")));
        return theTerritory ;
    }

    public WebElement verifyErrorMsgTerritory() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[2]/table/tbody/tr[6]/td[4]/div/div[2]"));
    }

    public void enterShippingStreet(String dataTerms) {
        driver.findElement(By.id("acc18street")).clear();
        driver.findElement(By.id("acc18street")).sendKeys(dataTerms);
    }

    public WebElement verifyErrorMsgShippingStreet() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[1]/td[2]/div" ));
    }


    public void enterShippingCity(String dataTerms) {
        driver.findElement(By.id("acc18city")).clear();
        driver.findElement(By.id("acc18city")).sendKeys(dataTerms);
    }

    public WebElement verifyErrorMsgShippingCity() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div"));
    }


    public void enterShippingState(String dataTerms) {
        driver.findElement(By.id("acc18state")).clear();
        driver.findElement(By.id("acc18state")).sendKeys(dataTerms);
    }

    public WebElement captureShippingState() throws InterruptedException {
    return  driver.findElement(By.id("acc18state"));
    }

    public WebElement verifyErrorMsgShippingState() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[3]/td[2]/div"));
    }

    public void enterShippingZip(String dataTerms) {
        driver.findElement(By.id("acc18zip")).clear();
        driver.findElement(By.id("acc18zip")).sendKeys(dataTerms);
    }

    public WebElement verifyErrorMsgShippingZip() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[4]/td[2]/div"));
    }


    public void enterShippingCountry(String dataTerms) {
        driver.findElement(By.id("acc18country")).clear();
        driver.findElement(By.id("acc18country")).sendKeys(dataTerms);
    }

    public WebElement captureShippingCountry() throws InterruptedException {
        return  driver.findElement(By.id("acc18country"));
    }


    public WebElement verifyErrorMsgShippingCountry() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[5]/td[2]/div"));
    }


    public WebElement verifyErrorMsgInvalidShippingCity() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[3]/td[2]/div"));
    }

    public WebElement verifyErrorMsgInvalidShippingState() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[3]/td[2]/div"));
    }

    public WebElement verifyErrorMsgInvalidShippingCountry() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[5]/td[2]/div"));
    }

    public WebElement verifyLegacyType() throws InterruptedException {
        return driver.findElement (By.id("acc6"));
    }

    public void enterMailingStreet(String dataTerms) {
        driver.findElement(By.id("acc17street")).clear();
        driver.findElement(By.id("acc17street")).sendKeys(dataTerms);
    }

    public void enterMailingCity(String dataTerms) {
        driver.findElement(By.id("acc17city")).clear();
        driver.findElement(By.id("acc17city")).sendKeys(dataTerms);
    }

    public void enterMailingState(String dataTerms) {
        driver.findElement(By.id("acc17state")).clear();
        driver.findElement(By.id("acc17state")).sendKeys(dataTerms);
    }

    public WebElement captureMailingState() throws InterruptedException {
        return  driver.findElement(By.id("acc17state"));
    }

    public void enterMailingZip(String dataTerms) {
        driver.findElement(By.id("acc17zip")).clear();
        driver.findElement(By.id("acc17zip")).sendKeys(dataTerms);
    }

    public void enterMailingCountry(String dataTerms) {
        driver.findElement(By.id("acc17country")).clear();
        driver.findElement(By.id("acc17country")).sendKeys(dataTerms);
    }

    public WebElement captureMailingCountry() throws InterruptedException {
        return  driver.findElement(By.id("acc17country"));
    }

    public void clickCopyMailingtoShippingButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"head_1_ep\"]/span/span/a")).click();

    }

    //--------------------------------------------------------------------------------------

    public WebElement verifyErrorMsgAccParent() throws InterruptedException {
        return driver.findElement (By.xpath("//*[@id=\"ep\"]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div/div[2]"));
    }


    public void clickParentAccountLookup() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"acc3_lkwgt\"]/img")).click();

    }

    public void  enterSearchParentAcc(String dataTerms) {
        driver.findElement(By.id("lksrch")).clear();
        driver.findElement(By.id("lksrch")).sendKeys(dataTerms);
    }


    public void clickSearchParentAccGo() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"theForm\"]/div/div[2]/input[2]")).click();
    }

    public void clickCloseParentAccWindow() throws InterruptedException {
        driver.findElement( By.className("closeDOMWindow") ).click();
    }

    private boolean checkElementClassExists( String ElementClass ) {
        WebElement elementIdExists = null;
        try {
            elementIdExists = driver.findElement( By.className( ElementClass ) );
            return elementIdExists.isDisplayed();
        } catch ( NoSuchElementException e ) {
            return false;
        }
    }

    public boolean verifyParentAccWindowOpens() {
        return checkElementClassExists("closeDOMWindow") ;
    }




    public void clickshowfilters() throws InterruptedException {
        driver.findElement(By.id("showFiltersIdAccount")).click();
    }



    public List <WebElement> getShowParentAccLinks() {
        return driver.findElements(By.partialLinkText("Abhi"));
    }

    public WebElement framepresent() {
        return driver.findElement(By.xpath("//*[@id=\"theForm\"]/div/div[1]/div/div/img"));

    }

    public void clickClearResults() throws InterruptedException {
        driver.findElement( By.className("clearResults") ).click();
    }


    public void clickusedParentAcc() throws InterruptedException {
        driver.findElement(By.partialLinkText("AbhiCompany")).click();
    }

    public WebElement PCAccount()  {
       return driver.findElement(By.id("00Ni000000COuhi_ileinner"));
    }

    public WebElement PRegion()  {
        return driver.findElement( By.id("00Ni000000COuhv_ileinner") );
    }

    public WebElement PTerritory()  {
        return driver.findElement( By.id("00Ni000000COui4_ileinner") );
    }

    public WebElement PWeblink()  {
        return driver.findElement( By.id("00Ni000000EGOrs_ileinner") );
    }


    public WebElement DCAccount()  {
        return driver.findElement( By.id("00Ni000000COuhi_ileinner") );
    }

    public WebElement DRegion()  {
        return driver.findElement( By.id("00Ni000000EGOsC_ileinner") );
    }

    public WebElement DTerritory()  {
        return driver.findElement( By.id("00Ni000000EGOsF_ileinner") );
    }

    public WebElement DWeblink()  {
        return driver.findElement( By.id("00Ni000000EGOrs_ileinner") );
    }




}





