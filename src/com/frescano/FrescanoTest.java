package com.frescano;

import java.io.IOException;
import java.util.HashSet;

public class FrescanoTest {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        /*try {
            foo();
        } catch (IOException e) {
            e = new IOException("");
            e.printStackTrace();
        }catch(Exception e){
            e = new Exception("");
            e.printStackTrace();
        }*/
    }

    public static void foo() throws IOException{
        System.out.println("Print--foo");
    }
    /*HashSet myMap = new HashSet();
    String s1 = new String("India");
    String s2 = new String("India");
    Country s3 = new Country("France");
    Country s4 = new Country("France");
  myMap.add(s1);
  myMap.add(s2);
  myMap.add(s3);
  myMap.add(s4);
  System.out.println(myMap);*/
}
