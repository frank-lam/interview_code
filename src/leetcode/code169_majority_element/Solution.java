package leetcode.code169_majority_element;


import java.util.Map;
import java.util.TreeMap;

/**
 * @author Created By Frank
 * @date 2018-07-11 18:44
 */

/**
 * 求众数 - LeetCode (中国)
 * https://leetcode-cn.com/problems/majority-element/description/
 */
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }


        int maxKey = 0;
        int maxValue = 0;

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() > maxValue){
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    public static void main(String[] args){
        int[] arr = {3,2,3};
        System.out.println(new Solution().majorityElement(arr));

    }
}