package com.cybertek.tests.tabs_frames_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFrames {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
       // WebDriverManager.chromedriver().setup();
        driver= new HtmlUnitDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }
    @AfterMethod
    public  void cleanUp(){driver.quit(); }

    @Test
    public void MiddleFrameTest(){
        WebElement iframe= driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(iframe);
    }
    @Test
    public void BottomFrameTest(){
        //go from right frame to bottom frame
        //from the html first find the frame tagname that u want to go
        //by using switchTo() method
        driver.switchTo().frame("frame-top");
        //to go to right frame first u need to go topFrame, cos they r nested
        driver.switchTo().frame("frame-right");
        //since bottom & top frames r siblings, first u need to go to default then go
        //bottom frame
        driver.switchTo() .defaultContent();
        driver.switchTo().frame("frame-bottom");
    }
}
