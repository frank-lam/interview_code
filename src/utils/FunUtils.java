package utils;

/**
 * @author Created By Frank
 * @date 2018-08-05 18:18
 */
public  class FunUtils {


    public static void swap(int[] fighting, int i, int j) {
        int k = fighting[i];
        fighting[i] = fighting[j];
        fighting[j] = k;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static long max(long a, long b) {
        return a > b ? a : b;
    }
}
