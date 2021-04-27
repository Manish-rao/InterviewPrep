package com.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComparingTriplets {
    public static void main(String[] args) {
        List<Integer> alice = new ArrayList<>(3);
        List<Integer> bob = new ArrayList<>(3);
        alice.add(10);
        alice.add(20);
        alice.add(30);
        bob.add(30);
        bob.add(20);
        bob.add(10);
        int[] result = new int[2];
        System.out.println("test");
        
        for (int i=0;i<=2;i++){
            System.out.println(i);
            System.out.println(alice.get(i)+"arr:"+bob.get(i));
            result[0] += alice.get(i)>bob.get(i)?1:0;
            result[1] += bob.get(i)>alice.get(i)?1:0;
        }
        System.out.println(result[0]+":"+result[1]);
        Arrays.asList(result).forEach(i -> System.out.println(i));
    }
}
