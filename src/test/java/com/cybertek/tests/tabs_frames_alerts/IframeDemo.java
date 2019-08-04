package com.cybertek.tests.tabs_frames_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeDemo {
    //https://the-internet.herokuapp.com/iframe
    @Test
    public void test()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/iframe");
        //Thread.sleep(5000);
        //locate the iframe
        WebElement iframe= driver.findElement(By.id("mce_0_ifr"));
        Thread.sleep(5000);
        //switch to iframe
        driver.switchTo().frame(iframe);
        driver.findElement(By.tagName("body")).sendKeys("Hello, guys!");

        //click on Elemental Selenium at the bottom
        //Selenium cannot see this link, cos we have switched to iframe.
        //we need to turn back.

        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        driver.close();
    }
}
