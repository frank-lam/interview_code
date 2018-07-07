package leetcode.code415_add_strings;

/**
 * @author Created By Frank
 * @date 2018-07-07 17:01
 */

/**
 * 字符串相加 - LeetCode (中国)
 * https://leetcode-cn.com/problems/add-strings/description/
 */
public class Solution {

    public String addStrings(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            sum.append((a + b + carry) % 10);
            carry = (a + b + carry) / 10;
        }
        if(carry>0)
            sum.append(carry);

        return sum.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(new Solution().addStrings("3876620623801494171", "6529364523802684779"));

    }
}
