package com.learn.automation.webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTableTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        int rowCount = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int columnCount = 3;

        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th"));

        for (WebElement header : headers) {
            System.out.print(header.getText() + " | ");
        }
        System.out.println();

        System.out.println("=============================================");

        for (int i = 2; i <= rowCount; i++) {

            for (int j = 1; j <= columnCount; j++) {
                WebElement element = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[" + j + "]"));
                System.out.print(element.getText() + " | ");
            }
            System.out.println();
        }

        driver.quit();
    }
}