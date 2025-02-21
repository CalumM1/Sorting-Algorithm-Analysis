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

        System.out.println("Starting experiment ...");
        System.out.println();

        long[] averageInsertionSortTimes = testInsertionSort(inputs);
        allTimes[0] = averageInsertionSortTimes;
        System.out.println("Insertion Sort completed.");

        long[] averageSelectionSortTimes = testSelectionSort(inputs);
        allTimes[1] = averageSelectionSortTimes;
        System.out.println("Selection Sort completed.");

        long[] averageShellSortTimes = testShellSort(inputs);
        allTimes[2] = averageShellSortTimes;
        System.out.println("Shell Sort completed.");

        long[] averageMergeSortTimes = testMergeSort(inputs);
        allTimes[3] = averageMergeSortTimes;
        System.out.println("Merge Sort completed.");

        long[] averageMergeInsertionSortTimes = testMergeInsertionSort(inputs);
        allTimes[4] = averageMergeInsertionSortTimes;
        System.out.println("Merge Insertion Sort completed.");

        long[] averageBottomUpMergeSortTimes = testBottomUpMergeSort(inputs);
        allTimes[5] = averageBottomUpMergeSortTimes;
        System.out.println("Bottom Up Merge Sort completed.");

        long[] averageQuickSortTimes = testQuickSort(inputs);
        allTimes[6] = averageQuickSortTimes;
        System.out.println("Quick Sort completed.");

        long[] averageQuickSortMedian3Times = testQuickSortMedian3(inputs);
        allTimes[7] = averageQuickSortMedian3Times;
        System.out.println("Quick Sort Median 3 completed.");

        long[] averageQuickSortDutchFlagTimes = testQuickSortDutchFlag(inputs);
        allTimes[8] = averageQuickSortDutchFlagTimes;
        System.out.println("Quick Sort Dutch Flag completed.");

        long[] averageQuickInsertionTimes = testQuickInsertionSort(inputs);
        allTimes[9] = averageQuickInsertionTimes;
        System.out.println("Quick Insertion Sort completed.");

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