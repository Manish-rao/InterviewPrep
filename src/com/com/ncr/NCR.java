package com.com.ncr;

import java.util.ArrayList;
import java.util.List;

public class NCR {
    public static void main(String[] args) {
        Integer a = 1200;
        int b = 1200;
        System.out.println(a!=b);
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(50);
        list.add(30);
        list.add(40);
        list.add(45);
        int secondMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i:list){
            if(max>i)
                secondMax = Math.max(i,secondMax);
            max = Math.max(i,max);
        }
        System.out.println(secondMax);
    }
}
