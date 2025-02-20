package main.java;

import java.io.FileNotFoundException;

public class Timer
{
    private Reader reader = new Reader();
    private Sorter sorter = new Sorter();


    public Timer() throws FileNotFoundException
    {

    }


    public long timeInsertionSort(String input) throws FileNotFoundException
    {
        int[] array = reader.readArray("input/" + input + ".txt");

        long startTime = System.nanoTime();
        sorter.insertionSort(array);
        long endTime = System.nanoTime();

        // return value in microseconds (μ)
        return (endTime - startTime)/1000;
    }


    public long timeSelectionSort(String input) throws FileNotFoundException
    {
        int[] array = reader.readArray("input/" + input + ".txt");

        long startTime = System.nanoTime();
        sorter.selectionSort(array);
        long endTime = System.nanoTime();

        // return value in microseconds (μ)
        return (endTime - startTime)/1000;
    }


    public long timeShellSort(String input) throws FileNotFoundException
    {
        int[] array = reader.readArray("input/" + input + ".txt");

        long startTime = System.nanoTime();
        sorter.shellSort(array);
        long endTime = System.nanoTime();

        // return value in microseconds (μ)
        return (endTime - startTime)/1000;
    }


    public long timeMergeSort(String input) throws FileNotFoundException
    {
        int[] array = reader.readArray("input/" + input + ".txt");

        long startTime = System.nanoTime();
        sorter.mergeSort(array, 0, array.length-1);
        long endTime = System.nanoTime();

        // return value in microseconds (μ)
        return (endTime - startTime)/1000;
    }


    public long timeMergeInsertionSort(String input) throws FileNotFoundException
    {
        int[] array = reader.readArray("input/" + input + ".txt");

        long startTime = System.nanoTime();
        sorter.mergeInsertionSort(array, 0, array.length-1);
        long endTime = System.nanoTime();

        // return value in microseconds (μ)
        return (endTime - startTime)/1000;
    }


    public long timeBottomUpMergeSort(String input) throws FileNotFoundException
    {
        int[] array = reader.readArray("input/" + input + ".txt");

        long startTime = System.nanoTime();
        sorter.bottomUpMergeSort(array, 0, array.length-1);
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


    public long averageMergeInsertionSortTime(String input) throws FileNotFoundException
    {
        long total = 0;
        for (int i = 0; i < 10; i++)
        {
            total += timeMergeInsertionSort(input);
        }
        return total/10;
    }


    public long averageBottomUpMergeSortTime(String input) throws FileNotFoundException
    {
        long total = 0;
        for (int i = 0; i < 10; i++)
        {
            total += timeBottomUpMergeSort(input);
        }
        return total/10;
    }


    public static void main(String[] args) throws FileNotFoundException
    {
        Timer timer = new Timer();

        String input = "int500k";

        System.out.println("------------------------");

        long averageInsertionTime = timer.averageInsertionSortTime(input);
        System.out.println("The average insertion sort time is " + averageInsertionTime + "μs (" + (double) averageInsertionTime/1_000_000 + "s)");

        long averageSelectionTime = timer.averageSelectionSortTime(input);
        System.out.println("The average selection sort time is " + averageSelectionTime + "μs (" + (double) averageSelectionTime/1_000_000 + "s)");

        long averageShellTime = timer.averageShellSortTime(input);
        System.out.println("The average shell sort time is " + averageShellTime + "μs (" + (double) averageShellTime/1_000_000 + "s)");

        long averageMergeTime = timer.averageMergeSortTime(input);
        System.out.println("The average Merge sort time is " + averageMergeTime + "μs (" + (double) averageMergeTime/1_000_000 + "s)");

        long averageMergeInsertionTime = timer.averageMergeInsertionSortTime(input);
        System.out.println("The average MergeInsertion sort time is " + averageMergeInsertionTime + "μs (" + (double) averageMergeInsertionTime/1_000_000 + "s)");

        long averageBottomUpMergeTime = timer.averageMergeInsertionSortTime(input);
        System.out.println("The average Bottom Up Merge sort time is " + averageBottomUpMergeTime + "μs (" + (double) averageBottomUpMergeTime/1_000_000 + "s)");

        System.out.println("------------------------");
    }
}
