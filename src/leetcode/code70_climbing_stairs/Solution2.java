package leetcode.code70_climbing_stairs;

/**
 * @author Created By Frank
 * @date 2018-07-12 9:17
 */
public class Solution2 {
    public int climbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;
        if (n == 2)
            return 2;

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static void main(String[] args) {

        System.out.println(new Solution2().climbStairs(0));
    }
}