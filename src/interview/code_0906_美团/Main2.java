package interview.code_0906_美团;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 说明：
 * 所有测试数据正确率为 82%！
 * 可以尝试再次完善代码，并调试，争取全部AC通过
 *
 * 温馨提示：有时候，申请大的全局数组会导致超时，如果有此类情况，请检查您的全局数组是否超过题目要求的内存大小。
 *  * 排除这个错误后，再检查别的情况引起的超时错误：例如死循环、循环结束条件错误等，或者需要更好的算法！
 */
public class Main2 {
    public static int calcount = 0;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0906_美团\\input2.txt")));
        int n, t, k;
        n = in.nextInt();
        k = in.nextInt();
        t = in.nextInt();
        if (n == 0 ) {
//            System.out.println(0);
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }


        int l0 = 0;
        int r0 = n - 1;
        if (r0 - l0 + 1 < k) {
            System.out.println(0);
            return;
        }


        int count = 0;

        for (int left = 0; left < n; left++) {
            int right = k + left - 1;
            if (right >= n) {
                break;
            }
            if (checkValid(left, right, t, arr)) {
                count++;
            }
        }
        System.out.println(count);
//        System.out.println("calcount: "+calcount);

    }

    private static boolean checkValid(int l, int r, int t, int[] arr) {
        calcount++;
        for (int index = l; index <= r; index++) {
            int count = 0;
            int now = arr[index];
            for (int i = l; i <= r; i++) {
                if (now == arr[i]) {
                    count++;
                }
            }
            if (count >= t) {
                return true;
            }
        }
        return false;
    }
}
