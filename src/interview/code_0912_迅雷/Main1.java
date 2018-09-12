package interview.code_0912_迅雷;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int maxnum = in.nextInt();
        int count = 0;

        for (int i = 1; i <= maxnum; i++) {
            for (int j = i; j <= maxnum; j++) {
                for (int k = j + 1; k <= maxnum; k++) {
                    if ((i * i + j * j) == k * k) {
                        if (check(i, j) && check(j, k) && check(i, k))
                            count++;
                    }
                }
            }
        }
        System.out.println(count);
    }


    // 下面这个是判断两个数是不是互质数
    public static boolean check(int m, int n) {
        return check2(m > n ? m : n, m <= n ? m : n);
    }

    public static boolean check2(int max, int min) {
        int mo = max % min;
        if (mo == 0) {
            return min == 1 ? true : false;
        } else {
            return check2(min, mo);
        }
    }

}
