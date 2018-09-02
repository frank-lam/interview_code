package sword_offer.code28_数组中出现次数超过一半的数字;

import java.util.HashMap;

public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int half = array.length / 2;
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            if (!map.containsKey(key)) {
                map.put(key,1);
            }
            else{
                map.put(key,map.get(key)+1);
            }
        }

        for(Integer key : map.keySet()){
            int count = map.get(key);
            if(count > half){
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}