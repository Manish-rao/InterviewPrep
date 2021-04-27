package com.HackerRank;

import java.io.*;
import java.util.*;

public class Anagram {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        //IntStream streamA = ;
        //IntStream streamB = ;
        //char[] streamB = b.toCharArray();
       /* long result1 =  a.chars().sorted()
                .flatMap(x -> b.chars().sorted()
                                .filter(y -> y!=x || x!=y)).count();*/
        int[] freq = new int[26];
        System.out.println("********A********");
        a.chars().forEach(System.out::println);
        int[] freq10 = new int[26];
        a.chars().forEach((c) -> {
            freq10[c - 97]++;
        });
        a.chars().forEach((c) -> {
            freq[c - 97]++;
        });
        Arrays.stream(freq).forEach(System.out::println);
        System.out.println("********B********");
        b.chars().forEach(System.out::println);
        b.chars().forEach((c) -> {
            freq[c - 97]--;
        });
        System.out.println("********C********");
        Arrays.stream(freq).forEach(System.out::println);
        return Arrays.stream(freq).map(Math::abs).sum();
        /*List<Integer> list =  Arrays.stream(ints2).boxed().collect(Collectors.toList());
        System.out.println("String B*******");
       // Arrays.stream(ints1).forEach(System.out::println);
        System.out.println("String A not found in B*******");
        Arrays.stream(ints1).sorted()
                .filter(x -> list.contains((x))).forEach(System.out::println);
        System.out.println("*******");
        long result =  Arrays.stream(ints1)
                .filter(x -> !list.contains((x))).count();
        List<Integer> list1 =  Arrays.stream(ints1).boxed().collect(Collectors.toList());
        System.out.println("String A*******");
        //Arrays.stream(ints2).forEach(System.out::println);
        System.out.println("String B not found in A*******");
        Arrays.stream(ints2).sorted()
                .filter(x -> list1.contains((x))).forEach(System.out::println);
        result += Arrays.stream(ints2)
                .filter(x -> !list1.contains((x))).count();*/
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String a = scanner.nextLine();

        //String b = scanner.nextLine();
        String a = "test";
        String b= "hello";
        int res = makeAnagram(a, b);
        System.out.println("Result: "+res);

        //bufferedWriter.write(String.valueOf(res));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        //scanner.close();
    }
}

