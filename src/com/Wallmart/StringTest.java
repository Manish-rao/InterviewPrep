package com.Wallmart;

import java.util.HashSet;

public class StringTest {
    public static void main(String[] args) {
        String s = new String("a");
        String s2 = "a";
        HashSet hashSet = new HashSet();
        hashSet.add(s);
        hashSet.add(s2);
        System.out.println(hashSet.size());
        System.out.println(s==s2);
    }
}
