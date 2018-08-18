package training.train_20180818;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * @author Created By Frank
 * @date 2018-08-18 20:05
 */
public class Main1 {
    public static void main(String[] args) throws FileNotFoundException {
        //        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\training\\train_20180818\\input1.txt")));

        String str = in.nextLine();

        List<Character> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        char[] strCh = str.toCharArray();
        for (int i = 0; i < strCh.length; i++) {
            char ch = strCh[i];
            if (ch == 'A') {
                list2.add(1);
            } else if (ch == 'T') {
                list2.add(10);
            } else if (ch == 'J') {
                list2.add(11);
            } else if (ch == 'Q') {
                list2.add(12);
            } else if (ch == 'K') {
                list2.add(13);
            } else {
                list2.add(ch - '0');
            }
        }
        Collections.sort(list2);
        System.out.println(list2);
        int count = playCard(list2);
        System.out.println(count);
    }

    private static int playCard(List<Integer> cards) {

        int count = 0;

        if (cards.size() == 0) {
            return 0;
        }

        // 5.打顺子
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < cards.size(); i++) {
            int valueLen = 0;
            for (int j = 0; j < cards.size(); j++) {
                if(cards.contains(cards.get(i)+j)){
                    valueLen++;
                }
                else{
                    break;
                }
            }
            hashMap.put(cards.get(i), valueLen);
        }
        System.out.println(hashMap);


        return 0;
    }
}