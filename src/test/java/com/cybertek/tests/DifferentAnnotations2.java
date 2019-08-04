package com.cybertek.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class DifferentAnnotations2 {

    @Test
    public void testOne(){
        System.out.println("This is test one");
    }

     @BeforeMethod
    public void beforeMethod(){
         System.out.println("This is before method");

     }
     @Test
    public void testTwo(){
         System.out.println("This is test two");

    }

      @BeforeClass
    public void beforeClass(){
          System.out.println("This is before class");
      }







}
