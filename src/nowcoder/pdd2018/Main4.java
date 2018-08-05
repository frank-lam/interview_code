package nowcoder.pdd2018;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-05 18:08
 */
public class Main4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        // 这里设置输入输出文件，方便长出入调试使用
//        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\nowcoder\\pdd2018\\input4.txt")));
        int n = in.nextInt();


        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextLong());
        }
        Collections.sort(list);

        int size = list.size();
        long res = 0;
        long max3 = list.get(size - 1) * list.get(size - 2) * list.get(size - 3);
        long min2max1 = list.get(0) * list.get(1) * list.get(size-1);
        res = max(max3,min2max1);

        System.out.println(res);
    }

    public static long max(long a, long b) {
        return a > b ? a : b;
    }
}
