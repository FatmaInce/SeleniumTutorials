package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AmazonSearch {

    /*open browser
    go to amazon
    enter search term and submit
    verify search box still contains the same search term
    */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

        String searchTerm= "charger";
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys(searchTerm + Keys.ENTER);


       // driver.findElement(By.id("twotabsearchtextbox")).clear();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
// ##1
        //getText() is not working here, since it is not hard coded, u just typed it.
        // find a different way

        //String actual= driver.findElement(By.id("twotabsearchtextbox")).getText();
 //##2
       //did not work either.
        String actual= driver.findElement(By.id("twotabsearchtextbox"))
                .getAttribute("innerHTML");

        if(searchTerm.equals(actual)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actual: " + actual);
            System.out.println("Search term: " + searchTerm);
        }

       driver.close();
    }

}
