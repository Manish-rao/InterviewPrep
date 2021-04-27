package com.Zolando;

import java.util.Arrays;

public class MakeLetterCountUnique {
    public static void main(String[] args) {
        int[] freq = new int[26];
        String S = "ccaaffddecee";
        S.chars().forEach((c) -> {
            freq[c - 97]++;
        });
        int[] newArr = Arrays.stream(freq).sorted().filter(i->i!=0).toArray();
        int sum = Arrays.stream(newArr).sum();
        for(int i=0; i<newArr.length; i++){
            isValueRepeated(newArr, newArr[i], i);
        }
        Arrays.stream(newArr).forEach(System.out::println);
        System.out.println(sum-Arrays.stream(newArr).sum());
    }

    public static  void isValueRepeated(int[] newArr, int value, int index){
        int temp = value;
        if(Arrays.stream(newArr).filter(i->i==temp).count()>1 && value>0){
            newArr[index] = value-1;
            isValueRepeated(newArr, newArr[index], index);
        }
    }

}
