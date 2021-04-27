package com.HackerRank;

import java.util.stream.IntStream;

public class CompareAlternateIntegers {
    public static void main(String[] args) {
        Integer[] intArr = new Integer[]{8,20,25,30};
        System.out.println(IntStream.range(1, intArr.length).map(i->intArr[i]*intArr[i-1]).max().getAsInt());
        System.out.println(IntStream.range(1, intArr.length).sorted().map(i ->intArr[i]-intArr[i-1]).sum());
        String testString = "ABAABAA";
        char[] testCharArray = testString.toCharArray();
        System.out.println(IntStream.range(1,testCharArray.length).filter(i->testCharArray[i]==testCharArray[i-1]).count());
    }
}
