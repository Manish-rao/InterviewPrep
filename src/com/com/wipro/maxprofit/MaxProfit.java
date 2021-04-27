package com.com.wipro.maxprofit;

public class MaxProfit {
    public static void main(String[] args) {
        int  prices[] = new int[]{7,1,5,3,6,4};
        int bestPrice = getMaxDiff(prices);
        System.out.println(bestPrice);
    }

    private static int getMaxDiff(int[] prices){
        if(prices.length<2)
            return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=1; i<prices.length;i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]-min);
        }
        return max;
    }
}
