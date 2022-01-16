package com.learn.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {
    public static void main(String[] args) {
//        System.setProperty("webdriver.gecko.driver","/Users/Rakesh_Budugu/softwares/geckodriver.exe");
//        WebDriver driver=new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver","/Users/Rakesh_Budugu/softwares/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/newtours");
        driver.manage().window().maximize();
        driver.findElement(By.name("userName")).sendKeys("mercury");
        driver.findElement(By.name("password")).sendKeys("mercury");
        driver.findElement(By.name("submit")).click();
        String exp_title="Login: Mercury Tours";

        String title = driver.getTitle();//returns the title of the page
        System.out.println(exp_title);
        System.out.println(title);

        if(exp_title.equals(title)){
            System.out.println("Test case is passed");
        }
        else
        {
            System.out.println("Test case is failed");
        }


        driver.quit();
    }
}
