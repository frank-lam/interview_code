package sword_offer.code29_最小的K个数;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> resList = new ArrayList<>();
        if (k > input.length) {
            return resList;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            resList.add(input[i]);
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(input, 4));
    }
}