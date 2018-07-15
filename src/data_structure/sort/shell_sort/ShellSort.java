package data_structure.sort.shell_sort;

/**
 * @author Created By Frank
 * @date 2018-07-10 13:39
 */
public class ShellSort {

    // 希尔排序
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int h = n / 2; h > 0; h = h / 2) {
            // 内部是一个插入排序
            for (int i = 0; i < n; i = i + h) {

                int e = arr[i];
                int j = i;
                for (; j > 0; j = j - h) {
                    if (e < arr[j - h])
                        arr[j] = arr[j - h];
                    else
                        break;
                }
                arr[j] = e;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                System.out.print(' ');
            }
        }
    }


    // 希尔排序2
    public static void sort2(int[] arr) {
        int n = arr.length;
        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        System.out.println(h);

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {

                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                int e = arr[i];
                int j = i;
                for (; j >= h && e < arr[j - h]; j -= h)
                    arr[j] = arr[j - h];
                arr[j] = e;
            }

            h /= 3;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
        int[] arr = {10, 91, 8, 7, 6, 5, 4, 3, 2, 1};
        ShellSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
