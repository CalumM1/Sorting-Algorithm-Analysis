package main;

import java.util.Arrays;

public class Sort
{

    public int[] insertionSort(int[] array)
    {
        for (int j = 1; j < array.length; j++)
        {
            int key = array[j];
            int i = j - 1;

            while (i >= 0 && array[i] > key)
            {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }
        return array;
    }


    public int[] selectionSort(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int sorted = array[i];

            int index = i;
            int min = sorted;
            for (int j = i + 1; j < array.length; j++)
            {
                int next = array[j];
                if (next < min)
                {
                    min = next;
                    index = j;
                }
            }
            swap(array, i, index);
        }
        return array;
    }


    public static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


}
