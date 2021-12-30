package com.learn.automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MousehoverTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        //check if the text is present before hovering over the image - should be false
        boolean displayed = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]")).isDisplayed();
        System.out.println("Before mouse hover: " + displayed);

        WebElement imageElement1 = driver.findElement(By.xpath("//h3/parent::div/div[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(imageElement1).build().perform();

        //check if the text is present after hovering over the image - should be true
        WebElement text = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
        System.out.println("After mouse hover: " + text.isDisplayed());

        if(text.isDisplayed()) {
            System.out.println("Test is passed");
        } else {
            System.out.println("Test is failed");
        }

        driver.quit();
    }
}
