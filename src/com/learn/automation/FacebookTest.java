package com.learn.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTest {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");// <title id="pageTitle">Facebook – log in or sign up</title>
        String actualTitle= driver.getTitle();
        String expectedTitle="Facebook – log in or sign up";

        if(actualTitle.equals(expectedTitle)) {

            System.out.println("Title is passed");
        }
        else
        {
            System.out.println("Title is failed");
        }

         driver.quit();
    }

}
