package training.hw2019;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-09 15:25
 */
public class Main1 {


    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\training\\hw2019\\input2.txt")));
        String str = in.nextLine();
        int n = str.length();
        char[] ch = str.toCharArray();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < n; i++) {
            char c = ch[i];
            if((c >= 'a' && c<='z')|| (c >= 'A' && c<='Z'))
                res.append(Character.toUpperCase(c));
            else
                res.append(c);
        }

        System.out.println(res.toString());
    }
}
