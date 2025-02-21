package main.java;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Custom {
    public int[] findKMostViewed(int[] array, int k) {
        ArrayList<Integer> mostViewed = new ArrayList<>();

        for (int item : array) {
            // if there are <k elements in the array, add element
            if (mostViewed.size() < k) {
                mostViewed.add(item);
            } else {
                // if item is > smallest element in mostViewed, replace it
                int min = Collections.min(mostViewed);
                if (item > min) {
                    mostViewed.add(item);
                    mostViewed.remove(Integer.valueOf(min));
                }
            }
        }

        // convert to int[]
        int[] result = new int[mostViewed.size()];
        for (int i = 0; i < mostViewed.size(); i++) {
            result[i] = mostViewed.get(i);
        }

        return result;
    }
}