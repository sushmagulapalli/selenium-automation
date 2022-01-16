package com.learn.automation.headleass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeTest {
    public static void main(String[] args) {

        ChromeOptions options=new ChromeOptions();
        options.setHeadless(true);

        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());

        driver.quit();
    }
}
