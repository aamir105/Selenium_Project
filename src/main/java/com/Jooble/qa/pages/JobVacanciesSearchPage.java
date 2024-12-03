package com.Jooble.qa.pages;

import com.Jooble.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobVacanciesSearchPage extends TestBase {

    public JobVacanciesSearchPage(){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@placeholder='What position are you looking for?']")
    WebElement position;
    @FindBy(xpath = "//input[@placeholder='Location']")
    WebElement location;
    @FindBy(xpath = "//span[normalize-space()='Find Jobs']")
    WebElement FindJobs;



    public void enterPosition(String ps){
        position.sendKeys(ps);
    }
    public void enterLocation(String loc){
        location.sendKeys(loc);
    }
    public ApplyFilterPage FindJobsButton() {
        FindJobs.click();
        return new ApplyFilterPage();
    }






}
