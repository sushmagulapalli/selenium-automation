package com.learn.automation.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFramesTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        System.out.println("Before switching to Frame title: " + driver.getTitle());
//        System.out.println("Before switching to Frame title: " + driver.findElement(By.xpath("//h1")));

        driver.switchTo().frame("frame2");
        String text = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text);
        System.out.println("After switching to Frame title: " + driver.getTitle());
//        System.out.println("Before switching to Frame title: " + driver.findElement(By.xpath("//h1")));
        driver.switchTo().defaultContent();

        System.out.println("After switching to parent title: " + driver.getTitle());
//        System.out.println("Before switching to Frame title: " + driver.findElement(By.xpath("//h1")));

        driver.quit();
    }
}
