package interview.code_0908_招银网络;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();


        for (int i = 0; i <= n; i++) {
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            for (int j = i + 1; i <= n; j++) {
                sum = sum + j;
                list.add(j);
                if(sum == n){
                    System.out.println(list);
                }
                else if(sum > n){
                    break;
                }
            }
        }
    }

}
