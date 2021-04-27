package com.RSA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class RSAtest3 {
    //123451
    //123689
    public static void main(String[] args) {
        /*Async myWork = new Async();
        Thread myThread = new Thread(myWork);
        myThread.start();
        CompletableFuture ct = CompletableFuture.runAsync(myWork);
        ct.join();*/
        List<String> myList = Arrays.asList("Jupiter", "Neptune","Mars","Earth");
        Map<Integer,List<String>> myMap = myList.stream().collect(Collectors.groupingBy(p->p.length()));

        myMap.forEach((l,s)-> System.out.println("l:"+l+" s"+s));
    }


}
