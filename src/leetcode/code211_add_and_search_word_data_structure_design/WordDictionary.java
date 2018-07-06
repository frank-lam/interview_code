package leetcode.code211_add_and_search_word_data_structure_design;


/**
 * @author Created By Frank
 * @date 2018-07-06 11:47
 */

import java.util.TreeMap;

/**
 * 添加与搜索单词 - 数据结构设计 - LeetCode (中国)
 * https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/description/
 */

class WordDictionary {

    // 定义结点的数据结构
    private class Node {
        private boolean isWord;
        private TreeMap<Character, Node> next;

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
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    // 递归查询方法
    private boolean match(Node node, String word, int index) {
        if (word.length() == index)
            return node.isWord;

        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null)
                return false;
            return match(node.next.get(c), word, index + 1);
        } else {
            for (char ch : node.next.keySet())
                if (match(node.next.get(ch), word, index + 1))
                    return true;
            return false;
        }


    }

    public static void main(String[] args){
        WordDictionary obj = new WordDictionary();
        obj.addWord("frank");
        System.out.println(obj.search(".ra.."));
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */