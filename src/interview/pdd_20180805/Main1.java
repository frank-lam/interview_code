package interview.pdd_20180805;


import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-05 18:52
 */
public class Main1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\pdd_20180805\\input2.txt")));

        String str = in.nextLine();
        int size = str.length();
        int len = size/4;

        char[][] input = new char[len + 1][len + 1];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                input[i][j] = ' ';
            }
        }

        for (int i = 0; i < size; i++) {
            char ch = str.charAt(i);
            if (i >= 0 && i < len) {
                input[0][i] = ch;
            }
        }

        for (int i = 0; i < size; i++) {
            char ch = str.charAt(i);
            if (i >= len && i < 2 * len) {
                input[i % (len)][len] = ch;
            }
        }

        for (int i = 0; i < size; i++) {
            char ch = str.charAt(i);
            if (i >= len * 2 && i < 3 * len) {
                input[len][len - i % len] = ch;
            }
        }

        for (int i = 0; i < size; i++) {
            char ch = str.charAt(i);
            if (i >= len * 3 && i < 4 * len) {
                input[len - i % len][0] = ch;
            }
        }

        print2DArray(input);
    }

    public static int sqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int begin = 1;
        int end = x;
        int middle = 0;
        while (begin <= end) {
            middle = begin + (end - begin) / 2;
            //不要写成middle*middle==x，会溢出
            if (middle == x / middle) {
                return middle;
            } else {
                if (middle < x / middle) {
                    begin = middle + 1;
                } else {
                    end = middle - 1;
                }
            }

        }
        //结束条件end一定<begin，所以返回end
        return end;
    }

    public static void print2DArray(char[][] magicSquare) {
        for (int i = 0; i < magicSquare.length; i++) {
            for (int j = 0; j < magicSquare[i].length; j++) {
                char ch = magicSquare[i][j];
                System.out.print(ch);
            }
            if(i+1 != magicSquare.length){ //换行
                System.out.println();
            }
        }
    }
}
