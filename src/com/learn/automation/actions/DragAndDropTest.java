package com.learn.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement firstElement = driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement secondElement = driver.findElement(By.xpath("//div[@id='column-b']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(firstElement).moveToElement(secondElement).release().build().perform();

//        actions.dragAndDrop(firstElement, secondElement).build().perform();
        driver.quit();
    }
}
