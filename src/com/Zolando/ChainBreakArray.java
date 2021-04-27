package com.Zolando;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChainBreakArray {
    public static void main(String[] args) {
        int[] A = new int[]{5,2,4,6,3,7};
        List<Integer> arrList = new ArrayList<>();
        for(int i=0;i<A.length; i++){
            for (int j=0;j<A.length; j++){
                if(i>0 && i<j && j-i>1 && j<A.length-1){
                    arrList.add(A[i]+A[j]);
                }
            }
        }
        Optional<Integer> retVal = arrList.stream().min(Integer::compareTo);
        if(retVal.isPresent())
            System.out.println(retVal.get());
        System.out.println(0);
    }
}
