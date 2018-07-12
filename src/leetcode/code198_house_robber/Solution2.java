package leetcode.code198_house_robber;

import utils.PrintHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 计算出哪些元素被查找
 */
class Solution2 {
    public static int[] memo;
    public static ArrayList<Integer> list;
    public static Stack<Integer> s;
    public static int dept = 0;
    public static int lastInt = -1;
    public static int lastValue = -1;

    // 待抢劫的房子价值
    public int rob(int[] nums) {
        list = new ArrayList<>();
        s = new Stack<>();
        memo = new int[nums.length + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return tryRobber(nums, 0);
    }

    // 考虑抢劫[index,nums.length-1]范围内的房子
    private int tryRobber(int[] nums, int index) {
        int n = nums.length;
        if (index >= n)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        int res = 0;
        for (int i = index; i < n; i++) {
            int item = nums[i] + tryRobber(nums, i + 2);
            if (item > res) {
                res = item;
                s.push(i);
            }
        }

        memo[index] = res;

        while (!s.isEmpty()) {
            int top = s.pop();
            if (!list.contains(top + 1) && !list.contains(top - 1) && !list.contains(top)) {
                list.add(top);
            }
        }
        Collections.sort(list);
        return res;
    }

    public static void main(String[] args) {
        int[] arr3 = {1, 2, 2, 3, 4, 2, 5, 1, 12, 12, 12};

        int max = new Solution2().rob(arr3);

        System.out.println("-------------------------");

        System.out.println("最大值为：" + max);

        System.out.println("-------------------------");

        PrintHelper.printArray(arr3);


        for (Integer index : list) {
            System.out.println("选择第" + (index) + "位：" + arr3[index]);
        }

//        System.out.println(list);

    }
}