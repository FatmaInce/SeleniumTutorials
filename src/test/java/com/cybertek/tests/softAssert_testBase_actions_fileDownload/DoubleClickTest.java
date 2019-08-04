package com.cybertek.tests.softAssert_testBase_actions_fileDownload;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClickTest extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        driver.switchTo().frame("iframeResult");
        //Actions require a constructor of type WebDriver
        //without "driver" it's not going to initialize
       //u need to pass your driver object as parameter in Actions class.
        Actions actions= new Actions(driver);
        //identify the webelement on which we double click
        WebElement text= driver.findElement(By.id("demo"));
        //double click on element
        //add "perform" at the end of each action
        actions.doubleClick(text).perform();
        Assert.assertTrue(text.getAttribute("style").contains("red"));
    }
}
