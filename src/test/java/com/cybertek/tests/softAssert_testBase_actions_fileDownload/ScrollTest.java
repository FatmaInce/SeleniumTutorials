package com.cybertek.tests.softAssert_testBase_actions_fileDownload;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ScrollTest extends TestBase {
    @Test
    public  void test(){
        driver.get("https://youtube.com");
        //scrolling down
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //scrolling up
        actions.sendKeys(Keys.PAGE_UP).perform();
        //scrolling down just a little bit
        //also there are other methods--> ARROW_DOWN -->ARROW_LEFT ....
        //in Convention UPPERCASE is being used for Finals
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }
}
