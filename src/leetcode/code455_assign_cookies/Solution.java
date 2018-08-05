package leetcode.code455_assign_cookies;

/**
 * @author Created By Frank
 * @date 2018-08-04 11:22
 */

import java.util.Arrays;

/**
 * 分发饼干 (Assign Cookies) - 领扣 (LeetCode)
 * https://leetcode-cn.com/problems/assign-cookies/description/
 */

public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        for (int i = g.length - 1; i >= 0; i--) {
            for (int j = s.length - 1; j >= 0; j--) {
                if(s[j] >= g[i]){
                    res ++;
                    s[j] = 0;
                    break;
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int res =  new Solution().findContentChildren(new int[]{1,2,3}, new int[]{3});
        System.out.println(res);
    }
}
