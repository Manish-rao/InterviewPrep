package com.RSA;

import java.lang.reflect.Array;
import java.util.*;

public class RSATest1 {
    //Thread 1 will produce values
    //Thread 2 will consume and print
    public static void main(String[] args) {
       /* List<Map<List<Integer>,List<String>>> parmaList = new ArrayList<>();
        Map<List<Integer>,List<String>> map = new HashMap<>();
        parmaList.add(null);
        parmaList.add(map);
        parmaList.add(new HashMap<List<Integer>,List<String>>());
        parmaList.forEach(e-> System.out.println(e+" "));*/

       String[] array = {"dog","cat","mouse","cat"};
       getSet(array).forEach(arr -> System.out.println(arr));
        System.out.println();

    }
    public static Set<String> getSet(String[] params){
        Collections.swap(Arrays.asList(params),0,1);
        Array.set(params,1,"comes after the");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        Collections.addAll(linkedHashSet, params);
        return linkedHashSet;
    }
}
