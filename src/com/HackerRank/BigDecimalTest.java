package com.HackerRank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BigDecimalTest {
    public static void main(String[] args) {
        List<BigDecimal>  myList = new ArrayList<>();
        myList.add(new BigDecimal(10));
        myList.add(new BigDecimal(20));
        BigDecimal myDec = new BigDecimal(10);
        BigDecimal sum = BigDecimal.ZERO;
        for(BigDecimal bd:myList){
            sum = sum.add(bd.multiply(myDec));
        }
        System.out.println(sum);
    }
}
