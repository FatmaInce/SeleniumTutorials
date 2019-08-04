package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected SoftAssert softAssert;
//Since we used "WebDriverManager.chromedriver().setup();"   in Driver class after creating it,
// we dont need below code no longer

//    @BeforeClass
//    public void setUpClass(){
//        WebDriverManager.chromedriver().setup();
//    }
    @BeforeMethod
    public void setUpMethod(){
        //wrote the below line after creating Driver class
        //before, i was using line 28, instead of 27.
        driver=Driver.getDriver();
        //driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions= new Actions(driver);
        softAssert= new SoftAssert();
    }
    @AfterMethod
    public void tearDownMethod(){
        //After adding Driver class, instead of line 38, we need to use line 39
        //driver.quit();
        Driver.closeDriver();
        softAssert.assertAll();

    }
}
