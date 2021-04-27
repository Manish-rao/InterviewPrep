package com.RSA;

public class RSATest4 {
    public static void main(String[] args) {
        Book b = new Book("Test","Test1");
        Book c = new Book( "Test","Test1");
        System.out.println(b.equals(c));
    }
}
