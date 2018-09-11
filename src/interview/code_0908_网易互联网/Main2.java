package interview.code_0908_网易互联网;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0908_网易互联网\\template2\\input2.txt")));
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            long k = in.nextLong();
            long min = 0;
            long max = 0;
//            StringBuilder sb = new StringBuilder();
//            ArrayList<Character> list = new ArrayList<>();

//            System.out.println("n: " + n + ",k: " + k);

            long kcount = k;
            long othercount = Math.min(n - k, k + 1);
            boolean do1 = false;
            boolean do2 = false;
            boolean do3 = false;

            if (n > 2 * k) {
                max= k-1;

            }
            else{
                while ((kcount > 0 && othercount > 0) && n != k) {
                    if (kcount > 0 && othercount > 0) {
//                    list.add('#');
//                    list.add('-');

                        kcount--;
                        othercount--;

                        if (kcount > 0) {
                            max++;
                        } else {
                            break;
                        }
                    }
                    if (kcount == 0 && othercount > 0) {
//                    sb.append("-");
//                    list.add('-');

                        othercount--;
                    }
                    if (kcount > 0 && othercount == 0) {
//                    list.add('#');
                        kcount--;
                    }
                }
            }


            System.out.println(min + " " + max);
        }
    }
}
