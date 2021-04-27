package com.HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OpenText {



    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        //int[] A = new int[]{10, 0, 8, 2, -1, 12, 11, 3};
        int[] A = new int[]{5,5};
        List<Integer> arrayIntegers = Arrays.stream(A).boxed().sorted().collect(Collectors.toList());
        int max = 0;
        for (int i=0;i<arrayIntegers.size()-1;i++){
            max = Math.max(max, arrayIntegers.get(i+1)-arrayIntegers.get(i));
        }
        System.out.println(max/2);
        System.out.println("Duration in milliseconds : "+(System.currentTimeMillis()-startTime));
    }
}
