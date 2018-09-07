package interview.code_0907_科大讯飞;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
public class Main2 {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0907_科大讯飞\\input2.txt")));
        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        boolean doit = true;
        int count = 0;
        ArrayList<Integer> next = list;

        while (doit) {
            ArrayList<Integer> nextList = new ArrayList<>();
            nextList.add(list.get(0));

//            if(list.size() == 1){
//                doit = false;
//                break;
//            }
            boolean dofor = false;
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i-1) <= list.get(i)){
                    nextList.add(list.get(i));
                }
            }
            if(nextList.size() == list.size()){
                doit = false;
                break;
            }

            else{
                list = nextList;
                count++;
            }
        }

        System.out.println(count);

    }

}
