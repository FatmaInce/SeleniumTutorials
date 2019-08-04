package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MixedAnnotations4 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.out.println("Setting up the drivers here");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Opening a browser");
        driver = new ChromeDriver();
        System.out.println("Go to website and login");
        driver.get("https://google.com");
    }

    @Test
    public void testOne() {
        System.out.println("Testing:account info");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Logout");
        System.out.println("Closing Browser");
        driver.quit();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Report everything");
    }

    @Test
    public void testTwo() {
        System.out.println("Testing:payment");
    }
}