package sword_offer.code27_字符串的排列;

import java.util.*;

/**
 * 本题是直接通过之前写过的全排序的例子进行修改的，通过代理模式的方式封装了一个中间函数。
 */
class Solution2 {
    public List<List<Character>> res;
    public boolean[] used;

    public List<List<Character>> permute(char[] nums) {
        res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];
        Arrays.fill(used, false);

        LinkedList<Character> p = new LinkedList<>();
        generatePermutation(nums, 0, p);
        return res;
    }

    private void generatePermutation(char[] nums, int index, LinkedList<Character> p) {
        if (index == nums.length) {
            res.add((List<Character>) p.clone());
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

    private static void printList(List<Character> list) {
        for (Character e : list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> reslist = new ArrayList<>();
        List<List<Character>> items = new Solution2().permute(str.toCharArray());
        for (List<Character> item : items){
            StringBuffer sb = new StringBuffer();
            for(Character ch : item){
                sb.append(ch);
            }
            if(!reslist.contains(sb.toString())){
                reslist.add(sb.toString());
            }

        }
        Collections.sort(reslist);
        return reslist;
    }

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> result = Permutation(str);
        System.out.println(result);
    }
}