package leetcode.code343_integer_break;

import java.util.Arrays;

/**
 * 整数拆分 - LeetCode (中国)
 * https://leetcode-cn.com/problems/integer-break/description/
 */

// 动态规划
class Solution3 {

    public int integerBreak(int n) {
        int[] num = new int[n + 1];
        Arrays.fill(num, -1);
        num[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                num[i] = max3(num[i],j * (i - j), j * num[i - j]);
            }
        }

        return num[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().integerBreak(10)); // => 36
    }
}