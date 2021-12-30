package com.learn.automation.windowhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.TreeSet;

public class WindowHandlingTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        //driver.manage().timeouts().implicitlyWait(5)

        Set<String> handles = driver.getWindowHandles();

        for(String id: handles) {
            System.out.println("Window Id: " + id);
            String title = driver.switchTo().window(id).getTitle();
            System.out.println(title);

            if(title.contains("ToolsQA")) {
                driver.close();
            }
        }

//        driver.quit();
    }
}
