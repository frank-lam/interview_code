package interview.code_20180830_拼多多正式;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-04 10:35
 * 65%
 */
public class Main1 {
    public static List<List<Integer>> reslist;


    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_20180830_拼多多正式\\input1.txt")));

        int hp = in.nextInt();
        int normal = in.nextInt();
        int buffed = in.nextInt();

        LinkedList<Integer> p = new LinkedList<>();
        reslist = new ArrayList<>();
        attack(hp, normal, buffed, p);

        int min = 0;
        for (int i = 0; i < reslist.size(); i++) {
            if(i == 0){
                min = getcount((LinkedList<Integer>) reslist.get(i),normal,buffed);
            }
            else{
                if(min > getcount((LinkedList<Integer>) reslist.get(i),normal,buffed)){
                    min = getcount((LinkedList<Integer>) reslist.get(i),normal,buffed);
                }
            }
//            System.out.println(getcount((LinkedList<Integer>) reslist.get(i),normal,buffed));
        }

        System.out.print(min);
    }

    private static void attack(int hp, int normal, int buffed, LinkedList<Integer> p) {
        if (sum(p) >= hp) {
            reslist.add((List<Integer>) p.clone());
            return;
        }
        p.add(normal);
        attack(hp, normal, buffed, p);
        p.removeLast();

        p.add(buffed);
        attack(hp, normal, buffed, p);
        p.removeLast();

        return;
    }

    public static int sum(LinkedList<Integer> s) {
        int res = 0;
        for (int i = 0; i < s.size(); i++) {
            res += s.get(i);
        }
        return res;
    }
    public static int getcount(LinkedList<Integer> s,int normal,int buffed) {
        int res = 0;
        for (int i = 0; i < s.size(); i++) {
            if(s.get(i) == buffed){
                res +=2;
            }
            else
                res++;
        }
        return res;
    }

}
