package com.RSA;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        OneFunc<Integer,Integer,Integer,Integer> funcI = (a,b,c)->a+b+c;
        System.out.println(funcI.func(1,2,3));
        OneFunc<String,String,Integer,?> funcO  = (a,b,c)->a+b+c;
        System.out.println(funcO.func("a","b",3));
        List<Integer> test1 = new ArrayList<>();
        System.out.println(test1.hashCode());
        test1.add(1);
        System.out.println(test1.hashCode());
        test1.add(1);
        System.out.println(test1.hashCode());
        String s="test";

    }
}
