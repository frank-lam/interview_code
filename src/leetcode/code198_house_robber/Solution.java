package leetcode.code198_house_robber;

/**
 * 打家劫舍 - LeetCode (中国)
 * https://leetcode-cn.com/problems/house-robber/description/
 */

class Solution {
    public int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
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
}