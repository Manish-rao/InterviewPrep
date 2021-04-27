package com.HackerRank;

import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i=1; i<chars.length; i++){
           if(chars[i-1]==chars[i])
               count++;
        }
        System.out.println(count);
        return count;
    }

    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int q = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] stringArray = new String[]{"AAAAA","ABAABAA","CDADC"};
        for (int qItr = 0; qItr < stringArray.length; qItr++) {
            String s = stringArray[qItr];

            int result = alternatingCharacters(s);
/*
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();*/
        }
/*
        bufferedWriter.close();

        scanner.close();*/
    }
}
