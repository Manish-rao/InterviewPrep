package com.PerformanceCheck;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ReadLineCount {
    public static boolean isIncreasing(int[] array) {
        return IntStream.range(0, array.length - 1).noneMatch(i -> array[i] > array[i + 1]);
    }
    public static void main(String[] args) throws IOException {
        List<Integer> test = new ArrayList<>();
        int[] sequence = test.stream().mapToInt(i->i).toArray();
        isIncreasing(sequence);

        Path path = Paths.get("C:\\Users\\manish.madhusoodhan\\Downloads\\TestLength.csv");

        long lines = 0;
        try {

            // much slower, this task better with sequence access
            //lines = Files.lines(path).parallel().count();

            lines = Files.lines(path).count();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(lines);
    }
}
