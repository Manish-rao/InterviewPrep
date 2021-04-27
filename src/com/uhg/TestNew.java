package com.uhg;

import java.util.Arrays;

public class TestNew {
    public static void main(String[] args) {
        int n=10;
        printNos(n,0);
    }
    static void printNos(int n, int sum){
       /* if(n>sum){
            sum++;
            System.out.println(sum);
            printNos(n,sum);
        }*/
       String a ="123456";
       String[] b = a.split("");
       Arrays.stream(b).forEach(System.out::println);
    }
}
