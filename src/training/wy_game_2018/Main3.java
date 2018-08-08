package training.wy_game_2018;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-08 8:34
 */
public class Main3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\training\\wy_game_2018\\input3.txt")));

        int t = in.nextInt();
        in.nextLine();

        for (int s = 0; s < t; s++) {

            int res = 0;
            int m = in.nextInt();
            int n = in.nextInt();
            char[][] board = new char[m][n];
            in.nextLine();

            for (int i = 0; i < m; i++) {
                String linestr = in.nextLine();
                char[] arr = linestr.toCharArray();
                for (int j = 0; j < n; j++) {
                    board[i][j] = arr[j];
                }
            }
            String word = in.nextLine();


            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (scanRight(board, i, j, word))
                        res++;
                    if (scanDown(board, i, j, word))
                        res++;
                    if (scanRD(board, i, j, word))
                        res++;
                }
            }
            System.out.println(res);
        }
    }

    private static boolean scanRD(char[][] board, int x, int y, String word) {
        int len = word.length();
        if (!inArea(x + len - 1, y + len - 1, board)) {
            return false;
        }
        StringBuffer sbf = new StringBuffer();
        for (int xs = x, ys = y; xs < x + len; xs++, ys++) {
            sbf.append(board[xs][ys]);
        }
        return word.equals(sbf.toString());
    }

    private static boolean scanDown(char[][] board, int x, int y, String word) {
        int len = word.length();
        if (!inArea(x + len - 1, y, board)) {
            return false;
        }
        StringBuffer sbf = new StringBuffer();
        for (int index = x; index < x + len; index++) {
            sbf.append(board[index][y]);
        }
        return word.equals(sbf.toString());
    }


    private static boolean scanRight(char[][] board, int x, int y, String word) {
        int len = word.length();
        if (!inArea(x, y + len - 1, board)) {
            return false;
        }

        StringBuffer sbf = new StringBuffer();
        for (int index = y; index < y + len; index++) {
            sbf.append(board[x][index]);
        }
        return word.equals(sbf.toString());
    }

    private static boolean inArea(int x, int y, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}