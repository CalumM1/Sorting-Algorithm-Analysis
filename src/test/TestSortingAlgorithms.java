package test;

import main.Reader;
import main.Sort;
import org.junit.Test;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class TestSortingAlgorithms
{
    private Reader reader = new Reader();
    private Sort sort = new Sort();
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
        Assert.assertArrayEquals(smallSorted, sort.insertionSort(smallInput));
    }

    @Test
    public void testInsertionSortBig() throws FileNotFoundException
    {
        int[] bigInput = reader.readArray(bigInputString);
        Assert.assertArrayEquals(bigSorted, sort.insertionSort(bigInput));
    }

    @Test
    public void testSelectionSortSmall() throws FileNotFoundException
    {
        int[] smallInput = reader.readArray(smallInputString);
        Assert.assertArrayEquals(smallSorted, sort.selectionSort(smallInput));
    }

    @Test
    public void testSelectionSortBig() throws FileNotFoundException
    {
        int[] bigInput = reader.readArray(bigInputString);
        Assert.assertArrayEquals(bigSorted, sort.selectionSort(bigInput));
    }

    @Test
    public void testShellSortSmall() throws FileNotFoundException
    {
        int[] smallInput = reader.readArray(smallInputString);
        Assert.assertArrayEquals(smallSorted, sort.shellSort(smallInput));
    }

    @Test
    public void testShellSortBig() throws FileNotFoundException
    {
        int[] bigInput = reader.readArray(bigInputString);
        Assert.assertArrayEquals(bigSorted, sort.shellSort(bigInput));
    }

    @Test
    public void testMergeSortSmall() throws FileNotFoundException
    {
        int[] smallInput = reader.readArray(smallInputString);
        Assert.assertArrayEquals(smallSorted, sort.mergeSort(smallInput, 0, smallInput.length - 1));
    }

    @Test
    public void testMergeSortBig() throws FileNotFoundException
    {
        int[] bigInput = reader.readArray(bigInputString);
        Assert.assertArrayEquals(bigSorted, sort.mergeSort(bigInput, 0 , bigInput.length - 1));
    }
}
