package com.Zolando;

import java.util.ArrayList;

public class BiggestSubstring {
    public static void main(String[] args) {
        String s = "50552";
        char a=6;
        if(a%3==0){
            System.out.println("true"+a);
        }
        ArrayList<Integer> listVals = new ArrayList<>();
        if(s.length()<=2){
            //return Integer.parseInt(s);
        }
        else{
            for(int i=0;i<s.length()-1;i++){
                String temp = s.charAt(i)+""+s.charAt(i+1);
                listVals.add(Integer.parseInt(temp));
            }
        }
        System.out.println(listVals.stream().max(Integer::compareTo).get());
    }

}
