package com.com.uber;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Uber {

    //aaabbbc
    public static void main(String[] args) {
        String test = "aaabdbbc";
        System.out.println(getFirstNonRepeatingCharacter(test));
    }

    public static char getFirstNonRepeatingCharacter(String test){
        char testChars[] = test.toCharArray();
        Map<Character,Integer> testMap = new LinkedHashMap<>();
        for(char c:testChars){
            if(testMap.containsKey(c)){
                testMap.put(c,testMap.get(c)+1);
            }else{
                testMap.put(c, 1);
            }
        }
        for(Map.Entry enty:testMap.entrySet()){
            if(((Integer) enty.getValue())==1)
                return (char)enty.getKey();
        }
        return ' ';
    }
}
