package com.PerformanceCheck;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestThreads {
    public static void main(String[] args) {
        AddRandomData addRandomData=new AddRandomData();
        long testTime=Calendar.getInstance().getTimeInMillis();
        for (RandomClass randomClass:addRandomData.getLotsOfData()) {
            System.out.println(ifElseChecks(randomClass));
        }
        String a = "test";
        if(a.contains("t")){
            System.out.println("Has a");
        }else if(a.contains("e")){
            System.out.println("Has e");
        }if(a.contains("s")){
            System.out.println("Has s");
        }

        System.out.println("Current time"+new SimpleDateFormat("yyyyMMddHHmm'.csv'").format(new Date()));
        System.out.println("Time taken:"+(testTime-Calendar.getInstance().getTimeInMillis()));
    }

    public static boolean ifElseChecks(RandomClass randomData){
        if(randomData.getInstrNum()==100){
            return true;
        }else {
            return false;
        }
    }
}
