package interview.code_0903_贝壳找房;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0903_贝壳找房\\input2.txt")));
        long n = in.nextInt();
        long m = in.nextInt();

        boolean deOne = true;
        int count = 0;
        HashSet<Long> set = new HashSet<>();

        int test = 0;
        while (n != m) {

            set.add(n);
            if (deOne) {
                n = n - 1;
                deOne = false;
            } else {
                n = n * 2;
                deOne = true;
            }
            count++;
            if(n > m+1){
                return;
            }
            if(n > 500000000){
                return;
            }

//            System.out.println("N当前值"+test+"："+n);
//            test++;
        }
        System.out.print(count);
    }
}
