package com.Jooble.qa.pages;

import com.Jooble.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(xpath = "//span[normalize-space()='Log in']")
    WebElement login;

    @FindBy(xpath = "//input[@id='input_:r2:']")
    WebElement email;

    @FindBy(xpath = "//span[text()='Continue']")
    WebElement cont;

    @FindBy(xpath = "//input[@id='input_:r3:']")
    WebElement password;

    @FindBy(xpath = "//button[@class='zrKtGv button_default button_size_M q+3eJr Givf4A _3p5yx8']")
    WebElement loginbtn;

    @FindBy(xpath = "//div[@class='gmmjRU']//*[name()='svg']")
    WebElement Logo;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickloginbutton() {
        loggerr.info("Clicking on the login button.");
        login.click();
    }

    public void entermail(String un) {
        loggerr.info("Entering email: " + un);
        email.sendKeys(un);
    }

    public void clickcontinuebutton() {
        loggerr.info("Clicking on the continue button.");
        cont.click();
    }

    public JobVacanciesSearchPage enterpass(String pw) {
        loggerr.info("Entering password.");
        password.sendKeys(pw);
        loginbtn.click();
        return new JobVacanciesSearchPage();
    }

    public void enterlogin() {
        loggerr.info("Logging in...");
        loginbtn.click();
    }

    public void multipleUserLogin(String emailID, String password) {
        loggerr.info("Performing multiple user login with email: " + emailID);
        clickloginbutton();
        entermail(emailID);
        clickcontinuebutton();
        enterpass(password);
        enterlogin();
    }

    public String validateLoginPageTitle() {
        loggerr.info("Validating login page title.");
        return driver.getTitle();
    }

    public boolean validateImage() {
        loggerr.info("Validating logo image presence.");
        return Logo.isDisplayed();
    }
}
