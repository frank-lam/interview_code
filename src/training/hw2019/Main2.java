package training.hw2019;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-09 15:43
 */
public class Main2 {

    private static int count = 0;
    private static int[][] memo;

    public int knapsack(int[] w, int[] v, int C) {
        int n = w.length;
        memo = new int[n][C + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);

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

    public static void main(String[] args) throws FileNotFoundException {
        //        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\training\\hw2019\\input2.txt")));
        String valueStr = in.nextLine();
        String weightStr = in.nextLine();
        int C = in.nextInt();
        int n = valueStr.split(",").length;

        int[] v = new int[n];
        int[] w = new int[n];


        String[] value = valueStr.split(",");
        String[] weight = weightStr.split(",");

        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(value[i]);
            w[i] = Integer.parseInt(weight[i]);
        }

        int bestValue = new Main2().knapsack(w,v,C);

        System.out.println(bestValue);
    }
}
