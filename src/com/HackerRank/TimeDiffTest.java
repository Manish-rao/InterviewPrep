package com.HackerRank;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeDiffTest {
    public static void main(String[] args) throws ParseException    {
        String str = "12:30pm-12:00am";
        String[] arr = str.split("-");
        SimpleDateFormat date12 = new SimpleDateFormat("hh:mmaa");
        SimpleDateFormat parseDate = new SimpleDateFormat("HH:mm");
        long date1 = date12.parse(arr[0]).getTime();
        long date2 = date12.parse(arr[1]).getTime();
        if(date1>date2){
            date2 = date2 + (1000*60*60*24);
        }
        long time = (date2-date1)/(1000*60);
        System.out.println(time);
        System.out.println(date12.parse(arr[0]));
        System.out.println(date12.parse(arr[1]));
    }
}
