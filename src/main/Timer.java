package main;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.function.Function;

public class Timer
{
    private Reader reader = new Reader();
    private Sort sort = new Sort();


    public Timer() throws FileNotFoundException
    {

    }


    public long timeInsertionSort(String input) throws FileNotFoundException
    {
        int[] array = reader.readArray("input/" + input + ".txt");

        long startTime = System.nanoTime();
        sort.insertionSort(array);
        long endTime = System.nanoTime();

        // return value in microseconds (μ)
        return (endTime - startTime)/1000;
    }


    public long timeSelectionSort(String input) throws FileNotFoundException
    {
        int[] array = reader.readArray("input/" + input + ".txt");

        long startTime = System.nanoTime();
        sort.selectionSort(array);
        long endTime = System.nanoTime();

        // return value in microseconds (μ)
        return (endTime - startTime)/1000;
    }


    public long averageInsertionSortTime() throws FileNotFoundException {
        long total = 0;
        for (int i = 0; i < 10; i++)
        {
            total += timeInsertionSort("int20k");
        }
        return total/10;
    }


    public long averageSelectionSortTime() throws FileNotFoundException {
        long total = 0;
        for (int i = 0; i < 10; i++)
        {
            total += timeSelectionSort("int20k");
        }
        return total/10;
    }


    public static void main(String[] args) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long averageInsertionTime = timer.averageInsertionSortTime();
        long averageSelectionTime = timer.averageSelectionSortTime();

        System.out.println("------------------------");
        System.out.println("The average insertion sort time is " + averageInsertionTime + "μs");
        System.out.println("The average selection sort time is " + averageSelectionTime + "μs");
        System.out.println("------------------------");
    }
}
