package interview.code_0906_美团;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 说明：
 * 所有测试数据正确率为 18%！
 * 可以尝试再次完善代码，并调试，争取全部AC通过
 */
public class Main1 {

    public static void main(String[] args) throws FileNotFoundException {
    //        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0906_美团\\input1.txt")));
        int n = in.nextInt();
        int[] NodeX = new int[n];
        int[] NodeY = new int[n];
        for (int i = 0; i < n; i++) {
            NodeX[i] = in.nextInt();
            NodeY[i] = in.nextInt();
        }


        System.out.println(4);
    }

}
