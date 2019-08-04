package com.cybertek.tests.softAssert_testBase_actions_fileDownload;

import com.cybertek.utilities.TestBase;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DragAndDrop extends TestBase {
    @Test
    public void test(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droptarget"));
        //pass the variable in the correct order
        //first one is source, second one is target
        actions.dragAndDrop(source,target).perform();
    }
    @Test
    public void test2(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droptarget"));
        //write the steps for doing the drag and drop operation
        //without using the dragAndDrop();
        //when we use multiple actions we need to add build() before we perform
        actions.clickAndHold(source).moveToElement(target).release().perform();
        //actions.clickAndHold(source).moveToElement(target).release().build().perform();
    }
}
