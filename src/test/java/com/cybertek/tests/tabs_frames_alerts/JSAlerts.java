package com.cybertek.tests.tabs_frames_alerts;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlerts {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void cleanUp()throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void oppsTest(){
        driver.get("https://sweetalert.js.org/");
        //trigger the pop up
        driver.findElement(By.xpath("(//button[@class='preview'])[1]")).click();
       //switch to alert
        Alert alert= driver.switchTo().alert();
       alert.accept();//clicking on OK a pop up
    }
    @Test(description = "click on the second box on this page")
    public void dismiss(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //trigger the pop up
        //driver.findElement(By.linkText("Click for JS Confirm")).click();
        driver.findElement(By.cssSelector(" button[onclick='jsConfirm()']")).click();
        //switch to alert
        Alert alert= driver.switchTo().alert();
        alert.dismiss();//clicking  Cancel on a pop up
    }
    @Test(description = "click on the third box on this page")
    public void alertText() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector(" button[onclick='jsPrompt()']")).click();
        Alert alert=driver.switchTo().alert();
        //typing on the alert
        alert.sendKeys("Selam,basarilar!!!");
        alert.accept();
    }
}
