package leetcode.code70_climbing_stairs;

/**
 * 爬楼梯 - LeetCode (中国)
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 */

/**
 * 自顶向下 记忆化搜索实现
 */

class Solution {
    public static int[] stairsArr;

    public int climbStairs(int n) {
        stairsArr = new int[n+1];
        for (int i = 0; i < stairsArr.length; i++) {
            stairsArr[i] = -1;
        }
        return calways(n);
    }

    private int calways(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(stairsArr[n] == -1){
            stairsArr[n] = calways(n-1)+calways(n-2);
        }
        return stairsArr[n];
    }


    public static void main(String[] args){
        int N = 3;
        System.out.println(new Solution().climbStairs(N));
    }
}