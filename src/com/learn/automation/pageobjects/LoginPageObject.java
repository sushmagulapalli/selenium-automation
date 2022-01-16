package com.learn.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {

    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    //fields --> web elements
    By userid = By.xpath("//input[@name='uid']");
    By password = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//input[@name='btnLogin']");


    //methods --> actions on those web elements
    public void setUserName(String userName) {
        driver.findElement(userid).sendKeys(userName);
    }

    public void setPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }


}
