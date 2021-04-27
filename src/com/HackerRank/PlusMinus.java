package com.HackerRank;

public class PlusMinus {
    public static void main(String[] args) {
        int[] arr = {10,-11,2,-55,0};
        int pos = 0;
        int neg = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                pos++;
            }else if(arr[i]<0){
                neg++;
            }
        }
        System.out.printf("%.5f\n", (float)pos/arr.length);
        System.out.printf("%.5f\n", (float)neg/arr.length);
        System.out.printf("%.5f\n", (float)(Math.abs(pos-neg))/arr.length);
    }
}
