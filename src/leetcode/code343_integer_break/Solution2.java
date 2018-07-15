package leetcode.code343_integer_break;

import java.util.Arrays;

/**
 * 整数拆分 - LeetCode (中国)
 * https://leetcode-cn.com/problems/integer-break/description/
 */

// 记忆化搜索
class Solution2 {
    private int[] memo;
    public int breakMaxValue(int n){
        int res = -1;
        if (n == 1 || n == 2)
            return 1;

        if(memo[n] != -1){
            return memo[n];
        }
        for (int i = 1; i < n; i++) {
            res = max3(i * breakMaxValue(n - i), res, i * (n - i));
        }

        memo[n] = res;
        return res;
    }


    public int integerBreak(int n) {
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        return breakMaxValue(n);
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().integerBreak(10)); // => 36
    }
}