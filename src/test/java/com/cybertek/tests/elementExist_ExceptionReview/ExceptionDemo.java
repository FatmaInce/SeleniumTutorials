package com.cybertek.tests.elementExist_ExceptionReview;

public class ExceptionDemo {
    public static void main(String[] args) {
        //I teach on Tuesdays--->normal flow
        //if i get sick      --->problem, issue
        // someone will replace me!!!----> alternative flow
        try{
            System.out.println("maruf is teaching on Tuesday");
        }catch(Exception e){
            System.out.println("Akbar will take over");
        }
    }
}
