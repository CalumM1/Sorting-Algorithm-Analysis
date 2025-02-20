package main;

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

            int minIndex = i;
            minIndex = findMinIndex(array, i);
            swap(array, i, minIndex);
        }
        return array;
    }


    public int[] shellSort(int[] array)
    {
        return array;
    }


    private static int findMinIndex(int[] array, int startingIndex) {
        int min = array[startingIndex];
        int index = startingIndex;
        for (int j = startingIndex + 1; j < array.length; j++)
        {
            if (array[j] < min)
            {
                min = array[j];
                index = j;
            }
        }
        return index;
    }


    private static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


}
