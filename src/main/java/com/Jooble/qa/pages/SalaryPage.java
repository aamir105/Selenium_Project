package com.Jooble.qa.pages;

import com.Jooble.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class SalaryPage extends TestBase {
    public SalaryPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div/header/section/section/button")
    WebElement setting;
    @FindBy(xpath = "//a[@class='_1LCFDZ _8XAyO5 YFPypm gOcdd7 he4-zr']//div[1]")
    WebElement salarybtn;
    @FindBy(xpath = "//input[@id='input_:Rkn71:']")
    WebElement enterSalary;
    @FindBy(xpath = "//input[@id='tbRegion']")
    WebElement enterRegion;
    @FindBy(xpath = "//button[normalize-space()='Search Salaries']")
    WebElement searchSalaries;

    public void handleCookieBanner() {
        Duration duration = Duration.ofSeconds(15);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cookiescript_accept']")));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", acceptButton);
    }


    public void settingClick(){
        setting.click();
    }
    public void salarybtnClick(){
        salarybtn.click();
    }
    public void enterSalaryButton(String sal){
        enterSalary.sendKeys(sal);
    }
    public void enterRegionClick(String reg){
        enterRegion.sendKeys(reg);
    }
    public void enterSearchSalary(){
        searchSalaries.click();
    }
}

