package com.learn.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjectWithPageFactory {

    WebDriver driver;

    public LoginPageObjectWithPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //fields --> web elements
    @FindBy(xpath = "//input[@name='uid']")
    WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//input[@name='btnLogin']")
    WebElement button;

    //methods --> actions on those web elements
    public void setUserName(String uName) {
        userName.sendKeys(uName);
    }

    public void setPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void clickLoginButton() {
        button.click();
    }



}
