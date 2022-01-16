package com.learn.automation.Naukri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NaukriUpdatePage {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.naukri.com/nlogin/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='usernameField']")).sendKeys("sushmagulapalliqa@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwordField']")).sendKeys("Passion@235");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement myProfileLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'My Naukri')]")));
        Actions action = new Actions(driver);
        action.moveToElement(myProfileLink).build().perform();

        WebElement editProfileLink = driver.findElement(By.xpath("//a[contains(text(),'Edit Profile')]"));
        editProfileLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='edit icon'])[1]"))).click();
        WebElement textArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='resumeHeadlineTxt']")));
        String actualText = textArea.getText();

        String substring = actualText.substring(actualText.length() - 1);
        String updatedText;

        if (substring.equals(".")) {
            updatedText = actualText.substring(0, actualText.length() - 1);
        } else {
            updatedText = actualText + ".";
        }
        textArea.clear();
        textArea.sendKeys(updatedText);

        driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();
        driver.quit();
    }
}

