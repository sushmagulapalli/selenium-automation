package com.learn.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //with page object model
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.setUserName("rakesh");
        loginPageObject.setPassword("1234");
        loginPageObject.clickLoginButton();

        //With page factory
        LoginPageObjectWithPageFactory loginPageObject1 = new LoginPageObjectWithPageFactory(driver);
        loginPageObject1.setUserName("sushma");
        loginPageObject1.setPassword("pawss");
        loginPageObject1.clickLoginButton();




    }
}
