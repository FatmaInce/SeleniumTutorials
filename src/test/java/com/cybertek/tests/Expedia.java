package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Expedia {
    WebDriver driver;

    @BeforeClass
    public void setuo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.expedia.com/");
    }
    @Test
    public void hotelBooking() throws  Exception{
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.xpath("//label[@for='package-origin-hp-package']")).sendKeys("Toronto");
        driver.findElement(By.xpath("//label[@for='package-origin-hp-package']")).sendKeys(Keys.DOWN);
        driver.findElement(By.xpath("//label[@for='package-origin-hp-package']")).sendKeys(Keys.DOWN);
        driver.findElement(By.xpath("//label[@for='package-origin-hp-package']")).click();

        driver.findElement(By.xpath("//label[@for='package-origin-hp-package']")).click();

        System.out.println(driver.findElement(By.xpath("//label[@for='package-origin-hp-package']")).getText());
    }
    @AfterClass
    public void tearDown(){

        driver.close();

    }
}
