package com.practice;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryFee {
    public static void main(String[] args) {

        int deliveries[][] ={{8,12,15,20, 23},{15,21,48,17,43}};
        int intervals[] = {0, 10, 22};
        int fees[] = {1, 3, 1};
        DeliveryFee deliveryFee = new DeliveryFee();
        System.out.println("Returned Value"+deliveryFee.deliveryFee(intervals, fees, deliveries));
    }

    boolean deliveryFee(int[] intervals, int[] fees, int[][] deliveries) {
        boolean isLengthNotEqual = Arrays.stream(fees).sum()!=deliveries[0].length;
        if(isLengthNotEqual)
            return false;
        for(int i=0;i<fees.length;i++){
            int start = intervals[i];
            int end = 24;
            if(i!=fees.length-1){
                end = intervals[i+1];
            }
            if(fees[i]!=getElementsInRange(start, end, deliveries)){
                return false;
            }
        }
        return true;
    }

    int getElementsInRange(int start, int end, int[][] deliveries){
        int count = 0;
        for(int i=0;i<deliveries[0].length;i++){
            if(deliveries[0][i]>start && deliveries[0][i]<end && deliveries[1][i]>00 && deliveries[1][i]<59){
                count++;
            }
        }
        return count;
    }

}
