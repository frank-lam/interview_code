package interview.wygame_20180809;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * @author Created By Frank
 * @date 2018-08-09 18:52
 */
public class Main4 {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\wygame_20180809\\input4.txt")));
        int n = Integer.parseInt(in.nextLine());
        List<String> list = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            int ruleCount = Integer.parseInt(in.nextLine());

            Map<String, String> ruleMap = new HashMap<>();
            int minLenth = 11;
            int maxLenth = 0;
            for (int i = 0; i < ruleCount; i++) {
                String str = in.nextLine();
                String[] charr = str.split(" ");
                String key = charr[0].replace("x", "");
                ruleMap.put(key, charr[1]);
                // 设置最小长度，剪枝操作
                if (minLenth > key.length()) {
                    minLenth = key.length();
                }
                if (key.length() > maxLenth) {
                    maxLenth = key.length();
                }
            }
            int testCount = Integer.parseInt(in.nextLine());

            for (int i = 0; i < testCount; i++) {
                String testStr = in.nextLine();
                boolean issuccess = false;
                for (int j = minLenth; j <= maxLenth; j++) {
                    String checkstr = testStr.substring(0, j);
                    if (ruleMap.containsKey(checkstr)) {
                        issuccess = true;
//                        System.out.print(ruleMap.get(checkstr));
                        list.add(ruleMap.get(checkstr));
                        break;
                    }
                }
                if (!issuccess) {
                    list.add("unknow");
//                    System.out.print("unknow");
                }
//                System.out.println();

            }
        }

        for (int i = 0; i < list.size(); i++) {

            System.out.print(list.get(i));
            if(i!= list.size()-1){
                System.out.println();
            }
        }
    }
}