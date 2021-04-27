package com.HackerRank;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        // write your code in Java SE 8
        int[] A = new int[]{4, 3, 3, 4, 1, 2, 2, 3, 6, 5, 4, 5};
        List<int[]> solList = new ArrayList<>();
        Map<Integer,Integer> finalMap = new HashMap<>();
        List<int[]> outList = new ArrayList<>();
        for(int i=0;i<A.length-1;i=i+2){
            int[] sol = new int[]{A[i],A[i+1]};
            if(sol[0]>sol[1]){
                sol[0] = A[i+1];
                sol[1] = A[i];
            }
            solList.add(sol);
        }
        for(int i:A){
            if(finalMap.containsKey(i)){
                finalMap.put(i, finalMap.get(i)+1);
            }else{
                finalMap.put(i, 1);
            }
        }
        if(finalMap.size()!=6){
            //return "NO";
        }

        for(int[] i:solList){
            finalMap.put(i[0], finalMap.get(i[0])-1);
            finalMap.put(i[1], finalMap.get(i[1])-1);
        }

        for ( Integer value: finalMap.values()) {
            if ( value != 0) {
               // return "NO";
            }
        }
       // return "YES";
    }





}