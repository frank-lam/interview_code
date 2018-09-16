package interview.code_0915_爱奇艺;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0915_爱奇艺\\input1.txt")));
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> dolist = new ArrayList<>();

        String number = in.nextLine();

        for (int i = 0; i < 3; i++) {
            int nownumber = number.charAt(i) - '0';
            list1.add(nownumber);
        }
        for (int i = 3; i < 6; i++) {
            int nownumber = number.charAt(i) - '0';
            list2.add(nownumber);
        }
        Collections.sort(list1);
        Collections.sort(list2);
//        System.out.println("list1 :" + list1);
//        System.out.println("list2 :" + list2);

        int s1 = getsum(list1);
        int s2 = getsum(list2);
        int max = Math.max(s1,s2);



        if(s1<s2){
            dolist = list1;
        }
        else if(s1>s2) {
            dolist = list2;
        }
        else{
            System.out.println(0);
            return;
        }


        int count = 0;
        int counttwo = 0;

        // 最多进行三次操作
        for (int i = 0; i <3; i++) {
            int currentNumber = dolist.get(i);
            for (int k = currentNumber + 1; k <= 9; k++) {
                dolist.set(i,k);
                int sum = getsum(dolist);

                if(sum < max && k == 9){
                    count++;
                }
                if(sum == max){
//                    System.out.println("dolist ：" + dolist);
                    count++;
                    if(sum == max){
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static int getsum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        return sum;
    }


}
