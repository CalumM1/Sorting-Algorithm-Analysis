package main.java;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Reader reader = new Reader();
        int[] a = reader.readArray("input/int50.txt");
        int[] b = reader.readArray("input/int50.txt");
        Arrays.sort(b);
        Sorter sorter = new Sorter();

        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(sorter.bottomUpMergeSort(a, 0, a.length - 1)));
    }
}