package com.HackerRank;

import java.util.Arrays;

public class BigSum {
    public static void main(String[] args) {
        long[] ar1 = {100000L,1000002L,1000003L,1000005L, 1000007L};
        System.out.println(Arrays.stream(ar1).sum());
    }

}
