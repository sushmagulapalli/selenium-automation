package com.learn.automation.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorsXpathAxes {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();

        driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
        driver.manage().window().maximize();

        //Self  - Selects the current node
        String text=driver.findElement(By.xpath("//a[contains(text(),'India Tourism De')]/self::a")).getText();
        System.out.println(text); //India Tourism De


        //Parent - Selects the parent of the current node (always One)
        text=driver.findElement(By.xpath("//a[contains(text(),'India Tourism De')]/parent::td")).getText();
        System.out.println(text);  //India Tourism De

        //Child - Selects all children of the current node (One or many)
        List childs=driver.findElements(By.xpath("//a[contains(text(),'India Tourism De')]/ancestor::tr/child::td"));
        System.out.println("Number of child elements:"+childs.size());//5

        //Ancestor - Selects all ancestors (parent, grandparent, etc.)
        text=driver.findElement(By.xpath("//a[contains(text(),'India Tourism De')]/ancestor::tr")).getText();
        System.out.println(text);

        //Descendant - Selects all descendants (children, grandchildren, etc.) of the current node
        List descendants=driver.findElements(By.xpath("//a[contains(text(),'India Tourism De')]/ancestor::tr/descendant::*"));
        System.out.println("Number of descendant nodes:"+descendants.size());

        //Following -Selects everything in the document after the closing tag of the current node
        List followingnodes=driver.findElements(By.xpath("//a[contains(text(),'India Tourism De')]/ancestor::tr/following::tr"));
        System.out.println("Number of following nodes:"+followingnodes.size());

        //Following-sibling : Selects all siblings after the current node
        List followingsiblings=driver.findElements(By.xpath("//a[contains(text(),'India Tourism De')]/ancestor::tr/following-sibling::tr"));
        System.out.println("Number of Following Siblings:"+followingsiblings.size());

        //Preceding - Selects all nodes that appear before the current node in the document
        List precedings=driver.findElements(By.xpath("//a[contains(text(),'India Tourism De')]/ancestor::tr/preceding::tr"));
        System.out.println("Number of preceding nodes:"+precedings.size());

        //preceding-sibling - Selects all siblings before the current node
        List precedingsiblings=driver.findElements(By.xpath("//a[contains(text(),'India Tourism De')]/ancestor::tr/preceding-sibling::tr"));
        System.out.println("Number of preceding sibling nodes:"+precedingsiblings.size());

        driver.close();
    }
}
