package data_structure.dp.knapsack;

/**
 * @author Created By Frank
 * @date 2018-08-04 21:31
 */


/**
 * 背包问题
 * 动态规划改进: 滚动数组
 * 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
 * 空间复杂度: O(C), 实际使用了2*C的额外空间
 */

public class Solution03 {
    public int knapsack(int[] w, int[] v, int C) {
        int n = w.length;
        int[][] memo = new int[n][C + 1];

        if (n == 0 || C == 0)
            return 0;

        for (int j = 0; j <= C; j++)
            memo[0][j] = (j >= w[0] ? v[0] : 0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i]) {
                    memo[i][j] = max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
                }
            }
        }

        return memo[n - 1][C];
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }


    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int C = 5;
        System.out.println(new Solution03().knapsack(w, v, C));
    }
}
