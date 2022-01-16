package com.learn.automation.datadriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataDrivenTest {

    public static void main(String[] args) throws IOException {

        //write the actual scenario with one set of data --> DONE
        //use the data from excel sheet to test this in a data driven mode --> DONE

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");

        //Updating the new excel data --> OUTPUT
        FileOutputStream fos = new FileOutputStream("/Users/Rakesh_Budugu/softwares/data.xlsx");
//        XSSFWorkbook workbookOut = new XSSFWorkbook();
//        workbookOut.getSheetAt(1);

        //Reading the excel data --> INPUT
        FileInputStream fis = new FileInputStream("/Users/Rakesh_Budugu/softwares/data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(1);
        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();

        for (int i = 1; i <= rows; i++) {

            XSSFCell cell = sheet.getRow(i).getCell(0);
            String principalAmount = String.valueOf((int) cell.getNumericCellValue());

            String returnOfInvestment = String.valueOf((int) sheet.getRow(i).getCell(1).getNumericCellValue());
            String period = String.valueOf((int) sheet.getRow(i).getCell(2).getNumericCellValue());
            String tenure = sheet.getRow(i).getCell(3).getStringCellValue();
            String frequency = sheet.getRow(i).getCell(4).getStringCellValue();
            String result = sheet.getRow(i).getCell(5).getStringCellValue();

            System.out.println("principalAmount: " + principalAmount);
            System.out.println("returnOfInvestment: " + returnOfInvestment);
            System.out.println("period: " + period);
            System.out.println("tenure: " + tenure);
            System.out.println("frequency: " + frequency);
            System.out.println("result: " + result);

            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principalAmount);
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(returnOfInvestment);
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period);

            WebElement element = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
            Select tenureListBox = new Select(element);
            tenureListBox.selectByVisibleText(tenure);
//            tenureListBox.getOptions();
//            tenureListBox.selectByIndex(0);
//            tenureListBox.selectByValue("365");

            WebElement element1 = driver.findElement(By.xpath("//select[@id='frequency']"));
            Select frequencyListBox = new Select(element1);
            frequencyListBox.selectByVisibleText(frequency);

            driver.findElement(By.xpath("//select[@id='frequency']/parent::div/parent::div/following-sibling::div/a[1]")).click();
            String actualText = driver.findElement(By.xpath(" //span[@id='resp_matval']")).getText();
            System.out.println("Actual Result: " + actualText);

//            String expectedText = "240000.00";

            if (actualText.equals(result)) {
                System.out.println("Test passed");
                sheet.getRow(i).getCell(6).setCellValue("Passed");
            } else {
                System.out.println("Test failed");
                sheet.getRow(i).getCell(6).setCellValue("Failed");
            }

            driver.navigate().refresh();

        }

        workbook.write(fos);
        fos.close();

        driver.quit();
    }
}
