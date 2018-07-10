package leetcode.code1_two_sum;

import utils.PrintHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created By Frank
 * @date 2018-07-11 0:14
 */


/**
 * 两数之和 - LeetCode (中国)
 * https://leetcode-cn.com/problems/two-sum/description/
 */

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(target == nums[i]+nums[j]){
                    list.add(i);
                    list.add(j);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        PrintHelper.printArray(new Solution().twoSum(nums, 9));
//        System.out.println();
    }
}
