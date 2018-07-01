package data_structure.sort_algorithm.quick_sort;

/**
 * @author Created By Frank
 * @date 2018-07-01 10:06
 */

// 这个是自己完成的快速排序
public class QuickSort_Study {


    // 递归使用快速排序,对arr[l...r]的范围进行排序
    public static void QuickSort(int[] arr,int l,int r){
        if(l>=r)
            return;
        int p = partition(arr,l,r);
        QuickSort(arr,l,p-1);
        QuickSort(arr,p+1,r);
    }

    // 将数组通过p分割成两部分
    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    public static int partition(int[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = arr[l];
        int j = l;
        for(int i = j +1;i<=r;i++){
            if(arr[i] < v){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        return j;
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 打印arr数组的所有内容
    public static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();

        return;
    }


    public static void main(String[] args){
        int[] arr = {4,3,12,12};
        QuickSort(arr,0,arr.length-1);
        printArray(arr);
    }
}
