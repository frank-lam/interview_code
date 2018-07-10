package leetcode.code7_reverse_integer;

/**
 * @author Created By Frank
 * @date 2018-07-10 19:51
 */

/**
 * 反转整数 - LeetCode (中国)
 * https://leetcode-cn.com/problems/reverse-integer/description/
 */
public class Solution {

    // 我的做法
    public int reverse(int x) {
        boolean isPositive = true;
        if (x == 0)
            return x;
        if (x < 0)
            isPositive = false;
        int x2 = Math.abs(x);
        StringBuilder sb = new StringBuilder(x2 + "");
        String s = sb.reverse().toString();
        int num = 0;
        try {
            num = Integer.valueOf(s);
        } catch (Exception e) {
            return 0;
        }

        return isPositive ? num : -num;
    }

    // Leetcode解答
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
    }
}
