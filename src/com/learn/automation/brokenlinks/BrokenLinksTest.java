package com.learn.automation.brokenlinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinksTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/newtours/");

        List<WebElement> linksList = driver.findElements(By.tagName("a"));

        for( WebElement l : linksList) {
            String link = l.getAttribute("href");

            try {
                URL url = new URL(link);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();

                if(urlConnection.getResponseCode() > 400) {
                    System.out.println(link + " is a broken link");
                } else {
                    System.out.println(link + " is a valid link");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
