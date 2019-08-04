package com.cybertek.tests.tabs_frames_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class SwitchOptions {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/iframe");
           }
    @AfterMethod
       public void cleanUp(){
          driver.quit();
           }

    @Test
    public  void switchByElement(){
        WebElement ifame= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(ifame);
        driver.findElement(By.tagName("body")).sendKeys("Hello, Muhsin and Hakan! I love you");
    }
    @Test
    public  void switchById(){
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.tagName("body")).sendKeys("Hello, Muhsin and Hakan! I love you");
    }
    @Test
    public  void switchByIndex(){
        driver.switchTo().frame(0);
        driver.findElement(By.tagName("body")).sendKeys("Hello, Muhsin and Hakan! I love you");
    }
}
