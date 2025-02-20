package main;

import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Reader reader = new Reader();
        int[] a = reader.readArray("int50.txt");
        System.out.println(a.getClass());

    }
}