package com.learn.automation.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //alert with OK button only
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        Alert alertOk = driver.switchTo().alert();
        String alertOkText = alertOk.getText();
        System.out.println(alertOkText);
        alertOk.accept();

        //alert with OK and CANCEL
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
        Alert alertOk2 = driver.switchTo().alert();
        String alertOkText2 = alertOk2.getText();
        System.out.println(alertOkText2);
        alertOk2.dismiss();
//        alertOk2.accept();

        //alert with OK, CANCEL and TEXT
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        Alert alertOk3 = driver.switchTo().alert();
        String alertOkText3 = alertOk3.getText();
        System.out.println(alertOkText3);
        String expectedText3 = "This is the text for alert!!!";
        alertOk3.sendKeys(expectedText3);
//        alertOk2.dismiss();
        alertOk2.accept();
        String actualText3 = driver.findElement(By.xpath("//p[@id='result']")).getText();

        if (actualText3.contains(expectedText3)) {
            System.out.println("Alert test3 passed");
        } else {
            System.out.println("Alert test3 failed");
        }

        driver.quit();
    }
}
