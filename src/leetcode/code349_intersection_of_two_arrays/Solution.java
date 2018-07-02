package leetcode.code349_intersection_of_two_arrays;

import utils.PrintHelper;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author Created By Frank
 * @date 2018-07-02 19:01
 */

/**
 * 两个数组的交集 - LeetCode (中国)
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 */

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        for(int item : set2){
            if(set1.contains(item)){
                list.add(item);
            }
        }
        int[] resArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resArr[i] = list.get(i);
        }
        return resArr;
    }

    public static void main(String[] args) {
        int[] res = new Solution().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        PrintHelper.printArray(res);
    }
}
