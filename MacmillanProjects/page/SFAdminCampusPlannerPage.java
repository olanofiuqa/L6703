package com.MacmillanProjects.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class SFAdminCampusPlannerPage {
private final WebDriver driver;


public SFAdminCampusPlannerPage(WebDriver driver) {
    this.driver = driver;
}


public void enterSearchParentAcc(String dataTerms) {
    driver.findElement(By.id("lksrch")).clear();
    driver.findElement(By.id("lksrch")).sendKeys(dataTerms);
}


public void clickSearchParentAcc() throws InterruptedException {
    driver.findElement(By.xpath("//*[@id=\"j_id0:cpform:pb1:pbs:j_id38_lkwgt\"]/img")).click();
}

public void enterDate(String dataTerms) {
    driver.findElement(By.xpath("//*[@id=\"j_id0:cpform:pb1:pbs\"]/div/table/tbody/tr/td[2]/input")).sendKeys(dataTerms);
}

public WebElement errorwrongDate() {
    return driver.findElement(By.xpath("//*[@id=\"j_id0:cpform:pb1:errorMsg:j_id5:j_id6:0:j_id7:j_id8:j_id10\"]"));
}

public WebElement successmessage() {
    return driver.findElement(By.xpath("//*[@id=\"j_id0:cpform:pb1:errorMsg:j_id5:j_id6:0:j_id7:j_id8:j_id10\"]"));
}

public WebElement accounterror() {
    return driver.findElement(By.xpath("//*[@id=\"j_id0:cpform:pb1:errorMsg:j_id5:j_id6:0:j_id7:j_id8:j_id10\"]"));
}


public void clickCreateTasks() throws InterruptedException {
    driver.findElement(By.xpath("//*[@id=\"j_id0:cpform:pb1:pbBtn:j_id32\"]")).click();
}


public Select campusVisitlist() {
Select cvl = new Select(driver.findElement(By.xpath("//*[@id=\"j_id0:cpFrm:pb:pbsSCV:values\"]")));
return cvl;
}

public void clickFinish() throws InterruptedException {
    driver.findElement(By.xpath("//*[@id=\"j_id0:cpform:pb1:pbBtn:j_id33\"]")).click();
}

public List<WebElement> chocontactsbox() {
    return driver.findElements(By.xpath("//*[(@class=\"checkbox\")]"));
}

}