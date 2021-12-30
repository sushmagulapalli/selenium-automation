package com.learn.automation.authpopup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopupTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String actualText = driver.findElement(By.xpath("//p")).getText();

        String expectedText = "Congratulations! You must have the proper credentials";

        if(actualText.contains(expectedText)) {
            System.out.println("Login is successful");
        } else {
            System.out.println("Login is failed");
        }

        driver.quit();
    }
}
