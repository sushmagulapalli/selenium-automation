package com.learn.automation.headleass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefoxTest {
    public static void main(String[] args) {

        FirefoxOptions options=new FirefoxOptions();
        options.setHeadless(true);

        WebDriver driver=new FirefoxDriver(options);
        driver.get("https://www.facebook.com/");

        System.out.println(driver.getTitle());
        driver.quit();
    }
}
