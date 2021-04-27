package com.HackerRank;

public class StringInternTest {
    public static void main(String[] args) {
        String s1 = "Test";
        String s2 = "Hello";
        String s3 =  new String("Hello");
        String s4 = s3.intern();

        System.out.println(s2==s4);

        System.out.println(s2.equals(s3));
        System.out.println(s2.equals(s4));


    }
}
