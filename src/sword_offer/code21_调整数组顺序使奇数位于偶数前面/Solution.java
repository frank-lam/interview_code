package sword_offer.code21_调整数组顺序使奇数位于偶数前面;

import utils.PrintHelper;

import java.util.ArrayList;

public class Solution {
    public static void reOrderArray(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int item = array[i];
            if (item % 2 == 1) {
                list.add(item);
            }
        }
        for (int i = 0; i < array.length; i++) {
            int item = array[i];
            if (item % 2 != 1) {
                list.add(item);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reOrderArray(test);
        PrintHelper.printArray(test);
    }
}