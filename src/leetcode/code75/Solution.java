package leetcode.code75;


import data_structure.sort_algorithm.quick_sort.SortTestHelper;

/**
 * @author Created By Frank
 * @date 2018-07-10 10:30
 */

// 分类颜色 - LeetCode (中国)
// https://leetcode-cn.com/problems/sort-colors/description/

class Solution {

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    public void QuickSort(int[] arr,int l,int r){
        if(l>=r)
            return;
        int p = partition(arr,l,r);
        QuickSort(arr,l,p-1);
        QuickSort(arr,p+1,r);
    }

    // 将数组通过p分割成两部分
    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    public int partition(int[] arr, int l, int r) {
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

    public void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void sortColors(int[] nums) {
        QuickSort(nums,0,nums.length-1);
    }

    public static void main(String[] args){
        int[] arr ={1,1,0,0,2,2,1};

        SortTestHelper.printArray(arr);

    }
}