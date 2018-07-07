package leetcode.code204_count_primes;

/**
 * @author Created By Frank
 * @date 2018-07-07 10:42
 */


/**
 * 计数质数 - LeetCode (中国)
 * https://leetcode-cn.com/problems/count-primes/description/
 * <p>
 * 判断一个数是不是素数 埃拉托斯特尼筛法 时间复杂度 O(n*lglgn) - CSDN博客
 * https://blog.csdn.net/x_i_y_u_e/article/details/46365549
 */

public class Solution {

    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n + 1]; // 此时都是false，表示全部都不是质数
        for (int i = 0; i < n; i++) { //初始化都为素数
            isPrime[i] = true;
        }


        //从2开始，将素数的倍数标记为非素数
        //从i的平方开始标记即可，不需要从i*j(且j<i)开始，因为i*j至少在遇到j时已经被标记过了
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) { // 不是质数
                continue;
            }

            //不是素数，说明i可以分解为两个因子相乘，那么在遇到这两个因子的较小者时，i的倍数已经被标记过
            for (long j = (long) (i) * i; j < n; j += i) {
                isPrime[(int) j] = false;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(499979));
    }


}
