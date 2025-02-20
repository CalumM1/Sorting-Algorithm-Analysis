package main;

import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Reader reader = new Reader();
        int[] a = reader.readArray("input/int50.txt");
        Sort sort = new Sort();

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(sort.selectionSort(a)));
    }
}