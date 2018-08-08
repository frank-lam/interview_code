package training.wy_game_2018;

/**
 * @author Created By Frank
 * @date 2018-08-07 15:13
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main3_demo {
    public static int sum = 0;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new BufferedReader(
                new FileReader("D:\\gitdoc\\interview_code\\src\\training\\wy_game_2018\\input3.txt")
        ));

        int group_Num = sc.nextInt();
        for (int i = 0; i < group_Num; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            char[][] chars = new char[row][col];
            for (int j = 0; j < row; j++) {
                String str = sc.next();
                for (int k = 0; k < col; k++) {
                    chars[j][k] = str.charAt(k);
                }
            }
            String word = sc.next();
            for (int l = 0; l < row; l++) {
                for (int m = 0; m < col; m++) {
                    if (chars[l][m] == word.charAt(0)) {
                        match_right(word, l, m, chars, row, col);
                        match_down(word, l, m, chars, row, col);
                        match_rightdown(word, l, m, chars, row, col);
                    }
                }
            }
            System.out.println(sum);
            sum = 0;
        }
    }

    public static void match_right(String word, int i, int j, char[][] chars, int row, int col) {
        if (col - j < word.length()) return;
        for (int n = 0; n < word.length(); n++) {
            if (word.charAt(n) != chars[i][j + n]) return;
        }
        sum++;
    }

    public static void match_down(String word, int i, int j, char[][] chars, int row, int col) {
        if (row - i < word.length()) return;
        for (int n = 0; n < word.length(); n++) {
            if (word.charAt(n) != chars[i + n][j]) return;
        }
        sum++;
    }

    public static void match_rightdown(String word, int i, int j, char[][] chars, int row, int col) {
        if (col - j < word.length() || row - i < word.length()) return;
        for (int n = 0; n < word.length(); n++) {
            if (word.charAt(n) != chars[i + n][j + n]) return;
        }
        sum++;
    }
}