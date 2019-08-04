package com.cybertek.tests.tabs_frames_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Tabs {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/windows");
    }
    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }
    /**
     * TestCase
     * go to the https://the-internet.herokuapp.com/windows
     * click on "Click here"
     * verify that new title is "New Window"
     * verify that new title is not "The Internet"
     */
    @Test
    public void changeTab() {
        System.out.println(driver.getWindowHandles().size());//1
        System.out.println(driver.getWindowHandle());//CDwindow-89DF5DC1F0E801A5D0A4CE58C3978438
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println(driver.getWindowHandles().size());//2
                //change to the new tab
        Set<String >windowHandles=driver.getWindowHandles();
        System.out.println("*******************");
        for(String handle: windowHandles){
            System.out.println(handle);
            //switch tabs
            driver.switchTo().window(handle);
            System.out.println(driver.getTitle());
            if(driver.getTitle().equals("New Window"));
            break;
        }
        //verify that new title is "New Window"
        Assert.assertEquals(driver.getTitle(),"New Window");
        //verify that new title is not "The Internet"
        Assert.assertNotEquals(driver.getTitle(),"The Internet");
    }
     /*
        go to https://www.w3schools.com/html/
        click on "Try it Yourself"
        verify the url of the new tab contains "default"
         */
    @Test
    public void changeTab2(){
       driver.get("https://www.w3schools.com/html/");
       driver.findElement(By.linkText("Try it Yourself »")).click();
       //title of the second tab is "Tryit Editor v3.6"
        //get all handles
        //switch 1 by one
        // if the title is right, break the loop
        for( String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
            System.out.println(driver.getTitle());
            if(driver.getTitle().equals("Tryit Editor v3.6")){
                break;
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("default"));
        System.out.println(driver.getWindowHandles().size());
        driver.close();
        System.out.println(driver.getWindowHandles().size());
    }

}
