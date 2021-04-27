package com.HackerRank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class Test {
    int climbingStairs(int n) {
        if(n<=2)
            return n;
        return climbingStairs(n-1)+climbingStairs(n-2);
    }

    int houseRobber(int[] nums) {
        int a = 0, b = 0;
        for (int number : nums) {
            b = Math.max(number + a, a = b);
        }
        return b;
    }

    String[] composeRanges(int[] nums) {
        Arrays.sort(nums);
        StringBuilder builder = new StringBuilder();
        List<Integer> tempList = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            System.out.println(i);
            if(i+1==nums.length){
                if(tempList.size()>0 && nums[i]-1==nums[i-1]){
                    builder.append(tempList.get(0)+"->"+nums[i]+",");
                }else{
                    builder.append(nums[i]);
                }
            }else if(nums[i]+1==nums[i+1]){
                System.out.println("Add:"+nums[i]);
                tempList.add(nums[i]);
            }
            else{
                System.out.println("Else:"+nums[i]);
                if(tempList.size()>=1){
                    tempList.add(nums[i]);
                    builder.append(tempList.get(0)+"->"+tempList.get(tempList.size()-1)+",");
                }else{
                    builder.append(nums[i]+",");
                }
                tempList.clear();
            }
        }
        return builder.length()>0? builder.toString().split(","):new String[0];
    }

    String[][] groupingDishes(String[][] dishes) {
        Map<String, ArrayList<String>> outMap = new HashMap<>();
        String dish = null;

        ArrayList<String> values = new ArrayList<>();
        for(int i=0;i<dishes.length;i++){
            dish = dishes[i][0];
            for(int k=0;k<dishes[i].length;k++){
                if(dishes[i][k]!=dish){
                    if(outMap.containsKey(dishes[i][k])){
                        values = outMap.get(dishes[i][k]);
                        values.add(dish);
                        outMap.put(dishes[i][k], values);
                    }else{
                        values = new ArrayList<>();
                        values.add(dish);
                        outMap.put(dishes[i][k], values);
                    }

                }
            }
        }

        ArrayList<String[]> list = new ArrayList<>();
        for(String ingred:outMap.keySet()){
            ArrayList<String> foods = outMap.get(ingred);
            if(foods.size()>1){
                Collections.sort(foods);
                String[] fin = new String[foods.size()+1];
                fin[0]=ingred;
                for(int i = 0; i < foods.size(); i++)
                    fin[i+1]=foods.get(i);
                list.add(fin);
            }
        }


        Collections.sort(list,(a,b)->a[0].compareTo(b[0]));
        return list.toArray(new String[0][]);
    }

    int arrayChange(int[] inputArray) {
        int initialSum = IntStream.range(0, inputArray.length).map(i->inputArray[i]).sum();
        for(int i=0; i <inputArray.length-1;i++){
            if(inputArray[i+1]<=inputArray[i]){
                inputArray[i+1] = inputArray[i+1]+Math.abs(inputArray[i+1]-inputArray[i])+1;
            }
        }
        return IntStream.range(0, inputArray.length).map(i->inputArray[i]).sum()-initialSum;
    }

    /*String[] composeRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i+1 < nums.length && nums[i]+1 == nums[i+1]) i++;
            int end = nums[i];
            res.add(start != end ? start + "->" + end : "" + start);
        }
        return res.toArray(new String[res.size()]);
    }
*/

    char firstNotRepeatingCharacter(String s) {
        char[] str= s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            char chars = str[i];
            if (s.indexOf(chars) == i && s.indexOf(chars, i + 1) == -1) {
                return chars;
            }
        }
        return '_';
    }

    public boolean areFollowingPatterns(String[] strings, String[] patterns){
        HashMap<String,String> stringMap = new HashMap<String,String>();
        HashMap<String,String> patternMap = new HashMap<String,String>();

        for(int i = 0; i < strings.length; i++){
            if(stringMap.containsKey(strings[i])  && !stringMap.get(strings[i]).equals(patterns[i])){
                return false;
            }
            if(patternMap.containsKey(patterns[i])  && !patternMap.get(patterns[i]).equals(strings[i])){
                return false;
            }

            stringMap.put(strings[i],patterns[i]);
            patternMap.put(patterns[i], strings[i]);

        }

        return true;
    }

    String[] addBorder(String[] picture) {
        String[] borderString = new String[picture.length+2];
        for(int i=0; i<picture.length;i++){
            borderString[i+1]=new StringBuilder("*"+picture[i]+"*").toString();
        }
        borderString[0] = borderString[picture.length + 1] = borderString[1].replaceAll(".","*");
        return borderString;
    }

    boolean palindromeRearranging(String inputString) {
        int[] freq = new int[26];
        inputString.chars().forEach((c) -> {
            freq[c - 97]++;
        });
        int cnt=0;
        for(int i=0;i<freq.length;i++)
            if(freq[i]%2!=0)
                cnt++;

        return cnt<=1;
    }

    static int count=0;
    public static void main(String[] args) {
        Map<String,List<TickTest>> myMap = new ConcurrentHashMap<>();
        List<TickTest> one = new ArrayList<>();
        one.add(new TickTest("IBM", 100, 10));
        one.add(new TickTest("IBM", 200, -1));
        one.add(new TickTest("IBM", 300, 20));
        List<TickTest> two = new ArrayList<>();
        two.add(new TickTest("BOSE", 400, -1));
        two.add(new TickTest("BOSE", 500, -1));
        two.add(new TickTest("BOSE", 600, -1));
        List<TickTest> three = new ArrayList<>();
        three.add(new TickTest("DELl", 400, 60));
        three.add(new TickTest("DELl", 500, 1));
        three.add(new TickTest("DELl", 600, 60));
        myMap.put("IBM",one);
        myMap.put("BOSE",two);
        myMap.put("DELl",three);
        myMap.forEach((l,s)-> System.out.println(l+":"+s));
        Iterator<List<TickTest>> iterator = myMap.values().iterator();
        while(iterator.hasNext()) {
            iterator.next().removeIf(x-> 0l > x.getTime());
        }
        myMap.values().removeIf(x-> x == null || x.isEmpty()) ;
        System.out.println("\nAfter:");
        myMap.forEach((l,s)-> System.out.println(l+":"+s));
    }

}
