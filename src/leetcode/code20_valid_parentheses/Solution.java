package leetcode.code20_valid_parentheses;

import java.util.Stack;

/**
 * @author Created By Frank
 * @date 2018-06-21 20:10
 */

//20. 有效的括号 - LeetCode (中国)
//https://leetcode-cn.com/problems/valid-parentheses/description/

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;

                char topch = stack.pop();
                if (ch == ']' && topch != '[')
                    return false;
                if (ch == ')' && topch != '(')
                    return false;
                if (ch == '}' && topch != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("[[]]"));
        System.out.println(new Solution().isValid("[[]][["));
    }
}
