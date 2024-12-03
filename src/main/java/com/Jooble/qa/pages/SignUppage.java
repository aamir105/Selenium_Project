package com.Jooble.qa.pages;

import com.Jooble.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignUppage extends TestBase {
    public SignUppage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div/header/section/section/button")
    WebElement setting;
    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    WebElement Signup;
    @FindBy(xpath = "//input[@id='input_:r4:']")
    WebElement email;
    @FindBy(xpath = "//button[@class='zrKtGv button_default button_size_M q+3eJr Givf4A _3p5yx8']")
    WebElement cont;
    @FindBy(xpath = "//input[@id='input_:r5:']")
    WebElement password;
    @FindBy(xpath = "//button[@class=\"zrKtGv button_default button_size_M q+3eJr Givf4A _3p5yx8\"]")
    WebElement createacctbtn;

    public void settingClick(){
        setting.click();
    }
    public void signUpClick(){
        Signup.click();
    }
    public void entermailClick(String un){
        email.sendKeys(un);
    }
    public void continuebuttonClick(){
        cont.click();
    }

    public JobVacanciesSearchPage enterpassClick(String pw) {
        password.sendKeys(pw);
        createacctbtn.click();
        return new JobVacanciesSearchPage();
    }
    public void enterSignupClick(){
        createacctbtn.click();
    }

}
