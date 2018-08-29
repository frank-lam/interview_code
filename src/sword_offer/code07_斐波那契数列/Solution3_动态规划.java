package sword_offer.code07_斐波那契数列;

import java.util.Arrays;

public class Solution3_动态规划 {
    public static int Fibonacci(int n) {
        int[] memo = new int[n + 2];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2 ; i <= n ; i ++)
            memo[i] = memo[i - 1] + memo[i - 2];

        return memo[n];

    }

    public static void main(String[] args){
        System.out.println(Fibonacci(0));
    }
}