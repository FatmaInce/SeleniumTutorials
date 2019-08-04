package com.cybertek.tests.softAssert_testBase_actions_fileDownload;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExistsTest {
    @Test
    public void test(){
        //get the current folder
        String current= System.getProperty("user.dir");
        System.out.println(current);
        //get the user folder
        String userFolder= System.getProperty("user.home");
        System.out.println(userFolder);

        String path= userFolder + "/Downloads/text.txt";
        //  if above is not working use below(for Windows)
        //String path= userFolder + "\\Downloads\\text.txt";
        System.out.println(path);
        //Files.exists(Paths.get(path)--> returns true if file exists in the parameter provided
        Assert.assertTrue(Files.exists(Paths.get(path)));
    }
}
