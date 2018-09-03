package interview.code_0805_拼多多内推;

import utils.PrintHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Created By Frank
 * @date 2018-08-05 18:52
 */
public class Main4 {

    private static List<Integer> LISindex = new ArrayList<>(); // 记录一下有几个上升子序列
    private static List<Integer> list;
    private static int count = 0;

    public static List<List<Integer>> lengthOfLIS(int[] nums,boolean reverse) {
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
            resList.add(reverse?reverseList(list):list);
        }

        return resList;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    private static List<Integer> reverseList(ArrayList<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }


    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        // 这里设置输入输出文件，方便长出入调试使用
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0805_拼多多内推\\input4.txt")));
        int n = in.nextInt();

        int[] nums = new int[n];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int inputeInt = in.nextInt();
            nums[i] = inputeInt;
            list.add(inputeInt);
        }

        int[] renums = reverseArray(nums);
        PrintHelper.printArray(nums);
        PrintHelper.printArray(renums);

        System.out.println(lengthOfLIS(nums,true)); // 正序
        System.out.println(lengthOfLIS(renums,false)); // 反序

        List<Integer> removeList = new ArrayList<>();


    }



    private static int[] reverseArray(int[] nums) {
        int[] copy = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            copy[nums.length - 1 - i] = nums[i];
        }
        return copy;
    }


}
