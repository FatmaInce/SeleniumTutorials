package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Checkboxes {
    /*go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
    verify monday is not selected
    select monday
    verify monday is selected
    unselect monday
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver() ;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

       WebElement monday= driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-input"));

//        System.out.println(monday.isSelected());//false, because it is not selected
//        monday.click();// you select monday
//        System.out.println(monday.isSelected());//true, since u selected monday
//        monday.click();// unselect monday
//        System.out.println(monday.isSelected());//false, because u unselected monday
        // monday.click();
        System.out.println(monday.isSelected());//false
        if(!monday.isSelected()){
            monday.click();
        }
            System.out.println(monday.isSelected());//true
        }
    }


