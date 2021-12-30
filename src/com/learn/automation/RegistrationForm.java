package com.learn.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationForm {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://mytestingthoughts.com/Sample/home.html");

        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Sushma");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Gulapalli");
        driver.findElement(By.xpath("//input[@id='inlineRadioFemale']")).click();

        WebElement element = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect2']"));
        Select hobbiesListBox = new Select(element);
        hobbiesListBox.selectByVisibleText("Swimming");

        WebElement element1 = driver.findElement(By.xpath("//select[@class=\"form-control selectpicker\"]"));
        Select departmentbox = new Select(element1);
        departmentbox.selectByVisibleText("MPDC");

        driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("SushmaVardhan");
        driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("Passion@235");
        driver.findElement(By.xpath("//input[@name='confirm_password']")).sendKeys("Passion@235");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("gulapallisushma93@gmail.com");
        driver.findElement(By.xpath("//input[@name='contact_no']")).sendKeys("(639)0304015");
        driver.findElement(By.xpath("//textarea[@id='exampleFormControlTextarea1']")).sendKeys("Registration Form");
        driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();

        //Verifying the success text on the page after successful form submission
        String successText = driver.findElement(By.xpath("//div[@id='success_message']")).getText();
        if (successText.contains("Success")) {
            System.out.println("Record is created and its passed");
        } else {
            System.out.println("Its failed, check your data");
        }

        //verifying the table content with the data entered
        driver.findElement(By.xpath("//table[@id='mytable']"));

        String givenInputFirstName = "Sushma";
        String actualFirstNameFromTable = driver.findElement(By.xpath("//table[@id='mytable']/tbody/tr[2]/td[1]")).getText();

        if (givenInputFirstName.equals(actualFirstNameFromTable)) {
            System.out.println("Firstname saved correctly");
        } else {
            System.out.println("Issue with firstname");
        }

        String givenInputLastName = "Gulapalli";
        String actualLastNameFromTable = driver.findElement(By.xpath("//table[@id='mytable']/tbody/tr[2]/td[2]")).getText();

        if (givenInputLastName.equals(actualLastNameFromTable)) {
            System.out.println("Lastname saved correctly");
        } else {
            System.out.println("Issue with lastname");
        }

        driver.quit();

    }
}
