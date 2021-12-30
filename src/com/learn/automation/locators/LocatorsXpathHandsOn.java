package com.learn.automation.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsXpathHandsOn {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        String Text =driver.findElement(By.xpath("//button[@id='u_0_10_Lp']//parent::*//parent::*/child::div[1]/div[1]/div[1]")).getText();
        System.out.println(Text);


    }
}
