package leetcode.code387_first_unique_character_in_a_string;

/**
 * @author Created By Frank
 * @date 2018-07-09 9:54
 */

import java.util.TreeMap;

/**
 * 字符串中的第一个唯一字符 - LeetCode (中国)
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 */

public class Solution {

    public int firstUniqChar(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.get(c) == 1){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("aabb"));
    }
}
