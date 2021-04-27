package com.Volt;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class VoltCodingChallenge {
    public static void main(String[] args) {
        String[] strArr = new String[] {"X:-1", "Y:1", "X:-4", "B:3", "X:5"};
        Map<Character,Integer> myMap = new HashMap();
        for(String str:strArr){
            String[] s1 = str.split(":");
            if(!("0".equals(s1[1]))){
                char keyChar = s1[0].charAt(0);
                System.out.println(s1[1]);
                if(myMap.containsKey(keyChar)){
                    myMap.put(keyChar,myMap.get(keyChar)+Integer.parseInt(s1[1]));
                }else{
                    myMap.put(keyChar,Integer.parseInt(s1[1]));
                }
            }
        };
        String mapAsString = myMap.keySet().stream()
                .map(key -> key + "=" + myMap.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
        System.out.println(mapAsString);
    }
}
