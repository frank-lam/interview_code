package nowcoder.pdd2018;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by jason on 2018/6/26.
 */
public class Main2 {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\nowcoder\\pdd2018\\input2.txt")));

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextInt(); // x
            points[i][1] = scanner.nextInt(); // y
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((points[i][1] - points[j][1]) * (points[k][0] - points[j][0]) != (points[k][1] - points[j][1]) * (points[i][0] - points[j][0])) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}