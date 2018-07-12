package leetcode.code213_house_robber_ii;

import utils.PrintHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 计算出哪些元素被查找
 */
class Solution {
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
        return tryRobber(nums, 0,nums.length-1);
    }

    // 考虑抢劫[index,nums.length-1]范围内的房子
    private int tryRobber(int[] nums, int l,int r) {

        if (l >= r)
            return 0;

        if (memo[l] != -1)
            return memo[l];

        int res = 0;
        for (int i = l; i <= r; i++) {
            int item = -1;
            if(i==0)
                item = nums[i] + tryRobber(nums, i + 2,r);
            else
                item = nums[i] + tryRobber(nums, i + 2,r-1);
            if (item > res) {
                res = item;
                s.push(i);
            }
        }

        memo[l] = res;

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
        int[] arr3 = {1,2,1};

        int max = new Solution().rob(arr3);

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