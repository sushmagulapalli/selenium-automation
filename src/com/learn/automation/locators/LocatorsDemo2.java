package com.learn.automation.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorsDemo2 {
    public static void main(String[] args) {
       WebDriver driver=new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        driver.manage().window().maximize(); // maximize web page

        //className
//        List<WebElement> elements = driver.findElements(By.className("homeslider-container"));
        int sliders=driver.findElements(By.className("homeslider-container")).size();
//        elements.size();
        System.out.println(sliders);

        //TagName
        int links=driver.findElements(By.tagName("a")).size();
        System.out.println(links);
        driver.quit();
    }
}
