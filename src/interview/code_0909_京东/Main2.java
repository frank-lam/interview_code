package interview.code_0909_京东;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0909_京东\\input2.txt")));

        int n = in.nextInt();
        int resCount = 0;

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            c[i] = in.nextInt();
        }

        // 开始判断
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            int bi = b[i];
            int ci = c[i];

            for (int j = 0; j < n; j++) {
                int aj = a[j];
                int bj = b[j];
                int cj = c[j];
                if (aj > ai && bj > bi && cj > ci) {
                    resCount++;
                    break;
                }
            }
        }

        System.out.println(resCount);
    }
}
