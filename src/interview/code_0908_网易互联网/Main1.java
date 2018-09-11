package interview.code_0908_网易互联网;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0908_网易互联网\\template2\\input1.txt")));
        String line = in.nextLine();
        int w = 0;
        int b = 0;
        int res = 0;
        if(line.length() == 0){
            System.out.println(0);
            return;
        }

        char[] arr = line.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch == 'w') {
                w++;
            }
            if (ch == 'b') {
                b++;
            }
        }

        if(w == 0 || b==0){
            res = 0;
            System.out.println(res);
            return;
        }

        res = Math.min(w, b)*2 + 1;

        System.out.println(res);

    }


}
