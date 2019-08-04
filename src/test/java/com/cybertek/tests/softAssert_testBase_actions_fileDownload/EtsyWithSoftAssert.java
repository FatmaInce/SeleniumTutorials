package com.cybertek.tests.softAssert_testBase_actions_fileDownload;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EtsyWithSoftAssert extends TestBase {
    @Test
    public void test(){
        SoftAssert softAssert=new SoftAssert();
        driver.get("https://etsy.com");
        driver.findElement(By.name("search_query")).sendKeys("gift", Keys.ENTER);
        softAssert.assertTrue(driver.getTitle().contains("gift"),"title did not match");
        Assert.assertTrue(driver.getTitle().contains("AAA"));
        //By using Assert class before softAssert, we have broken our code.
        //Despite softAssert executes till the end if any softAssert test fails, but it cannot continue
        //if there is an Assert class before it

        //so below code moved to TestBase class to guarantee the execution of assertAll() method.
        //softAssert.assertAll();
    }
    @Test
    public void test2() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("start");
        softAssert.assertTrue(false);
        softAssert.assertEquals("google", "etsy");
        System.out.println("done");
        softAssert.assertAll();
        System.out.println("really");

    }
}
