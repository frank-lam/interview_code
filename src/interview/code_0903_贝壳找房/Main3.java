package interview.code_0903_贝壳找房;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0903_贝壳找房\\input3.txt")));
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            map.put(a, b);
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            boolean aisb = getAisBfather(a,b);
            int result = 0;
            if(aisb){
                result = 1;
            }
            else{
                if(getAisBfather(b,a)){
                    result = 2;
                }
            }
            if(i!= m-1){
                System.out.println(result);
            }
            else{
                System.out.print(result);
            }
        }
    }

    private static boolean getAisBfather(int a, int b) {
        if (a == b) {
            return false;
        }

        int count = 0;
        int nowRoot = b;
        while (map.get(nowRoot) != -1 && count <= 10) { //  == -1 到根节点 查找结束
            nowRoot = map.get(nowRoot);
            if (nowRoot == a) {
                return true;
            }
            count++;
        }
        return false;
    }

}
