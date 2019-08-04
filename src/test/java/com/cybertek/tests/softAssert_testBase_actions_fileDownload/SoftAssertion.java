package com.cybertek.tests.softAssert_testBase_actions_fileDownload;

import com.cybertek.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion  {
    @Test
    public void test1(){
        System.out.println("start");//start
        Assert.assertTrue(true);
        System.out.println("done");//done
    }
    @Test
    public void test2(){
        SoftAssert softAssert=new SoftAssert();
        System.out.println("start");
        softAssert.assertTrue(false);
        System.out.println("done");
        softAssert.assertEquals(3,1);
        softAssert.assertAll();
    }
    @Test
    public void mixedAssertions(){
        SoftAssert softAssert=new SoftAssert();
        System.out.println("start");
        softAssert.assertTrue(false);
        Assert.assertTrue(false);
        System.out.println("done");
        softAssert.assertAll();
    }
}
