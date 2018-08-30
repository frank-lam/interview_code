package interview.code_20180809_网易游戏内推;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-09 18:31
 */
public class Main1 {
    public static void main(String[] args) throws FileNotFoundException {
        //        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_20180809_网易游戏内推\\input1.txt")));
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            long fee = getFee(arr[i]);
            System.out.println(fee);
        }
    }

    private static long getFee(int money) {
        double[] fee = {
                3000 * 0.03,
                (12000 - 3000) * 0.1,
                (25000 - 12000) * 0.2,
                (35000 - 25000) * 0.25,
                (55000 - 35000) * 0.3,
                (80000 - 55000) * 0.35
        };

        if (money <= 5000) {
            return 0;
        }
        money = money - 5000;

        double res = 0;
        if (money >= 80000) {
            res = sum(fee, 5) + (money - 80000) * 0.45;
        }
        if (55000 <= money && money < 80000) {
            res = sum(fee, 4) + (money - 55000) * 0.35;
        }

        if (35000 <= money && money < 55000) {
            res = sum(fee, 3) + (money - 35000) * 0.3;
        }

        if (25000 <= money && money < 35000) {
            res = sum(fee, 2) + (money - 25000) * 0.25;
        }

        if (12000 <= money && money < 25000) {
            res = sum(fee, 1) + (money - 12000) * 0.2;
        }
        if (3000 <= money && money < 12000) {
            res = sum(fee, 0) + (money - 3000) * 0.1;
        }
        if (money < 3000) {
            res = money * 0.03;
        }


        return Math.round(res);
    }

    private static double sum(double[] fee, int index) {
        double res = 0;
        for (int i = 0; i <= index; i++) {
            res += fee[i];
        }
        return res;
    }
}