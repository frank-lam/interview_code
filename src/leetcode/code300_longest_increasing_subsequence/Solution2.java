package leetcode.code300_longest_increasing_subsequence;

/**
 * @author Created By Frank
 * @date 2018-08-05 10:53
 * 最长上升子序列 (Longest Increasing Subsequence) - 领扣 (LeetCode)
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 */

/**
 * 最长上升子序列 (Longest Increasing Subsequence) - 领扣 (LeetCode)
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求出具体的上升子序列值
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class Solution2 {
    private static List<Integer> LISindex = new ArrayList<>(); // 记录一下有几个上升子序列

    public List<List<Integer>> lengthOfLIS(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return null;
        }

        int res = 1;
        int[] memo = new int[n];

        Arrays.fill(memo, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    memo[i] = max(memo[i], memo[j] + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            res = max(memo[i], res);
        }

        for (int i = 0; i < n; i++) {
            if (memo[i] == res)
                LISindex.add(i); // 遍历一下最长子序列最后一位是谁，统计一共有多少个子序列
        }

        for (int lastIndex : LISindex) {
            ArrayList<Integer> list = new ArrayList<>();
            int nowMemoCount = memo[lastIndex];

            for (int i = lastIndex; i >= 0; i--) {
                if (nowMemoCount - memo[i] == 1 || nowMemoCount - memo[i] == 0) {
                    list.add(nums[i]);
                    nowMemoCount--;
                }
            }
            resList.add(reverseList(list));
        }

        return resList;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private List<Integer> reverseList(ArrayList<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution2().lengthOfLIS(arr));
    }
}
