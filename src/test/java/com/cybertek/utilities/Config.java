package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    //below declaration should be static, cos we are using it in the static block.
   private static Properties pro;
    static{
        String path="configuration.properties";
        try {
            FileInputStream file= new FileInputStream(path);
            pro= new Properties();
            pro.load(file);
            file.close();
        } catch (Exception e) {
            System.out.println("Path: "+ path+ " - not found." );
        }
    }
 public static String getProperty(String key){
        return pro.getProperty(key);
 }
//    public static void main(String[] args) {
//      String s= pro.getProperty("name");
//        System.out.println(s);
//    }
}
