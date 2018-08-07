package interview.pdd_20180805;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-05 18:52
 */
public class Main2 {

    public static List<List<String>> list = new ArrayList<>();
    public static List<List<String>> temp = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        //        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\pdd_20180805\\input2.txt")));
        String str = in.nextLine();

        int res = 0;

        int n = str.length();
        for (int i = 1; i < n; i++) {
            List<String> item = new ArrayList<>();
            String a = str.substring(0,i);
            String b = str.substring(i);
            item.add(a);
            item.add(b);
            boolean check = checkItem(a,b);

            if(check)
                list.add(item);
        }

        for(List<String> item : list){
            String s1 = item.get(0);
            String s2 = item.get(1);
//            if(result.size()>0){
//                list.addAll(result);
//            }
        }


        System.out.println(list);
    }





    private static boolean checkItem(String a, String b) {
        if(a.length() >=2 && Integer.valueOf(a) == 0){
            return false;
        }
        if(b.length() >=2 && Integer.valueOf(b) == 0){
            return false;
        }
        return true;
    }



}
