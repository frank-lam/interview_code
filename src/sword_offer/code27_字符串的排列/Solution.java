package sword_offer.code27_字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    ArrayList<String> res = new ArrayList<>();
    boolean[] used;

    public ArrayList<String> Permutation(String str) {
        used = new boolean[str.length()];
        if (res == null)
            return null;
        if (str.length() == 0)
            return res;

        generatePermutation(str, 0, new StringBuilder());
        Arrays.fill(used, false);

        return res;
    }

    // p 中保存了一个有 index-1 个元素的排列。
    // 向这个排列的末尾添加第 index 个元素, 获得一个有 index 个元素的排列
    private void generatePermutation(String str, int index, StringBuilder p) {
        if (index == str.length()) {
            if (!res.contains(p.toString())) {
                res.add(p.toString());
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!used[i]) {
                p.append(str.charAt(i));
                used[i] = true;
                generatePermutation(str, index + 1, p);
                p.deleteCharAt(p.length() - 1);
                used[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Permutation("ABABAB"));
    }
}