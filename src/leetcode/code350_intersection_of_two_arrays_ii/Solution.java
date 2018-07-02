package leetcode.code350_intersection_of_two_arrays_ii;

/**
 * @author Created By Frank
 * @date 2018-07-02 19:13
 */

import utils.PrintHelper;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 两个数组的交集 II - LeetCode (中国)
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if(map.containsKey(num)){
                list.add(num);
                map.put(num,map.get(num)-1);
                if(map.get(num) == 0){
                    map.remove(num);
                }
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] res = new Solution().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        PrintHelper.printArray(res);
    }
}
