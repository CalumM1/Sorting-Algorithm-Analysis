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


    public long timeShellSort(String input) throws FileNotFoundException
    {
        int[] array = reader.readArray("input/" + input + ".txt");

        long startTime = System.nanoTime();
        sort.shellSort(array);
        long endTime = System.nanoTime();

        // return value in microseconds (μ)
        return (endTime - startTime)/1000;
    }


    public long timeMergeSort(String input) throws FileNotFoundException
    {
        int[] array = reader.readArray("input/" + input + ".txt");

        long startTime = System.nanoTime();
        sort.mergeSort(array, 0, array.length-1);
        long endTime = System.nanoTime();

        // return value in microseconds (μ)
        return (endTime - startTime)/1000;
    }


    public long averageInsertionSortTime(String input) throws FileNotFoundException
    {
        long total = 0;
        for (int i = 0; i < 10; i++)
        {
            total += timeInsertionSort(input);
        }
        return total/10;
    }


    public long averageSelectionSortTime(String input) throws FileNotFoundException
    {
        long total = 0;
        for (int i = 0; i < 10; i++)
        {
            total += timeSelectionSort(input);
        }
        return total/10;
    }


    public long averageShellSortTime(String input) throws FileNotFoundException
    {
        long total = 0;
        for (int i = 0; i < 10; i++)
        {
            total += timeShellSort(input);
        }
        return total/10;
    }


    public long averageMergeSortTime(String input) throws FileNotFoundException
    {
        long total = 0;
        for (int i = 0; i < 10; i++)
        {
            total += timeMergeSort(input);
        }
        return total/10;
    }


    public static void main(String[] args) throws FileNotFoundException
    {
        Timer timer = new Timer();

        String input = "int20K";
        long averageInsertionTime = timer.averageInsertionSortTime(input);
        long averageSelectionTime = timer.averageSelectionSortTime(input);
        long averageShellTime = timer.averageShellSortTime(input);
        long averageMergeTime = timer.averageMergeSortTime(input);

        System.out.println("------------------------");
        System.out.println("The average insertion sort time is " + averageInsertionTime + "μs (" + (double) averageInsertionTime/1_000_000 + "s)");
        System.out.println("The average selection sort time is " + averageSelectionTime + "μs (" + (double) averageSelectionTime/1_000_000 + "s)");
        System.out.println("The average shell sort time is " + averageShellTime + "μs (" + (double) averageShellTime/1_000_000 + "s)");
        System.out.println("The average Merge sort time is " + averageMergeTime + "μs (" + (double) averageMergeTime/1_000_000 + "s)");
        System.out.println("------------------------");
    }
}
