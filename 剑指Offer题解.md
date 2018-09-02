# 前言

本文将通过 Java 实现剑指 Offer 例题。本文的例题顺序根据牛客网在线编程顺序，通过最简练的语言描述。

在线练习转向：[剑指 Offer-牛客网](https://www.nowcoder.com/ta/coding-interviews)



# 26. 二叉搜索树与双向链表

## 题目描述

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

## 解题思路

二叉搜索树的中序遍历序列就是递增有序的

```java
//递归实现
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
        	return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null)
        	return pRootOfTree;
        //将左子树构造成双链表，并返回链表头结点
        TreeNode pLeft = Convert(pRootOfTree.left);
        TreeNode pNode = pLeft;
        //定位左子树链表的尾结点
        while (pNode != null && pNode.right != null) 
        	pNode = pNode.right;
 		//左子树不为空，则将根节点加到左子树链表末尾
 		if (pLeft != null) {
 			pNode.right = pRootOfTree;
 			pRootOfTree.left = pNode;
 		}
 		//将右子树构造成双链表，并返回链表头结点
 		TreeNode pRight = Convert(pRootOfTree.right);
 		//如果右子树链表不为空，则加到根节点后
 		if (pRight != null){
 			pRootOfTree.right = pRight;
 			pRight.left = pRootOfTree;
 		}
 		//根节点左子树链表不为空，则pLeft为链表头结点；否则根节点为链表头结点
        if(pLeft != null)
           return pLeft;
        return pRootOfTree;
    }
}
```



# 27. 字符串的排列

## 题目描述

输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

## 输入描述

```
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
```

## 解题思路

使用回溯法

```java
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
            if(!res.contains(p.toString())){
                res.add(p.toString());
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            // 这里好好感受回溯思想
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
}
```





# 28. 数组中出现次数超过一半的数字

## 题目描述

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

## 解题思路

```java
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
}
```



# 29. 最小的K个数

## 题目描述

输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

## 解题思路

```java
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
}
```



# 30. 连续子数组的最大和

## 题目描述

{6,-3,-2,7,-15,1,2,2}，连续子向量的最大和为 8

## 解题思路

分析数组规律法：对于一个数A，若A的左边累计数非负，那么加上A能使值不小于A，则认为累计值对当前子数组整体和是有贡献的；如果前几项累计值为负数，则认为有害于当前子数组总体和，total记录当前和值，若total大于maxSum，则maxSum=total。

```java
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int total = array[0];
        int maxsum = array[0];
        for (int i = 1; i < array.length; i++) {
            if(total > 0){
                total += array[i];
            }
            else{
                total = array[i];
            }
            if(total > maxsum){
                maxsum = total;
            }
        }
        return maxsum;
    }
}
```

