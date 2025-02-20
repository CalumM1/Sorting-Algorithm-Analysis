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

    private int[] smallInput = reader.readArray(smallInputString);
    private int[] smallSorted = reader.readArray(smallInputString);
    private int[] bigInput = reader.readArray(bigInputString);
    private int[] bigSorted = reader.readArray(bigInputString);

    // constructor creates sorted arrays to test against using java method
    public TestSortingAlgorithms() throws FileNotFoundException
    {
        Arrays.sort(smallSorted);
        Arrays.sort(bigSorted);
    }


    @Test
    public void testInsertionSortSmall()
    {
        Assert.assertArrayEquals(smallSorted, sort.insertionSort(smallInput));
    }

    @Test
    public void testInsertionSortBig()
    {
        Assert.assertArrayEquals(bigSorted, sort.insertionSort(bigInput));
    }

    @Test
    public void testSelectionSortSmall()
    {
        Assert.assertArrayEquals(smallSorted, sort.selectionSort(smallInput));
    }

    @Test
    public void testSelectionSortBig()
    {
        Assert.assertArrayEquals(bigSorted, sort.selectionSort(bigInput));
    }
}
