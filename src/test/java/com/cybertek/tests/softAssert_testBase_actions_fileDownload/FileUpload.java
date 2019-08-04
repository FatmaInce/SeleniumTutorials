package com.cybertek.tests.softAssert_testBase_actions_fileDownload;

        import com.cybertek.utilities.TestBase;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.testng.Assert;
        import org.testng.annotations.Test;

public class FileUpload extends TestBase {
    /*
    go to https://the-internet.herokuapp.com/upload
    click choose file,     click upload,     verify text uploaded
     */
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/upload");
        //create a webElement
        WebElement chooseFile= driver.findElement(By.id("file-upload"));
        //find the path of the file u want to upload
        String path= "C:\\Users\\Fatma Ince\\Downloads\\text.txt";
        //send keys(path) to the element
        chooseFile.sendKeys(path);
        //click on "upload" to upload the file
        driver.findElement(By.id("file-submit")).click();
        //verify if the file is uploaded
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());
    }
}
