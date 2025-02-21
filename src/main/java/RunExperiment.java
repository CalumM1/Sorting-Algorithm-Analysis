package main.java;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class RunExperiment
{
    public static void main(String[] args) throws IOException
    {
        final String[] inputs = {"int10",
                                "int50",
                                "int100",
                                "int1000",
                                "int20k",
                                "int500k",
                                "intBig",};

        Reader reader = new Reader();
        long[][] allTimes = new long[10][7];

        long[] averageInsertionSortTimes = testInsertionSort(inputs);
        allTimes[0] = averageInsertionSortTimes;

        long[] averageSelectionSortTimes = testSelectionSort(inputs);
        allTimes[1] = averageSelectionSortTimes;

        long[] averageShellSortTimes = testShellSort(inputs);
        allTimes[2] = averageShellSortTimes;

        long[] averageMergeSortTimes = testMergeSort(inputs);
        allTimes[3] = averageMergeSortTimes;

        long[] averageMergeInsertionSortTimes = testMergeInsertionSort(inputs);
        allTimes[4] = averageMergeInsertionSortTimes;

        long[] averageBottomUpMergeSortTimes = testBottomUpMergeSort(inputs);
        allTimes[5] = averageBottomUpMergeSortTimes;

        long[] averageQuickSortTimes = testQuickSort(inputs);
        allTimes[6] = averageQuickSortTimes;

        long[] averageQuickSortMedian3Times = testQuickSortMedian3(inputs);
        allTimes[7] = averageQuickSortMedian3Times;

        long[] averageQuickSortDutchFlagTimes = testQuickSortDutchFlag(inputs);
        allTimes[8] = averageQuickSortDutchFlagTimes;

        long[] averageQuickInsertionTimes = testQuickInsertionSort(inputs);
        allTimes[9] = averageQuickInsertionTimes;

        writeLongArrayToCSV(allTimes, "runtimes.csv");


    }


    private static long[] testInsertionSort(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[7];

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

        long[] times = new long[7];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageShellSortTime(inputs[i]);
        }
        return times;
    }


    private static long[] testMergeSort(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[7];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageMergeSortTime(inputs[i]);
        }
        return times;
    }


    private static long[] testMergeInsertionSort(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[7];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageMergeInsertionSortTime(inputs[i]);
        }
        return times;
    }


    private static long[] testBottomUpMergeSort(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[7];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageBottomUpMergeSortTime(inputs[i]);
        }
        return times;
    }


    private static long[] testQuickSort(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[7];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageQuickSortTime(inputs[i]);
        }
        return times;
    }


    private static long[] testQuickSortMedian3(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[7];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageQuickSortMedian3Time(inputs[i]);
        }
        return times;
    }


    private static long[] testQuickSortDutchFlag(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[7];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageQuickSortDutchFlagTime(inputs[i]);
        }
        return times;
    }


    private static long[] testQuickInsertionSort(String[] inputs) throws FileNotFoundException
    {
        Timer timer = new Timer();

        long[] times = new long[7];

        for (int i = 0; i < inputs.length; i++)
        {
            times[i] = timer.averageQuickInsertionSortTime(inputs[i]);
        }
        return times;
    }


    public static void writeLongArrayToCSV(long[][] data, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (long[] row : data) {
                // Convert each row to a comma-separated string and write it
                for (int i = 0; i < row.length; i++) {
                    writer.write(String.valueOf(row[i]));
                    if (i < row.length - 1) {
                        writer.write(","); // Add a comma after each value except the last one
                    }
                }
                writer.newLine(); // Move to the next line after writing each row
            }
        }
    }
}