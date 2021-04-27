package com.com.wipro.pairs;

import java.util.HashMap;

public class FindPairs {
    class Pair {
        int first, second;
        Pair(int one, int two) {
            first = one;
            second = two;
        }
    }

    void findPairs(int arr[]) {
        HashMap<Integer, Pair> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum))
                    map.put(sum, new Pair(i, j));
                else {
                    Pair p = map.get(sum);
                    System.out.println("(" + arr[p.first] + ", " + arr[p.second] +
                            ") and (" + arr[i] + ", " + arr[j] + ")");
                }
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5};
        FindPairs a = new FindPairs();
        a.findPairs(arr);
    }

}
