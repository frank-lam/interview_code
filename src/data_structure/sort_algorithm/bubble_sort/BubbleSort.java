package data_structure.sort_algorithm.bubble_sort;

/**
 * @author Created By Frank
 * @date 2018-07-10 11:54
 */
public class BubbleSort {


    private static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) { // 从最后一位开始确定
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]){
                    swapped = true;
                    swap(arr,j,j+1);
                }
            }
            if(!swapped)
                return;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        BubbleSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }


}
