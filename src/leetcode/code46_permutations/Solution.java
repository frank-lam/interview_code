package leetcode.code46_permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * (1) 全排列 - LeetCode (中国)
 * https://leetcode-cn.com/problems/permutations/description/
 */
class Solution {
    public List<List<Integer>> res;
    public boolean[] used;


    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];
        Arrays.fill(used, false);

        LinkedList<Integer> p = new LinkedList<>();
        generatePermutation(nums, 0, p);
        return res;
    }

    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p) {

        if (index == nums.length) {
            res.add((List<Integer>) p.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) { // 这里好好感受一下回溯的感觉
                p.add(nums[i]);
                used[i] = true;

                generatePermutation(nums, index + 1, p);
                p.removeLast();
                used[i] = false;
            }
        }

        return;

    }

    private static void printList(List<Integer> list) {
        for (Integer e : list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new Solution()).permute(nums);
        for (List<Integer> list : res)
            printList(list);
    }
}