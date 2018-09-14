package data_structure.sort.quick_sort;

import utils.PrintHelper;

/**
 * @author Created By Frank
 * @date 2018-09-14 10:57
 */
public class QuickSort_normal {


    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 8, 0, 2, 3};

        quickSort(arr, 0, arr.length - 1);
        PrintHelper.printArray(arr);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l > r)
            return;
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int j = l;
        for (int i = j + 1; i <= r; i++) {
            if(arr[i] < v){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }
}
