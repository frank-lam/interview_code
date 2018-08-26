package sword_offer.code10_斐波那契数列系列.斐波那契数列;

import java.util.Arrays;

public class Solution2_记忆化搜索 {

    private int num = 0;

    public int Fibonacci(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fib(n, memo);
    }

    public int fib(int n, int[] memo){
        num ++;
        if(n == 0)
            return 0;

        if(n == 1)
            return 1;

        if(memo[n] == -1)
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);

        return memo[n];
    }


}