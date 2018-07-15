package leetcode.code213_house_robber_ii;

/**
 * @author Created By Frank
 * @date 2018-07-13 11:33
 * <p>
 * house robber 2
 * <p>
 * house robber 2
 * <p>
 * house robber 2
 * <p>
 * house robber 2
 * <p>
 * house robber 2
 * <p>
 * house robber 2
 * <p>
 * house robber 2
 * <p>
 * house robber 2
 */

/**
 * house robber 2
 */

import utils.PrintHelper;

import java.util.Arrays;

/**
 * 打家劫舍 - LeetCode (中国)
 * https://leetcode-cn.com/problems/house-robber/description/
 */

public class Solution1 {
    public static int[] memo;

    // 记忆搜索
    public int rob2(int[] nums) {

        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return tryRobber(nums, 0);
    }


    // 考虑抢劫[index,nums.length-1]范围内的房子
    private int tryRobber(int[] nums, int index) {
        int n = nums.length;
        if (index >= n)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        int res = 0;
        for (int i = index; i < n; i++) {
            res = Math.max(nums[i] + tryRobber(nums, i + 2), res);
        }
        memo[index] = res;
        return res;
    }

    // 动态规划
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        memo = new int[n]; // 这是一个记忆化数组
        memo[n - 1] = nums[n - 1]; // 如果只打劫最后一个的话

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                System.out.println(i + " === " + j);
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }



    public static void main(String[] args) {
        int[] arr3 = {1, 2, 2, 3, 4, 2, 5, 1, 12, 12, 12};
        int[] arr2 = {1, 2, 3, 1};

        int max = new Solution1().rob(arr2);
        System.out.println("最大值为：" + max);

        PrintHelper.printArray(memo);
    }
}
