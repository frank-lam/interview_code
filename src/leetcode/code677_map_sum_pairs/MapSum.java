package leetcode.code677_map_sum_pairs;


/**
 * @author Created By Frank
 * @date 2018-07-06 15:17
 */

import java.util.TreeMap;

/**
 * 键值映射 - LeetCode (中国)
 * https://leetcode-cn.com/problems/map-sum-pairs/description/
 */

class MapSum {

    private class Node {
        public int value;
        public TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    public Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return 0;
            }
            cur = cur.next.get(c);
        }

        return sum(cur);
    }

    // 这里递归的计算所有的单词
    public int sum(Node node){
        if(node.next.size() == 0){ // 当前节点是叶子节点
            return node.value;
        }
        int res = node.value;
        for(char ch : node.next.keySet()){
            res += sum(node.next.get(ch));
        }
        return res;
    }

    public static void main(String[] args){
        // 输入: insert("apple", 3), 输出: Null
        //输入: sum("ap"), 输出: 3
        //输入: insert("app", 2), 输出: Null
        //输入: sum("ap"), 输出: 5

        MapSum mapSum = new MapSum();
        mapSum.insert("apple",3);
        mapSum.insert("app",100);
        System.out.println(mapSum.sum("app"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */