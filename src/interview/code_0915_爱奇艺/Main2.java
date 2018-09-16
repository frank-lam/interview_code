package interview.code_0915_爱奇艺;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0915_爱奇艺\\input2.txt")));
        int n = in.nextInt(); // 有几种食物
        int m = in.nextInt(); // 吃或者买，m次
        int p = in.nextInt(); // p的排名

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, in.nextInt());
        }

        in.nextLine();
        for (int i = 0; i < m; i++) {
            String line = in.nextLine();
            String op = line.split(" ")[0];
            int key = Integer.valueOf(line.split(" ")[1]);
            if (op.equals("A")) { // 买一份
                map.put(key, map.get(key) + 1);

            } else { // 吃一份
                map.put(key, map.get(key) - 1);
            }
        }

        System.out.println(map);
        // 开始排序
        int now = map.get(p);
        int rank = 1;
        for (int i = 1; i <= n; i++) {
            int mapnum = map.get(i);
            if(mapnum > now){
                rank++;
            }
        }
        System.out.println(rank);
    }
}
