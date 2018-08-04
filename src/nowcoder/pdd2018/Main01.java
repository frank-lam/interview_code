package nowcoder.pdd2018;

/**
 * @author Created By Frank
 * @date 2018-08-04 8:50
 */

import java.io.FileNotFoundException;
import java.util.*;

/**
 * 拼多多2018校园招聘编程题题解 - 代码天地
 * https://www.codetd.com/article/1809763
 * <p>
 * 小熊吃糖_拼多多笔试题_牛客网
 * https://www.nowcoder.com/questionTerminal/dc49df3bbc0146dd92322889d40afcb1?orderByHotValue=1&page=1&onlyReference=false
 */
public class Main01 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        int n, m;
        n = in.nextInt();
        m = in.nextInt();

        List<Integer> candys = new ArrayList<>();
        for (int i = 0; i < m; i++)
            candys.add(in.nextInt());

        Collections.sort(candys, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        int[] fighting = new int[n];
        int[] hunger = new int[n];
        int[] recOrder = new int[n];
        for (int i = 0; i < recOrder.length; i++)
            recOrder[i] = i;


        int[] sortArr = new int[n];

        for (int i = 0; i < n; i++) {
            fighting[i] = in.nextInt();
            hunger[i] = in.nextInt();
        }


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (fighting[i] < fighting[j]) {
                    swap(fighting, i, j);
                    swap(hunger, i, j);
                    swap(recOrder, i, j); // 这样记录的是排序后的下标索引，故在下文需要反转一下
                }
            }
        }


        // 从第一只熊开始吃糖
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (hunger[i] >= candys.get(j) && candys.get(j) != 0) {
                    hunger[i] -= candys.get(j);
                    candys.set(j, 0);
                }
            }
        }

        // 反转记录数组
        int[] recOrder2 = Arrays.copyOf(recOrder, recOrder.length);
        for (int i = 0; i < recOrder2.length; i++) {
            recOrder2[recOrder[i]] = i ;
        }

        // 根据记录的下标 输出从0-n的小熊剩余数量
        for (Integer index : recOrder2) {
            System.out.println(hunger[index]);
        }

    }

    private static void swap(int[] fighting, int i, int j) {
        int k = fighting[i];
        fighting[i] = fighting[j];
        fighting[j] = k;
    }

}
