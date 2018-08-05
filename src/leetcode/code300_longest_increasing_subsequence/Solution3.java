package leetcode.code300_longest_increasing_subsequence;

/**
 * @author Created By Frank
 * @date 2018-08-05 10:53
 */

/**
 * 最长公共子序列
 */
public class Solution3 {

    public int LCS(String s1, String s2) {
        return bestLength(s1, s2, s1.length() - 1, s2.length() - 1);
    }

    public int bestLength(String s1, String s2, int m, int n) {
        if (m < 0 || n < 0)
            return 0;
        int lcs = 0;
        if (s1.charAt(m) == s2.charAt(n)) {
            lcs = 1 + bestLength(s1, s2, m - 1, n - 1);
        } else {
            lcs = max(bestLength(s1, s2, m - 1, n), bestLength(s1, s2, m, n - 1));
        }
        return lcs;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().LCS("ABCDEE", "ABDCEE"));
    }
}
