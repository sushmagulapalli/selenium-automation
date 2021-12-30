package com.learn.automation.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        //id & name locators
        WebElement searchbox= driver.findElement(By.id("search_query_top"));
        searchbox.sendKeys("T-shirts");
       driver.findElement(By.name("submit_search")).click();

       //Link text & Partial Link Text
        driver.findElement(By.linkText("Printed Chiffon Dress")).click();
        //driver.findElement(By.partialLinkText("Chiffon Dress")).click();









     driver.quit();
    }
}
