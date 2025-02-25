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


    public int[] mergeSort(int[] array, int low, int high)
    {
        if (low < high){
            int q = (low+high)/2;
            mergeSort(array, low, q);
            mergeSort(array , q+1, high);
            merge(array, low, q, high);
        }
        return array;
    }


    public int[] mergeInsertionSort(int[] array, int low, int high)
    {
        if (low < high)
        {
            // Use insertion sort for small subarrays
            if (high - low + 1 <= 10)
            {
                insertionSortInPlace(array, low, high);
            } else {
                int q = (low + high) / 2;
                mergeSort(array, low, q);
                mergeSort(array, q + 1, high);
                merge(array, low, q, high);
            }
        }
        return array;
    }


    public int[] bottomUpMergeSort(int[] array, int low, int high)
    {
        int n = high - low + 1;
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
            int pivotIndex = partitionQuick(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
        return array;
    }


    public int[] quickSortMedian3(int[] array, int low, int high)
    {
        if (low < high)
        {
            int pivotIndex = partitionMedianOfThree(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
        return array;
    }


    public int[] quickSortDutchFlag(int[] array, int low, int high)
    {
        if (low < high)
        {
            int[] pivots = partitionDutchFlag(array, low, high);
            quickSort(array, low, pivots[0] - 1);
            quickSort(array, pivots[1] + 1, high);
        }
        return array;
    }


    public int[] quickInsertionSort(int[] array, int low, int high) {
        if (low < high)
        {
            // Use Insertion Sort for small subarrays
            if (high - low + 1 <= 10)
            {
                insertionSortInPlace(array, low, high);
            } else {
                int pivotIndex = partitionQuick(array, low, high);
                quickSort(array, low, pivotIndex - 1);
                quickSort(array, pivotIndex + 1, high);
            }
        }
        return array;
    }


    private static int medianOfThree(int[] array, int p, int r)
    {
        int mid = p + (r - p) / 2;

        if (array[p] > array[mid])
        {
            swap(array, p, mid);
        }

        if (array[p] > array[r])
        {
            swap(array, p, r);
        }

        if (array[mid] > array[r])
        {
            swap(array, mid, r);
        }
        return mid;
    }


    private static int partitionMedianOfThree(int[] array, int p, int r)
    {
        int medianIndex = medianOfThree(array, p, r);
        swap(array, medianIndex, r);

        return partition(array, p, r);
    }


    private static int partitionQuick(int[] array, int p, int r)
    {
        return partition(array, p, r);
    }


    private static int[] partitionDutchFlag(int[] array, int low, int high)
    {
        int pivot = array[high];
        int i = low - 1;
        int j = low;
        int k = high;

        while (j <= k) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
                j++;
            } else if (array[j] > pivot) {
                swap(array, j, k);
                k--;
            } else {
                j++;
            }
        }
        return new int[] { i + 1, k };
    }


    private static int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, r);
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


    private static int findMinIndex(int[] array, int startingIndex)
    {
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
