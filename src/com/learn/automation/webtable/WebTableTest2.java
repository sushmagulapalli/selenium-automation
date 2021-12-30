package com.learn.automation.webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTableTest2 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/Rakesh_Budugu/demo.html");
         int rowcount = driver.findElements(By.xpath("//table[@id='table']/tbody/tr")).size();
         int column =2;
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table']/thead/tr/th"));
        for (WebElement header: headers)
        {
            System.out.print(header.getText()+ "   ||   ");
        }
        System.out.println();
        System.out.println("====================");
        for (int i = 1; i <= rowcount; i++) {

            for (int j = 1; j <= column; j++) {
                WebElement element = driver.findElement(By.xpath("//table[@id='table']/tbody/tr["+ i +"]/td["+ j +"]"));
                System.out.print(element.getText() + " | ");
            }
            System.out.println();





    }
        driver.quit();
}
}

