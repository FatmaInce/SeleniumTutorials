package com.cybertek.tests.softAssert_testBase_actions_fileDownload;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends TestBase {
    /*
    go to Amazon,     hover over sign in,
    click on "Your Hearts",           verify title includes"Interseting"
     */
    @Test
    public void test(){
        driver.get("https://www.amazon.com/");
        WebElement signIn= driver.findElement(By.xpath("//span[@class='nav-line-1' and contains (text(),'Hello')]"));
        //moving the mouse(hover over) on top of the given element
        actions.moveToElement(signIn).perform();
        driver.findElement(By.xpath("//span[.='Your Hearts']")).click();
        Assert.assertTrue(driver.getTitle().contains("Interesting"));
    }
    /*
    go to Amazon,          scrool down,    find the "Help" at the bottom
     */
    @Test
    public void test2(){
        driver.get("https://www.amazon.com/");
        //cre ate a webElement to pass into actions' needed method
      WebElement help= driver.findElement(By.xpath("(//a[.='Help'])[2]"));
      //scrolling down to find the element
      actions.moveToElement(help).perform();
    }
}
