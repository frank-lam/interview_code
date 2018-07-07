package leetcode.code67_add_binary;

/**
 * @author Created By Frank
 * @date 2018-07-07 16:53
 */

/**
 * 二进制求和 - LeetCode (中国)
 * https://leetcode-cn.com/problems/add-binary/description/
 */

class Solution {
    public String addBinary(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            sum.append((a + b + carry) % 2);
            carry = (a + b + carry) / 2;
        }
        if(carry>0)
            sum.append(carry);

        return sum.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(new Solution().addBinary("01", "01"));
    }
}