package com.Stream;

import java.util.*;
import java.util.stream.Stream;

public class Test {

    static Map<String, String> testMap = new HashMap<String, String>() {
        {put("a","b");}
        {put("c","d");}
    };

    public static void main(String[] args) {

        if(testMap.containsKey("a")){
            System.out.println(testMap.get("a"));
        }

        int ar[] = new int[]{1,2,3,4,5};
        Arrays.stream(ar).sum();

        PaymentChannel paymentChannel = new PaymentChannel("bank",null);
        PaymentChannel card = new PaymentChannel("card",null);
        System.out.println("b".toCharArray()[0]-10);
        List<BankAcc> bankAccList = new ArrayList<>();
        bankAccList.add(new BankAcc(paymentChannel));
        bankAccList.add(new BankAcc(card));

        System.out.println(bankAccList.stream().anyMatch(a -> a.getPaymentChannel().getExceptionCode()!=null)
        );

        HashMap<Integer,String> test = new HashMap();
        test.put(1,"test");

        test.forEach((key, value) -> System.out.println(key + ":" + value));
        test.entrySet().removeIf(e -> e.getValue().equalsIgnoreCase("test"));
        test.forEach((key, value) -> System.out.println(key + ":" + value));
        int i =10;
        System.out.print(i);
    }

}
