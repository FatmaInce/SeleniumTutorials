package com.cybertek.tests.pageObjectModel;

import com.cybertek.pages.HomePage;
import com.cybertek.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessageValidationTest extends TestBase {
    HomePage homePage=new HomePage();
    @Test
    public void wrongEmailTest(){

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        homePage.username.sendKeys("admin");
        homePage.password.sendKeys("test");
        homePage.loginButton.click();

        String actualError=homePage.errorMessage.getText();
        String expectedError="Invalid Login or Password";
        Assert.assertEquals(actualError,expectedError);
    }
    @Test
    public void wrongPasswordTest(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        homePage.username.sendKeys("Tester");
        homePage.password.sendKeys("wrong password");
        homePage.loginButton.click();

        String actualError=homePage.errorMessage.getText();
        String expectedError="Invalid Login or Password";
        Assert.assertEquals(actualError,expectedError);
    }
    @Test
    public void blankUsername(){
        homePage.openUrl();
        homePage.login("","test");

        String actualError=homePage.errorMessage.getText();
        String expectedError="Invalid Login or Password";
        Assert.assertEquals(actualError,expectedError);


    }
}
