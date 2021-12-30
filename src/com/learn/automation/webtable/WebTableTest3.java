package com.learn.automation.webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTableTest3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        int rowCount = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr")).size();
        int column = 3;

        List<WebElement> headers = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/thead/tr/th"));

        for (int i = 0; i <= 2 ; i++) {
            System.out.print(headers.get(i).getText() + " | ");
        }
        System.out.println();

        for (int j = 1; j <= rowCount; j++) {
            String headertext = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + j + "]/th")).getText();
            System.out.print(headertext + " | ");

            for (int k = 1; k <= 2; k++) {
                String cellText = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + j + "]/td[" + k + "]")).getText();
                System.out.print(cellText + " | ");
            }
            System.out.println();
        }

        driver.quit();

    }
}
