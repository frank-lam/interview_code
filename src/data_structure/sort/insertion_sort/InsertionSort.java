package data_structure.sort.insertion_sort;

import utils.SortTestHelper;

import java.util.Arrays;

/**
 * @author Created By Frank
 * @date 2018-07-10 11:25
 */
public class InsertionSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
                else
                    break;
            }
        }
    }

    // 改进版插入排序
    public static void better_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int e = arr[i];
            int j = i;
            for (; j > 0; j--) {
                if (e < arr[j - 1])
                    arr[j] = arr[j - 1];
                else
                    break;
            }
            arr[j] = e;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
//        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        InsertionSort.better_sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//            System.out.print(' ');
//        }
//        System.out.println();


        int N = 20000;


        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.SelectionSort", arr1);
    }
}
