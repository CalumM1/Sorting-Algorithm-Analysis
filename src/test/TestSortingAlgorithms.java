package test;

import main.Reader;
import main.Sort;
import org.junit.Test;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class TestSortingAlgorithms
{
    Sort sort = new Sort();

    String inputString = "input/int100.txt";
    private Reader reader = new Reader();
    private int[] input = reader.readArray(inputString);
    private int[] sorted = reader.readArray(inputString);

    public TestSortingAlgorithms() throws FileNotFoundException
    {
        Arrays.sort(sorted);
    }


    @Test
    public void test()
    {
        Assert.assertEquals(Arrays.toString(sorted), Arrays.toString(sort.insertionSort(input)));
    }
}
