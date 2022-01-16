package com.learn.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/V4/index.php");

        driver.findElement(By.xpath("//input[@name='id']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        //verification 2


    }
}
