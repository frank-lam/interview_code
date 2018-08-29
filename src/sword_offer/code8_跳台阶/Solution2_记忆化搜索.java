package sword_offer.code10_斐波那契数列系列.跳台阶;

import java.util.Arrays;

public class Solution2_记忆化搜索 {

    public static int JumpFloor(int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return jump(target, memo);
    }

    public static int jump(int target, int[] memo) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }

        if (memo[target] == -1) {
            memo[target] = jump(target - 1, memo) + jump(target - 2, memo);
        }
        return memo[target];
    }


    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(JumpFloor(45));
        long end = System.nanoTime();

        System.out.println((end - start) / 1000000000.0 + " s");
    }
}