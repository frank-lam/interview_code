package interview.code_0903_贝壳找房;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0903_贝壳找房\\input1.txt")));
        int n = in.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int h = in.nextInt();
            start[i] = x + 1;
            end[i] = x + h - 1;
            list.add(x);
        }

        for (int i = 0; i < n; i++) {
            int count = getPushSize(start, end, list, i);
            if(i != n-1){
                System.out.print(count + " ");
            }
            else{
                System.out.print(count);
            }
        }
    }

    private static int getPushSize(int[] start, int[] end, ArrayList<Integer> list, int index) {
        int res = 1;
        int x = start[index];
        int y = end[index];

        for (int i = 0; i < list.size(); i++) {
            int item = list.get(i);
            if (item >= x && item <= y) {
                res++;
            }
        }
        return res;
    }


}
