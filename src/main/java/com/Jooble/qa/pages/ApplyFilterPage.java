package com.Jooble.qa.pages;
//
import com.Jooble.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplyFilterPage extends TestBase {
    public ApplyFilterPage(){
        PageFactory.initElements(driver,this);
    }
//
    @FindBy(xpath = "//div[@class='apmZrt']//div[1]//*[name()='svg']")
    WebElement DateOFPostingButton;
    @FindBy(xpath = "//div[normalize-space()='Near me']")
    WebElement Nearme;
    @FindBy(xpath = "//div[normalize-space()='Last 7 days']")
    WebElement Last7Days;
    @FindBy(xpath = "//label[@for='period_3']")
    WebElement MonthlySalary;
    @FindBy(xpath = "//label[@for='salaryMin_24000']")
    WebElement HigherThan24k;
    @FindBy(xpath = "//span[normalize-space()='Full-time']")
    WebElement FullTime;
    @FindBy(xpath = "//div[normalize-space()='Any experience']")
    WebElement Experience;
    @FindBy(xpath = "//span[@class='ASRh9- caption_default']")
    WebElement ApplyFilter;

//
    public void DateOFPostingButtonMthd(){
        DateOFPostingButton.click();
    }
//
//
    public void EmployementType(){
        Nearme.click();
    }
    public void DateOfPosting(){
        Last7Days.click();
    }
    public void Salary(){
        MonthlySalary.click();
    }
    public void PerMonthSalary(){
        HigherThan24k.click();
    }
    public void TypeOfEmployment(){
        FullTime.click();
    }
    public void WorkExperience(){
        Experience.click();
    }
    public void Apply(){
        ApplyFilter.click();
    }
}

