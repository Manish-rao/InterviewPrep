package com.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDimensionalArrayDiagonal {
    public static void main(String[] args) {
        Integer[][] arr = {{1, 2, 3},
                {5, 6, 7},
                {8, 2, 3}};
        List<List<Integer>> arrList = new ArrayList<>();
        for (Integer[] ints : arr) {
            arrList.add(Arrays.asList(ints));
        }
        int size = arrList.size();
        System.out.println(size);
        int leadingDiagonalSum = 0;
        int antiDiagonalSum = 0;
        for (int i = 0; i < size; i++) {
            leadingDiagonalSum += arrList.get(i).get(i);
            antiDiagonalSum += arrList.get(i).get(size - i - 1);
        }
        System.out.println(Math.abs(leadingDiagonalSum-antiDiagonalSum));
    }
}
