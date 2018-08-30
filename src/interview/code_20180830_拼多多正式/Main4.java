package interview.code_20180830_拼多多正式;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-04 10:35
 * 25%
 */
public class Main4 {
    public static ArrayList<String> createStr;
    public static ArrayList<String> leters;
    public static ArrayList<String> alreadyStr;


    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_20180830_拼多多正式\\input4.txt")));

        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        alreadyStr = new ArrayList<>();
        createStr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String word = in.nextLine();
            alreadyStr.add(word);
        }

        int wordCount = alreadyStr.size(); // 单词个数
        int wordLenth = alreadyStr.get(0).length(); // 单词长度
        leters = new ArrayList<>();
        for (int i = 0; i < wordLenth; i++) {
            StringBuffer sb2 = new StringBuffer();
            for (int j = 0; j < wordCount; j++) {
                sb2.append(alreadyStr.get(j).charAt(i));
            }
            leters.add(sb2.toString());
        }

        createStrMeth(wordLenth, 0, "");
        Collections.sort(createStr);

        if (createStr.size() > 0) {
            System.out.print(createStr.get(0));
        } else {
            System.out.print("-");
        }
    }

    // index 代表索引到哪一个单词了
    public static void createStrMeth(int wordLenth, int index, String s) {
        if (index == wordLenth) { // 单词长度
            if (!alreadyStr.contains(s)) {
                createStr.add(s);
            }
            return;
        }
        for (int i = 0; i < leters.get(index).length(); i++) {
            createStrMeth(wordLenth, index + 1, s + leters.get(index).charAt(i));
        }
        return;
    }
}
