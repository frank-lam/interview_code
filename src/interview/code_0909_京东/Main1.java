package interview.code_0909_京东;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0909_京东\\input1.txt")));
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {

            ArrayList<ArrayList<Integer>> group = new ArrayList<>();

            int n = in.nextInt(); // 点的个数
            int m = in.nextInt(); // 边的个数
            ArrayList<Integer> v1list = new ArrayList<>();
            ArrayList<Integer> v2list = new ArrayList<>();


            for (int k = 0; k < m; k++) {
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                v1list.add(v1);
                v2list.add(v2);
            }

            // 开始遍历数组中的元素，开始分组
            for (int k = 0; k < m; k++) {
                int v1 = v1list.get(k);
                int v2 = v2list.get(k);

                if (group.size() == 0) {
                    ArrayList<Integer> e1 = new ArrayList<>();
                    ArrayList<Integer> e2 = new ArrayList<>();
                    e1.add(v1);
                    e2.add(v2);
                    group.add(e1);
                    group.add(e2);
                } else {
                    for (ArrayList<Integer> item : group) {
                        // 处理v1
                        if (!item.contains(v1)) {
                            if (hasNotEdition(item, v1list, v2list, v1)) { // 如果不存在边的话直接插入
                                item.add(v1);
                            }
                        }

                        // 处理v2
                        if (!item.contains(v2)) {
                            if (hasNotEdition(item, v1list, v2list, v2)) { // 如果不存在边的话直接插入
                                item.add(v2);
                            }
                        }

                    }
                }
            }
            System.out.println(group);

            System.out.println("No");
//            System.out.println("Yes");
        }

    }

    private static boolean hasNotEdition(ArrayList<Integer> item, ArrayList<Integer> v1list, ArrayList<Integer> v2list, int v) {

        for (int i = 0; i < v1list.size(); i++) {
            int v1 = v1list.get(i);
            int v2 = v2list.get(i);
            if(item.contains(v1) && item.contains(v2)){
                return false;
            }
        }
        return true;

    }


}
