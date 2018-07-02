package leetcode.code804_unique_morse_code_words;

/**
 * @author Created By Frank
 * @date 2018-07-02 17:24
 */

import java.util.TreeSet;

/**
 * 唯一摩尔斯密码词 - LeetCode (中国)
 * https://leetcode-cn.com/problems/unique-morse-code-words/description/
 */
public class Solution {

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        TreeSet<String> set = new TreeSet<>();

        for(String word:words){
            StringBuffer str = new StringBuffer();
            for(int i = 0;i<word.length();i++){
                str.append(codes[word.charAt(i)-'a']);
            }
            set.add(str.toString());
        }
        return set.size();
    }

    public static void main(String[] args){
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(new Solution().uniqueMorseRepresentations(words));
    }
}
