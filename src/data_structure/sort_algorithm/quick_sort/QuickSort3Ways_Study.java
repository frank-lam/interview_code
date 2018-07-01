package data_structure.sort_algorithm.quick_sort;

public class QuickSort3Ways_Study {

    // 我们的算法类不允许产生任何实例
    private QuickSort3Ways_Study(){}

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void QuickSort3Ways(int[] arr, int l, int r){

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l, (int)(Math.random()*(r-l+1)) + l );

        int v = arr[l];

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l+1;    // arr[lt+1...i) == v
        while( i < gt ){
            if( arr[i] < v){
                swap( arr, i, lt+1);
                i ++;
                lt ++;
            }
            else if( arr[i] > v ){
                swap( arr, i, gt-1);
                gt --;
            }
            else{ // arr[i] == v
                i ++;
            }
        }

        swap( arr, l, lt );

        QuickSort3Ways(arr, l, lt-1);
        QuickSort3Ways(arr, gt, r);
    }


    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 打印arr数组的所有内容
    public static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
        return;
    }

    // 测试 QuickSort
    public static void main(String[] args) {

        // 三路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int[] arr = {4, 3, 12, 12};
        QuickSort3Ways(arr, 0, arr.length - 1);
        printArray(arr);
    }
}