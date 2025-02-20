package main.java;

import java.io.FileNotFoundException;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Reader reader = new Reader();
        int[] a = reader.readArray("input/int50.txt");
        Sorter sorter = new Sorter();
    }
}