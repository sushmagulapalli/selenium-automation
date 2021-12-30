package com.learn.automation.actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClickTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement element = driver.findElement(By.xpath("//div[@id='hot-spot']"));

        Actions actions = new Actions(driver);
        actions.contextClick(element).build().perform();

        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);

        alert.accept();
        driver.quit();
    }
}
