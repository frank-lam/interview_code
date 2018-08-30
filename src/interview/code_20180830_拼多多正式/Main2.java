package interview.code_20180830_拼多多正式;

import utils.PrintHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-04 10:35
 */
public class Main2 {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_20180830_拼多多正式\\input2.txt")));
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        char[][] block = new char[m][n];

        for (int i = 0; i < m; i++) {
            String line = in.nextLine();
            for (int j = 0; j < n; j++) {
                block[i][j] = line.charAt(j);
            }
        }

        PrintHelper.print2DArray(block);

        for (int i = m-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (block[i][j] == 'o') {
                    moveBlock(block, i, j);
                }
            }
        }
        System.out.println("------------------");
        PrintHelper.print2DArray(block);
//
//
//        for (int i = 0; i < block.length; i++) {
//            for (int j = 0; j < block[i].length; j++) {
//                System.out.print(block[i][j]);
//            }
//            if(i != block.length - 1 ){
//                System.out.println();    //换行
//            }
//        }
    }

    private static void moveBlock(char[][] block, int x, int y) {
        int m = block.length;
        for (int i = x; i < m; i++) {
//            System.out.println("正在处理" + i+","+y+"元素");
            if(i + 1 == m && block[i][y] == 'o' ){
                block[i][y] = '.';
                return;
            }
            if (block[i + 1][y] == '.') {
                block[i + 1][y] = 'o';
                block[i][y] = '.';
            }
            if(block[i + 1][y] == 'x'){
                return;
            }
        }
    }


}
