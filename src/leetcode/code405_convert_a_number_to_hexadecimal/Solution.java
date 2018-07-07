package leetcode.code405_convert_a_number_to_hexadecimal;

/**
 * @author Created By Frank
 * @date 2018-07-07 12:00
 */

import java.util.Stack;

/**
 * 数字转换为十六进制数 - LeetCode (中国)
 * https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/description/
 */
public class Solution {

    public String toHex(int num) {

        if (num == 0)
            return "0";
        Stack<Character> stack = new Stack<>();
        Character[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        int count = 0; // 用来记录是否已经到第32位
        while (num != 0 && count<8 ) {
            char c = map[num & 0xf];
            stack.push(c); // 查表，并入栈
            num = num >> 4; // 右移四位
            count++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb = sb.append(stack.pop());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().toHex(-1));
    }
}
