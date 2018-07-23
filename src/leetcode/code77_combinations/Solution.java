package leetcode.code77_combinations;

/**
 * @author Created By Frank
 * @date 2018-07-15 19:59
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * (1) 组合 - LeetCode (中国)
 * https://leetcode-cn.com/problems/combinations/description/
 */
public class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        LinkedList<Integer> p = new LinkedList<>();

        generateCombine(n, k, 1, p);
        return res;
    }

    // 求解C(n,k), 当前已经找到的组合存储在c中, 需要从start开始搜索新的元素
    private void generateCombine(int n, int k, int start, LinkedList<Integer> p) {
        if (p.size() == k) {
            res.add((List<Integer>) p.clone()); // 这里很重要啊
            return;
        }

        for (int i = start; i <= n; i++) {
            p.add(i);
            generateCombine(n, k, i + 1, p);
            p.removeLast();
        }
        return;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = (new Solution()).combine(4, 2);
        System.out.println(res);
    }
}
