package leetcode.code208_implement_trie_prefix_tree;

import java.util.TreeMap;

/**
 * @author Created By Frank
 * @date 2018-07-06 11:13
 */


/**
 * 实现 Trie (前缀树) - LeetCode (中国)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 */

public class Trie {

    // 先定义结点的数据结构
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    public Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
    }

    // 向Trie中添加一个新的单词word
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) // 如果包含的话
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    // 查询单词word是否在Trie中
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) // 如果包含的话
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    // 查询是否在Trie中有单词以prefix为前缀
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) // 如果包含的话
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }


    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("frank");
        obj.insert("nancy");
        System.out.println(obj.search("frank"));
        System.out.println(obj.startsWith("fr1"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */