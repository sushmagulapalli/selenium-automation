package com.learn.automation.headleass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverTest {
    public static void main(String[] args) {

        WebDriver driver=new HtmlUnitDriver();

        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
