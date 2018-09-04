package interview.code_0904_携程;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0904_携程\\input1.txt")));
        long n = in.nextLong();
        int res = NumberOf1(n);
        System.out.print(res);
    }

    public static int NumberOf1(long n) {
        String bstr = Long.toBinaryString(n);
        int res = 0;
        for (int i = 0; i < bstr.length(); i++) {
            char ch = bstr.charAt(i);
            if (ch == '1') {
                res++;
            }
        }
        return res;
    }
}
