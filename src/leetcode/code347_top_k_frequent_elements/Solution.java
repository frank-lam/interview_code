package leetcode.code347_top_k_frequent_elements;

/**
 * @author Created By Frank
 * @date 2018-07-04 11:06
 */

import java.util.*;

/**
 * 前K个高频元素 - LeetCode (中国)
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 在映射中保存所有的键和频率
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }

        // 优先队列
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a)-map.get(b);
            }
        });

        for(int key : map.keySet()){
            if(pq.size()<k){
                pq.add(key);
            }
            else if(map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            list.add(pq.remove());
        }
        return list;
    }


    public static void main(String[] args){
        int[] arr = {1,1,1,1,2,2,2,2,3};
        System.out.println(new Solution().topKFrequent(arr, 2));
    }
}
