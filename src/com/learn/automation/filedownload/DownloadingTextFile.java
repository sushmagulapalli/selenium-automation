package com.learn.automation.filedownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadingTextFile {
    public static void main(String[] args) {

//        WebDriver driver = new ChromeDriver();

        //Create a firefox profile to disable the download pop-up
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
        profile.setPreference("browser.download.manager.showWhenStarting", false);

        //Create a firefox options with the above profile
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        //Load the firefox browser with the set options
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[contains(text(),'testfile.txt')]")).click();

//        driver.quit();
    }
}
