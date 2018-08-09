package data_structure.dp.knapsack;

/**
 * @author Created By Frank
 * @date 2018-08-04 20:55
 */

import utils.PrintHelper;

import java.util.Arrays;

/**
 * 背包问题
 * 记忆化搜索
 * 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
 * 空间复杂度: O(n * C)
 */
public class Solution01 {
    private static int count = 0;
    private static int[][] memo;

    public int knapsack(int[] w, int[] v, int C) {
        int n = w.length;
        memo = new int[n][C + 1];
        for(int i = 0;i<n;i++)
            Arrays.fill(memo[i],-1);

        return bestValue(w, v, n - 1, C);
    }

    // 用 [0...index]的物品,填充容积为c的背包的最大价值
    private int bestValue(int[] w, int[] v, int i, int C) {
        count++;
        if (i < 0 || C <= 0)
            return 0;

        if (memo[i][C] != -1) // 记忆化搜索
            return memo[i][C];

        int res = 0;
        res = bestValue(w, v, i - 1, C);
        if (C >= w[i])
            res = max(res, v[i] + bestValue(w, v, i - 1, C - w[i]));

        return memo[i][C] = res;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        int[] w = {1,2,3};
        int[] v = {6,10,12};
        int C = 5;
        System.out.println(new Solution01().knapsack(w, v, C));
        System.out.println("count of bestValue() exec：" + count);
        PrintHelper.print2DArray(memo);
    }
}
