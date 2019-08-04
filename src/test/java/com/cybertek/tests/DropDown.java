package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement selectElement= driver.findElement(By.id("dropdown"));

        Select list= new Select(selectElement);

        //print the selected option
        String selectedOption=list.getFirstSelectedOption().getText();
        System.out.println(selectedOption);

        //print all available options
        List<WebElement> options = list.getOptions();
        System.out.println("options.size()= "+ options.size());

        for(WebElement option:options){
            //System.out.println(option);//will give hashcode, selenium gives u the elements
                                         // use .getText()--> to get the text
            System.out.println(option.getText());
        }
         // select different options
        //sometimes one will work and the other time other one will work

        //1.  selectByVisibleText
        list.selectByVisibleText("Option 1");//---> check from the HTML
        // if there are any spaces after the text
        System.out.println("Selected option: " +list.getFirstSelectedOption().getText());

        //2.selectByIndex
        list.selectByIndex(2);
        System.out.println("Selected option: " +list.getFirstSelectedOption().getText());

        //3.selectByValue
        list.selectByValue("1");
        System.out.println("Selected option: " +list.getFirstSelectedOption().getText());

  driver.close();

    }
}
