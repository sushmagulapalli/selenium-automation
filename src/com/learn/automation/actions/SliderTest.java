package com.learn.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement element = driver.findElement(By.xpath(" //h3[contains(text(),'Horizontal Slider')]/parent::div/div/input"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).dragAndDropBy(element, 300, 0).build().perform();

        driver.quit();
    }
}
