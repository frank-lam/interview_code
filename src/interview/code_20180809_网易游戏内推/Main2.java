package interview.code_20180809_网易游戏内推;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-09 18:51
 */
public class Main2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_20180809_网易游戏内推\\input2.txt")));
        int n = in.nextInt();
        in.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextLine());
        }

        for (int i = 0; i < n; i++) {
            boolean result = checkPassword(list.get(i));
            if (result)
                System.out.print("yes");
            else
                System.out.print("no");
            if(i!=n-1){
                System.out.println();
            }
        }
    }

    private static boolean checkPassword(String s) {
        int n = s.length();
        // 1. 判断长度
        if (s.length() < 8) {
            return false;
        }


        boolean hasUp = false, hasLow = false, hasNum = false, hasSchar = false;
        // 2. 包含判断
        String schar = "!@#$%^&*()_-=+[]{},.<>/?";
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z')
                hasLow = true;
            if (ch >= 'A' && ch <= 'Z')
                hasUp = true;
            if (ch >= '0' && ch <= '9')
                hasNum = true;
            if (schar.contains(String.valueOf(ch)))
                hasSchar = true;
        }
        if (!(hasUp && hasLow && hasSchar && hasNum))
            return false;


        // 3.等差数列数字

        for (int i = 1; i + 1 < n; i++) {
            char c1 = s.charAt(i - 1);
            char c2 = s.charAt(i);
            char c3 = s.charAt(i + 1);
            if (c2 - c1 == c3 - c2 && (isnum(c1) && isnum(c2) && isnum(c3))) {
                return false;
            }
        }


        // 4.三个连续的大写小写字母
        for (int i = 1; i + 1 < n; i++) {
            char c1 = s.charAt(i - 1);
            char c2 = s.charAt(i);
            char c3 = s.charAt(i + 1);
            if (c2 - c1 == 1 && c3 - c2 == 1 && (islow(c1) && islow(c2) && islow(c3))) {
                return false;
            }
            if (c2 - c1 == 1 && c3 - c2 == 1 && (isup(c1) && isup(c2) && isup(c3))) {
                return false;
            }
        }

        // 5.是否包含字符串
        String[] words = {"password", "admin", "qwerty", "hello", "iloveyou", "112233"};
        for (int i = 0; i < words.length; i++) {
            if (s.contains(words[i])) {
                return false;
            }
        }
//        PrintHelper.printArray(words);


        return true;
    }

    private static boolean islow(char c1) {
        if (c1 >= 'a' && c1 <= 'z') {
            return true;
        }
        return false;
    }

    private static boolean isup(char c1) {
        if (c1 >= 'A' && c1 <= 'Z') {
            return true;
        }
        return false;
    }

    private static boolean isnum(char c1) {
        if (c1 >= '0' && c1 <= '9') {
            return true;
        }
        return false;
    }

}
