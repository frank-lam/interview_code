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
 * <p>
 * house robber 2
 */

/**
 * house robber 2
 */

import java.util.Arrays;

/**
 * 打家劫舍 - LeetCode (中国)
 * https://leetcode-cn.com/problems/house-robber/description/
 */

public class Solution2 {
    public static int[] memo;

    // 记忆搜索
    public int rob2(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        memo = new int[n];
        Arrays.fill(memo, -1);
        int right = tryRobber(nums, 0, n-1);

        Arrays.fill(memo, -1);
        int left = tryRobber(nums, 1, n);

        return Math.max(left,right);
    }


    // 考虑抢劫[index,nums.length-1]范围内的房子
    private int tryRobber(int[] nums, int index, int n) {
        if (index >= n)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        int res = 0;
        for (int i = index; i < n; i++) {
            res = Math.max(nums[i] + tryRobber(nums, i + 2, n), res);
        }
        memo[index] = res;
        return res;
    }


    public static void main(String[] args) {
        int[] arr2 = {1,3,1,3,100};

        int max = new Solution2().rob2(arr2);
        System.out.println("最大值为：" + max);

//        PrintHelper.printArray(memo);
    }
}
