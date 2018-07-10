package data_structure.sort_algorithm.merge_sort;

import java.util.Arrays;

/**
 * @author Created By Frank
 * @date 2018-07-10 20:25
 */
public class MergeSort {

    private static void sort(int[] arr) {
        __MergeSort(arr, 0, arr.length - 1);
    }

    private static void __MergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        __MergeSort(arr, l, mid);
        __MergeSort(arr, mid + 1, r);
        if (arr[mid] > arr[mid + 1])
            merge(arr, l, mid, r);
    }

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
//        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
//        // 可以在1秒之内轻松处理100万数量级的数据
//        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
//        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
//        int N = 1000000;
//        int[] arr = SortTestHelper.generateRanArray(N, 0, 100000);
//        long star = System.currentTimeMillis();
//        MergeSort.sort(arr);
//        long end = System.currentTimeMillis();
//
//        double time = (end-star)/1000.0;
//        System.out.println("Merge Sort Time: "+ time+" s");
//        return;


        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MergeSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
