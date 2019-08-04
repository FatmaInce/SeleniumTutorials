package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CraigsListTest {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://washingtondc.craigslist.org/");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //find searchbox   //type corolla
     //   driver.findElement(By.id("query")).sendKeys("corolla");
     //   driver.findElement(By.linkText("electronics")).click();
          driver.findElement(By.partialLinkText("+garden")).click();//part of the link
                                         // can be from the beginning or end, middle






    }
}
