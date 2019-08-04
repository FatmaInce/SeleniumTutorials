package com.cybertek.tests;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*  check from screenshots in the documents
1.Open browser
2.go to https://amazon.com
3.verify that default dropdown option is "All"
4.verify that all options are sorted alphabetically
5.Click on the menu icon on the left
6.click on "Full Store Directory"
7.capture all of the main department names in the page
8. Verify that dep. names are sorted alphabetically
9.verify that all departments names are listed in the dropdown from step 4
 */
 public class AmazonDepartmentsTest {
  WebDriver driver;
  Select allDepartments;

  @BeforeClass
 public void setUp(){
   WebDriverManager.chromedriver().setup();
   driver=new ChromeDriver();
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   driver.get("https://amazon.com");

  }

  @Test(description = "3.verify that default dropdown option is \"All\"")
 public void testDefaultValue(){
   WebElement selectElement= driver.findElement(By.id("searchDropdownBox"));
   allDepartments= new Select(selectElement);
   String selectOption= allDepartments.getFirstSelectedOption().getText();
  // Assert.assertEquals(selectOption,"All");
  }
  //@Test(description ="4.verify that all options are sorted alphabetically" )
  public void sortAlphabetical() throws InterruptedException {
      Thread.sleep(3000);
      for(int i=0; i<allDepartments.getOptions().size()-1;i++){
          String current= allDepartments.getOptions().get(i).getText();
          String next= allDepartments.getOptions().get(i+1).getText();
          Assert.assertTrue(current.compareTo(next)<=0);
      }
  }
//  5.Click on the menu icon on the left
//  6.click on "Full Store Directory"
//  7.capture all of the main department names in the page
//  8. Verify that dep. names are sorted alphabetically
  @Test
  public void mainDepartmentsTest() throws InterruptedException {
      driver.findElement(By.cssSelector(".hm-icon.nav-sprite")).click();
      driver.findElement(By.xpath("//div[contains(text(),'Full Store')]")).click();
      //7.capture all of the main department names in the page
      List<WebElement> mainDepts=driver.findElements(By.cssSelector("h2.fsdDeptTitle"));
      Thread.sleep(3000);
      for (WebElement option:mainDepts ) {
          System.out.println(option.getText());


      }


  }
 @AfterClass
 public void tearDown(){
   driver.quit();
 }
}



