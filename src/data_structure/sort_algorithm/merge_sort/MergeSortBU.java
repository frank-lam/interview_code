package data_structure.sort_algorithm.merge_sort;

import utils.PrintHelper;

import java.util.Arrays;

/**
 * @author Created By Frank
 * @date 2018-07-10 21:12
 */
public class MergeSortBU {
    private static void sort(int[] arr) {
        int N = arr.length;
        int[] aux = new int[N];
        for (int sz = 1; sz < N; sz += sz)
            for (int i = 0; i + sz < N; i += sz + sz)
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, N - 1));
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

    public static void main(String[] args){
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MergeSortBU.sort(arr);
        PrintHelper.printArray(arr);
        System.out.println();
    }
}
