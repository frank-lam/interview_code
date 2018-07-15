package leetcode.code213_house_robber_ii;

import utils.PrintHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 打家劫舍 II - LeetCode (中国)
 * https://leetcode-cn.com/problems/house-robber-ii/description/
 */

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
        if(nums.length == 1)
            return nums[0];

        list = new ArrayList<>();
        s = new Stack<>();
        memo = new int[nums.length + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return Math.max(tryRobber(nums, 0,nums.length-2),tryRobber(nums, 1,nums.length-1));
    }

    // 考虑抢劫[index,nums.length-1]范围内的房子
    private int tryRobber(int[] nums, int l,int r) {
        if (l > r)
            return 0;


        if (memo[l] != -1)
            return memo[l];

        int res = 0;
        for (int i = l; i <= r; i++) {
            int item = nums[i] + tryRobber(nums, i + 2,r);
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
        int[] arr3 = {1,3,1,3,100};

        int max = new Solution().rob(arr3);

        System.out.println("-------------------------");

        System.out.println("最大值为：" + max);

        System.out.println("-------------------------");

        PrintHelper.printArray(arr3);



//        System.out.println(list);

    }
}