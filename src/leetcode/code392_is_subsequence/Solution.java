package leetcode.code392_is_subsequence;

/**
 * @author Created By Frank
 * @date 2018-08-05 16:06
 */

/**
 * 判断子序列 (Is Subsequence) - 领扣 (LeetCode)
 * https://leetcode-cn.com/problems/is-subsequence/description/
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        char[] ss = s.toCharArray(), tt = t.toCharArray();


        int resCount = 0;


        for (int i = 0, j = 0; i < ss.length; i++) {
            while (j < tt.length) {
                if (ss[i] == tt[j]) {
                    resCount++;
                    j++;
                    break;
                }
                j++;
            }

        }


        if (resCount == ss.length) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSubsequence2(String s, String t) {
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int i, j = 0;
        for (i = 0; i < ss.length; i++) {
            while (j < tt.length && tt[j] != ss[i])
                j++;
            if (j == tt.length)
                return false;
            j++;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("acb", "ahbgdc"));
    }
}
