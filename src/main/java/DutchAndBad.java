package main.java;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static main.java.RunExperiment.runAndGetTimes;
import static main.java.RunExperiment.writeLongArrayToCSV;

public class DutchAndBad
{
    public static void main(String[] args) throws IOException
    {
        final String[] inputs = {"bad", "dutch"};

        long[][] allTimes = runAndGetTimes(inputs, new long[10][2]);

        writeLongArrayToCSV(allTimes,"dutchAndBad.csv");
    }


    private static long[] testInsertionSort(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[2];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageInsertionSortTime(inputs[i]);
        }
        return times;
    }


    private static long[] testSelectionSort(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[7];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageSelectionSortTime(inputs[i]);
        }
        return times;
    }


    private static long[] testShellSort(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[2];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageShellSortTime(inputs[i]);
        }
        return times;
    }


    private static long[] testMergeSort(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[2];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageMergeSortTime(inputs[i]);
        }
        return times;
    }


    private static long[] testMergeInsertionSort(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[2];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageMergeInsertionSortTime(inputs[i]);
        }
        return times;
    }


    private static long[] testBottomUpMergeSort(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[2];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageBottomUpMergeSortTime(inputs[i]);
        }
        return times;
    }


    private static long[] testQuickSort(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[2];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageQuickSortTime(inputs[i]);
        }
        return times;
    }


    private static long[] testQuickSortMedian3(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[2];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageQuickSortMedian3Time(inputs[i]);
        }
        return times;
    }


    private static long[] testQuickSortDutchFlag(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[2];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageQuickSortDutchFlagTime(inputs[i]);
        }
        return times;
    }


    private static long[] testQuickInsertionSort(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[2];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageQuickInsertionSortTime(inputs[i]);
        }
        return times;
    }

}
