package com.MacmillanProjects.page.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {

    private final WebDriver driver;
    private final String elementId;


    public CheckBox( WebDriver driver, String elementId ) {
        this.driver = driver;
        this.elementId = elementId;
    }


    public void setChecked( boolean isChecked ) {
        if ( isChecked ) {
            unCheckIfChecked();
        } else {
            checkIfNotChecked();
        }
    }


    public boolean isChecked() {
        return getElement().isEnabled();
    }

    private void unCheckIfChecked() {
        WebElement element = getElement();
        if ( !element.isSelected() ) {
            element.click();
        }
    }


    private WebElement getElement() {
        return driver.findElement( By.id( elementId ) );
    }


    private void checkIfNotChecked() {
        WebElement element = getElement();
        if ( element.isSelected() ) {
            element.click();
        }
    }
}
