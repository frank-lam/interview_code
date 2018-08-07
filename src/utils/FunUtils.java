package utils;

import java.util.regex.Pattern;

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


    /*方法二：推荐，速度最快
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
