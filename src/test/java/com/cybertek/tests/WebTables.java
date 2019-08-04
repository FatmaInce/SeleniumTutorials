package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {
    WebDriver driver;
    @BeforeMethod
        public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public  void printWholeTable(){
        login();
        WebElement table=driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());
    }
    @Test
    public void  printAllHeaders(){
        login();
        List<WebElement>headers= driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
        for(WebElement header: headers){
            System.out.println(header.getText());
        }
    }
    //prints the number of rows
    //prints all rows== the whole table
    //prints the certain row based on index
    @Test
    public void printRow(){
        login();
        List<WebElement>allRows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        System.out.println("Number of rows: " + allRows.size());
        for(WebElement row:allRows){
            System.out.println(row.getText());
        }
        //print the nth row
        System.out.println("Printing row " + 3);
        System.out.println(allRows.get(2).getText());
    }
    //prints the size: columns and rows in a table
    @Test
    public void printTableSize(){
        login();
        List<WebElement>allRows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        System.out.println("Number of rows: " + allRows.size());
        List<WebElement>allHeaders= driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[1]/th"));
        System.out.println("Number of headers/columns: " + allHeaders.size());
    }
    @Test
    public void printRowAgain(){
        login();
        WebElement row=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[1]"));
        System.out.println(row.getText());
    }
    //print all the cells of a row whose index is given in the xpath
    @Test
    public void printAllCellsInOneRow(){
        login();
        List<WebElement >cells=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td"));
        for(WebElement cell:cells){
            System.out.println(cell.getText());
        }
        //print by coordinates: based on row and column number
    }
    @Test
    public  void printByCoordinates(){
        login();
//        WebElement cell= driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[3]/td[3]"));
//        System.out.println(cell.getText());
        //------OR------
        System.out.println(getCell(3,3).getText());
    }
    //print all the values in single column
    @Test
    public void printColumn(){
        login();
        List<WebElement>allValues=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        for(WebElement values: allValues){
            System.out.println(values.getText());
        }
    }
    //find the select checkbox for a given name
    @Test
    public void selectCheckbox(){
        login();
        WebElement checkbox=driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]/input"));
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());
    }
    //verify that name "someone" exists in the names column
    //verify that city "anytown" exists in the cities column
    @Test
    public void test() {
        login();
        //int nameIndex = getColumnIndex("Name");
       // System.out.println(nameIndex);
        List<WebElement> allNames = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[" + getColumnIndex("Name") + "]"));
        boolean found = false;
        for (int i = 0; i < allNames.size(); i++) {
            if (allNames.get(i).getText().equals("Mark Smith")) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
        found = false;
        int cityIndex = getColumnIndex("City");
        List<WebElement> allCities = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[" + cityIndex + "]"));
        for (int i = 0; i < allCities.size(); i++) {
            if (allCities.get(i).getText().equals("Whitestone, British")) {
                found = true;
                break;
            }
        }
    }
    @Test
    public void test1(){
        login();
         boolean found= false;
        int productIndex=getColumnIndex("Product");
        List<WebElement>allPro=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[\"+productIndex+\"]"));
        for (int i = 0; i <allPro.size() ; i++) {
            if (allPro.get(i).getText().equals("MyMoney")) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
        }

    //gets a column name as a parameter
    //returns the index of the column name
    public  int  getColumnIndex(String column){
        List<WebElement>allHeader=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
        for(int i=0;i<allHeader.size();i++){
            if(allHeader.get(i).getText().equals(column)){
                return i+1;
            }
        }
        return 0;
    }

    public WebElement getCell(int row,int column){
        String xpathCellLocator="//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+row+"]/td["+column+"]";
        return driver.findElement(By.xpath(xpathCellLocator));
    }
    public void login(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }
}
