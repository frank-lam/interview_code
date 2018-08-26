package leetcode.code204_count_primes;

/**
 * 超出时间限制 最后执行的输入：1500000 Time: 0.560414072s
 */
class Solution1 {
    public int countPrimes(int n) {
        int count = 0;
        for(int i = 2;i<n;i++){
            if(isPrimeNumber(i)){
                count++;
            }
        }
        return count;
    }

    public boolean isPrimeNumber(int n) {
        double sqrtn = Math.sqrt(n*1.0);
        if (n == 0 || n == 1)
            return false;

        for (int i = 2; i <= sqrtn; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
//        System.out.println(new Solution1_递归方法().countPrimes(1500000));
        long endTime  = System.nanoTime();
        System.out.println("Time: " + (endTime-startTime)/1000000000.0 + "s");

    }
}