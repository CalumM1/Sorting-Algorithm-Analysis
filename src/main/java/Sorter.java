package main.java;

public class Sorter
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
                i--;
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
        long h = 1;

        while (h < array.length / 3)
        {
            h = (h * 3) + 1;
        }
        while (h >= 1)
        {
            for (long i = h; i < array.length; i++)
            {
                for (long j = i; j >= h && array[(int) j] < array[(int)(j-h)]; j-=h)
                {
                    swap(array,(int) j, (int) (j-h));
                }
            }
            h /= 3;
        }
        return array;
    }


    public int[] mergeSort(int[] array, int p, int r)
    {
        if (p < r){
            int q = (p+r)/2;
            mergeSort(array, p, q);
            mergeSort(array , q+1, r);
            merge(array, p, q, r);
        }
        return array;
    }


    public int[] mergeInsertionSort(int[] array, int p, int r)
    {
        final int INSERTION_SORT_THRESHOLD = 10;
        if (p < r)
        {
            // Use insertion sort for small subarrays
            if (r - p + 1 <= INSERTION_SORT_THRESHOLD)
            {
                insertionSortInPlace(array, p, r);
            } else {
                int q = (p + r) / 2;
                mergeSort(array, p, q);
                mergeSort(array, q + 1, r);
                merge(array, p, q, r);
            }
        }
        return array;
    }


    public int[] bottomUpMergeSort(int[] array, int p, int r)
    {
        int n = r - p + 1;
        for (int sz = 1; sz < n; sz = sz+sz)
        {
            for (int q = 0; q < n - sz; q += sz + sz)
            {
                merge(array, q, q + sz - 1, Math.min(q + sz + sz - 1, n - 1));
            }
        }
        return array;
    }


    public int[] quickSort(int[] array, int low, int high)
    {
        if (low < high)
        {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
        return array;
    }


    private static int partition(int[] array, int p, int r){
        int x = array[r];
        int i = p - 1;
        for (int j = p; j < r; j++){
            if (array[j] <= x){
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, r);
        return i + 1;
    }


    private static void merge(int[] array, int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        if (n1 >= 0)
        {
            System.arraycopy(array, p, L, 0, n1);
        }

        for (int j=0; j<n2; j++)
        {
            R[j] = array[q + 1 + j];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k=p; k<= r; k++)
        {
            if(L[i] <= R[j]){
                array[k] = L[i];
                i++;
            }
            else{
                array[k] = R[j];
                j++;
            }
        }
    }


    private void insertionSortInPlace(int[] a, int p, int r)
    {
        for (int i = p + 1; i < r; i++)
        {
            for (int j = i; j > p && a[j] < a[j-1]; j--)
            {
                swap(a, j, j-1);
            }
        }
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
