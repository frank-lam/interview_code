package leetcode.code343_integer_break;

/**
 * 整数拆分 - LeetCode (中国)
 * https://leetcode-cn.com/problems/integer-break/description/
 */

// 递归方式
class Solution {
    public int integerBreak(int n) {
        int res = -1;
        if (n == 1 || n == 2)
            return 1;
        for (int i = 1; i < n; i++) {
            res = max(i * integerBreak(n - i), res, i * (n - i));
        }
        return res;
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(10)); // => 36
    }
}