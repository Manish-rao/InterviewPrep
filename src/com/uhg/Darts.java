package com.uhg;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Darts {
    public static void main(String[] args) {
        int sum = 301;
        String A[] = new String[]{"D20", "T20", "T20", "T20", "T10", "1", "T17", "0" , "0", "11", "0", "0"};
        boolean isDouble = false;
        for(String points: A){
            int point;
            System.out.println("Points"+points);
            if(points.charAt(0)=='D' && !isDouble) isDouble = true;
            if(isDouble) {
                if ("SB".equals(points)) {
                    point = 25;
                } else if ("DB".equals(points)) {
                    point = 50;
                } else if (points.charAt(0) == 'D') {
                    point = Integer.parseInt(points.substring(1, points.length())) * 2;
                } else if (points.charAt(0) == 'T') {
                    point = Integer.parseInt(points.substring(1, points.length())) * 3;
                } else {
                    point = Integer.parseInt(points);
                }
                if (points.charAt(0) != 'D' && sum-point<1) {
                    System.out.println("Player is bust");
                    break;
                }else
                {
                    System.out.println("Sum:"+sum);
                    sum -= point;
                }
            }
        }
        /*if(sum<1 && A[A.length-1].charAt(0)!='D'){
            System.out.println("Player is bust");
            sum += IntStream.range(A.length-3,A.length).sum();
        }*/
        System.out.println("Final sum:"+sum);
    }

}
