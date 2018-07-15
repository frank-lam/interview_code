package leetcode.code17_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created By Frank
 * @date 2018-07-15 16:59
 */

/**
 * 电话号码的字母组合 - LeetCode (中国)
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 */


public class Solution2 {
    public String[] numsMap = {" ","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};  //  2-9
    public List<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<>();
        if (digits.equals(""))
            return res;

        findCombination(digits, 0, "");
        return res;
    }

    // 这里是一个深度优先（DFS）遍历的递归算法
    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letter = numsMap[c - '0'];

        for (int i = 0; i < letter.length(); i++) {
            findCombination(digits, index+1, s+letter.charAt(i));
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution2().letterCombinations(""));
//        System.out.println();
    }
}
