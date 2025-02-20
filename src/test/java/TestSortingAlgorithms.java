package test.java;

import main.java.Reader;
import main.java.Sorter;
import org.junit.Test;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class TestSortingAlgorithms
{
    private Reader reader = new Reader();
    private Sorter sorter = new Sorter();
    private String smallInputString = "input/int100.txt";
    private String bigInputString = "input/int20k.txt";

    private int[] smallSorted = reader.readArray(smallInputString);
    private int[] bigSorted = reader.readArray(bigInputString);


    // constructor creates sorted arrays to test against using java method
    public TestSortingAlgorithms() throws FileNotFoundException
    {
        Arrays.sort(smallSorted);
        Arrays.sort(bigSorted);
    }


    @Test
    public void testInsertionSortSmall() throws FileNotFoundException
    {
        int[] smallInput = reader.readArray(smallInputString);
        Assert.assertArrayEquals(smallSorted, sorter.insertionSort(smallInput));
    }

    @Test
    public void testInsertionSortBig() throws FileNotFoundException
    {
        int[] bigInput = reader.readArray(bigInputString);
        Assert.assertArrayEquals(bigSorted, sorter.insertionSort(bigInput));
    }

    @Test
    public void testSelectionSortSmall() throws FileNotFoundException
    {
        int[] smallInput = reader.readArray(smallInputString);
        Assert.assertArrayEquals(smallSorted, sorter.selectionSort(smallInput));
    }

    @Test
    public void testSelectionSortBig() throws FileNotFoundException
    {
        int[] bigInput = reader.readArray(bigInputString);
        Assert.assertArrayEquals(bigSorted, sorter.selectionSort(bigInput));
    }

    @Test
    public void testShellSortSmall() throws FileNotFoundException
    {
        int[] smallInput = reader.readArray(smallInputString);
        Assert.assertArrayEquals(smallSorted, sorter.shellSort(smallInput));
    }

    @Test
    public void testShellSortBig() throws FileNotFoundException
    {
        int[] bigInput = reader.readArray(bigInputString);
        Assert.assertArrayEquals(bigSorted, sorter.shellSort(bigInput));
    }

    @Test
    public void testMergeSortSmall() throws FileNotFoundException
    {
        int[] smallInput = reader.readArray(smallInputString);
        Assert.assertArrayEquals(smallSorted, sorter.mergeSort(smallInput, 0, smallInput.length - 1));
    }

    @Test
    public void testMergeSortBig() throws FileNotFoundException
    {
        int[] bigInput = reader.readArray(bigInputString);
        Assert.assertArrayEquals(bigSorted, sorter.mergeSort(bigInput, 0 , bigInput.length - 1));
    }

    @Test
    public void testMergeInsertSortSmall() throws FileNotFoundException
    {
        int[] smallInput = reader.readArray(smallInputString);
        Assert.assertArrayEquals(smallSorted, sorter.mergeInsertionSort(smallInput, 0, smallInput.length - 1));
    }

    @Test
    public void testMergeInsertSortBig() throws FileNotFoundException
    {
        int[] bigInput = reader.readArray(bigInputString);
        Assert.assertArrayEquals(bigSorted, sorter.mergeInsertionSort(bigInput, 0 , bigInput.length - 1));
    }
}
