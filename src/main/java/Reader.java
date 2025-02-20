package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader
{

    public int[] copyArray(ArrayList<Integer> data)
    {
        int n = data.size();
        int[] res = new int[n];
        for (int i = 0; i<n; i++)
        {
            res [i] = data.get(i);
        }
        return res;
    }

    public int[] readArray(String path) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File(path));
        ArrayList<Integer> data = new ArrayList<Integer>();

        while (sc.hasNextInt())
        {
            data.add(sc.nextInt());
        }
        return copyArray(data);
    }

}
