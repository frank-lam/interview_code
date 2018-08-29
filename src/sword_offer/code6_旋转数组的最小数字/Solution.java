package sword_offer.code6_旋转数组的最小数字;

public class Solution {

    // 方法1：顺序遍历数组
    //       时间复杂度：O(n)
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // 方法2：二分查找
    //       时间复杂度：O(logn)
    //      left    mid    right
    //       ↓       ↓       ↓
    //       3   4   5   1   2
    public static int minNumberInRotateArray2(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left + (right - left) / 2;
        while (left + 1 < right) {
            if (array[mid] >= array[left]) { // 说明此时是第一个序列，则最小值在后面
                left = mid;
            }
            if (array[mid] <= array[right]) {  // 说明此时是第二个序列，则最小值在前面
                right = mid;
            }
            mid = (left + right) / 2;
        }

        return array[right];
    }

    public static void main(String[] args) {
        // 典型输入，单调升序的数组的一个旋转
        int[] array1 = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray2(array1));
    }
}