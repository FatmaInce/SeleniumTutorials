package com.cybertek.tests.elementExist_ExceptionReview;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTextDisappearTest extends TestBase {
    @Test
    public void verify1(){
        driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");
        WebElement text= driver.findElement(By.id("myDIV"));
        System.out.println(text.getText());
        Assert.assertTrue(text.isDisplayed());
        WebElement button=driver.findElement(By.xpath("//button[.='Toggle Hide and Show']" ));
                //css-->  "button[class='w3-btn w3-hover-black w3-dark-grey']-->also works
        button.click();
        //assertFalse()--->expects your condition to be true
        Assert.assertFalse(text.isDisplayed());
        //below code also works, but it is better to write assertFalse() in that kind of cases
        //Assert.assertTrue(!text.isDisplayed());

    }
}
