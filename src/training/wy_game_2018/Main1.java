package training.wy_game_2018;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-07 15:12
 */
public class Main1 {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(
                new FileReader("D:\\gitdoc\\interview_code\\src\\training\\wy_game_2018\\input1.txt")
        ));

        int n = Integer.valueOf(in.nextLine());

        for(int i = 0;i<n;i++){
            String strTime = in.nextLine();
            if (!isValid(strTime)) {
                System.out.println(changeTime(strTime));
            } else {
                System.out.println(strTime);
            }
        }

    }

    // 判断是否有效
    public static boolean isValid(String time) {
        int hours = Integer.valueOf(time.split(":")[0]);
        int mins = Integer.valueOf(time.split(":")[1]);
        int seconds = Integer.valueOf(time.split(":")[2]);

        if (hours >= 0 && hours <= 23 && mins >= 0 && mins <= 59 && seconds >= 0 && seconds <= 59)
            return true;
        return false;
    }


    public static String changeTime(String time) {
        StringBuffer res = new StringBuffer();

        String h = time.split(":")[0];
        String m = time.split(":")[1];
        String s = time.split(":")[2];


        int hours = Integer.valueOf(time.split(":")[0]);
        int mins = Integer.valueOf(time.split(":")[1]);
        int seconds = Integer.valueOf(time.split(":")[2]);

        List<String> list = new ArrayList<>();

        if (hours >= 0 && hours <= 23) {
            res.append(h);
        } else {
            res.append("0");
            res.append(hours % 10);
        }
        res.append(":");

        if (mins >= 0 && mins <= 59) {
            res.append(m);
        } else {
            res.append("0");
            res.append(mins % 10);
        }

        res.append(":");

        if (seconds >= 0 && seconds <= 59) {
            res.append(s);
        } else {
            res.append("0");
            res.append(seconds % 10);
        }
        return res.toString();
    }
}